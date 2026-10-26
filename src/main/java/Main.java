import java.util.Scanner;

/**
 * Головний клас програми для роботи з одягом
 * Демонструє створення об'єктів, копіювання,
 * enum та агрегацію
 */
public class Main {

    /**
     * Точка входу в програму
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wardrobe wardrobe = new Wardrobe();

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

                        Clothes item = new Clothes(
                                name, size, price, quantity, category);

                        wardrobe.addClothes(item);
                        System.out.println("Об'єкт успішно створено!");

                        Clothes copy = new Clothes(item);

                        System.out.println("Original: " + item);
                        System.out.println("Copy: " + copy);
                        System.out.println("Same object: " + (item == copy));
                        System.out.println("Items in wardrobe: "
                                + wardrobe.getSize());

                    } catch (NumberFormatException e) {
                        System.out.println("Помилка! Введіть правильне число.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка! " + e.getMessage());
                    }
                    break;

                case "2":
                    wardrobe.printClothes();
                    break;

                case "3":
                    System.out.println("Роботу завершено.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Помилка. Виберіть пункт від 1 до 3");
            }
        }
    }
}
