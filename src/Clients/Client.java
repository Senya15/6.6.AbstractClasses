package Clients;

public abstract class Client {
    protected int accountAmount;
    protected int availableMoney;

    Client(int availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int getInfoAvailableMoney() {
        return availableMoney;
    }

    protected int getAccountBalance() {
        return accountAmount;
    }

    public abstract String getInfoAccount();

    public abstract boolean getAccountMoney(int money);

    public abstract boolean setAccountAmount(int money);
}
