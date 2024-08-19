package MovieBookingSystem.controller;

import MovieBookingSystem.entity.City;
import MovieBookingSystem.entity.Movie;
import MovieBookingSystem.service.MovieService;

import java.util.List;

public class MovieController {

    MovieService movieService;

    public MovieController(){
        movieService = new MovieService();
    }

    public Movie addMovie(Movie movieDTO, City cityDTO){
       return movieService.addMove(movieDTO,cityDTO);
    }

    public Movie getMovieByName(String movieName){
        return movieService.getMovieByName(movieName);
    }

    public List<Movie> getMovieByCity(City city){
        return movieService.getMovieByCity(city);
    }
}
