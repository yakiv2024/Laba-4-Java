import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Клас для читання та запису об'єктів одягу у текстовий файл
 * Кожен об'єкт зберігається в окремому рядку, поля розділені ';'
 * Перше поле визначає тип об'єкта (Clothes, Pants, Shirts, Jacket, Shoes)
 */
public class FileManager {
    private static final String SEPARATOR = ";";

    /**
     * Зчитує об'єкти з файлу
     * Некоректні рядки пропускаються з повідомленням
     *
     * @param fileName ім'я файлу
     * @return список зчитаних об'єктів
     */
    public static ArrayList<Clothes> load(String fileName) {
        ArrayList<Clothes> clothes = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Файл " + fileName
                    + " не знайдено. Починаємо з порожнього списку");
            return clothes;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    clothes.add(parseLine(line));
                } catch (IllegalArgumentException e) {
                    System.out.println("Рядок " + lineNumber
                            + " пропущено: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }

        return clothes;
    }

    /**
     * Записує всі об'єкти у файл 
     *
     * @param clothes список об'єктів
     * @param fileName ім'я файлу
     * @return true, якщо запис пройшов успішно
     */
    public static boolean save(ArrayList<Clothes> clothes, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, StandardCharsets.UTF_8))) {
            for (Clothes item : clothes) {
                // поліморфізм: кожен клас формує свій рядок
                writer.write(item.toFileString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Помилка запису файлу: " + e.getMessage());
            return false;
        }
    }

    /**
     * Створює об'єкт потрібного класу з одного рядка файлу
     *
     * @param line рядок файлу
     * @return створений об'єкт
     * @throws IllegalArgumentException якщо рядок некоректний
     */
    public static Clothes parseLine(String line) {
        String[] parts = line.split(SEPARATOR, -1);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String type = parts[0];
        int expected;

        switch (type) {
            case "Clothes":
            case "Pants":
            case "Shirts":
                expected = 6;
                break;
            case "Jacket":
            case "Shoes":
                expected = 7;
                break;
            default:
                throw new IllegalArgumentException(
                        "невідомий тип '" + type + "'");
        }

        if (parts.length != expected) {
            throw new IllegalArgumentException("для типу " + type
                    + " очікується " + expected + " полів, а є "
                    + parts.length);
        }

        String name = parts[1];
        String size = parts[2];
        double price;
        int quantity;

        try {
            price = Double.parseDouble(parts[3]);
            quantity = Integer.parseInt(parts[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "некоректна ціна або кількість");
        }

        switch (type) {
            case "Clothes":
                return new Clothes(name, size, price, quantity,
                        parseCategory(parts[5]));
            case "Pants":
                return new Pants(name, size, price, quantity, parts[5]);
            case "Shirts":
                return new Shirts(name, size, price, quantity, parts[5]);
            case "Jacket":
                return new Jacket(name, size, price, quantity,
                        parts[5], parseBoolean(parts[6]));
            default:
                return new Shoes(name, size, price, quantity,
                        parts[5], parseBoolean(parts[6]));
        }
    }

    /**
     * Перетворює текст у категорію одягу
     *
     * @throws IllegalArgumentException якщо категорії не існує
     */
    private static ClothingCategory parseCategory(String value) {
        try {
            return ClothingCategory.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "невідома категорія '" + value + "'");
        }
    }

    /**
     * Перетворює текст true/false у boolean
     *
     * @throws IllegalArgumentException якщо значення не true і не false
     */
    private static boolean parseBoolean(String value) {
        if (value.equalsIgnoreCase("true")) {
            return true;
        }
        if (value.equalsIgnoreCase("false")) {
            return false;
        }
        throw new IllegalArgumentException(
                "очікується true або false, а є '" + value + "'");
    }
}