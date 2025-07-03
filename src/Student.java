public class Student {
    String name;
    int rollNumber;
    int age;
    double height;

    Student(String name, int rollNumber, int age, double height){
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.height = height;
    }

    // override
    public String toString(){
        return "Student{name='" + name + "', rollNumber=" + rollNumber + ", age=" + age + ", height=" + height + "}";
    }
}
