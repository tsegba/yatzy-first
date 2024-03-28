package error;

public class InvalidRollDiceException extends RuntimeException{
    public InvalidRollDiceException(final String errorMessage) {
        super(errorMessage);
    }
}
