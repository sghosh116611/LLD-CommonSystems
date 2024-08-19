package MovieBookingSystem;

import MovieBookingSystem.controller.BookingController;
import MovieBookingSystem.controller.HallController;
import MovieBookingSystem.controller.MovieController;
import MovieBookingSystem.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    /*MVC Architecture*/
    public static void main(String[] args) {
        MovieController movieController = new MovieController();
        HallController hallController = new HallController();
        BookingController bookingController =  new BookingController();


        // Create user
        User user1 = new User();
        user1.setName("Soumojit");
        user1.setId((int) new Random().nextInt(100-10)+10);

        // Create City
        City city1 = new City();
        city1.setCityName("KOLKATA");
        city1.setCityID((int) new Random().nextInt(100-10)+10);

        City city2 = new City();
        city2.setCityName("DELHI");
        city2.setCityID((int) new Random().nextInt(100-10)+10);

        // Create movie
        Movie movie1 = new Movie();
        movie1.setMovieName("KANTARA");
        movie1.setDuration(90);

        Movie movie2 = new Movie();
        movie2.setMovieName("RAMBO");
        movie2.setDuration(120);

        movie1 = movieController.addMovie(movie1,city1);
        movie2 = movieController.addMovie(movie2,city2);

        // Create screen
        Screen screen1 = new Screen();
        screen1.setId((int) new Random().nextInt(100-10)+10);
        screen1.setSeats(new ArrayList<>());

        Screen screen2 = new Screen();
        screen2.setId((int) new Random().nextInt(100-10)+10);
        screen2.setSeats(new ArrayList<>());

        // Create show
        Show show1 = new Show();
        show1.setStartTime(1130);
        show1.setScreen(screen1);
        show1.setMovieDetail(movie1);
        show1.setBookedSeatIds(new ArrayList<>());

        Show show2 = new Show();
        show2.setStartTime(1200);
        show2.setScreen(screen2);
        show2.setMovieDetail(movie2);
        show2.setBookedSeatIds(new ArrayList<>());

        // Create hall
        Hall hall1 = new Hall();
        hall1.setCity(city1);
        List<Screen> screens1 = new ArrayList<>();
        screens1.add(screen1);
        hall1.setScreens(screens1);
        hall1.setCity(city1);
        List<Show> shows = new ArrayList<>();
        shows.add(show1);
        hall1.setShows(shows);

        hallController.addHall(hall1, city1);

        // Create booking

        Booking booking = bookingController.makeBooking(city1,"KANTARA",user1);

    }
}
