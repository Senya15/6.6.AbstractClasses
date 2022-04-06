import Clients.Client;
import Clients.IndividualEntrepreneur;
import Clients.LegalEntity;
import Clients.NaturalPerson;

import java.util.Scanner;

public class Main {
    static NaturalPerson fizlico = new NaturalPerson(10_000);
    static IndividualEntrepreneur ip = new IndividualEntrepreneur(50_000);
    static LegalEntity urlico = new LegalEntity(100_000);

    static ClientStatus status;
    static Scanner scInt = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = true;
        do {
            System.out.printf("Выберите клиента (1 -> %s, 2 -> %s, 3 -> %s, " +
                    "0 -> завершение программы):%n", "Физ. лицо", "ИП", "Юр. лицо");
            int inCommand = nextIntCommand();
            switch (inCommand) {
                case 1:
                    setClientStatus(ClientStatus.FIZLICO);
                    selectOperation(fizlico);
                    break;
                case 2:
                    setClientStatus(ClientStatus.IP);
                    selectOperation(ip);
                    break;
                case 3:
                    setClientStatus(ClientStatus.URLIZO);
                    selectOperation(urlico);
                    break;
                case 0:
                    System.out.println("Програма завершена...");
                    check = false;
                    scInt.close();
                    break;
                default:
                    System.out.println("Команда не распознана! Повторите");
            }
        } while (check);
    }

    public static void selectOperation(Client client) {
        boolean check = true;
        int money;
        do {
            System.out.printf("Введите одну из команд для клиента \"%s\" (1 -> %s, 2 -> %s, 3 -> %s, 4 -> %s, " +
                            "0 -> Завершение программы):%n", getStatus().getLocalisation(),
                    "Информация о счёте", "Деньги \"на руках\" у клиента", "Снятие со счёта", "Пополнение счёта");
            int inCommand = nextIntCommand();
            switch (inCommand) {
                case 1:
                    System.out.println(client.getInfoAccount());
                    break;
                case 2:
                    System.out.println(client.getInfoAvailableMoney() + " рублей");
                    break;
                case 3:
                    System.out.printf("Введите сумму для снятия со счёта клиента \"%s\"%n", getStatus().getLocalisation());
                    money = nextIntAmount();
                    if (money == 0) break;
                    if (client.getAccountMoney(money)) {
                        System.out.printf("Вы сняли %d рублей%n", money);
                        if (client.equals(urlico)) {
                            System.out.printf("Комиссия составила %d рублей%n", urlico.getCommission());
                        }
                    } else System.out.println("Недостаточно средст на счёте!");
                    break;
                case 4:
                    System.out.printf("Внесите сумму для пополнения счёта клиента \"%s\"%n", getStatus().getLocalisation());
                    money = nextIntAmount();
                    if (money == 0) break;
                    if (client.setAccountAmount(money)) {
                        System.out.printf("Вы пополнили счёт клиента \"%s\" на %d рублей%n",
                                getStatus().getLocalisation(), money);
                        if (client.equals(ip)) {
                            System.out.printf("Комиссия составила %d рублей%n", ip.getCommission());
                        }
                    } else System.out.println("Недостаточно средст для пополнения! В наличии " +
                            client.getInfoAvailableMoney() + " рублей");
                    break;
                case 0:
                    System.out.printf("Клиент \"%s\" заершил работу со счётом...%n", getStatus().getLocalisation());
                    check = false;
                    break;
                default:
                    System.out.println("Команда не распознана! Повторите");
            }
        } while (check);
    }

    public static void setClientStatus(ClientStatus status) {
        Main.status = status;
    }

    public static ClientStatus getStatus() {
        return Main.status;
    }

    public static int nextIntCommand() {
        while (!scInt.hasNextInt()) {
            System.out.println("Неверно! Повторите ввод ещё раз.");
            scInt.next();
        }
        return scInt.nextInt();
    }

    public static int nextIntAmount() {
        int number = 1;
        do {
            if (number < 0) {
                System.out.println("Сумма должна быть больше нуля!");
            }
            while (!scInt.hasNextInt()) {
                System.out.println("Неверно! Повторите ввод ещё раз.");
                scInt.next();
            }
            number = scInt.nextInt();
        } while (number < 0);
        return number;
    }
}

