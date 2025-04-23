import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();
        int idNum = 1;

        while (true) {
            System.out.print("Enter first name: ");
            String first = in.nextLine();
            System.out.print("Enter last name: ");
            String last = in.nextLine();
            String id = String.format("%06d", idNum++);
            System.out.print("Enter email: ");
            String email = in.nextLine();
            System.out.print("Enter date of birth ");
            String yob = in.nextLine();

            String record = first + ", " + last + ", " + id + ", " + email + ", " + yob;
            data.add(record);

            System.out.print("Would you like to add another? (y/n): ");
            String again = in.nextLine().toLowerCase();
            if (!again.equals("y")) break;
        }

        System.out.print("Enter the name of the file ");
        String filename = in.nextLine();

        try {
            FileWriter writer = new FileWriter("src/" + filename);
            for (String record : data) {
                writer.write(record + "\n");
            }
            writer.close();
            System.out.println("Data has been saved to " + filename);
        } catch (Exception e) {
            System.out.println("There was an error saving the file.");
        }
    }
}
