package CricBuzz.observer;

import CricBuzz.entity.Ball;
import CricBuzz.entity.BattingScoreCard;
import CricBuzz.entity.RunType;

public class BattingScoreCardObserver implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball) {
        int run = 0;
        BattingScoreCard battingScoreCard = (BattingScoreCard)ball.getPlayedBy().getBattingScoreCard();

        if(RunType.SINGLE == ball.getRunType()){
            run = 1;
        }else if(RunType.DOUBLE == ball.getRunType()){
            run = 2;
        }else if(RunType.TRIPLE == ball.getRunType()){
            run = 3;
        }else if(RunType.FOUR == ball.getRunType()){
            run = 4;
            battingScoreCard.setTotal4s(battingScoreCard.getTotal4s()+1);
        } else if (RunType.SIX == ball.getRunType()) {
            run = 6;
            battingScoreCard.setTotal6s(battingScoreCard.getTotal6s()+1);
        }

        battingScoreCard.setTotalRuns(battingScoreCard.getTotalRuns()+run);
        battingScoreCard.setTotalBalls(battingScoreCard.getTotalBalls()+1);

        if(ball.getWicketTaken()){
            battingScoreCard.setWicket(ball.getWicket());
        }
    }
}
