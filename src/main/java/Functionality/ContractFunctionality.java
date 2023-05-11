package Functionality;

import Models.Contract;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ContractFunctionality {
    static final String SELECT = "SELECT \n" +
            "    Info.id_contract, Info.ingame_name, Info.first_name, Info.last_name, Info.player_position, Info.salary, Info.price,\n" +
            "    Stats.team_name, Stats.wins, Stats.loses, Stats.games_played, Stats.win_rate,\n" +
            "    Info.contract_expired, Info.start_at\n" +
            "FROM\n" +
            "(SELECT\n" +
            "    Contracts.id_contract, Players.ingame_name, Players.first_name, Players.last_name, Players.id_team, \n" +
            "    Players.player_position, Players.salary, Players.contract_expired,\n" +
            "    Contracts.start_at, Contracts.price\n" +
            "FROM Players JOIN Contracts ON Players.id_player = Contracts.id_player) Info\n" +
            "JOIN\n" +
            "(SELECT \n" +
            "    Win_table.id_team, Win_table.team_name, Win_table.wins, Lose_table.loses,\n" +
            "    (Win_table.wins + Lose_table.loses) games_played,\n" +
            "    ROUND((Win_table.wins / (Win_table.wins + Lose_table.loses) * 100), 1) win_rate\n" +
            "FROM \n" +
            "    (SELECT id_team, team_name, SUM(wins) wins FROM\n" +
            "        (\n" +
            "            (SELECT id_team, team_name, COUNT(*) wins \n" +
            "                FROM teams JOIN game_history ON id_team = id_red_team \n" +
            "                WHERE status = 2 AND game_result = 2 \n" +
            "                GROUP BY id_team, team_name) UNION ALL\n" +
            "            (SELECT id_team, team_name, COUNT(*) wins \n" +
            "                FROM teams join game_history ON id_team = id_blue_team \n" +
            "                WHERE status = 2 AND game_result = 1 \n" +
            "                GROUP BY id_team, team_name)\n" +
            "        ) GROUP BY id_team, team_name) Win_table\n" +
            "    JOIN\n" +
            "    (SELECT id_team, team_name, SUM(loses) loses FROM\n" +
            "        (\n" +
            "            (SELECT id_team, team_name, COUNT(*) loses \n" +
            "                FROM teams JOIN game_history ON id_team = id_red_team \n" +
            "                WHERE status = 2 AND game_result = 1 \n" +
            "                GROUP BY id_team, team_name) UNION ALL\n" +
            "            (SELECT id_team, team_name, COUNT(*) loses \n" +
            "                FROM teams JOIN game_history ON id_team = id_blue_team \n" +
            "                WHERE status = 2 AND game_result = 2 \n" +
            "                GROUP BY id_team, team_name)\n" +
            "        ) GROUP BY id_team, team_name) Lose_table\n" +
            "    \n" +
            "    ON Win_table.id_team = Lose_table.id_team) Stats\n" +
            "ON Info.id_team = Stats.id_team WHERE wins >= ? AND games_played >= ? AND win_rate >= ?";
    static final String INSERT_1 = "INSERT INTO Contracts (id_player, start_at, price)" +
            "VALUES (?, ?, ?)";
    static final String INSERT_2 = "INSERT INTO Contracts (id_manager, id_player, start_at, price)" +
            "VALUES (?, ?, ?, ?)";
    static final String UPDATE = "UPDATE Contracts SET id_player = ?, id_manager = ?, start_at = ?, price = ? " +
            "WHERE id_contract = ?";
    static final String DELETE = "DELETE Contracts WHERE id_contract = ?";

    static final String BuyContract = "BEGIN BuyContract(?, ? ,?, ?, ?); END;"; // {CALL/EXECUTE BuyContract(?, ? ,?, ?, ?)} not working, bug?
    static final String TerminateContract = "BEGIN TerminateContract(?, ?, ?); END;"; // {CALL/EXECUTE TerminateContract(?, ? ,?)} not working, bug?

    public static void Select(Connection con, int win, int games, float win_rate){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(SELECT);
            statement.setInt(1, win);
            statement.setInt(2, games);
            statement.setFloat(3, win_rate);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Contract contract = new Contract();
                contract.setId_contract(rs.getLong(1));
                contract.setIngame_name(rs.getString(2));
                contract.setFirst_name(rs.getString(3));
                contract.setLast_name(rs.getString(4));
                contract.setPos(rs.getInt(5));
                contract.setSalary(rs.getInt(6));
                contract.setPrice(rs.getInt(7));
                contract.setTeam_name(rs.getString(8));
                contract.setWins(rs.getInt(9));
                contract.setLoses(rs.getInt(10));
                contract.setGames(rs.getInt(11));
                contract.setWinrate(rs.getFloat(12));
                contract.setExpire(rs.getDate(13));
                contract.setStart_at(rs.getDate(14));

                contract.printContract();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Insert(Connection con, int id_player, int id_manager, LocalDate date, int price){
        PreparedStatement statement;
        try {
            if (id_manager == 0) {
                statement = con.prepareStatement(INSERT_1);
                statement.setInt(1, id_player);
                statement.setDate(2, Date.valueOf(date));
                statement.setInt(3, price);
            } else {
                statement = con.prepareStatement(INSERT_2);
                statement.setInt(1, id_manager);
                statement.setInt(2, id_player);
                statement.setDate(3, Date.valueOf(date));
                statement.setInt(4, price);
            }

            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Update(Connection con, int id, int id_player, int id_manager, LocalDate date, int price){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(UPDATE);
            statement.setInt(1, id_player);
            statement.setInt(2, id_manager);
            statement.setDate(3, Date.valueOf(date));
            statement.setInt(4, price);
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(Connection con, int id){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(DELETE);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void BuyContract(Connection con, int id_contract, int id_buyer, int new_salary, LocalDate new_start_at){
        CallableStatement storedProc;
        try {
            storedProc = con.prepareCall(BuyContract);
            storedProc.setInt(1, id_contract);
            storedProc.setInt(2, id_buyer);
            storedProc.setInt(3, new_salary);
            storedProc.setDate(4, Date.valueOf(new_start_at));
            storedProc.registerOutParameter(5, Types.VARCHAR);

            storedProc.executeUpdate();
            String msg = storedProc.getString(5);

            System.out.println(msg);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void TerminateContract(Connection con, int id_player, LocalDate date){
        CallableStatement storedProc;
        try {
            storedProc = con.prepareCall(TerminateContract);
            storedProc.setInt(1, id_player);
            storedProc.setDate(2, Date.valueOf(date));
            storedProc.registerOutParameter(3, Types.VARCHAR);

            storedProc.executeUpdate();
            String msg = storedProc.getString(3);

            System.out.println(msg);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
