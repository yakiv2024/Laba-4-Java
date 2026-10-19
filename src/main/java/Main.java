import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count;

        while (true) {
            System.out.print("Введіть кількість речей: ");

            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                scanner.nextLine();

                if (count > 0) {
                    break;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Помилка! Введіть додатне ціле число.");
        }

        Clothes[] clothes = new Clothes[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nРіч №" + (i + 1));

            System.out.print("Назва: ");
            String name = scanner.nextLine();

            System.out.print("Розмір: ");
            String size = scanner.nextLine();

            double price;

            while (true) {
                System.out.print("Ціна: ");

                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    scanner.nextLine();

                    if (Double.isFinite(price) && price >= 0) {
                        break;
                    }
                } else {
                    scanner.nextLine();
                }

                System.out.println("Помилка! Введіть коректну ціну.");
            }

            System.out.print("Кількість: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            clothes[i] = new Clothes(name, size, price, quantity);
        }

        System.out.println("\nСписок одягу:");

        for (Clothes item : clothes) {
            System.out.println(item.toString());
        }

        scanner.close();
    }
}


