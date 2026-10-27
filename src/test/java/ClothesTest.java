import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Автоматичні тести класів одягу
 */
public class ClothesTest {

    /**
     * Перевіряє заборону від'ємної ціни
     */
    @Test
    void testInvalidPriceInSetter() {
        Clothes item = new Clothes("Shirt", "M", 500, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            item.setPrice(-100);
        });
    }

    /**
     * Перевіряє заборону некоректної кількості
     */
    @Test
    void testInvalidQuantityInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Jacket", "L", 1500, -2);
        });
    }

    /**
     * Перевіряє конструктор копіювання
     */
    @Test
    void testCopyConstructor() {
        Clothes original = new Clothes(
                "Shirt", "M", 500, 2, ClothingCategory.TSHIRT);

        Clothes copy = new Clothes(original);

        assertEquals(original, copy);
        assertNotSame(original, copy);
    }

    /**
     * Перевіряє категорію одягу
     */
    @Test
    void testEnumCategory() {
        Clothes item = new Clothes(
                "Jacket", "L", 1500, 1, ClothingCategory.JACKET);

        assertEquals(ClothingCategory.JACKET, item.getCategory());
    }

    /**
     * Перевіряє заборону порожньої категорії
     */
    @Test
    void testInvalidCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Shirt", "M", 500, 2, null);
        });
    }

    /**
     * Перевіряє створення штанів
     */
    @Test
    void testPantsInheritance() {
        Pants pants = new Pants("Nike", "L", 1200, 2, "Slim");

        assertTrue(pants instanceof Clothes);
        assertEquals("Slim", pants.getFit());
        assertEquals(ClothingCategory.PANTS, pants.getCategory());
    }

    /**
     * Перевіряє створення сорочки
     */
    @Test
    void testShirtsInheritance() {
        Shirts shirt = new Shirts("Adidas", "M", 800, 1, "Long");

        assertTrue(shirt instanceof Clothes);
        assertEquals("Long", shirt.getSleeveLength());
        assertEquals(ClothingCategory.TSHIRT, shirt.getCategory());
    }

    /**
     * Перевіряє поліморфізм
     */
    @Test
    void testPolymorphism() {
        Clothes first = new Pants("Nike", "L", 1200, 2, "Slim");
        Clothes second = new Shirts("Adidas", "M", 800, 1, "Long");

        assertTrue(first.toString().startsWith("Pants{"));
        assertTrue(second.toString().startsWith("Shirts{"));
    }

    /**
     * Перевіряє некоректний фасон штанів
     */
    @Test
    void testInvalidPantsFit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pants("Nike", "L", 1200, 2, "");
        });
    }

    /**
     * Перевіряє некоректний тип рукава
     */
    @Test
    void testInvalidShirtsSleeve() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Shirts("Adidas", "M", 800, 1, "");
        });
    }
}
