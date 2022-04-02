package Clients;

public class LegalEntity extends Client {

    public LegalEntity(int availableMoney) {
        super(availableMoney);
    }

    @Override
    public boolean getAccountAmount(int money) {
        return 0;
    }

    @Override
    public boolean setAccountAmount(int money) {

    }
}
