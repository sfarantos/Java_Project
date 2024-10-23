package service;

import domain.Customer;
import exceptions.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    private List<Customer> customerList = new ArrayList<>();



    public CustomerService() {

    }


    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }


//    public void deleteCustomer(long customerid) throws CustomerNotFoundException {
//        //customerList.remove(customer);
//        for (int i =0; i < customerList.size(); i++){
//            if (customerList.get(i).getId()==customerid){
//                customerList.remove(i);
//                return;
//            }
//        }
//        throw new CustomerNotFoundException("Customer id : " + customerid );
//    }



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






//    public Customer searchCustomer(long customerid) throws CustomerNotFoundException {
//        for (Customer customer: customerList){
//            if (customer.getId()==customerid){
//                return customer;
//            }
//        }
//        throw new CustomerNotFoundException(customerid);
//
//    }



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
                System.out.println("ID: " + customer.getId() + " , Name : " + customer.getName() + " , Email : " + customer.getEmail());
            }
        }
    }


    public String forValidEmail(Scanner scanner){
        String email;
        while (true){
            System.out.print("Enter customer email: ");
            email = scanner.nextLine();
            if (email.contains("@")){
                break;
            } else {
                System.out.println("Invalid email. Pleasa enter again the email ");
            }
        }
        return email;
    }





}
