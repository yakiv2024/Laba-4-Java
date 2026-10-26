import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClothesTest {

    @Test
    void testInvalidPriceInSetter() {
        Clothes item = new Clothes("Shirt", "M", 500, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            item.setPrice(-100);
        });
    }

    @Test
    void testInvalidQuantityInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Jacket", "L", 1500, -2);
        });
    }

    @Test
    void testCopyConstructor() {
        Clothes original = new Clothes(
                "Shirt", "M", 500, 2, ClothingCategory.TSHIRT);

        Clothes copy = new Clothes(original);

        assertEquals(original, copy);
        assertNotSame(original, copy);
    }

    @Test
    void testStaticCounter() {
        int before = Clothes.getObjectCount();

        new Clothes("Shirt", "M", 500, 2);

        assertEquals(before + 1, Clothes.getObjectCount());
    }

    @Test
    void testEnumCategory() {
        Clothes item = new Clothes(
                "Jacket", "L", 1500, 1, ClothingCategory.JACKET);

        assertEquals(ClothingCategory.JACKET, item.getCategory());
    }

    @Test
    void testWardrobeAggregation() {
        Wardrobe wardrobe = new Wardrobe();

        Clothes first = new Clothes("Shirt", "M", 500, 2);
        Clothes second = new Clothes("Jacket", "L", 1500, 1);

        wardrobe.addClothes(first);
        wardrobe.addClothes(second);

        assertEquals(2, wardrobe.getSize());
    }

    @Test
    void testInvalidCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Shirt", "M", 500, 2, null);
        });
    }
}


