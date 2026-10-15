
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість речей: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Clothes[] clothes = new Clothes[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nРіч №" + (i + 1));

            System.out.print("Назва: ");
            String name = scanner.nextLine();

            System.out.print("Розмір: ");
            String size = scanner.nextLine();

            System.out.print("Ціна: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            clothes[i] = new Clothes(name, size, price);
        }

        System.out.println("\nСписок одягу:");

        for (Clothes item : clothes) {
            System.out.println(item.toString());
        }

        scanner.close();
    }
}
