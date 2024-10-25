

import domain.Customer;
import domain.Itinerary;
import domain.Ticket;
import enumeration.PaymentMethod;
import exceptions.CustomerNotFoundException;
import exceptions.InvalidEmailException;
import enumeration.Category;
import enumeration.Nationality;
import service.CustomerService;
//import service.ReportService;
import service.TicketService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TravelCompanyEShop {


    public static void main(String[] args) {

        long id = 0;

        CustomerService customerService = new CustomerService();
        TicketService ticketService = new TicketService(customerService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Travel Company Menu ===");
            System.out.println("1. Add new customer");
            System.out.println("2. Search customer by email");
            System.out.println("3. Purchase ticket");
            System.out.println("4. Delete customer by email");
            System.out.println("5. Show all customers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    String email = customerService.forValidEmail(scanner);
                    System.out.print("Enter customer address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter customer nationality (1 for GREEK , 2 for ITALIAN , 3 for USA): ");
                    int nationalityChoice = scanner.nextInt();
                    Nationality nationality = switch (nationalityChoice){
                        case 1 -> Nationality.GREEK;
                        case 2 -> Nationality.ITALIAN;
                        case 3 -> Nationality.USA;
                        default -> throw new IllegalArgumentException("Invalid nationality");
                    };


                    System.out.print("Enter customer type (1 for BUSINESS, 2 for INDIVIDUAL): ");
                    int categoryChoice = scanner.nextInt();
                    Category category = (categoryChoice == 1) ? Category.BUSINESS : Category.INDIVIDUAL;

                    try {
                        Customer newCustomer = new Customer(id++ , name , email , address , nationality , category);
                        customerService.addCustomer(newCustomer);
                        System.out.println("Customer added successfully");
                    } catch (InvalidEmailException e){
                        System.out.println("Invalid email format: " + e.getMessage());
                    }
                    break;

                case 2:
                    String searchEmail = customerService.forValidEmail(scanner);
                    try {
                        Customer foundCustomer = customerService.searchCustomer(searchEmail);
                        System.out.println("Customer found: " + foundCustomer.getName() + " (" + foundCustomer.getCategory() + ")");
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    String customerEmail = customerService.forValidEmail(scanner);
                    System.out.print("Enter payment method (1 for CREDIT_CARD , 2 for CASH) : ");
                    int paymentMethodChoice = scanner.nextInt();
                    scanner.nextLine();

                    PaymentMethod paymentMethod;
                    if (paymentMethodChoice == 1) {
                        paymentMethod = PaymentMethod.CREDIT_CARD;
                    } else if (paymentMethodChoice == 2) {
                        paymentMethod = PaymentMethod.CASH;
                    } else {
                        System.out.println("Invalid payment method. Please try again.");
                        continue;
                    }

                    try {
                        Ticket ticket = ticketService.purchaseTicket(customerEmail, paymentMethod, scanner);
                        if (ticket != null) {
                            System.out.println("Ticket purchased for " + ticket.getCustomer().getName() +
                                    ", Final Price: " + ticket.getFinalPrice());
                        }
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 4:
                    String deleteEmail = customerService.forValidEmail(scanner);
                    try{
                        customerService.deleteCustomer(deleteEmail);
                        System.out.println("Customer delete successfully");
                    } catch (CustomerNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    customerService.showAllCustomers();
                    break;



                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }








}
