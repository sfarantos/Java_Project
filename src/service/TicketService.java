package service;

import domain.Customer;
import domain.Ticket;
import enumeration.PaymentMethod;

class TicketService {
    public double calculateFinalPrice(Ticket ticket, Customer customer, PaymentMethod paymentMethod) {
        double basePrice = ticket.getPaymentAmount();
        double customerDiscount = customer.getDiscount();
        double paymentDiscount = paymentMethod.getDiscount();


        double finalPrice = basePrice * (1 - customerDiscount) * (1 - paymentDiscount);
        return finalPrice;
    }
}
