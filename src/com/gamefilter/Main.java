package com.gamefilter;

import com.gamefilter.controller.Controller;
import com.gamefilter.model.HockeyPlayer;
import com.gamefilter.model.HockeyTeam;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.loadPlayers();
        controller.createTeams();

        Double maxPrice = 100.0;
        Double minPrice = maxPrice - 30.0;

        System.out.println("Filter max price: " + maxPrice);

        List<HockeyTeam> hockeyTeams = controller.getHockeyTeams();

        for (HockeyTeam team: hockeyTeams) {
            if (team.getTeamPriceAmount() > minPrice && team.getTeamPriceAmount() < maxPrice) {
                double amount = new BigDecimal(team.getTeamPriceAmount()).setScale(2, RoundingMode.UP).doubleValue();
                int totalTime = team.getTeamTime();
                System.out.println("Total team price: " + amount + "   Total team time: " + totalTime);

                List<HockeyPlayer> hockeyPlayers = team.getPlayers();

                for (HockeyPlayer player: hockeyPlayers) {
                    String role = player.getRoleShortName().toString();
                    String name = player.getPlayerName();
                    String price = player.getPlayerPrice().toString();
                    String time = player.getTimePlayed().toString();
                    System.out.println(String.format("%1$11s | %2$20s | %3$4s | %4$2s", role,name,price,time));
                }

                System.out.println();
                System.out.println();
            }
        }
    }

}
