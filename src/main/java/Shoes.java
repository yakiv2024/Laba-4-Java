/**
 * Клас взуття, який успадковує Clothes
 * Містить матеріал підошви та наявність шнурків
 */
public class Shoes extends Clothes {
    private String soleMaterial;
    private boolean hasLaces;

    /**
     * Створює об'єкт взуття
     *
     * @param name назва
     * @param size розмір
     * @param price ціна
     * @param quantity кількість
     * @param soleMaterial матеріал підошви
     * @param hasLaces чи є шнурки
     */
    public Shoes(String name, String size, double price,
                 int quantity, String soleMaterial, boolean hasLaces) {
        super(name, size, price, quantity, ClothingCategory.SHOES);
        setSoleMaterial(soleMaterial);
        setHasLaces(hasLaces);
    }

    /**
     * Повертає матеріал підошви
     */
    public String getSoleMaterial() {
        return soleMaterial;
    }

    /**
     * Встановлює матеріал підошви
     *
     * @throws IllegalArgumentException якщо матеріал порожній
     */
    public void setSoleMaterial(String soleMaterial) {
        if (soleMaterial == null || soleMaterial.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Матеріал підошви не може бути порожнім");
        }
        this.soleMaterial = soleMaterial;
    }

    /**
     * Повертає, чи має взуття шнурки
     */
    public boolean hasLaces() {
        return hasLaces;
    }

    /**
     * Встановлює наявність шнурків
     */
    public void setHasLaces(boolean hasLaces) {
        this.hasLaces = hasLaces;
    }

    /**
     * Повертає тип застібки взуття
     *
     * @return "шнурки" або "без шнурків"
     */
    public String getFasteningType() {
        return hasLaces ? "шнурки" : "без шнурків";
    }

    /**
     * Повертає інформацію про взуття
     */
    @Override
    public String toString() {
        return "Shoes{name='" + getName() +
                "', size='" + getSize() +
                "', price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", category=" + getCategory() +
                ", soleMaterial='" + soleMaterial +
                "', fastening='" + getFasteningType() + "'}";
    }
}
