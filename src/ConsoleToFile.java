import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleToFile {

    public static void main() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

