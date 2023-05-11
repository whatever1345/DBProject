package Models;

import java.time.LocalDate;

public class GameHistory {
    private Long id_game;
    private Team blue_team;
    private Team red_team;
    private Spectator spectator;
    private Integer game_result;
    private LocalDate start_at;
    private LocalDate end_at;

    private int status;

    public GameHistory() {
    }

    public GameHistory(Team blue_team, Team red_team, Spectator spectator, int game_result, LocalDate start_at, LocalDate end_at, int status) {
        this.blue_team = blue_team;
        this.red_team = red_team;
        this.spectator = spectator;
        this.game_result = game_result;
        this.start_at = start_at;
        this.end_at = end_at;
        this.status = status;
    }

    public Long getId_game() {
        return id_game;
    }

    public void setId_game(Long id_game) {
        this.id_game = id_game;
    }

    public Team getBlue_team() {
        return blue_team;
    }

    public void setBlue_team(Team blue_team) {
        this.blue_team = blue_team;
    }

    public Team getRed_team() {
        return red_team;
    }

    public void setRed_team(Team red_team) {
        this.red_team = red_team;
    }

    public Spectator getSpectator() {
        return spectator;
    }

    public void setSpectator(Spectator spectator) {
        this.spectator = spectator;
    }

    public int getGame_result() {
        return game_result;
    }

    public void setGame_result(int game_result) {
        this.game_result = game_result;
    }

    public LocalDate getStart_at() {
        return start_at;
    }

    public void setStart_at(LocalDate start_at) {
        this.start_at = start_at;
    }

    public LocalDate getEnd_at() {
        return end_at;
    }

    public void setEnd_at(LocalDate end_at) {
        this.end_at = end_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Models.GameHistory{" +
                "id_game=" + id_game +
                ", blue_team=" + blue_team.getTeam_name() +
                ", red_team=" + red_team.getTeam_name() +
                ", spectator=" + spectator.getFirst_name() +
                ", game_result=" + game_result +
                ", start_at=" + start_at +
                ", end_at=" + end_at +
                ", status=" + status +
                '}';
    }
}
