package exceptions;

public class InvalidPhoneNum extends InvalidInput{
    @Override
    public String getMessage() {
        return super.getMessage() + "...invalid phoneNumber format\n";
    }
}
