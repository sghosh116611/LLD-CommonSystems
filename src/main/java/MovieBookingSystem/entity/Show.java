package MovieBookingSystem.entity;

import java.util.List;

public class Show {
    private int id;
    private Movie movieDetail;
    private Screen screen;
    private int startTime;
    private List<Integer> bookedSeatIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(Movie movieDetail) {
        this.movieDetail = movieDetail;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }
}
