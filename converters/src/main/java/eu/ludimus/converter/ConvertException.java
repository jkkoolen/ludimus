package eu.ludimus.converter;

public class ConvertException extends Exception {
    private static final long serialVersionUID = 19981017L;

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(Throwable cause) {
        super(cause);
    }

}
