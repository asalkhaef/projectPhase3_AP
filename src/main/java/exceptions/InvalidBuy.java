package exceptions;

public class InvalidBuy extends RuntimeException {
    public InvalidBuy() {
        super("error! invalidBuy has been detected\n");
    }
}
