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

        System.out.print("Do you want to see all itineraries (1) or select a departure code (2)? : ");
        int choice = scanner.nextInt();

        Itinerary selectedItinerary = null;
        if (choice == 1) {
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
            selectedItinerary = itineraries[itineraryChoice];
        } else if (choice == 2) {
            System.out.print("Select departure code (1 for ATH, 2 for XAN, 3 for SAM): ");
            int departureChoice = scanner.nextInt();
            String departureCode = switch (departureChoice) {
                case 1 -> "ATH";
                case 2 -> "XAN";
                case 3 -> "SAM";
                default -> throw new IllegalArgumentException("Invalid choice");
            };

            String destinationCode = null;
            if ("ATH".equals(departureCode)) {
                System.out.print("Choose destination (1 for PAR, 2 for LON): ");
                int destChoice = scanner.nextInt();
                destinationCode = (destChoice == 1) ? "PAR" : "LON";
            } else if ("XAN".equals(departureCode)) {
                System.out.print("Choose destination (1 for NYC, 2 for PAR): ");
                int destChoice = scanner.nextInt();
                destinationCode = (destChoice == 1) ? "NYC" : "PAR";
            } else if ("SAM".equals(departureCode)) {
                System.out.print("Choose destination (1 for TOK, 2 for IST): ");
                int destChoice = scanner.nextInt();
                destinationCode = (destChoice == 1) ? "TOK" : "IST";
            }

            System.out.print("Choose airline (1 for Ryanair, 2 for Wizz): ");
            int airlineChoice = scanner.nextInt();
            String airlineName = (airlineChoice == 1) ? "Ryanair" : "Wizz";

            double price = getPriceBasedOnRoute(departureCode, destinationCode);
            selectedItinerary = new Itinerary(departureCode, destinationCode, "date", airlineName, price);
        }

        double finalPrice = calculateFinalPrice(customer, selectedItinerary.getPrice(), paymentMethod);
        customer.addPurchase(finalPrice);

        return new Ticket(customer, selectedItinerary, finalPrice);
    }

    private double getPriceBasedOnRoute(String departureCode, String destinationCode) {
        if ("ATH".equals(departureCode) && "PAR".equals(destinationCode)) return 200;
        if ("ATH".equals(departureCode) && "LON".equals(destinationCode)) return 250;
        if ("XAN".equals(departureCode) && "NYC".equals(destinationCode)) return 500;
        if ("XAN".equals(departureCode) && "PAR".equals(destinationCode)) return 250;
        if ("SAM".equals(departureCode) && "TOK".equals(destinationCode)) return 800;
        if ("SAM".equals(departureCode) && "IST".equals(destinationCode)) return 100;

        return 0;
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




    public void displayAllItineraries() {
        System.out.println("Available Itineraries:");
        for (int i = 0; i < itineraries.length; i++) {
            Itinerary itinerary = itineraries[i];
            System.out.println("Departure: " + itinerary.getDepartureCode() +
                    ", Destination: " + itinerary.getDestinationCode() +
                    ", Date: " + itinerary.getDepartureDate() +
                    ", Airline: " + itinerary.getAirlineName() +
                    ", Price: " + itinerary.getPrice());
        }
    }







}

