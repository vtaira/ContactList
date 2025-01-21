// Subclass of Person
public class Teenager extends Person {
    // Instance variable that holds the teenager's age
    private int age;

    // Constructor
    // Calls the Person constructor
    // Initializes the Teenager's age
    public Teenager(String firstName, String lastName, String phoneNumber, int age){
        super(firstName, lastName, phoneNumber);
        this.age = age;
    }

    // Returns the age of the teenager
    public int getAge() {
        return age;
    }

    // Overrides the Person toString() method
    // Returns the Person's toString and the Teenager's age
    public String toString(){
        return super.toString() + " Age: " + age;
    }
}
