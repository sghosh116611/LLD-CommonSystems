package CricBuzz.entity;

public class T20MatchType implements MatchType{
    @Override
    public int noOfOvers() {
        return 6;
    }

    @Override
    public int maxOversOfBowlers() {
        return 3;
    }
}
