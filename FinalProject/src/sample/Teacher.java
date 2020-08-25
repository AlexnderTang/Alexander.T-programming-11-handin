package sample;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Teacher {
    private String firstName;
    private String lastName;
    private int age;
    private int experience;

    //Teacher Constructor
    Teacher(String firstName,String lastName,int age,int experience){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.experience=experience;
    }
    //Requires: A Teacher object
    //Modifies: Teacher.txt
    //Effects: Writes firstName + "," + lastName + "." + age + "-" + experience + "*\r" + ";\r" to Teacher.txt
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Teacher.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + "," + lastName + "." + age + "-" + experience + "*\r");
        bw.write(";\r");
        bw.close();
    }

    //Requires: Two Teacher Objects
    //Modifies: Nothing
    //Effects: Return true if the two Teacher objects have the same first and last name. If not, return false.
    public boolean compareTeacher(Teacher t){
        if((this.getFirstName().equals(t.getFirstName()))&&(this.getLastName().equals(t.getLastName()))){
            return true;
        }
        else return false;
    }

    //Getters
    public String getFirstName() { return firstName;}

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public int getExperience() {
        return experience;
    }

    public String toString(){
        return getFirstName()+"."+getLastName();
    }


}
