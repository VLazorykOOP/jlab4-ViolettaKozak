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
                if(line.codePointAt(line.length()-1)==90 && line.codePointAt(line.length()-2)==94){
                    line = line.substring(0, line.length()-2);
                    writer.write(line);
                    break;
                }
                else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            writer.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

