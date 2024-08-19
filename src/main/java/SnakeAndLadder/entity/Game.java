package SnakeAndLadder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Obstacle[][] board;
    Scanner sc;
    private final int numberOfUsers;

    public Game(int numberOfUsers) {
        this.board = new Obstacle[4][4];
        sc = new Scanner(System.in);
        this.numberOfUsers = numberOfUsers;
    }

    public void createBoard() {
        // Create snakes and ladder
        Snake snake1 = new Snake(new Point(3, 2), new Point(0, 0));
        Snake snake2 = new Snake(new Point(1, 2), new Point(0, 3));

        Ladder ladder = new Ladder(new Point(1, 0), new Point(3, 0));

        board[3][2] = snake1;
        board[1][2] = snake2;

        board[1][0] = ladder;

        System.out.println("---- Board ----");

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == null)
                    System.out.print("0");
                else if(board[i][j].getClass().toString().equalsIgnoreCase("class SnakeAndLadder.entity.Snake"))
                    System.out.print("S");
                else if (board[i][j].getClass().toString().equalsIgnoreCase("class SnakeAndLadder.entity.Ladder"))
                    System.out.print("L");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void start() {
        createBoard();
        List<User> userList = new ArrayList<>();


        for (int userCount = 1; userCount <= this.numberOfUsers; userCount++) {
            System.out.println("Enter name of user 1");
            String user1Name = sc.nextLine();
            Dice dice1 = new Dice(0, new Point(0, 0), DiceColor.RED);
            User user = new User(dice1, user1Name);
            userList.add(user);
        }

        Random random = new Random();
        while (true) {
            for (User user : userList) {
                int value = random.nextInt(6) + 1;
                Dice userDice = user.getDice();
                userDice.setDiceValue(value);

                Point userDiceInitialPoint = userDice.getDicePoint();
                int x1 = userDiceInitialPoint.getX1();
                int y1 = userDiceInitialPoint.getY1();
                int y2 = y1 + value;
                int x2 = x1;
                while (y2 >= board.length) {
                    y2 -= board.length;
                    x2++;

                    if(x2 >= board.length){
                        x2 = board.length - 1;
                        y2 = board.length - 1;
                        System.out.println(user.getName() + " wins the game!");
                        return;
                    }
                }
                Point targetPoint = new Point(x2, y2);
                Obstacle obstacle = board[x2][y2];
                if (obstacle != null) {
                    int endingPositionX = obstacle.getEndingPoint().getX1();
                    int endingPositionY = obstacle.getEndingPoint().getY1();

                    Point targetPointForSnakeOrLadder = new Point(endingPositionX, endingPositionY);
                    userDice.setDicePoint(targetPointForSnakeOrLadder);
                } else {
                    userDice.setDicePoint(targetPoint);
                }

                Point diceEndingPosition = userDice.getDicePoint();
                if(diceEndingPosition.getX1() == board.length - 1 && diceEndingPosition.getY1() == board.length - 1){
                    System.out.println(user.getName() + " wins the game");
                    return;
                }
            }
        }
    }
}
