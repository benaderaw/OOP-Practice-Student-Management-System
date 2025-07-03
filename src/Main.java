import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("<===== OOP Practice: Student Management System =====>");
        Scanner scanner = new Scanner(System.in);

        // student array - arraylist of student objects
        ArrayList<Student> studentsArray = new ArrayList<>();

        while(true){
            System.out.print("Add a new student? y/n: ");
            String userInput = scanner.nextLine().toLowerCase().trim();

            if(userInput.equals("y")){
                System.out.println("\n=== ADDING NEW STUDENT ===");
                // get name
                System.out.print("Student name: ");
                String nameInput = scanner.nextLine().toUpperCase().trim();

                // get roll number
                System.out.print("Student roll number: ");
                int rollNumInput = scanner.nextInt();

                // get age
                System.out.print("Student age: ");
                int ageInput = scanner.nextInt();

                // get height
                System.out.print("Student height: ");
                double heightInput = scanner.nextDouble();
                scanner.nextLine();

                Student student = new Student(nameInput, rollNumInput, ageInput, heightInput);
                studentsArray.add(student);

            }else if(userInput.equals("n")){
                System.out.println("Goodbye 👋");
                break;
            }
        }

        System.out.println(studentsArray);
    }
}
