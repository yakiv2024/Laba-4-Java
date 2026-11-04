import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з одягом
 * Демонструє наслідування та поліморфізм
 */
public class Main {

    /**
     * Точка входу в програму
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Clothes> clothes = new ArrayList<>();

        while (true) {
            System.out.println("\n МЕНЮ ПРОГРАМИ");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести інформацію про всі об'єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Виберіть дію: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    try {
                        System.out.println("Тип одягу:");
                        System.out.println("1. Звичайний одяг");
                        System.out.println("2. Штани");
                        System.out.println("3. Сорочка");
                        System.out.println("4. Куртка");
                        System.out.println("5. Взуття");
                        System.out.println("0. Повернутися до головного меню");
                        System.out.print("Виберіть тип: ");

                        int type = Integer.parseInt(
                                scanner.nextLine().trim());

                        if (type == 0) {
                            System.out.println("Повернення до головного меню");
                            break;
                        }

                        if (type < 1 || type > 5) {
                            throw new IllegalArgumentException(
                                    "Неправильний тип одягу");
                        }

                        System.out.print("Назва: ");
                        String name = scanner.nextLine();

                        System.out.print("Розмір: ");
                        String size = scanner.nextLine();

                        System.out.print("Ціна: ");
                        double price = Double.parseDouble(
                                scanner.nextLine().trim().replace(',', '.'));

                        System.out.print("Кількість: ");
                        int quantity = Integer.parseInt(
                                scanner.nextLine().trim());

                        Clothes item;

                        if (type == 1) {
                            System.out.println("Категорії:");
                            System.out.println("1. TSHIRT");
                            System.out.println("2. JACKET");
                            System.out.println("3. PANTS");
                            System.out.println("4. SHOES");
                            System.out.print("Виберіть категорію: ");

                            int categoryNumber = Integer.parseInt(
                                    scanner.nextLine().trim());

                            ClothingCategory category;

                            switch (categoryNumber) {
                                case 1:
                                    category = ClothingCategory.TSHIRT;
                                    break;
                                case 2:
                                    category = ClothingCategory.JACKET;
                                    break;
                                case 3:
                                    category = ClothingCategory.PANTS;
                                    break;
                                case 4:
                                    category = ClothingCategory.SHOES;
                                    break;
                                default:
                                    throw new IllegalArgumentException(
                                            "Неправильна категорія");
                            }

                            item = new Clothes(
                                    name, size, price, quantity, category);

                        } else if (type == 2) {
                            System.out.print("Фасон штанів: ");
                            String fit = scanner.nextLine();

                            item = new Pants(
                                    name, size, price, quantity, fit);

                        } else if (type == 3) {
                            System.out.print("Тип рукава: ");
                            String sleeveLength = scanner.nextLine();

                            item = new Shirts(
                                    name, size, price, quantity, sleeveLength);

                        } else if (type == 4) {
                            System.out.print("Сезон: ");
                            String season = scanner.nextLine();

                            boolean waterproof = readYesNo(
                                    scanner, "Водонепроникна? (так/ні): ");

                            item = new Jacket(name, size, price,
                                    quantity, season, waterproof);

                        } else {
                            System.out.print("Матеріал підошви: ");
                            String soleMaterial = scanner.nextLine();

                            boolean hasLaces = readYesNo(
                                    scanner, "Є шнурки? (так/ні): ");

                            item = new Shoes(name, size, price,
                                    quantity, soleMaterial, hasLaces);
                        }

                        clothes.add(item);
                        System.out.println("Об'єкт успішно створено!");
                        System.out.println(item);

                    } catch (NumberFormatException e) {
                        System.out.println("Помилка! Введіть правильне число");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка! " + e.getMessage());
                    }
                    break;

                case "2":
                    if (clothes.isEmpty()) {
                        System.out.println("Список одягу порожній");
                    } else {
                        System.out.println("\nСписок одягу:");

                        int index = 1;
                        for (Clothes item : clothes) {
                            System.out.println(index++ + ". Тип: "
                                    + item.getClass().getSimpleName());
                            // поліморфізм: викликається toString()
                            // конкретного підкласу
                            System.out.println("   " + item);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Роботу завершено");
                    scanner.close();
                    return;

                default:
                    System.out.println("Помилка. Виберіть пункт від 1 до 3");
            }
        }
    }

    /**
     * Зчитує відповідь "так" або "ні"
     *
     * @param scanner сканер для введення
     * @param prompt текст запитання
     * @return true для "так", false для "ні"
     * @throws IllegalArgumentException якщо відповідь некоректна
     */
    private static boolean readYesNo(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("так") || answer.equals("y")
                || answer.equals("yes") || answer.equals("1")) {
            return true;
        }
        if (answer.equals("ні") || answer.equals("n")
                || answer.equals("no") || answer.equals("0")) {
            return false;
        }
        throw new IllegalArgumentException("Введіть 'так' або 'ні'");
    }
}