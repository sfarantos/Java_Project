package exceptions;

public class CustomerNotFoundException extends Throwable {


    public CustomerNotFoundException(long customerid) {
        super("Customer id :" + customerid +" not valid");
    }

}
