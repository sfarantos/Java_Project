package service;

import domain.Customer;
import domain.Itinerary;
import domain.Ticket;
import enumeration.Category;
import enumeration.PaymentMethod;
import exceptions.CustomerNotFoundException;

public class TicketService {


    private CustomerService customerService;

    public TicketService(CustomerService customerService){
        this.customerService = customerService;
    }


    public Ticket purchaseTicket(String customerEmail, Itinerary itinerary, PaymentMethod paymentMethod) throws CustomerNotFoundException {
        Customer customer = customerService.searchCustomer(customerEmail);
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
