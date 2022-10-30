package exceptions;

public class InvalidEmail extends InvalidInput{
    @Override
    public String getMessage() {
        return super.getMessage() + "...invalid email format\n";
    }
}
