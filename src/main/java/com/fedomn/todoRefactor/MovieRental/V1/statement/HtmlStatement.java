package com.fedomn.todoRefactor.MovieRental.V1.statement;

import com.fedomn.todoRefactor.MovieRental.V1.Customer;
import com.fedomn.todoRefactor.MovieRental.V1.Rental;

public class HtmlStatement extends Statement{

    String headerString(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>";
    }

    String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>";
    }

    String footerString(Customer aCustomer) {
        return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>"
                + "On this rental you earned <EM>" + String.valueOf(aCustomer.getFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
    }

}
