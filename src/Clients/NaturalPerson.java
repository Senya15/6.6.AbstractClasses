package Clients;

public class NaturalPerson extends Client {

    public NaturalPerson(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public String getInfoAccount() {
        return String.format("\tКомисия за снятие: отсутствует%n" +
                "\tКомиссия за пополнение: отсутствует%n" +
                "\tБаланс счёта: %d рублей%n", getAccountBalance());
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
