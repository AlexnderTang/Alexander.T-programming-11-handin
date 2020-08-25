package sample;
import java.io.*;
import java.util.ArrayList;

public class CreateStudent {
    private static String firstName;
    private static String lastName;
    private static int age;
    private static String licenseTest;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Student> students = new ArrayList<>();


    //Requires: fileName
    //Modifies: this, students
    //Effects: As br.readLine, parseStudent the lines that aren't ";"
    public static ArrayList createAllStudents(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String studentString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                studentString += line;
            } else {
                parseStudent(studentString);
                studentString = "";
            }
        }
        return students;
    }

    //Requires: string
    //Modifies: this,students
    //Effects: Reads Student.txt and creates Student objects. If the created Student does not have the same first and last name as existing Student objects, then add to Students ArrayList
    public static void parseStudent(String string) {
        int posDot = 0;
        int posComma = 0;
        int posNeg = 0;
        int posStar = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        String licenseTest ="";
        for ( int i = 0; i < string.length(); i++ ) {
            if (string.substring(i, i + 1).equals(",")) {
                posComma = i;
                firstName = string.substring(0, posComma);
                for ( int x = 0; x < string.length(); x++ ) {
                    if (string.substring(x, x + 1).equals(".")) {
                        posDot = x;
                        lastName = string.substring(posComma + 1, posDot);
                        for ( int z = 0; z < string.length(); z++ ) {
                            if (string.substring(z, z + 1).equals("-")) {
                                posNeg = z;
                                age = Integer.parseInt(string.substring(posDot + 1, posNeg));
                                for ( int y = 0; y < string.length(); y++ ) {
                                    if (string.substring(y, y + 1).equals("*")) {
                                        posStar = y;
                                        licenseTest =string.substring(posNeg + 1, posStar);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        Student s = new Student(firstName, lastName, age, licenseTest);
        boolean studentExists=false;
        for ( Student student: students ) {
            if (s.compareStudent(student)) {
                studentExists = true;
            }
        }
        if (!studentExists) {
            students.add(s);
        }
    }
}