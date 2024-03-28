package error;

public class InvalidDiceFaceException extends RuntimeException{
    public InvalidDiceFaceException(final String errorMessage) {
        super(errorMessage);
    }
}
