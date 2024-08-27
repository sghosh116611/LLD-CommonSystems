package CricBuzz;

import CricBuzz.entity.*;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Application ob = new Application();

        Team teamA = ob.addTeam("India");
        Team teamB = ob.addTeam("SriLanka");

        Umpire[] umpires = new Umpire[2];
        umpires[0] = new Umpire("Simon", 45);
        umpires[1] = new Umpire("Jacob",46);
        MatchType matchType = new T20MatchType();
        Match match = new Match(teamA, teamB, null, matchType, new Date("22/07/2024"), new Venue("ABC", PitchType.DRY),umpires);
        match.start();

    }


    private Team addTeam(String name) {

        Queue<Player> playerDetails = new LinkedList<>();

        Player p1 = addPlayer(name + "1", PlayerType.BATTER);
        Player p2 = addPlayer(name + "2", PlayerType.BATTER);
        Player p3 = addPlayer(name + "3", PlayerType.BATTER);
        Player p4 = addPlayer(name + "4", PlayerType.BATTER);
        Player p5 = addPlayer(name + "5", PlayerType.BATTER);
        Player p6 = addPlayer(name + "6", PlayerType.BATTER);
        Player p7 = addPlayer(name + "7", PlayerType.ALL_ROUNDER);
        Player p8 = addPlayer(name + "8", PlayerType.ALL_ROUNDER);
        Player p9 = addPlayer(name + "9", PlayerType.BOWLER);
        Player p10 = addPlayer(name + "10", PlayerType.BOWLER);
        Player p11 = addPlayer(name + "11", PlayerType.BOWLER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        Team team = new Team(name, playerDetails, new ArrayList<>());
        return team;

    }

    private Player addPlayer(String name, PlayerType playerType) {

        return new Player(name, playerType);
    }

}
