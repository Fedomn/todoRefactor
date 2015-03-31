package com.fedomn.todoRefactor.MovieRental.V1.statement;

import com.fedomn.todoRefactor.MovieRental.V1.Customer;
import com.fedomn.todoRefactor.MovieRental.V1.Rental;

public class TextStatement extends Statement{

    String footerString(Customer aCustomer) {
        return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(aCustomer.getFrequentRenterPoints())
                + " frequent renter points";
    }

    String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

}
