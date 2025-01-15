public class Teenager extends Person {
    private int age;

    public Teenager(String firstName, String lastName, String phoneNumber, int age){
        super(firstName, lastName, phoneNumber);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return super.toString() + " Age: " + age;
    }
}
