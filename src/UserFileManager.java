import java.io.*;
import java.nio.file.*;

public class UserFileManager {
    public static void main(String[] args) {
        //Завдання 1 створення директорії
        // Оголошуємо шлях до директорії
        Path directory = Paths.get("G:\\OOP2\\potikVvodyVydedy\\directory");
        try {
            // Перевіряємо, чи існує ця директорія
            if (!Files.exists(directory)) {
                // Якщо не існує, створюємо її
                Files.createDirectory(directory);
                System.out.println("Директорію створено: " + directory.toString());
            } else {
                // Якщо директорія вже є, виводимо повідомлення
                System.out.println("Директорія вже існує.");
            }
        } catch (IOException e) {
            // Якщо сталася помилка (наприклад, немає прав на створення), виводимо помилку
            System.out.println("Помилка при створенні директорії: " + e.getMessage());
            return; // Виходимо з програми, якщо сталася помилка
        }

        //Завдання 2. Зчитувати текст із файлу і підраховувати кількість рядків у ньому;
        Path filePath = directory.resolve("users.txt"); //шлях до файлу "users.txt" у директорії
        try (
                BufferedWriter writer = Files.newBufferedWriter(filePath)
        ) {
            // Записуємо дані про користувачів у файл
            writer.write("Степан, 17, Чоловік\n");
            writer.write("Оля, 24, Жінка\n");
            writer.write("Олег, 21, Чоловік\n");
            writer.write("Анна, 32, Жінка\n");
            System.out.println("Дані записано у файл: " + filePath.toString());
        } catch (IOException e) {
            // Повідомлення про помилку
            System.out.println("Помилка при записі в файл: " + e.getMessage());
            return; // Завершуємо виконання програми, якщо помилка
        }
        // Підрахунок кількості рядків у файлі
        try {
            // Метод Files.lines відкриває файл як потік рядків і обчислює кількість рядків
            long lineCount = Files.lines(filePath).count();
            System.out.println("Кількість рядків у файлі: " + lineCount); // Виводимо кількість рядків
        } catch (IOException e) {
            // Обробка помилки, якщо файл не можна відкрити або зчитати
            System.out.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }

        // Завдання 3. Копіювання в новий файл за введеним шляхом
        System.out.println("Введіть шлях до файлу для копіювання даних:");
        //G:\OOP2\potikVvodyVydedy\directory(\)users-copy.txt - шлях(дужки забрати)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String destinationPath = reader.readLine();  // Зчитуємо шлях
            Path destination = Paths.get(destinationPath); // Перетворюємо шлях у об'єкт Path
            Files.copy(filePath, destination); // Копіюємо файл
            System.out.println("Файл скопійовано до: " + destination.toString());
        } catch (IOException e) {
            System.out.println("Помилка при копіюванні файлу або введенні шляху: " + e.getMessage());
        }

    }
}