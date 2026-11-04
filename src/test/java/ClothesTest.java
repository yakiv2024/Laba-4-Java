import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Перевіряє створення куртки
     */
    @Test
    void testJacketInheritance() {
        Jacket jacket = new Jacket("Columbia", "XL", 3500, 1, "Зима", true);

        assertTrue(jacket instanceof Clothes);
        assertEquals("Зима", jacket.getSeason());
        assertTrue(jacket.isSuitableForRain());
        assertEquals(ClothingCategory.JACKET, jacket.getCategory());
    }

    /**
     * Перевіряє некоректний сезон куртки
     */
    @Test
    void testInvalidJacketSeason() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Jacket("Columbia", "XL", 3500, 1, " ", false);
        });
    }

    /**
     * Перевіряє створення взуття
     */
    @Test
    void testShoesInheritance() {
        Shoes shoes = new Shoes("Puma", "42", 2500, 1, "Гума", false);

        assertTrue(shoes instanceof Clothes);
        assertEquals("Гума", shoes.getSoleMaterial());
        assertEquals("без шнурків", shoes.getFasteningType());
        assertEquals(ClothingCategory.SHOES, shoes.getCategory());
    }

    /**
     * Перевіряє некоректний матеріал підошви
     */
    @Test
    void testInvalidShoesSole() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Shoes("Puma", "42", 2500, 1, "", true);
        });
    }

    /**
     * Перевіряє поліморфізм усіх п'яти класів в одному ArrayList
     */
    @Test
    void testPolymorphismAllTypes() {
        List<Clothes> list = new ArrayList<>();
        list.add(new Clothes("Base", "M", 100, 1));
        list.add(new Pants("Nike", "L", 1200, 2, "Slim"));
        list.add(new Shirts("Adidas", "M", 800, 1, "Long"));
        list.add(new Jacket("Columbia", "XL", 3500, 1, "Зима", true));
        list.add(new Shoes("Puma", "42", 2500, 1, "Гума", true));

        String[] prefixes = {"Clothes{", "Pants{", "Shirts{", "Jacket{", "Shoes{"};
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).toString().startsWith(prefixes[i]));
        }
    }
}