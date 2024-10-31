package service;

import domain.Customer;

import exceptions.CustomerNotFoundException;


import java.util.*;
import java.util.regex.Pattern;

public class CustomerService {

    private List<Customer> customerList ;


    public CustomerService() {
        this.customerList = new ArrayList<Customer>();
    }


    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }



    public void deleteCustomer(String email) throws CustomerNotFoundException {
        Customer customerToDelete = searchCustomer(email);
        customerList.remove(customerToDelete);
        ressignIds();
    }
//        for (int i =0; i < customerList.size(); i++){
//            if (customerList.get(i).getEmail().equals(email)){
//                customerList.remove(i);
//                return;
//            }
//        }
//        throw new CustomerNotFoundException("Customer with email : " + email + " not found" );
//    }


    private void ressignIds(){
        for (int i = 0 ; i < customerList.size() ; i++){
            customerList.get(i).setId(i + 1);
        }
    }




    public Customer searchCustomer(String email) throws CustomerNotFoundException {
        for (Customer customer: customerList){
            if (customer.getEmail().equals(email)){
                return customer;
            }
        }
        throw new CustomerNotFoundException("Customer with email : " + email + " not found");

    }





    public void addCustomer(Customer customer) {
        customer.setId(customerList.size() +1);
        customerList.add(customer);
        }





    public void showAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customer list:");
            for (Customer customer : customerList) {
                System.out.println("ID: " + customer.getId() +
                        ", Name: " + customer.getName() +
                        ", Email: " + customer.getEmail() +
                        ", Total Spent: " + customer.getTotalSpent());
            }
        }
    }




//    public String forValidEmail(Scanner scanner){
//        String email;
//        while (true){
//            System.out.print("Enter customer email: ");
//            email = scanner.nextLine();
//            if (email.contains("@")){
//                break;
//            } else {
//                System.out.println("Invalid email. Pleasa enter again the email ");
//            }
//        }
//        return email;
//    }


    public String forValidEmail(Scanner scanner) {
        String email;
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        while (true) {
            System.out.print("Enter customer email: ");
            email = scanner.nextLine();

            if (emailPattern.matcher(email).matches()) {
                break;
            } else {
                System.out.println("Invalid email. Please enter again the email ");
            }
        }
        return email;
    }




}



