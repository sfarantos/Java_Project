package domain;

import enumeration.PaymentMethod;

public class Ticket {

    private PaymentMethod paymentMethod;
    private Itinerary itinerary;
    private Customer customer;
    private double paymentAmount;

    public Ticket(String paymentMethod, Itinerary itinerary, Customer customer, double paymentAmount) {
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.itinerary = itinerary;
        this.customer = customer;
        this.paymentAmount = paymentAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }






}