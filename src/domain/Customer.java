package domain;

import enumeration.Category;
import enumeration.Nationality;
import exceptions.InvalidEmailException;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;
    private Category category;

    private double totalSpent;
    private List<Double> purchaseHistory;




    public Customer( long id, String name, String email, String address, Nationality nationality, Category category) throws InvalidEmailException {
        this.id = id;
        this.name = name;
        if (validEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("fails email can not be @travelcompany.com ");
        }
        this.address = address;
        this.nationality = nationality;
        this.category = category;
        this.totalSpent = 0.0;
        this.purchaseHistory = new ArrayList<>();

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (validEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("fails : the email can not be @travelcompany.com ");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public boolean validEmail(String email) {
//        if (email.endsWith("@travelcompany.com")) {
//            return false;
//        }
//        return true;
        return !email.endsWith("@travelcompany.com");
    }



    public void addPurchase(double amount) {
        purchaseHistory.add(amount);
        totalSpent += amount;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public List<Double> getPurchaseHistory() {
        return purchaseHistory;
    }




}