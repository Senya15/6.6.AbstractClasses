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
    public boolean getAccountAmount(int money) {
        if (money <= accountAmount) {
            accountAmount -= money;
            availableMoney += money;
            return true;
        } else return false;
    }

    @Override
    public boolean setAccountAmount(int money) {
        money = setCommission(money);
        if (money <= availableMoney) {
            availableMoney -= money;
            accountAmount += money;
            return true;
        } else return false;
    }

    private int setCommission(int money) {
        if (money < 1000) {
            commission = (int) (money / 100 * PERCENT1);
            money += commission;
        } else {
            commission = (int) (money / 100 * PERCENT2);
            money += commission;
        }
        return money;
    }

//    public int getPercent(){
//        return PERCENT;
//    }
}
