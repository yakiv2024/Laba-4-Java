import java.util.ArrayList;

/**
 * Клас для зберігання об'єктів одягу
 */
public class Wardrobe {
    private ArrayList<Clothes> clothes;

    /**
     * Створює порожній гардероб.
     */
    public Wardrobe() {
        clothes = new ArrayList<>();
    }

    /**
     * Додає об'єкт одягу до гардероба
     */
    public void addClothes(Clothes item) {
        if (item == null) {
            throw new IllegalArgumentException("Об'єкт не може бути null");
        }
        clothes.add(item);
    }

    /**
     * Повертає кількість речей у списку
     */
    public int getSize() {
        return clothes.size();
    }

    /**
     * Виводить усі об'єкти гардероба
     */
    public void printClothes() {
        if (clothes.isEmpty()) {
            System.out.println("Список одягу порожній");
        } else {
            System.out.println("\nСписок одягу:");

            for (Clothes item : clothes) {
                System.out.println(item.toString());
            }
        }
    }
}

