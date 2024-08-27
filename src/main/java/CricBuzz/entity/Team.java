package CricBuzz.entity;

import CricBuzz.controller.BattingController;
import CricBuzz.controller.BowlingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Team {

    private String teamName;
    private Queue<Player> players;
    private List<Player> benchPlayers;
    private boolean isWinner;
    private int totalRun;

    private BattingController battingController;
    private BowlingController bowlingController;

    public Team(String teamName, Queue<Player> players, List<Player> benchPlayers) {
        this.teamName = teamName;
        this.players = players;
        this.benchPlayers = benchPlayers;
        this.isWinner = false;
        battingController = new BattingController(players);
        List<Player> bowlers = new ArrayList<>();
        for (Player player : players) {
            if (player.getPlayerType() != PlayerType.BATTER)
                bowlers.add(player);
        }
        bowlingController = new BowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public List<Player> getBenchPlayers() {
        return benchPlayers;
    }

    public void setBenchPlayers(List<Player> benchPlayers) {
        this.benchPlayers = benchPlayers;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }

    public BattingController getBattingController() {
        return battingController;
    }

    public void setBattingController(BattingController battingController) {
        this.battingController = battingController;
    }

    public BowlingController getBowlingController() {
        return bowlingController;
    }

    public void setBowlingController(BowlingController bowlingController) {
        this.bowlingController = bowlingController;
    }

    public void nextBatter() {
        battingController.nextBatter();
    }

    public void nextBowler(int maxNoOvers){
        bowlingController.nextBowler(maxNoOvers);
    }

    public void printBattingScoreCard(){

        for(Player playerDetails : players){
            playerDetails.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(Player playerDetails : players){
            if(((BowlingScoreCard)playerDetails.getBowlingScoreCard()).getTotalOversBowled() > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }
}
