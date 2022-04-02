package Clients;

public abstract class Client {
    int accountAmount;
    int availableMoney;

    public Client(int availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int checkMoney() {
        return availableMoney;
    }

    public int checkAccount() {
        return accountAmount;
    }

    public abstract boolean getAccountAmount(int money);

    public abstract boolean setAccountAmount(int money);
}
