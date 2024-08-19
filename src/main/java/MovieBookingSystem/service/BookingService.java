package MovieBookingSystem.service;

import MovieBookingSystem.controller.HallController;
import MovieBookingSystem.controller.MovieController;
import MovieBookingSystem.entity.*;

import java.util.*;

public class BookingService {

    static Map<User, List<Booking>> userBookings;
    MovieController movieController;
    HallController hallController;

    public BookingService() {
        userBookings = new HashMap<>();
        movieController = new MovieController();
        hallController = new HallController();
    }

    public Booking book(City city, String movieName, User user) {
        Booking bookingDTO = new Booking();

        List<Movie> allMovies = movieController.getMovieByCity(city);
        Movie selectedMovie = null;
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equalsIgnoreCase(movieName)) {
                selectedMovie = movie;
            }
        }

        List<Hall> hallsWithSelectedMovieInTheCity = hallController.getAllShows(selectedMovie, city);

        // Choose a hall
        Hall selectedHall = hallsWithSelectedMovieInTheCity.get(0);

        List<Show> runningShows = selectedHall.getShows();

        // Choose a show
        Show interestedShow = runningShows.get(0);

        // Book seats
        int seatNumber = 15;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);

            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }

            // Start payment
            Payment payment = new Payment();
            payment.setId((int) new Random().nextInt(100-10)+10);
            payment.setPaymentType(PaymentType.CARD);

            booking.setSeats(myBookedSeats);
            booking.setShow(interestedShow);
            booking.setPayment(payment);

            booking.setStatus("Success");

            List<Booking> userBookingsList = userBookings.computeIfAbsent(user, k -> new ArrayList<>());
            userBookingsList.add(booking);
            userBookings.put(user, userBookingsList);

            System.out.println("Booked!");

            return booking;
        } else {
            System.out.println("Seat already booked!");
            return null;
        }
    }

    public List<Booking> getUserBookingHistory(User user){
        return userBookings.get(user);
    }
}
