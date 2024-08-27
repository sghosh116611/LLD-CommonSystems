package CricBuzz.entity;

import java.util.Date;

public class Match {

    private Team teamA;
    private Team teamB;
    private Inning[] innings;
    private MatchType matchType;
    private Date matchDate;
    private Venue venue;
    private Umpire[] umpires;
    private Team tossWinner;

    public Match(Team teamA, Team teamB, Inning[] innings, MatchType matchType, Date matchDate, Venue venue, Umpire[] umpires) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.innings = new Inning[2];
        this.matchType = matchType;
        this.matchDate = matchDate;
        this.venue = venue;
        this.umpires = umpires;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Inning[] getInnings() {
        return innings;
    }

    public void setInnings(Inning[] innings) {
        this.innings = innings;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Umpire[] getUmpires() {
        return umpires;
    }

    public void setUmpires(Umpire[] umpires) {
        this.umpires = umpires;
    }

    public Team getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(Team tossWinner) {
        this.tossWinner = tossWinner;
    }

    public void start(){
        // Toss
        this.tossWinner = toss();

        System.out.println("Match:"+ teamA.getTeamName() + " v/s " + teamB.getTeamName());
        System.out.println("Hosted at: "+ venue.getName() + ". It's a " + venue.getPitchType() + " pitch");
        System.out.println("Today's umpires are ");
        for(int umpireIdx = 0; umpireIdx < 2; umpireIdx++){
            Umpire umpire = umpires[umpireIdx];
            System.out.print(umpire.getName());
            if(umpireIdx != 1)
                System.out.print(" & ");
        }
        System.out.println();
        // Start innings
        for(int inning = 1; inning <= 2; inning++){

            Team battingTeam;
            Team bowlingTeam;
            Inning inningDetails;

            if(inning == 1){
                battingTeam = tossWinner;
                bowlingTeam = (tossWinner.getTeamName().equals(teamA.getTeamName())) ? teamB : teamA;
                inningDetails = new Inning(battingTeam, bowlingTeam,matchType);
                inningDetails.start(-1);
                inningDetails.setTotalRuns(battingTeam.getTotalRun());
            }else{
                bowlingTeam = tossWinner;
                battingTeam = (tossWinner.getTeamName().equals(teamA.getTeamName())) ? teamB : teamA;
                inningDetails = new Inning(battingTeam, bowlingTeam,matchType);
                inningDetails.start(this.innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRun() > battingTeam.getTotalRun()){
                    bowlingTeam.setWinner(true);
                }
            }

            innings[inning - 1] = inningDetails;

            System.out.println("SCORECARD--");
            System.out.println("INNING " + inning + " -- total Run:" + battingTeam.getTotalRun());
            System.out.println("--- Batting ScoreCard :"+ battingTeam.getTeamName() + "-----");

            battingTeam.printBattingScoreCard();

            System.out.println("--- Bowling ScoreCard :"+ bowlingTeam.getTeamName() + "-----");
            bowlingTeam.printBowlingScoreCard();
        }
    }

    private Team toss() {
        if((double) Math.random() < 0.5)
            return teamA;
        else
            return teamB;
    }
}
