/**
 * Клас штанів, який успадковує Clothes
 */
public class Pants extends Clothes {
    private String fit;

    /**
     * Створює об'єкт штанів
     */
    public Pants(String name, String size, double price,
                 int quantity, String fit) {
        super(name, size, price, quantity, ClothingCategory.PANTS);
        setFit(fit);
    }

    /**
     * Повертає фасон штанів
     */
    public String getFit() {
        return fit;
    }

    /**
     * Встановлює фасон штанів
     */
    public void setFit(String fit) {
        if (fit == null || fit.trim().isEmpty()) {
            throw new IllegalArgumentException("Фасон не може бути порожнім");
        }
        this.fit = fit;
    }

    /**
     * Повертає інформацію про штани
     */
    public String toString() {
        return "Pants{name='" + getName() +
                "', size='" + getSize() +
                "', price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", category=" + getCategory() +
                ", fit='" + fit + "'}";
    }
}

