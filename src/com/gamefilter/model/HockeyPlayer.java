package com.gamefilter.model;

import java.util.Objects;

public class HockeyPlayer implements Player {

    private Integer gameId;
    private String playerName;
    private String teamShortName;
    private PlayerRole roleShortName;
    private Double playerPrice;
    private Integer timePlayed;

    public HockeyPlayer(Integer gameId, String playerName, String teamShortName, PlayerRole roleShortName, Double playerPrice, Integer timePlayed) {
        this.gameId = gameId;
        this.playerName = playerName;
        this.teamShortName = teamShortName;
        this.roleShortName = roleShortName;
        this.playerPrice = playerPrice;
        this.timePlayed = timePlayed;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamShortName() {
        return teamShortName;
    }

    public void setTeamShortName(String teamShortName) {
        this.teamShortName = teamShortName;
    }

    public PlayerRole getRoleShortName() {
        return roleShortName;
    }

    public void setRoleShortName(PlayerRole roleShortName) {
        this.roleShortName = roleShortName;
    }

    public Double getPlayerPrice() {
        return playerPrice;
    }

    public void setPlayerPrice(Double playerPrice) {
        this.playerPrice = playerPrice;
    }

    public Integer getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(Integer timePlayed) {
        this.timePlayed = timePlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HockeyPlayer that = (HockeyPlayer) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(playerName, that.playerName) &&
                Objects.equals(teamShortName, that.teamShortName) &&
                Objects.equals(roleShortName, that.roleShortName) &&
                Objects.equals(playerPrice, that.playerPrice) &&
                Objects.equals(timePlayed, that.timePlayed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameId, playerName, teamShortName, roleShortName, playerPrice, timePlayed);
    }
}
