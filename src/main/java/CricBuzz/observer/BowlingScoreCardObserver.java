package CricBuzz.observer;

import CricBuzz.entity.Ball;
import CricBuzz.entity.BallType;
import CricBuzz.entity.BowlingScoreCard;
import CricBuzz.entity.RunType;

public class BowlingScoreCardObserver implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball) {
        BowlingScoreCard bowlingScoreCard = (BowlingScoreCard)ball.getBowledBy().getBowlingScoreCard();

        if (ball.getBallNo() == 6 && ball.getBallType() == BallType.LEGIT) {
            bowlingScoreCard.setTotalOversBowled(bowlingScoreCard.getTotalOversBowled()+1);
        }
        if (RunType.SINGLE == ball.getRunType()) {
            bowlingScoreCard.setTotalRunsGiven(bowlingScoreCard.getTotalRunsGiven()+1);
        } else if (RunType.DOUBLE == ball.getRunType()) {
            bowlingScoreCard.setTotalRunsGiven(bowlingScoreCard.getTotalRunsGiven()+2);
        } else if (RunType.FOUR == ball.getRunType()) {
            bowlingScoreCard.setTotalRunsGiven(bowlingScoreCard.getTotalRunsGiven()+4);
        } else if (RunType.SIX == ball.getRunType()) {
            bowlingScoreCard.setTotalRunsGiven(bowlingScoreCard.getTotalRunsGiven()+6);
        }

        if (ball.getWicketTaken()) {
            bowlingScoreCard.setWicketsTaken(bowlingScoreCard.getWicketsTaken()+1);
        }

        if (ball.getBallType() == BallType.NOBALL) {
            bowlingScoreCard.setNoBallsBowled(bowlingScoreCard.getNoBallsBowled() + 1);
        }

        if (ball.getBallType() == BallType.WIDEBALL) {
            bowlingScoreCard.setWideBallsBowled(bowlingScoreCard.getWideBallsBowled() + 1);
        }

    }
}
