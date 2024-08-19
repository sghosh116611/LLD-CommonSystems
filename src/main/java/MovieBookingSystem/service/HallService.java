package MovieBookingSystem.service;

import MovieBookingSystem.entity.City;
import MovieBookingSystem.entity.Hall;
import MovieBookingSystem.entity.Movie;
import MovieBookingSystem.entity.Show;

import java.util.*;

public class HallService {

    static Map<City , List<Hall>> cityHalls;
    static List<Hall> allHalls;

    public HallService(){
        cityHalls = new HashMap<>();
        allHalls = new ArrayList<>();
    }

    public Hall addHall(City city, Hall hall){

        hall.setId((int)new Random().nextInt(100-10)+10);

        List<Hall> halls = cityHalls.computeIfAbsent(city, k -> new ArrayList<>());
        halls.add(hall);

        allHalls.add(hall);

        return hall;
    }

    public List<Hall> getAllShows(Movie movie, City city){

        List<Hall> hallsInTheCity = cityHalls.get(city);
        List<Hall> hallsInCityForSelectedMovie = new ArrayList<>();
        for(Hall hall: hallsInTheCity){
            List<Show> shows = hall.getShows();
            for(Show show: shows){
                Movie showMovie = show.getMovieDetail();
                if(showMovie.getMovieName().equalsIgnoreCase(movie.getMovieName()))
                    hallsInCityForSelectedMovie.add(hall);
            }
        }
        return hallsInCityForSelectedMovie;
    }


}
