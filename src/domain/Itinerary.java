package domain;

public class Itinerary {


    private String departureCode;
    private String destinationCode;
    private String departureDate;
    private String airlineName;
    private double price;


    public Itinerary(String departureCode , String destinationCode , String departureDate , String airlineName , double price) {
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
        this.departureDate = departureDate;
        this.airlineName = airlineName;
        this.price = price;

    }


    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
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