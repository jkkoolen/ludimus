package eu.ludimus.redis;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String format) {
        super(format);
    }
}
