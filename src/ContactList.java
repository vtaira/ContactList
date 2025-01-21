// Contact List
// By Veronica Taira
// Jan 21, 2025
import java.util.ArrayList;
import java.util.Scanner;

// Main class, where the contact list is created and modified/searched through
public class ContactList {
    // Holds all of the different contacts
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<>();
    }

    // Returns all contacts
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds a contact to the contact list
    public void addContact() {
        Scanner s = new Scanner(System.in);
        // Asks what kind of contact the user wants to add
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Teenager");
        int contactChoice = s.nextInt();
        s.nextLine();

        // Asks for the things needed for both Students and Teenagers
        System.out.println("First name: ");
        String name = s.nextLine();
        System.out.print("Last Name: ");
        String lastName = s.nextLine();
        System.out.println("Phone number:");
        String phone = s.nextLine();

        // If the user has chosen a Student, ask for a grade
        if (contactChoice == 1) {
            System.out.println("Grade: ");
            int studentGrade = s.nextInt();
            // Creates a new Student object
            Student newStudent = new Student(name, lastName, phone, studentGrade);
            contacts.add(newStudent);

            // If the user has chosen a Teenager, ask for an age
        } else if (contactChoice == 2) {
            System.out.println("Age: ");
            int teenAge = s.nextInt();
            // Creates a new Teenager object
            Teenager newTeen = new Teenager(name, lastName, phone, teenAge);
            contacts.add(newTeen);
        }
    }

    // Prints out all contacts
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    // Sorts contact list through bubble sort by first name, last name, or phone number
    public void sort(int sortBy) {
        // 0 = sort by last name
        if (sortBy == 0) {
            // Traverses through the contact list
            // If the current contact's last name is lower alphabetically than the contact after, switch the two
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < (contacts.size() - 1 - i); j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            // Prints out the contacts in correct order
            printContacts();
        }
        // Sorts by first name
        else if (sortBy == 1) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If the current contacts first name is lower alphabetically than the contact after it
                    // Switch the two
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        Person temp2 = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp2);
                    }
                }
            }
            // Print out the contacts in alphabetical order by first name
            printContacts();
        }
        // Sort by phone number
        else if (sortBy == 2) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If the current contact's phone number is lower alphabetically than the contact after it
                    // switch the two contacts
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        Person temp3 = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp3);
                    }
                }
            }
            // Prints contacts by phone number
            printContacts();
        }

    }

    // Searches through the contacts ArrayList for a given first name
    public String searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i).toString();
            }
        }
        // If the given first name does not exist, tell the user that it's not present in the contact list
        return firstName + " is not in the contact list";
    }

    // Searches through contacts for a given last name
    public String searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                // Returns the contact whose last name matches the given name
                return contacts.get(i).toString();
            }
        }
        // If the last name isn't in the contact list, tell the user
        return lastName + " is not in the contact list";
    }

   // Searches contacts for a given phone number
    public String searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                // Returns the contact whose phone number matches the given one
                return contacts.get(i).toString();
            }
        }
        // If the phone number doesn't exist, tell the user
        return phoneNumber + " is not in the contact list";
    }

    // Lists all the Students in the contacts ArrayList
    public void listStudents() {
        for (Person p : contacts) {
            // If a Person is a Student, and is in contacts, return the Student
            if (p instanceof Student) {
                System.out.println(p.toString());
            }
        }
    }

    // Runs the option list for the contact list, calls the different functions
    public void run() {
        Scanner input = new Scanner(System.in);
        int choice;
       // Continue to print out the menu of options while the user's choice is greater than 0
        do {
            System.out.println("Menu: ");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By Last Name");
            System.out.println("3. List All Contacts By First Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            // Saves user's input into a variable
            choice = input.nextInt();
            input.nextLine();

            // If the choice is 1, call the add contact function
            if (choice == 1) {
                addContact();
            }
            // Else if the choice is 2, sort by last name
           else if (choice == 2) {
                sort(0);
            }
            // Else if the choice 3, sort by first name
          else if (choice == 3) {
                sort(1);
            }

          // Else if the choice is 4, sort by phone number
          else if (choice == 4) {
                sort(2);
            }

          // Else if the choice is 5, list all the students
          else if (choice == 5) {
                listStudents();
            }

          // If the choice is 6, allow the user to input a first name, and search for it in the contact list
          else if (choice == 6) {
                System.out.println("Enter a name: ");
                String name = input.nextLine();
                System.out.println(searchByFirstName(name));
            }

          // If the choice is 7, allow user to input a last name
          // Search for the name in the contact list
          else if (choice == 7) {
                System.out.println("Enter a last name");
                System.out.println(searchByLastName(input.nextLine()));
            }

          // If choice is 8, enter a phone number
          // Search for the phone number in contact list
          else if (choice == 8) {
                System.out.println("Enter a phone number");
                System.out.println(searchByPhoneNumber(input.nextLine()));
            }

        } while (choice > 0);
    }

    // Main method
    // Creates a new contact list
    // Calls the run() function
    public static void main(String args[]) {
        ContactList test = new ContactList();
        test.run();
    }
}



