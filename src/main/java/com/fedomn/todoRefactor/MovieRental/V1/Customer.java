package com.fedomn.todoRefactor.MovieRental.V1;

import com.fedomn.todoRefactor.MovieRental.V1.statement.HtmlStatement;
import com.fedomn.todoRefactor.MovieRental.V1.statement.TextStatement;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    public double getTotalCharge() {
        double result = 0;
        for (Rental aRental : rentals) {
            result += aRental.getCharge();
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        int result = 0;
        for (Rental aRental : rentals) {
            result += aRental.getFrequentRenterPoints();
        }
        return result;
    }

}
