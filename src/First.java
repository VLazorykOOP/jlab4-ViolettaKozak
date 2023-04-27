import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class First {

    public static void main() {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо імена файлів від користувача
        System.out.print("Введіть ім'я першого файлу: ");
        String fileName1 = scanner.nextLine();
        System.out.print("Введіть ім'я другого файлу: ");
        String fileName2 = scanner.nextLine();

        List<String> words1 = readWordsFromFile(fileName1);
        List<String> words2 = readWordsFromFile(fileName2);

        words1 = toLowerCase(words1);
        words2 = toLowerCase(words2);

        List<String> commonWords = CommonWords(words1, words2);
        List<String> deduped = commonWords.stream().distinct().collect(Collectors.toList());
        System.out.print("Введіть ім'я файлу для запису: ");
        String outputFileName = scanner.nextLine();
        writeWordsToFile(outputFileName, deduped);

        List<String> sortedWords1 = new ArrayList<>(words1);
        sortedWords1.sort(String.CASE_INSENSITIVE_ORDER);
        sortedWords1 = sortedWords1.stream().distinct().collect(Collectors.toList());
        List<String> sortedWords2 = new ArrayList<>(words2);
        sortedWords2.sort(String.CASE_INSENSITIVE_ORDER);
        sortedWords2 = sortedWords2.stream().distinct().collect(Collectors.toList());

        System.out.println("Слова з першого файлу:");
        for (String word : sortedWords1) {
            System.out.println(word);
        }

        System.out.println("Слова з другого файлу:");
        for (String word : sortedWords2) {
            System.out.println(word);
        }

        scanner.close();
    }

    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new File(fileName));
            String line;
            System.out.println("Файл " + fileName + " відкрито для читання");
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                String[] lineWords = line.split("[ ,.:;?]+");

                for (String word : lineWords) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }

            reader.close();
            System.out.println("Файл " + fileName + " прочитано");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не знайдено");
        }

        return words;
    }
    public static List<String> toLowerCase(List<String> words) {
        List<String> lowerCaseWords = new ArrayList<>();

        for (String word : words) {
            lowerCaseWords.add(word.toLowerCase());
        }

        return lowerCaseWords;
    }

    public static List<String> CommonWords(List<String> w1, List<String> w2){
        List<String> result = new ArrayList<>();

        for(String word : w1){
            for (String wor : w2){
                if(Objects.equals(word, wor)){
                    result.add(word);
                }
            }
        }

        return result;
    }

    public static void writeWordsToFile(String file, List<String> words){
        try(BufferedWriter write = new BufferedWriter(new FileWriter(file))){
            for (String word : words){
                write.write(word + '\n');
            }
            System.out.println("Результат записано у файл");
        }catch (IOException i){
            System.out.println("Помилка запису файлу " + file);
        }
    }
}
