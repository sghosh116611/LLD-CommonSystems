package MovieBookingSystem.controller;

import MovieBookingSystem.entity.City;
import MovieBookingSystem.entity.Hall;
import MovieBookingSystem.entity.Movie;
import MovieBookingSystem.service.HallService;

import java.util.List;

public class HallController {

    private HallService hallService;

    public HallController(){
            hallService = new HallService();
    }

    public Hall addHall(Hall hallDTO, City cityDTO){
        return hallService.addHall(cityDTO, hallDTO);
    }
    public List<Hall> getAllShows(Movie movie, City city) {
        return hallService.getAllShows(movie,city);
    }

}
