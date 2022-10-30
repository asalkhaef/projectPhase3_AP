package exceptions;

public class AccountBalanceEx extends InvalidBuy{
    @Override
    public String getMessage() {
        return super.getMessage() + "...error for account balance\n";
    }
}
