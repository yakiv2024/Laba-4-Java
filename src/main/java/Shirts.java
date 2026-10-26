/**
 * Клас сорочок, який успадковує Clothes
 */
public class Shirts extends Clothes {
    private String sleeveLength;

    /**
     * Створює об'єкт сорочки
     */
    public Shirts(String name, String size, double price,
                  int quantity, String sleeveLength) {
        super(name, size, price, quantity, ClothingCategory.TSHIRT);
        setSleeveLength(sleeveLength);
    }

    /**
     * Повертає тип рукава
     */
    public String getSleeveLength() {
        return sleeveLength;
    }

    /**
     * Встановлює тип рукава
     */
    public void setSleeveLength(String sleeveLength) {
        if (sleeveLength == null || sleeveLength.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип рукава не може бути порожнім");
        }
        this.sleeveLength = sleeveLength;
    }

    /**
     * Повертає інформацію про сорочку
     */
    public String toString() {
        return "Shirts{name='" + getName() +
                "', size='" + getSize() +
                "', price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", category=" + getCategory() +
                ", sleeveLength='" + sleeveLength + "'}";
    }
}
