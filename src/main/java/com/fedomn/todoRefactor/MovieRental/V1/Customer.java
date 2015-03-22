package com.fedomn.todoRefactor.MovieRental.V1;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalsList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalsList.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = rentalsList.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = rentals.next();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount = 2;
                    if (each.getDayRented() > 2)
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRented() *3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3)
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    break;
            }

            //add frequent renter points
            frequentRenterPoints ++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDayRented() > 1)
                frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
