package domain;

public class WrongEmailException extends Exception {


    public WrongEmailException() {
        super("Email not valid");
    }



}
