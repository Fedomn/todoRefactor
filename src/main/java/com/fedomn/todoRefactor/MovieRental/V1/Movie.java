package com.fedomn.todoRefactor.MovieRental.V1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }


    abstract class Price {
        abstract int getPriceCode();

        abstract double getCharge(int daysRented);

        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    }

    class ChildrenPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.CHILDREN;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3)
                result += (daysRented - 3) * 1.5;
            return result;
        }
    }

    class NewReleasePrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }

        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }

        int getFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2 : 1;
        }
    }

    class RegularPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.REGULAR;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2)
                result += (daysRented - 2) * 1.5;
            return result;
        }
    }


}
