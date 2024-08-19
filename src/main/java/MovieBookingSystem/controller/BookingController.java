package MovieBookingSystem.controller;

import MovieBookingSystem.entity.Booking;
import MovieBookingSystem.entity.City;
import MovieBookingSystem.entity.User;
import MovieBookingSystem.service.BookingService;

import java.util.List;

public class BookingController {

    private BookingService bookingService;

    public BookingController(){
        bookingService = new BookingService();
    }

    public Booking makeBooking(City cityDTO, String movieName, User userDTO){
        return bookingService.book(cityDTO,movieName,userDTO);
    }

    public List<Booking> getBookingHistory(User user){
        return bookingService.getUserBookingHistory(user);
    }
}
