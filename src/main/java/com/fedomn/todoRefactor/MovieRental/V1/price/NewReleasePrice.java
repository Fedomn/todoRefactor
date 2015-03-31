package com.fedomn.todoRefactor.MovieRental.V1.price;

import com.fedomn.todoRefactor.MovieRental.V1.Movie;

public class NewReleasePrice extends Price{

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
