package Clients;

import lombok.Getter;

@Getter
public class LegalEntity extends Client {
    private static final float PERCENT = 1f;
    private int commission;

    public LegalEntity(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public String getInfoAccount() {
        return String.format("\tКомисия за снятие: %.1f %c%n" +
                "\tКомиссия за пополнение: отсутствует%n" +
                "\tБаланс счёта: %d рублей%n", PERCENT, '%', getAccountBalance());
    }

    @Override
    public boolean getAccountMoney(int money) {
        setCommission(money);
        if (money <= accountAmount) {
            accountAmount -= (money + getCommission());
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

    private void setCommission(int money) {
        commission = (int) Math.ceil((double) money / 100 * PERCENT);
    }
}
