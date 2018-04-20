package com.gamefilter.controller;

import com.gamefilter.model.HockeyPlayer;
import com.gamefilter.model.HockeyTeam;
import com.gamefilter.model.PlayerRole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Controller() {
    }

    private List<HockeyPlayer> hockeyPlayersGoalkeeper = new ArrayList<>();
    private List<HockeyPlayer> hockeyPlayersDefender = new ArrayList<>();
    private List<HockeyPlayer> hockeyPlayersForward = new ArrayList<>();
    private List<HockeyTeam> hockeyTeams = new ArrayList<>();

    public void loadPlayers() throws IOException {
        File file = new File("/home/glier/Загрузки/Telegram Desktop/schedule_table_real.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.ready()) {
            String[] arr =  reader.readLine().split(";");

            Integer gameId = Integer.parseInt(arr[0]);
            String playerName = arr[1];
            String teamShortName = arr[2];
            PlayerRole roleShortName = arr[3].equals("G") ? PlayerRole.Goalkeeper : arr[3].equals("D") ? PlayerRole.Defender : PlayerRole.Forward;
            Double playerPrice = Double.parseDouble(arr[4]);
            Integer timePlayed = Integer.parseInt(arr[5]);

            HockeyPlayer player = new HockeyPlayer(gameId, playerName, teamShortName, roleShortName, playerPrice, timePlayed);

            if (player.getRoleShortName().equals(PlayerRole.Goalkeeper) && player.getTimePlayed() != 0) {
                hockeyPlayersGoalkeeper.add(player);
            }

            if (player.getRoleShortName().equals(PlayerRole.Defender) && player.getTimePlayed() != 0) {
                hockeyPlayersDefender.add(player);
            }

            if (player.getRoleShortName().equals(PlayerRole.Forward) && player.getTimePlayed() != 0) {
                hockeyPlayersForward.add(player);
            }
        }
    }

    public void createTeams() {
        for (int i = 0; i < hockeyPlayersGoalkeeper.size() ; i++) {
            for (int j = 0; j < hockeyPlayersDefender.size()-HockeyTeam.MAX_DEFENDER; j++) {
                for (int k = 0; k < hockeyPlayersForward.size()-HockeyTeam.MAX_FORWARD; k++) {
                    int forCount = 0;
                    int defCount = 0;
                    int goaCount = 0;

                    HockeyTeam hockeyTeam = new HockeyTeam();

                    for (int l = 0; l < HockeyTeam.MAX_GOALKEEPER + HockeyTeam.MAX_DEFENDER + HockeyTeam.MAX_FORWARD + 1 ; l++) {
                        if (goaCount < HockeyTeam.MAX_GOALKEEPER) {
                            hockeyTeam.addPlayer(hockeyPlayersGoalkeeper.get(i + goaCount));
                            goaCount++;
                        }
                        if (defCount < HockeyTeam.MAX_DEFENDER) {
                            hockeyTeam.addPlayer(hockeyPlayersDefender.get(j + defCount));
                            defCount++;
                        }
                        if (forCount < HockeyTeam.MAX_FORWARD) {
                            hockeyTeam.addPlayer(hockeyPlayersForward.get(k + forCount));
                            forCount++;
                        }
                    }

                    hockeyTeams.add(hockeyTeam);
                }
            }
        }
    }

    public List<HockeyTeam> getHockeyTeams() {
        return hockeyTeams;
    }

    public List<HockeyPlayer> getHockeyPlayersGoalkeeper() {
        return hockeyPlayersGoalkeeper;
    }

    public List<HockeyPlayer> getHockeyPlayersDefender() {
        return hockeyPlayersDefender;
    }

    public List<HockeyPlayer> getHockeyPlayersForward() {
        return hockeyPlayersForward;
    }
}
