package SnakeAndLadder;

import SnakeAndLadder.entity.Game;

public class Application {
    public static void main(String[] args){
        Game game = new Game(2);
        game.start();
    }
}
