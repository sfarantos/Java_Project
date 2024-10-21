package service;

public abstract class PaymentMethod {
    public abstract double getDiscount();
}

class CreditCardPayment extends PaymentMethod {
    public double getDiscount() {
        return 0.10;
    }
}

class CashPayment extends PaymentMethod {
    public double getDiscount() {
        return 0.0;
    }
}


