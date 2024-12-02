import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentToKursant{
    public static void main(String[] args) {
        // Шлях до вхідного файлу
        Path inputFilePath = Paths.get("input.txt");
        // Шлях до вихідного файлу
        Path outputFilePath = Paths.get("output.txt");

        // Перевірка, чи існує вхідний файл
        if (!Files.exists(inputFilePath)) {
            // Якщо файл не існує, створюємо новий з початковим вмістом
            try {
                Files.write(inputFilePath, Arrays.asList(
                        "I am a student of programming.",
                        "The student is learning Java."
                ));
                System.out.println("Вхідний файл не існував, тому було створено файл з початковим вмістом.");
            } catch (IOException e) {
                System.out.println("Помилка при створенні вхідного файлу: " + e.getMessage());
                return;
            }
        }
        try {
            // зчитування всіх рядків з вхідного файлу
            List<String> lines = Files.readAllLines(inputFilePath);
            // Заміна "student" на "kursant" у кожному рядку
            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).replace("student", "kursant"));
            }
            // Запис модифікованих рядків у новий файл
            Files.write(outputFilePath, lines);

            System.out.println("Слово 'student' було замінено на 'kursant' і записано у файл: " + outputFilePath.toString());
        } catch (IOException e) {
            // Обробка помилки, якщо виникла проблема при зчитуванні або записі файлу
            System.out.println("Помилка при зчитуванні або записі файлу: " + e.getMessage());
        }
    }
}
