package MovieBookingSystem.service;

import MovieBookingSystem.entity.City;
import MovieBookingSystem.entity.Movie;

import java.util.*;

public class MovieService {
    static Map<City, List<Movie>> cityMovies;
    static List<Movie> allMovies;

    public MovieService() {
        cityMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public Movie addMove(Movie movie, City city) {
        movie.setId((int) new Random().nextInt(100 - 10) + 10);

        List<Movie> movies = cityMovies.computeIfAbsent(city, k -> new ArrayList<>());
        movies.add(movie);

        allMovies.add(movie);

        return movie;
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMovieByCity(City city) {

        return new ArrayList<>(cityMovies.get(city));
    }
}
