package com.fedomn.todoRefactor.MovieRental.V1.model;

public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}