package Models;

import java.time.LocalDate;

public class Player {
    private Long id_player;
    private String ingame_name;
    private String first_name;
    private String last_name;
    private Team team;
    private int player_position;
    private int status;
    private int salary;

    private LocalDate contract_expired;

    public Player() {
    }

    public Player(String ingame_name, String first_name, String last_name, Team team, int player_position, int status, int salary, LocalDate contract_expired) {
        this.ingame_name = ingame_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.team = team;
        this.player_position = player_position;
        this.status = status;
        this.salary = salary;
        this.contract_expired = contract_expired;
    }

    public Long getId_player() {
        return id_player;
    }

    public void setId_player(Long id_player) {
        this.id_player = id_player;
    }

    public String getIngame_name() {
        return ingame_name;
    }

    public void setIngame_name(String ingame_name) {
        this.ingame_name = ingame_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPlayer_position() {
        return player_position;
    }

    public void setPlayer_position(int player_position) {
        this.player_position = player_position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getContract_expired() {
        return contract_expired;
    }

    public void setContract_expired(LocalDate contract_expired) {
        this.contract_expired = contract_expired;
    }

    @Override
    public String toString() {
        return "Models.Player{" +
                "id_player=" + id_player +
                ", ingame_name='" + ingame_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", team=" + team.getTeam_name() +
                ", player_position=" + player_position +
                ", status=" + status +
                ", salary=" + salary +
                ", contract_expired=" + contract_expired +
                '}';
    }
}
