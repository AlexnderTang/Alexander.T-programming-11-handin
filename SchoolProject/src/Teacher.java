
//Teacher class.
public class Teacher {

    // The fields: firstName, lastName, and subject are the instance variables of the Teacher class
    private String firstName;
    private String lastName;
    private String subject;

    //The constructor instantiates the object, Teacher. It also takes in parameters so the fields can also be initialized when the object is being created.
    public Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //Getter for full name
    public String getName() {
        return lastName + ", " + firstName;
    }

    //Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Setter for LastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter for subject
    public String getSubject() {
        return subject;
    }

    //Setter for Subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //This method turns the Teacher object into a string when printed
    public String toString() {
        return "Name: " + this.getName() + " Subject: " + this.getSubject();
    }
}