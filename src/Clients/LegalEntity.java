package Clients;

public class LegalEntity extends Client {
    private static final float PERCENT = 1f;
    private int commission;

    public LegalEntity(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public void checkAccount() {

    }

    @Override
    public boolean getAccountMoney(int money) {
        money = setCommission(money);
        if (money <= accountAmount) {
            accountAmount -= money;
            availableMoney += money;
            return true;
        } else return false;
    }

    @Override
    public boolean setAccountAmount(int money) {
        if (money <= availableMoney) {
            availableMoney -= money;
            accountAmount += money;
            return true;
        } else return false;
    }

    private int setCommission(int money) {
        commission = (int) (money / 100 * PERCENT);
        money += commission;
        return money;
    }

}
