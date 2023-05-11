package Models;

import java.time.LocalDate;

public class Worlds {
    private Long id_champ;
    private Team team;
    private LocalDate worlds_year;
    private String worlds_location;
    private int prize;

    public Worlds() {
    }

    public Worlds(Team team, LocalDate worlds_year, String worlds_location, int prize) {
        this.team = team;
        this.worlds_year = worlds_year;
        this.worlds_location = worlds_location;
        this.prize = prize;
    }

    public Long getId_champ() {
        return id_champ;
    }

    public void setId_champ(Long id_champ) {
        this.id_champ = id_champ;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public LocalDate getWorlds_year() {
        return worlds_year;
    }

    public void setWorlds_year(LocalDate worlds_year) {
        this.worlds_year = worlds_year;
    }

    public String getWorlds_location() {
        return worlds_location;
    }

    public void setWorlds_location(String worlds_location) {
        this.worlds_location = worlds_location;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Models.Worlds{" +
                "id_champ=" + id_champ +
                ", team=" + team.getTeam_name() +
                ", worlds_year=" + worlds_year +
                ", worlds_location='" + worlds_location + '\'' +
                ", prize=" + prize +
                '}';
    }
}
