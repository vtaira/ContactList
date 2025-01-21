public class Person {
   // Instance variables for Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    // Returns first name, last name, or phone number
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString: returns the Person's first name, last name, and phone number
    public String toString(){
        return firstName + " " + lastName + " - #" + phoneNumber;
    }

}
