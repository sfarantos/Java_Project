package service;

import domain.Customer;
import exceptions.CustomerNotFoundException;

import java.util.ArrayList;

public class CustomerService {

    private ArrayList<Customer> customerList;

    public CustomerService(ArrayList customerList) {
        this.customerList = customerList;
    }


    public ArrayList getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList customerList) {
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
        throw new CustomerNotFoundException(customerid);
    }


    public Customer searchCustomer(long customerid) throws CustomerNotFoundException {
        for (Customer customer: customerList){
            if (customer.getId()==customerid){
                return customer;
            }
        }
        throw new CustomerNotFoundException(customerid);

    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
        }



}
