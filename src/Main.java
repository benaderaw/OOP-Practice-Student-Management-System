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

        // student statistics
        System.out.println("\n=== Student Statistics ===");
        int averageAge = averageAge(studentsArray);
        double averageHeight = averageHeight(studentsArray);

        System.out.println("Average age: " + averageAge);
        System.out.println("Average height: " + averageHeight + " feet");
    }

    // calculate average age
    // not returning double - no need to be precise
    public static int averageAge(ArrayList<Student> studentArray){
        int ageSum = 0;

        for(Student student: studentArray){
           ageSum += student.age;
        }

        return ageSum / studentArray.size();
    }

    // calculate average height
    // return double
    public static double averageHeight(ArrayList<Student> studentArray){
        double heightSum = 0.0;

        for(Student student: studentArray){
            heightSum += student.height;
        }

        return heightSum / studentArray.size();
    }
}
