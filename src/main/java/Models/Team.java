package Models;

import java.time.LocalDate;

public class Team {
    private Long id_team;
    private String team_name;
    private Region region;
    private LocalDate established_on;

    public Team() {
    }

    public Team(String team_name, Region region, LocalDate established_on) {
        this.team_name = team_name;
        this.region = region;
        this.established_on = established_on;
    }

    public Long getId_team() {
        return id_team;
    }

    public void setId_team(Long id_team) {
        this.id_team = id_team;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getEstablished_on() {
        return established_on;
    }

    public void setEstablished_on(LocalDate established_on) {
        this.established_on = established_on;
    }

    @Override
    public String toString() {
        return "Models.Team{" +
                "id_team=" + id_team +
                ", team_name='" + team_name + '\'' +
                ", region=" + region.getRegion_name() +
                ", established_on=" + established_on +
                '}';
    }
}
