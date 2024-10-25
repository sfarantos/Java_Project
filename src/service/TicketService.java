package service;

import domain.Customer;
import domain.Itinerary;
import domain.Ticket;
import enumeration.Category;
import enumeration.PaymentMethod;
import exceptions.CustomerNotFoundException;

import java.util.Scanner;

public class TicketService {




    private CustomerService customerService;

    private Itinerary[] itineraries = {
            new Itinerary("ATH", "PAR", "22/11/2024 13:35", "Ryanair", 200),
            new Itinerary("ATH", "LON", "16/12/2024 11:15", "Wizz", 250),
            new Itinerary("XAN", "NYC", "07/01/2024 18:30", "Ryanair", 500),
            new Itinerary("XAN", "PAR", "02/08/2024 16:00", "Wizz", 250),
            new Itinerary("SAM", "TOK", "12/06/2024 07:45", "Ryanair", 800),
            new Itinerary("SAM", "IST", "03/03/2024 09:25", "Wizz", 100)
    };

    public TicketService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Ticket purchaseTicket(String customerEmail, PaymentMethod paymentMethod, Scanner scanner) throws CustomerNotFoundException {
        Customer customer = customerService.searchCustomer(customerEmail);

        System.out.println("Available Itineraries:");
        for (int i = 0; i < itineraries.length; i++) {
            Itinerary itinerary = itineraries[i];
            System.out.println((i + 1) + ". Departure: " + itinerary.getDepartureCode() +
                    ", Destination: " + itinerary.getDestinationCode() +
                    ", Date: " + itinerary.getDepartureDate() +
                    ", Airline: " + itinerary.getAirlineName() +
                    ", Price: " + itinerary.getPrice());
        }

        System.out.print("Select an itinerary (1-" + itineraries.length + "): ");
        int itineraryChoice = scanner.nextInt() - 1;
        if (itineraryChoice < 0 || itineraryChoice >= itineraries.length) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Itinerary selectedItinerary = itineraries[itineraryChoice];
        double finalPrice = calculateFinalPrice(customer, selectedItinerary.getPrice(), paymentMethod);

        return new Ticket(customer, selectedItinerary, finalPrice);
    }

    private double calculateFinalPrice(Customer customer, double basePrice, PaymentMethod paymentMethod) {
        double discount = 0.0;

        if (customer.getCategory() == Category.BUSINESS) {
            discount += 0.10;
        } else if (customer.getCategory() == Category.INDIVIDUAL) {
            discount -= 0.20;
        }

        if (paymentMethod == PaymentMethod.CREDIT_CARD) {
            discount += 0.10;
        }

        double finalPrice = basePrice - (basePrice * discount);
        return finalPrice;
    }





}
