
import java.util.Objects;

public class Clothes {
    private String name;
    private String size;
    private double price;
    private int quantity;

    public Clothes(String name, String size, double price, int quantity) {
        setName(name);
        setSize(size);
        setPrice(price);
        setQuantity(quantity);
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

    public String toString() {
        return "Clothes{name='" + name +
                "', size='" + size +
                "', price=" + price +
                ", quantity=" + quantity + "}";
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
                && Objects.equals(size, other.size);
    }
}



