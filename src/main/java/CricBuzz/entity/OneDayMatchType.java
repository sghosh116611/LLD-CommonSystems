package CricBuzz.entity;

public class OneDayMatchType implements MatchType{
    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxOversOfBowlers() {
        return 10;
    }
}
