package CricBuzz.controller;

import CricBuzz.entity.Player;

import java.util.*;

public class BowlingController {
    private Deque<Player> bowlersList;
    private Map<Player, Integer> oversBowled;
    private Player currentBowler;

    public BowlingController(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>();
        this.oversBowled = new HashMap<>();
        for(Player bowler : bowlersList){
            this.bowlersList.addLast(bowler);
            this.oversBowled.put(bowler, 0);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

    public void nextBowler(int maxOversAllowed){

        // Remove current bowler from top
        Player bowler = bowlersList.poll();

        // if over count == max over --> remove from queue else move it to the last
        if(oversBowled.get(bowler)+1 == maxOversAllowed){
            currentBowler = bowler;
        }else{
            currentBowler = bowler;
            bowlersList.addLast(bowler);
            oversBowled.put(bowler, oversBowled.get(bowler) + 1);
        }

    }
}
