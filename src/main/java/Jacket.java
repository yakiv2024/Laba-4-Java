/**
 * Клас куртки, який успадковує Clothes
 * Містить сезон та ознаку водонепроникності
 */
public class Jacket extends Clothes {
    private String season;
    private boolean waterproof;
 
    /**
     * Створює об'єкт куртки
     *
     * @param name назва
     * @param size розмір
     * @param price ціна
     * @param quantity кількість
     * @param season сезон (зима, осінь, весна, літо)
     * @param waterproof чи водонепроникна куртка
     */
    public Jacket(String name, String size, double price,
                  int quantity, String season, boolean waterproof) {
        super(name, size, price, quantity, ClothingCategory.JACKET);
        setSeason(season);
        setWaterproof(waterproof);
    }
 
    /**
     * Повертає сезон куртки
     */
    public String getSeason() {
        return season;
    }
 
    /**
     * Встановлює сезон куртки
     *
     * @throws IllegalArgumentException якщо сезон порожній
     */
    public void setSeason(String season) {
        if (season == null || season.trim().isEmpty()) {
            throw new IllegalArgumentException("Сезон не може бути порожнім");
        }
        this.season = season;
    }
 
    /**
     * Повертає, чи водонепроникна куртка
     */
    public boolean isWaterproof() {
        return waterproof;
    }
 
    /**
     * Встановлює водонепроникність куртки
     */
    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }
 
    /**
     * Перевіряє, чи підходить куртка для дощової погоди
     *
     * @return true, якщо куртка водонепроникна
     */
    public boolean isSuitableForRain() {
        return waterproof;
    }
 
    /**
     * Повертає інформацію про куртку
     */
    @Override
    public String toString() {
        return "Jacket{name='" + getName() +
                "', size='" + getSize() +
                "', price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", category=" + getCategory() +
                ", season='" + season +
                "', waterproof=" + waterproof + "}";
    }
 
    /**
     * Повертає рядок для запису об'єкта у файл
     *
     * @return рядок для файлу
     */
    @Override
    public String toFileString() {
        return getClass().getSimpleName() + ";" + clean(getName()) + ";"
                + clean(getSize()) + ";" + getPrice() + ";" + getQuantity()
                + ";" + clean(season) + ";" + waterproof;
    }
}