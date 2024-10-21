

import domain.Customer;
import exceptions.WrongEmailException;
import enumeration.Category;
import enumeration.Nationality;

public class TravelCompanyEShop {
    public static void main(String[] args) {

        long id =0;

        Nationality nationality = Nationality.valueOf("italian".toUpperCase());
        System.out.println(nationality);
        try {
            Customer businessCustomer = new Customer(id++ , "Dionysis", "d.petrotos@codehub.gr", "Stadiou 2", Nationality.GREEK, Category.BUSINESS);
            //Customer businessCustomer2 = new Customer(id++ , "Dionysis", "d.petrotos@travelcompany.com", "Stadiou 2", Nationality.GREEK, Category.BUSINESS);
        } catch (WrongEmailException e) {
            e.printStackTrace();
        }

    }






}
