import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person a){
        contacts.add(a);
    }

    public void printContacts(){
        for(Person p : contacts){
            System.out.println(p.toString());
        }
    }

    public void sort(int sortBy){  }


    public String searchByFirstName(String firstName){
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getFirstName().equals(firstName)){
                return contacts.get(i).toString();
            }
        }
        return firstName + " is not in the contact list";
    }

    public String searchByLastName(String lastName){
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getLastName().equals(lastName)){
                return contacts.get(i).toString();
            }
        }
        return lastName + " is not in the contact list";
    }

    public String searchByPhoneNumber(String phoneNumber){
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getPhoneNumber().equals(phoneNumber)){
                return contacts.get(i).toString();
            }
        }
        return phoneNumber + " is not in the contact list";
    }

    public void listStudents(){
        for( Person p : contacts)
        {
            if(p instanceof Student){
                System.out.println(p.toString());
            }
        }
    }

    public void run(){
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By Last Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("9. Search By Phone Number");
        System.out.println("0. Exit");

        Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
        while(choice != 0){
            if(choice == 1)
            {
               System.out.println("Select a type of contact to add: ");
               System.out.println("1. Student");
               System.out.println("2. Teenager");
                if(input.nextInt() == 1)
                {
                    System.out.println("First name: ");
                    String name = input.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = input.nextLine();
                    System.out.println("Phone number:");
                    String phone = input.nextLine();
                    System.out.println("Grade: ");
                    int studentGrade = input.nextInt();

                    Student newStudent = new Student(name, lastName, phone, studentGrade);
                    addContact(newStudent);
                }



            }

            if(choice == 2) {
                sort(0);
            }

            if(choice == 3) {
                sort(1);
            }

            if(choice == 4){
                sort(2);
            }

            if(choice == 5){
               listStudents();
            }

            if(choice == 6){
                System.out.println("Enter a name");
                searchByFirstName(input.nextLine());
            }

            if(choice == 7){
                System.out.println("Enter a last name");
                searchByLastName(input.nextLine());
            }

            if(choice == 8){
                System.out.println("Enter a phone number");
                searchByPhoneNumber(input.nextLine());
            }
        }
    }
}


