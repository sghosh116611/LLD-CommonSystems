package CricBuzz.entity;

public class Venue {
    private String name;
    private PitchType pitchType;

    public Venue(String name, PitchType pitchType) {
        this.name = name;
        this.pitchType = pitchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PitchType getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchType pitchType) {
        this.pitchType = pitchType;
    }
}
