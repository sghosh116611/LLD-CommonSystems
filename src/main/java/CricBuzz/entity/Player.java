package CricBuzz.entity;

public class Player {

    private String name;
    private PlayerType playerType;
    private ScoreCard battingScoreCard;
    private ScoreCard bowlingScoreCard;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
        battingScoreCard = new BattingScoreCard();
        bowlingScoreCard = new BowlingScoreCard();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public ScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }

    public void setBattingScoreCard(ScoreCard battingScoreCard) {
        this.battingScoreCard = battingScoreCard;
    }

    public ScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }

    public void setBowlingScoreCard(ScoreCard bowlingScoreCard) {
        this.bowlingScoreCard = bowlingScoreCard;
    }

    public void printBattingScoreCard(){
        BattingScoreCard battingScoreCard = (BattingScoreCard) this.getBattingScoreCard();
        System.out.println("PlayerName: " + this.name + " -- totalRuns: " + battingScoreCard.getTotalRuns()
                + " -- totalBallsPlayed: " + battingScoreCard.getTotalBalls() + " -- 4s: " + battingScoreCard.getTotal4s()
                + " -- 6s: " + battingScoreCard.getTotal6s() + " -- outby: " +   ((battingScoreCard.getWicket() != null) ? battingScoreCard.getWicket().getTakenBy().getName() : "notout"));
    }

    public void printBowlingScoreCard(){
        BowlingScoreCard bowlingScoreCard = (BowlingScoreCard) this.getBowlingScoreCard();
        System.out.println("PlayerName: " + this.name + " -- totalOversThrown: " + bowlingScoreCard.getTotalOversBowled()
                + " -- totalRunsGiven: " + bowlingScoreCard.getTotalRunsGiven() + " -- WicketsTaken: " + bowlingScoreCard.getWicketsTaken());
    }

}
