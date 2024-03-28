package error;

public class InvalidYatzyCategoryException extends RuntimeException{
    public InvalidYatzyCategoryException(final String errorMessage) {
        super(errorMessage);
    }
}
