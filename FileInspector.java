import javax.swing.*;
        import java.io.*;
        import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File("src"));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            int lines = 0;
            int words = 0;
            int chars = 0;

            try {
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    lines++;
                    words += line.split("\\s+").length;
                    chars += line.length();
                    System.out.println(line);
                }
                reader.close();

                System.out.println("\nFile Summary:");
                System.out.println("File name: " + file.getName());
                System.out.println("Lines: " + lines);
                System.out.println("Words: " + words);
                System.out.println("Characters: " + chars);
            } catch (Exception e) {
                System.out.println("Error reading the file.");
            }
        }
    }
}
