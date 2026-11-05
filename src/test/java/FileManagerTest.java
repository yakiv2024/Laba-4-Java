import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Тести читання та запису об'єктів у файл
 */
public class FileManagerTest {

    @TempDir
    File tempDir;

    /**
     * Записує об'єкти всіх типів у файл і зчитує їх назад
     */
    @Test
    void testSaveAndLoadAllTypes() {
        ArrayList<Clothes> original = new ArrayList<>();
        original.add(new Clothes("Base", "M", 100, 1, ClothingCategory.SHOES));
        original.add(new Pants("Nike", "L", 1200, 2, "Slim"));
        original.add(new Shirts("Adidas", "M", 800, 1, "Long"));
        original.add(new Jacket("Columbia", "XL", 3500, 1, "Зима", true));
        original.add(new Shoes("Puma", "42", 2500, 1, "Гума", false));

        String fileName = new File(tempDir, "test.txt").getPath();

        assertTrue(FileManager.save(original, fileName));
        ArrayList<Clothes> loaded = FileManager.load(fileName);

        assertEquals(original.size(), loaded.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).getClass(), loaded.get(i).getClass());
            assertEquals(original.get(i).toString(), loaded.get(i).toString());
        }
    }

    /**
     * Перевіряє, що некоректні рядки пропускаються, а коректні зчитуються
     */
    @Test
    void testLoadSkipsInvalidLines() throws IOException {
        File file = new File(tempDir, "bad.txt");

        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            writer.write("Pants;Nike;L;1200.0;2;Slim\n");
            writer.write("Hat;Cap;M;100.0;1;Red\n");
            writer.write("Shoes;Puma;42;abc;1;Гума;true\n");
            writer.write("Jacket;Columbia;XL;3500.0;1;Зима;maybe\n");
            writer.write("Shirts;Adidas;M;800.0\n");
            writer.write("\n");
            writer.write("Clothes;Base;M;-5;1;TSHIRT\n");
            writer.write("Jacket;Columbia;XL;3500.0;1;Зима;true\n");
        }

        ArrayList<Clothes> loaded = FileManager.load(file.getPath());

        assertEquals(2, loaded.size());
        assertTrue(loaded.get(0) instanceof Pants);
        assertTrue(loaded.get(1) instanceof Jacket);
    }

    /**
     * Перевіряє, що відсутній файл дає порожній список без помилки
     */
    @Test
    void testLoadMissingFile() {
        String fileName = new File(tempDir, "missing.txt").getPath();

        ArrayList<Clothes> loaded = FileManager.load(fileName);

        assertTrue(loaded.isEmpty());
    }

    /**
     * Перевіряє розбір одного рядка
     */
    @Test
    void testParseLine() {
        Clothes item = FileManager.parseLine("Shoes;Puma;42;2500.0;1;Гума;true");

        assertTrue(item instanceof Shoes);
        assertEquals("Гума", ((Shoes) item).getSoleMaterial());
        assertTrue(((Shoes) item).hasLaces());
    }

    /**
     * Перевіряє, що символ ';' у назві не ламає формат файлу
     */
    @Test
    void testSeparatorInName() {
        Pants pants = new Pants("Nike;Pro", "L", 1200, 2, "Slim");

        Clothes loaded = FileManager.parseLine(pants.toFileString());

        assertEquals("Nike,Pro", loaded.getName());
    }
}
