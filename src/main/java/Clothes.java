import java.util.Objects;

public class Clothes {
    private String name;
    private String size;
    private double price;
    private int quantity;

    public Clothes(String name, String size, double price, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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


