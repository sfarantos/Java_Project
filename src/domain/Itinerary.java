package domain;

import java.util.Date;

public class Itinerary {

    private Date departureDate;
    private String airlineName;
    private double price;
    private String departureCode;
    private String destinationCode;

    public Itinerary(Date departureDate, String airlineName, double price, String departureCode, String destinationCode) {
        this.departureDate = departureDate;
        this.airlineName = airlineName;
        this.price = price;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }











}