package domain;

public class Ticket {


    private Customer customer;
    private Itinerary itinerary;

    private double finalPrice;

    public Ticket( Customer customer, Itinerary itinerary, double paymentAmount) {
        this.itinerary = itinerary;
        this.customer = customer;
        this.finalPrice = paymentAmount;
    }


    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }






}