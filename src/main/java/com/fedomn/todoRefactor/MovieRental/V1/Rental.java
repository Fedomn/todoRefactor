package com.fedomn.todoRefactor.MovieRental.V1;

public class Rental {

    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    double getCharge() {
        return movie.getCharge(dayRented);
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(dayRented);
    }
}
