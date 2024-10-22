package service;

import domain.Customer;
import domain.Itinerary;
import domain.Ticket;
import enumeration.Category;
import enumeration.PaymentMethod;

public class TicketService {
    public Ticket purchaseTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod) {
        double finalPrice = calculateFinalPrice(customer, itinerary.getPrice(), paymentMethod);
        return new Ticket(customer, itinerary, finalPrice);
    }

    private double calculateFinalPrice(Customer customer, double basePrice, PaymentMethod paymentMethod) {
        double discount = 0.0;

        if (customer.getCategory() == Category.BUSINESS) {
            discount += 0.10;
        }
        else if (customer.getCategory() == Category.INDIVIDUAL) {
            discount -= 0.20;
        }


        if (paymentMethod == PaymentMethod.CREDIT_CARD) {
            discount += 0.10;
        }

        double finalPrice = basePrice - (basePrice * discount);
        return finalPrice;
    }









}
