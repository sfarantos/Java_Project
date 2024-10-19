package domain;

public class NoCustomerIdException extends Throwable {


    public NoCustomerIdException(long customerid) {
        super("Customer id :" + customerid +" not valid");
    }

}
