package sample;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class BookTest {
    private Student s;
    private Teacher t;
    private LocalDate ld;
    private String time;

    //BookTest Constructor
    BookTest(Student s, Teacher t, LocalDate ld,String time) {
    this.s=s;
    this.t=t;
    this.ld=ld;
    this.time=time;
    }

    //Requires: A BookTest Object
    //Modifies: Nothing
    //Effects: returns a string representation of the BookTest Object
    public String toString() {
        return s.toString() + "/" + t.toString() + "@" + ld + "/" + time;
    }



    //Requires: A BookTest Object
    //Modifies: BookTest.txt
    //Effects: Write s.getFirstName() + "," + s.getLastName() + "." + s.getAge() + "_" +  s.getLicenseTest()+ "*"+t.getFirstName() + "^" + t.getLastName() + "#" + t.getAge() + "!" + t.getExperience() + "'"+ ld +"?"+ time +
    // "~\r" + ";\r" to BookTest.txt
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("BookTest.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(s.getFirstName() + "," + s.getLastName() + "." + s.getAge() + "_" +  s.getLicenseTest()+ "*"+t.getFirstName() + "^" + t.getLastName() + "#" + t.getAge() + "!" + t.getExperience() + "'"+ ld +"?"+ time + "~\r");
        bw.write(";\r");
        bw.close();
    }
    //Requires: Two BookTest objects
    //Modifies: Nothing
    //Effects: Return true if the two BookTests share the same student or date&time. If not, return false.
    public boolean compareBookTest(BookTest b){
        if((b.getS().compareStudent(this.getS()))||(((b.getLd() + b.getTime()).equals(this.getLd() + this.time))&&(b.getT().compareTeacher(this.getT())))){
            return true;
        }
        else return false;
    }

    //Getters
    public Student getS() {
        return s;
    }

    public Teacher getT() {
        return t;
    }

    public LocalDate getLd() {
        return ld;
    }

    public String getTime() {
        return time;
    }
}