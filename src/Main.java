import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("<===== OOP Practice: Student Management System =====>");
        Scanner scanner = new Scanner(System.in);

        // student array - arraylist of student objects
        ArrayList<Student> studentsArray = new ArrayList<>();

//        // TEST STUDENTS
//        studentsArray.add(new Student("Ben", 77, 19, 5.9));
//        studentsArray.add(new Student("Mike", 300, 15, 9));
//        studentsArray.add(new Student("big T", 35, 18, 10.5));


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

            if(userInput.equals("y") || userInput.equals("yes")){
                System.out.println("\n=== ADDING NEW STUDENT ===");
                // get name
                System.out.print("Student name: ");
                String nameInput = scanner.nextLine().toUpperCase().trim();

                // get roll number
                int rollNumInput;
                while (true) {
                    rollNumInput = isInteger("Roll Number", "Student roll number: ", scanner); // check if user input in an int
                    boolean isRollUnique = isUnique(studentsArray, rollNumInput); // check if int is unique
                    if(isRollUnique){
                        break;
                    }
                }

                // get age
                int ageInput;
                ageInput = ageLimit("Age", "Student age: ", scanner);

                // get height
                double heightInput;
                heightInput = isDouble("Height", "Student height: ", scanner);

                // create new student object and add to students array
                Student student = new Student(nameInput, rollNumInput, ageInput, heightInput);
                studentsArray.add(student);

                // display all added students
                viewStudents(studentsArray);

            }else if(userInput.equals("n") || userInput.equals("no")){
                viewStudents(studentsArray);
                break;
            }
        }
    }

    // view all students after a new student gets added
    public static void viewStudents(ArrayList<Student> studentsArray){
        System.out.println("\n=== ALL STUDENTS ===");

        if(studentsArray.isEmpty()){
            System.out.println("No students found...");
        }else {
            for (Student student : studentsArray) {
                System.out.printf("Name: %s\tRoll #: %d\tAge: %d\t Height: %.1f\n", student.name, student.rollNumber, student.age, student.height);
            }
        }

        System.out.println(" ");
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
        Student oldestStudent = studentArray.get(0);

        for(Student student: studentArray){
            if(student.age > oldestStudent.age){
                oldestStudent = student;
            }
        }
        return oldestStudent;
    }

    // tallest student
    // returns Student instance object
    public static Student tallestStudent(ArrayList<Student> studentArray){
        Student tallestStudent = studentArray.get(0);

        for(Student student: studentArray){
            if(student.height > tallestStudent.height){
                tallestStudent = student;
            }
        }
        return tallestStudent;
    }

    // check if roll number is unique
    public static boolean isUnique(ArrayList<Student> studentsArray, int rollNumInput){
        boolean numIsUnique = true;

        for(Student student: studentsArray){
            if (student.rollNumber == rollNumInput) {
                numIsUnique = false;
                break;
            }
        }

        if(!numIsUnique){
            System.out.println("🔶" + "Roll number already exists, please assign a different roll number.");
        }

        return numIsUnique;
    }

    // check if num is an int
    public static int isInteger(String statLabel, String message, Scanner scanner){
        int num;

        while(true){
            System.out.print(message);
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶" + statLabel + " must be a number...");
            }
        }

        return num;
    }

    // age limits
    public static int ageLimit(String statLabel, String message, Scanner scanner){
        int age;
        while(true) {
            age = isInteger(statLabel, message, scanner);

            if (age <= 4 || age >= 21) {
                System.out.println("🔶" + "Age must be from 5 to 20 years...");
                continue;
            }

            break;
        }

        return age;
    }

    // check if num is a double
    public static double isDouble(String statLabel, String message, Scanner scanner){
        double num;

        while(true){
            System.out.print(message);
            if(scanner.hasNextDouble()){
                num = scanner.nextDouble();
                scanner.nextLine();
                break;
            }else{
                scanner.nextLine();
                System.out.println("🔶" + statLabel + " must be a number...");
            }
        }

        return num;
    }
}
