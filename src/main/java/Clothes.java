import java.util.Objects;

public class Clothes {
    private String name;
    private String size;
    private double price;
    private int quantity;
    private ClothingCategory category;

    private static int objectCount = 0;

    public Clothes(String name, String size, double price,
                   int quantity, ClothingCategory category) {
        setName(name);
        setSize(size);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);
        objectCount++;
    }

    public Clothes(String name, String size, double price, int quantity) {
        this(name, size, price, quantity, ClothingCategory.TSHIRT);
    }

    public Clothes(Clothes other) {
        this(other.getName(), other.getSize(), other.getPrice(),
             other.getQuantity(), other.getCategory());
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою");
        }
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Розмір не може бути порожнім");
        }
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Ціна повинна бути невід'ємною");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість повинна бути більшою за нуль");
        }
        this.quantity = quantity;
    }

    public ClothingCategory getCategory() {
        return category;
    }

    public void setCategory(ClothingCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Категорія не може бути порожньою");
        }
        this.category = category;
    }

    public String toString() {
        return "Clothes{name='" + name +
                "', size='" + size +
                "', price=" + price +
                ", quantity=" + quantity +
                ", category=" + category + "}";
    }

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






