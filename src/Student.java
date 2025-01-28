// Subclass of Person
public class Student extends Person{
    // Instance variable
    private int grade;

   // Constructor
   // Calls Person's constructor to initialize the first name, last name, and phone number
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Returns the Student's grade
    public int getGrade() {
        return grade;
    }

    // Overrides the Person class to String
    // Returns the Person's toString, and the Student's grade
    public String toString(){
        return super.toString() + " Grade: " + grade;
    }
}
