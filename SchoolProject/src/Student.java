//Student class
public class Student {

    //The fields: firstName, lastName, grade, studentNumber, and count are the instance variables of the Student class
    private String firstName;
    private String lastName;
    private int grade;
    int studentNumber;
    static int count = 1;

    //The constructor instantiates the object, Student. It also take in parameters so the fields can also be initialized when the object is being created.
    public Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = count;
        count++;
    }

    //Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Getter for full name
    public String getName() {
        return lastName + ", " + firstName;
    }

    //Getter for grade
    public int getGrade() {
        return grade;
    }

    //Setter for grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    //Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter for StudentNumber
    public int getStudentNumber() {
        return studentNumber;
    }

    //This method turns the Student object into a string when printed
    public String toString() {
        return "Name: " + this.getName() + " Grade: " + this.getGrade();
    }
}


