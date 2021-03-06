package com.hotmail.pederwaern.movie_graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.hotmail.pederwaern.movie_graphql.models.ImageConfig;
import com.hotmail.pederwaern.movie_graphql.models.Movie;
import com.hotmail.pederwaern.movie_graphql.models.Rating;
import com.hotmail.pederwaern.movie_graphql.models.User;
import com.hotmail.pederwaern.movie_graphql.repositories.MovieRepository;
import com.hotmail.pederwaern.movie_graphql.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ImageConfig config;
    private final Logger logger = LoggerFactory.getLogger(Query.class);

    public Query(MovieRepository movieRepository, UserRepository userRepository, ImageConfig config) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.config = config;
    }

    public List<User> allUsers() {
        logger.info("All users requested");
        return this.userRepository.allUsers();
    }

    public User getUserById(String id) {
        logger.info("User with id: " + id + " was requested");
        return this.userRepository.getUserById(id); }

    public List<Movie> allMovies() {
        logger.info("All movies requested");
        return movieRepository.getAllMovies();
    }

    public Movie getMovieById(String id) {
        logger.info("Movie by ID: " + id + " was requested");
        return movieRepository.getMovieById(id);
    }

    public List<Rating> allRatings() {
        logger.info("All ratings requested");
        return userRepository.allRatings();}

    public Rating ratingByUserAndMovie(String userId, String movieId) {
        return this.userRepository.getRatingByUserAndMovie(userId, movieId);
    }

    public List<Rating> ratingsByUser(String id) {
         return this.userRepository.getUserById(id).getRatings();
    }
    public Rating ratingById(String id) {
        return userRepository.getRatingById(id);
    }

    public ImageConfig config() {
        return this.config;
    }
}
