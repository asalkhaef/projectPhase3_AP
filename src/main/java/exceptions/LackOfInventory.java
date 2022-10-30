package exceptions;

public class LackOfInventory extends InvalidBuy{
    @Override
    public String getMessage() {
        return super.getMessage() + "...lack of inventory\n";
    }
}
