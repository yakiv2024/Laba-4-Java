import java.util.Objects;

/**
 * Клас для опису одягу
 * Містить назву, розмір, ціну, кількість та категорію
 */
public class Clothes {
    private String name;
    private String size;
    private double price;
    private int quantity;
    private ClothingCategory category;

    /**
     * Створює новий об'єкт одягу
     *
     * @param name назва одягу
     * @param size розмір одягу
     * @param price ціна
     * @param quantity кількість
     * @param category категорія
     */
    public Clothes(String name, String size, double price,
                   int quantity, ClothingCategory category) {
        setName(name);
        setSize(size);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);
    }

    /**
     * Створює одяг із категорією TSHIRT за замовчуванням
     *
     * @param name назва одягу
     * @param size розмір одягу
     * @param price ціна
     * @param quantity кількість
     */
    public Clothes(String name, String size, double price, int quantity) {
        this(name, size, price, quantity, ClothingCategory.TSHIRT);
    }

    /**
     * Створює копію іншого об'єкта одягу
     *
     * @param other об'єкт для копіювання
     */
    public Clothes(Clothes other) {
        this(other.getName(), other.getSize(), other.getPrice(),
             other.getQuantity(), other.getCategory());
    }

    /**
     * Повертає назву одягу
     *
     * @return назва одягу
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву одягу
     *
     * @param name нова назва
     * @throws IllegalArgumentException якщо назва порожня
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою");
        }
        this.name = name;
    }

    /**
     * Повертає розмір одягу
     *
     * @return розмір одягу
     */
    public String getSize() {
        return size;
    }

    /**
     * Встановлює розмір одягу
     *
     * @param size новий розмір
     * @throws IllegalArgumentException якщо розмір порожній
     */
    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Розмір не може бути порожнім");
        }
        this.size = size;
    }

    /**
     * Повертає ціну одягу
     *
     * @return ціна одягу
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну одягу
     *
     * @param price нова ціна
     * @throws IllegalArgumentException якщо ціна некоректна
     */
    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Ціна повинна бути невід'ємною");
        }
        this.price = price;
    }

    /**
     * Повертає кількість одиниць одягу
     *
     * @return кількість одягу
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Встановлює кількість одиниць одягу
     *
     * @param quantity нова кількість
     * @throws IllegalArgumentException якщо кількість не додатна
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість повинна бути більшою за нуль");
        }
        this.quantity = quantity;
    }

    /**
     * Повертає категорію одягу
     *
     * @return категорія одягу
     */
    public ClothingCategory getCategory() {
        return category;
    }

    /**
     * Встановлює категорію одягу
     *
     * @param category нова категорія
     * @throws IllegalArgumentException якщо категорія null
     */
    public void setCategory(ClothingCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Категорія не може бути порожньою");
        }
        this.category = category;
    }

    /**
     * Повертає текстове представлення об'єкта
     *
     * @return інформація про одяг
     */
    public String toString() {
        return "Clothes{name='" + name +
                "', size='" + size +
                "', price=" + price +
                ", quantity=" + quantity +
                ", category=" + category + "}";
    }

    /**
     * Порівнює два об'єкти одягу за значеннями полів
     *
     * @pram obj об'єкт для порівняння
     * @return true, якщо об'єкти мають однакові значення
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Clothes other = (Clothes) obj;

        return Double.compare(price, other.price) == 0
                && quantity == other.quantity
                && Objects.equals(name, other.name)
                && Objects.equals(size, other.size)
                && category == other.category;
    }
}
