import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("<===== OOP Practice: Student Management System =====>");
        Scanner scanner = new Scanner(System.in);

        // student array - arraylist of student objects
        ArrayList<Student> studentsArray = new ArrayList<>();

        // add student - prompt user to add new students and details
        addStudent(studentsArray, scanner);

        // student statistics
        System.out.println("\n=== STUDENT STATISTICS ===");

        if(!studentsArray.isEmpty()){
            int averageAge = averageAge(studentsArray);
            double averageHeight = averageHeight(studentsArray);
            Student oldestStudent = oldestStudent(studentsArray);
            Student tallestStudent = tallestStudent(studentsArray);

            System.out.println("Average age: " + averageAge);
            System.out.println("Average height: " + averageHeight + " feet");
            System.out.println("Oldest student: " + oldestStudent.name + ", " + oldestStudent.age  + " [ Roll Number: " + oldestStudent.rollNumber + " ]");
            System.out.println("Tallest student: " + tallestStudent.name + ", " + tallestStudent.height + " [ Roll Number: " + tallestStudent.rollNumber + " ]");
        }

        if(studentsArray.isEmpty()){
            System.out.println("No students found...");
        }
    }


    // ===================================
    // ===================================

    // add new student
    public static void addStudent(ArrayList<Student> studentsArray, Scanner scanner){
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

                // create new student object and add to students array
                Student student = new Student(nameInput, rollNumInput, ageInput, heightInput);
                studentsArray.add(student);

                // display all added students
                viewStudents(studentsArray);

            }else if(userInput.equals("n")){
                break;
            }
        }
    }

    // view all students after a new student gets added
    public static void viewStudents(ArrayList<Student> studentsArray){
        System.out.println("\n=== ALL STUDENTS ===");

        for(Student student: studentsArray){
            System.out.printf("Name: %s\tRoll #: %d\tAge: %d\t Height: %.1f\n", student.name, student.rollNumber, student.age, student.height);
        }

        System.out.println("");
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

    // oldest student
    // returns Student instance object
    public static Student oldestStudent(ArrayList<Student> studentArray){
        int oldestAge = studentArray.get(0).age;
        Student oldestStudent = studentArray.get(0);

        for(Student student: studentArray){
            if(student.age > oldestAge){
                oldestStudent = student;
            }
        }
        return oldestStudent;
    }

    // tallest student
    // returns Student instance object
    public static Student tallestStudent(ArrayList<Student> studentArray){
        double tallestHeight = studentArray.get(0).height;
        Student tallestStudent = studentArray.get(0);

        for(Student student: studentArray){
            if(student.height > tallestHeight){
                tallestStudent = student;
            }
        }
        return tallestStudent;
    }
}
