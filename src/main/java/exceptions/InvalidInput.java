package exceptions;

public class InvalidInput extends RuntimeException{
    public InvalidInput() {
        super("error! invalidInput has been detected\n");
    }
}
