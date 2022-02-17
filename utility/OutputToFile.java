package utility;

import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; //

public class OutputToFile {
    public void writeOutputToFile(String filename, String data) {
        try {
            FileWriter myWriter = new FileWriter(filename + ".txt");
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
