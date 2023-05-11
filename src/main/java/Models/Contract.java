package Models;

import java.sql.Date;

public class Contract {
    private Long id_contract;
    private int id_manager;
    private int id_player;
    private String ingame_name;
    private String first_name;
    private String last_name;
    private int pos;
    private String team_name;
    private int wins;
    private int loses;
    private int games;
    private float winrate;
    private Date expire;
    private Date start_at;
    private int price;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Contract() {
    }

    public Long getId_contract() {
        return id_contract;
    }

    public void setId_contract(Long id_contract) {
        this.id_contract = id_contract;
    }

    public int getId_manager() {
        return id_manager;
    }

    public void setId_manager(int id_manager) {
        this.id_manager = id_manager;
    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public String getIngame_name(){
        return ingame_name;
    }

    public void setIngame_name(String ingame_name){
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

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public float getWinrate() {
        return winrate;
    }

    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Date getStart_at() {
        return start_at;
    }

    public void setStart_at(Date start_at) {
        this.start_at = start_at;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printContract(){
        System.out.println("------------------------------------------------------");
        System.out.println("id contract: " + id_contract);
        System.out.println("Ingame name: " + ingame_name);
        System.out.println("Full Name: " + first_name + " " + last_name);
        System.out.println("Team: " + team_name);
        System.out.println("Salary: " + salary);
        System.out.println("Price: " + price);
        System.out.println("Wins: " + wins);
        System.out.println("Loses: " + loses);
        System.out.println("Winrate: " + winrate);
        System.out.println("Current contract expired at: " + expire);
        System.out.println("Open for sale at: " + start_at);
    }
}
