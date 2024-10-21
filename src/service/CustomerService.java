package service;

import domain.Customer;
import exceptions.NoCustomerIdException;

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

    public void deleteCustomer(long customerid) throws NoCustomerIdException {
        //customerList.remove(customer);
        for (int i =0; i < customerList.size(); i++){
            if (customerList.get(i).getId()==customerid){
                customerList.remove(i);
                return;
            }
        }
        throw new NoCustomerIdException(customerid);
    }


    public Customer searchCustomer(long customerid) throws NoCustomerIdException {
        for (Customer customer: customerList){
            if (customer.getId()==customerid){
                return customer;
            }
        }
        throw new NoCustomerIdException(customerid);

    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
        }



}
