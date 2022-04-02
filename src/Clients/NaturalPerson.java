package Clients;

public class NaturalPerson extends Client {

    public NaturalPerson(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public void checkAccount() {
        System.out.printf("\tКомисия за снятие - отсутствует%n" +
                "\tКомиссия за пополнение - отсутствует%n" +
                "\tБаланс счёта - %d рублей%n", checkAccountAmount());
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
        if (money <= availableMoney) {
            availableMoney -= money;
            accountAmount += money;
            return true;
        } else return false;
    }
}
