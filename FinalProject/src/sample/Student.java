package sample;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    private int age;
    private String firstName;
    private String lastName;
    private String licenseTest;

    //Student Constructor
    Student(String firstName, String lastName,int age, String licenseTest){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.licenseTest=licenseTest;
    }
    //Requires: A Student Object
    //Modifies: Student.txt
    //Effects: writes firstName + "," + lastName + "." + age + "-" + licenseTest+ "*\r" + ";\r" to Student.txt
    public void writeToFile() throws IOException {
        FileWriter fw= new FileWriter("Student.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + "," + lastName + "." + age + "-" +  licenseTest+ "*\r");
        bw.write(";\r");
        bw.close();
    }

    //Requires: Two Student Objects
    //Modifies: Nothing
    //Effects: Returns true if both Students have the same first and last name, if not return false
    public boolean compareStudent(Student s){
        if((this.getFirstName().equals(s.getFirstName()))&&(this.getLastName().equals(s.getLastName()))){
            return true;
        }
        else return false;
    }
    //Getters
    public String getFirstName() { return firstName;}

    public String getLastName() { return lastName; }

    public int getAge() {
        return age;
    }

    public String getLicenseTest() {
        return licenseTest;
    }

    public String toString(){
        return getFirstName()+"."+getLastName();
    }

    public String getName() {
        return firstName+"."+lastName;
    }
}
