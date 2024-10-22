package service;

import domain.Customer;
import domain.Itinerary;
import domain.Ticket;

import java.util.*;
import java.util.stream.Collectors;

public class ReportService {

    // 1. Συνολικός αριθμός και κόστος εισιτηρίων για όλους τους πελάτες
    public void reportTotalTicketsAndCostPerCustomer(List<Ticket> tickets) {
        Map<Customer, List<Ticket>> customerTickets = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getCustomer));

        for (Customer customer : customerTickets.keySet()) {
            List<Ticket> customerTicketList = customerTickets.get(customer);
            double totalCost = customerTicketList.stream().mapToDouble(Ticket::getFinalPrice).sum();
            System.out.println("Customer: " + customer.getName() + ", Total Tickets: " + customerTicketList.size() + ", Total Cost: " + totalCost);
        }
    }

    // 2. Δρομολόγια ανά προορισμό και αναχώρηση
    public void reportItinerariesPerDestination(List<Itinerary> itineraries) {
        Map<String, List<Itinerary>> itinerariesByDestination = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDestinationCode));

        System.out.println("Itineraries per Destination:");
        for (String destination : itinerariesByDestination.keySet()) {
            List<Itinerary> destinationItineraries = itinerariesByDestination.get(destination);
            System.out.println("Destination: " + destination + ", Itineraries: " + destinationItineraries.size());
        }
    }

    public void reportItinerariesPerDeparture(List<Itinerary> itineraries) {
        Map<String, List<Itinerary>> itinerariesByDeparture = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDepartureCode));

        System.out.println("Itineraries per Departure:");
        for (String departure : itinerariesByDeparture.keySet()) {
            List<Itinerary> departureItineraries = itinerariesByDeparture.get(departure);
            System.out.println("Departure: " + departure + ", Itineraries: " + departureItineraries.size());
        }
    }

    // 3. Πελάτες με τα περισσότερα εισιτήρια και το μεγαλύτερο κόστος αγορών
    public void reportCustomersWithMostTickets(List<Ticket> tickets) {
        Map<Customer, Long> ticketCountByCustomer = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getCustomer, Collectors.counting()));

        ticketCountByCustomer.entrySet().stream()
                .sorted(Map.Entry.<Customer, Long>comparingByValue().reversed())
                .limit(1)
                .forEach(entry -> System.out.println("Customer with Most Tickets: " + entry.getKey().getName() + ", Tickets: " + entry.getValue()));
    }

    public void reportCustomersWithLargestCost(List<Ticket> tickets) {
        Map<Customer, Double> totalCostByCustomer = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getCustomer, Collectors.summingDouble(Ticket::getFinalPrice)));

        totalCostByCustomer.entrySet().stream()
                .sorted(Map.Entry.<Customer, Double>comparingByValue().reversed())
                .limit(1)
                .forEach(entry -> System.out.println("Customer with Largest Cost: " + entry.getKey().getName() + ", Total Cost: " + entry.getValue()));
    }

    // 4. Πελάτες χωρίς αγορές εισιτηρίων
    public void reportCustomersWithoutTickets(List<Customer> customers, List<Ticket> tickets) {
        Set<Customer> customersWithTickets = tickets.stream()
                .map(Ticket::getCustomer)
                .collect(Collectors.toSet());

        customers.stream()
                .filter(customer -> !customersWithTickets.contains(customer))
                .forEach(customer -> System.out.println("Customer without Tickets: " + customer.getName()));
    }






}
