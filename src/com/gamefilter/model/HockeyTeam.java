package com.gamefilter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HockeyTeam implements Team {

    public static final Integer MAX_GOALKEEPER = 1;
    public static final Integer MAX_DEFENDER = 2;
    public static final Integer MAX_FORWARD = 3;
    private Double teamPriceAmount = 0.0;
    private int teamTime = 0;

    private List<HockeyPlayer> hockeyPlayers = new ArrayList<>();

    public void addPlayer(HockeyPlayer player) {
        hockeyPlayers.add(player);
        teamPriceAmount += player.getPlayerPrice();
        teamTime += player.getTimePlayed();
    }


    public List<HockeyPlayer> getPlayers() {
        return hockeyPlayers;
    }

    public Double getTeamPriceAmount() {
        return teamPriceAmount;
    }

    public int getTeamTime() {
        return teamTime;
    }

    public Integer getGoalkeeperCount() {

        int count = 0;

        for (HockeyPlayer player: hockeyPlayers) {
            if (player.getRoleShortName().equals(PlayerRole.Goalkeeper)) {
                count += 1;
            }
        }

        return count;
    }

    public Integer getDefenderCount() {

        int count = 0;

        for (HockeyPlayer player: hockeyPlayers) {
            if (player.getRoleShortName().equals(PlayerRole.Defender)) {
                count += 1;
            }
        }

        return count;
    }

    public Integer getForwardCount() {

        int count = 0;

        for (HockeyPlayer player: hockeyPlayers) {
            if (player.getRoleShortName().equals(PlayerRole.Forward)) {
                count += 1;
            }
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HockeyTeam that = (HockeyTeam) o;
        return teamTime == that.teamTime &&
                Objects.equals(teamPriceAmount, that.teamPriceAmount) &&
                Objects.equals(hockeyPlayers, that.hockeyPlayers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamPriceAmount, teamTime, hockeyPlayers);
    }
}
