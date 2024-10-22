package service;

import domain.Customer;
import exceptions.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> customerList = new ArrayList<>();

//    public CustomerService(List<Customer> customerList) {
//        this.customerList = customerList;
//    }

    public CustomerService() {

    }


    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }


    public void deleteCustomer(long customerid) throws CustomerNotFoundException {
        //customerList.remove(customer);
        for (int i =0; i < customerList.size(); i++){
            if (customerList.get(i).getId()==customerid){
                customerList.remove(i);
                return;
            }
        }
        throw new CustomerNotFoundException("Customer id : " + customerid );
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
        customerList.add(customer);
        }


    public void showAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customer list:");
            customerList.forEach(customer -> System.out.println(customer.getName() + " - " + customer.getEmail()));
        }
    }








}
