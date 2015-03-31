package com.fedomn.todoRefactor.MovieRental.V1.statement;


import com.fedomn.todoRefactor.MovieRental.V1.Customer;
import com.fedomn.todoRefactor.MovieRental.V1.Rental;

import java.util.Iterator;

public abstract class Statement {

    public String value(Customer aCustomer) {
        Iterator<Rental> rentals = aCustomer.getRentals().iterator();
        String result = headerString(aCustomer);
        while (rentals.hasNext()) {
            Rental each = rentals.next();

            result += eachRentalString(each);
        }
        result += footerString(aCustomer);
        return result;
    }

    abstract String eachRentalString(Rental each);

    abstract String headerString(Customer aCustomer);

    abstract String footerString(Customer aCustomer);

}
