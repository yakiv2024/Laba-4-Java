
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}

