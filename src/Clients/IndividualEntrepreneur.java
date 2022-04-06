package Clients;

import lombok.Getter;

@Getter
public class IndividualEntrepreneur extends Client {
    private static final float PERCENT1 = 1f;
    private static final float PERCENT2 = 0.5f;
    private int commission;

    public IndividualEntrepreneur(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public String getInfoAccount() {
        return String.format("\tКомисия за снятие: отсутствует%n" +
                "\tКомиссия за пополнение: если сумма < 1000 рублей - %.1f %c, если сумма >= 1000 рублей - %.1f %c%n" +
                "\tБаланс счёта: %d рублей%n", PERCENT1, '%', PERCENT2, '%', getAccountBalance());
    }

    @Override
    public boolean getAccountMoney(int money) {
        if (money <= accountAmount) {
            accountAmount -= money;
            availableMoney += money;
            return true;
        } else return false;
    }

    @Override
    public boolean setAccountAmount(int money) {
        setCommission(money);
        if (money <= availableMoney) {
            availableMoney -= (money + getCommission());
            accountAmount += money;
            return true;
        } else return false;
    }

    private void setCommission(int money) {
        if (money < 1000) {
            commission =  (int) Math.ceil((double) money / 100 * PERCENT1);
        } else {
            commission = (int) Math.ceil((double) money / 100 * PERCENT2);
        }
    }

//    public int getPercent(){
//        return PERCENT;
//    }
}
