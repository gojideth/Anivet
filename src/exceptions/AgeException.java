package exceptions;

public class AgeException extends Exception{

    public static final String ERROR_TEXT = "No tiene edad para esta carrera";

    public AgeException() {
        super(ERROR_TEXT);
    }
}
