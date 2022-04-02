import Clients.Client;
import Clients.IndividualEntrepreneur;
import Clients.LegalEntity;
import Clients.NaturalPerson;

import java.util.Scanner;

public class Main {
    Client fizlico = new NaturalPerson(10_000);
    Client ip = new IndividualEntrepreneur(50_000);
    Client urlico = new LegalEntity(100_000);

    static Scanner scInt = new Scanner(System.in);
    static Scanner scCommand = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = true;
        do {
            System.out.printf("Выберите счёт (1 -> %s, 2 -> %s, 3 -> %s, " +
                    "0 -> завершение программы):%n", "Физ. лицо", "ИП", "Юр. лицо");
            int inCommand = nextIntCommand();
            switch (inCommand) {
                case 1:
                    selectOperation(mainAccount);
                    break;
                case 2:
                    selectOperation(depositAccount);
                    break;
                case 3:
                    selectOperation(creditAccount);
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

    public static int nextIntCommand() {
        while (!scInt.hasNextInt()) {
            System.out.println("Неверно! Повторите ввод ещё раз.");
            scInt.next();
        }
        return scInt.nextInt();
    }
}

