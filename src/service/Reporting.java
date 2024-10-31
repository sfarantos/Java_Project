package service;

import domain.Customer;
import domain.Ticket;

import java.util.List;

public class Reporting {

    private CustomerService customerService;
    private TicketService ticketService;

    public Reporting(CustomerService customerService, TicketService ticketService) {
        this.customerService = customerService;
        this.ticketService = ticketService;
    }

    public void showTotalAmountSpent() {
        double totalAmount = 0.0;
        int totalTickets = 0;
        List<Customer> customers = customerService.getCustomerList();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            totalAmount += customer.getTotalSpent();
            totalTickets += customer.getPurchaseHistory().size();
        }

        if (totalAmount == 0) {
            System.out.println("No purchases have been made yet.");
        } else {
            System.out.println("Total amount spent by all customers: " + totalAmount);
            System.out.println("Total number of tickets purchased: " + totalTickets);
        }
    }

    public void showAllItineraries() {
        ticketService.displayAllItineraries();
    }

    public void showAllPurchases() {
        List<Customer> customers = customerService.getCustomerList();
        boolean hasPurchases = false;

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            List<Double> purchases = customer.getPurchaseHistory();
            for (int j = 0; j < purchases.size(); j++) {
                double purchase = purchases.get(j);
                System.out.println("Customer Name: " + customer.getName() +
                        ", Email: " + customer.getEmail() +
                        ", Purchase Amount: " + purchase);
                hasPurchases = true;
            }
        }

        if (!hasPurchases) {
            System.out.println("No purchases have been made.");
        }
    }

    public void showCustomersWithoutPurchases() {
        List<Customer> customers = customerService.getCustomerList();
        boolean hasCustomersWithoutPurchases = false;

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getTotalSpent() == 0.0) {
                System.out.println("Customer Name: " + customer.getName() + ", Email: " + customer.getEmail());
                hasCustomersWithoutPurchases = true;
            }
        }

        if (!hasCustomersWithoutPurchases) {
            System.out.println("No customers without purchases.");
        }
    }








}