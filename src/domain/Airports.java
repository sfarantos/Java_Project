package domain;

public class Airports {

    private String airportCode;
    private String airportName;

    public Airports(String airport_code) {
        airportCode = airport_code;
        airportName = "";
    }


    public Airports(String airport_code, String airport_name) {
        airportCode = airport_code;
        airportName = airport_name;
    }


    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }




}
