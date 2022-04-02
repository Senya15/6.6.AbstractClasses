package Clients;

public abstract class Client {
    int accountAmount;
    int availableMoney;

    public Client(int availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int checkAvailableMoney() {
        return availableMoney;
    }

    public int checkAccountAmount() {
        return accountAmount;
    }

    public abstract void checkAccount();

    public abstract boolean getAccountMoney(int money);

    public abstract boolean setAccountAmount(int money);
}
