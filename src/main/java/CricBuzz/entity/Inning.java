package CricBuzz.entity;

import java.util.ArrayList;
import java.util.List;

public class Inning {

    private Team battingTeam;
    private Team bowlingTeam;
    private int totalRuns;
    private MatchType matchType;

    private List<Over> overs;

    public Inning(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.totalRuns = 0;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public void start(int runsToWin){
        battingTeam.nextBatter();

        int noOfOvers = matchType.noOfOvers();
        for(int overNumber = 1; overNumber <= noOfOvers; overNumber++){
            bowlingTeam.nextBowler(matchType.maxOversOfBowlers());

            Over over = new Over(overNumber, bowlingTeam.getBowlingController().getCurrentBowler());
            overs.add(over);

            boolean won = over.start(battingTeam, bowlingTeam, runsToWin);
            if(won)
                break;

            Player swap = battingTeam.getBattingController().getStriker();
            battingTeam.getBattingController().setStriker(battingTeam.getBattingController().getNonStriker());
            battingTeam.getBattingController().setNonStriker(swap);
        }
    }
}
