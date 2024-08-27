package CricBuzz.controller;

import CricBuzz.entity.Player;

import java.util.LinkedList;
import java.util.Queue;

public class BattingController {

    private Queue<Player> yetToPlayPlayers;
    private Player striker;
    private Player nonStriker;

    public BattingController(Queue<Player> yetToPlayPlayers) {
        this.yetToPlayPlayers = new LinkedList<>();
        this.yetToPlayPlayers.addAll(yetToPlayPlayers);
    }

    public void nextBatter(){
        if(striker == null)
            striker = yetToPlayPlayers.poll();
        if(nonStriker == null)
            nonStriker = yetToPlayPlayers.poll();
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }
}
