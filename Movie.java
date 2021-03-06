package no.hvl.dat159;

public abstract class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public abstract double determineAmount(int daysRented);

    public int getFrequentRenterPoints(int frequentRenterPoints, int priceCode, int daysRented) {
        return ++frequentRenterPoints;
    }

    class Childeren extends Movie {

        public Childeren(String title, int priceCode) {

            super(title, priceCode);
        }

        @Override
        public double determineAmount(int daysRented) {
            double thisAmount = 1.5;
            if (daysRented > 3)
                thisAmount += (daysRented - 3) * 1.5;
            return thisAmount;
        }

    }

    class Regular extends Movie {
        public Regular(String title, int priceCode) {

            super(title, priceCode);
        }

        @Override
        public double determineAmount(int daysRented) {
            double thisAmount = 2;
            if (daysRented > 2)
                thisAmount += (daysRented - 2) * 1.5;
            return thisAmount;
        }
    }

    class NewRelease extends Movie {
        public NewRelease(String title, int priceCode) {

            super(title, priceCode);
        }

        @Override
        public double determineAmount(int daysRented) {

            return daysRented * 3;
        }

        @Override
        public int getFrequentRenterPoints(int frequentRenterPoints, int priceCode, int daysRented) {
            frequentRenterPoints++;

            if (daysRented > 1)
                frequentRenterPoints++;
            return frequentRenterPoints;
        }
    }

}
