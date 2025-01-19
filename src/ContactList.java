import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Teenager");
        int contactChoice = s.nextInt();
        s.nextLine();
        System.out.println("First name: ");
        String name = s.nextLine();
        System.out.print("Last Name: ");
        String lastName = s.nextLine();
        System.out.println("Phone number:");
        String phone = s.nextLine();

        if (contactChoice == 1) {
            System.out.println("Grade: ");
            int studentGrade = s.nextInt();
            Student newStudent = new Student(name, lastName, phone, studentGrade);
            contacts.add(newStudent);
        } else if (contactChoice == 2) {
            System.out.println("Age: ");
            int teenAge = s.nextInt();
            Teenager newTeen = new Teenager(name, lastName, phone, teenAge);
            contacts.add(newTeen);
        }
    }


    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    public void sort(int sortBy) {
        //0 = sort by last name
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < (contacts.size() - 1 - i); j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            printContacts();
        } else if (sortBy == 1) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        Person temp2 = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp2);
                    }
                }
            }
            printContacts();
        } else if (sortBy == 2) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        Person temp3 = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp3);
                    }
                }
            }
            printContacts();
        }

    }


    public String searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i).toString();
            }
        }
        return firstName + " is not in the contact list";
    }

    public String searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                return contacts.get(i).toString();
            }
        }
        return lastName + " is not in the contact list";
    }

    public String searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                return contacts.get(i).toString();
            }
        }
        return phoneNumber + " is not in the contact list";
    }

    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p.toString());
            }
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice;
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
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                addContact();
            }

            if (choice == 2) {
                sort(0);
            }

            if (choice == 3) {
                sort(1);
            }

            if (choice == 4) {
                sort(2);
            }

            if (choice == 5) {
                listStudents();
            }

            if (choice == 6) {
                System.out.println("Enter a name: ");
                String name = input.nextLine();
                System.out.println(searchByFirstName(name));
            }

            if (choice == 7) {
                System.out.println("Enter a last name");
                System.out.println(searchByLastName(input.nextLine()));
            }

            if (choice == 8) {
                System.out.println("Enter a phone number");
                System.out.println(searchByPhoneNumber(input.nextLine()));
            }

        } while (choice > 0);
    }

    public static void main(String args[]) {
        ContactList test = new ContactList();
        test.run();
    }
}



