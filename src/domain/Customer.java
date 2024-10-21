package domain;

import enumeration.Category;
import enumeration.Nationality;
import exceptions.WrongEmailException;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;
    private Category category;

    public Customer(Long id, String name, String email, String address, Nationality nationality, Category category) throws WrongEmailException {
        this.id = id;
        this.name = name;
        if (validEmail(email)) {
            this.email = email;
        } else {
            throw new WrongEmailException("fails");
        }
        this.address = address;
        this.nationality = nationality;
        this.category = category;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setEmail(String email) throws WrongEmailException {
        if (validEmail(email)) {
            this.email = email;
        } else {
            throw new WrongEmailException("fails");
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
        if (email.endsWith("@travelcompany.com")) {
            return false;
        }
        return true;
    }


//    public void double getDiscount(){
//
//    }
//
//    public BusinessCustomer {
//        public double getDiscount () {
//            return 0.10;
//        }
//    }
//
//    public IndividualCustomer  {
//        public double getDiscount () {
//            return -0.20;
//        }
//    }


}