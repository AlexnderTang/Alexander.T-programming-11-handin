package sample;
import java.io.*;
import java.util.ArrayList;

public class CreateTeacher {
    private static String firstName;
    private static String lastName;
    private static int age;
    private static int experience;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Teacher> teachers = new ArrayList<>();

    //Requires: fileName
    //Modifies: this, teachers
    //Effects: As br.readLine, parseTeacher the lines that aren't ";"
    public static ArrayList createAllTeachers(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String teacherString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                teacherString += line;
            } else {
                parseTeacher(teacherString);
                teacherString = "";
            }
        }
        return teachers;
    }

    //Requires: string
    //Modifies: Nothing
    //Effects: Reads Teacher.txt and creates Teacher objects. If the created Teacher object does not have the same first and last name as existing Teacher objects, then add to Teachers ArrayList
    public static void parseTeacher(String string) {
        int posDot = 0;
        int posComma = 0;
        int posNeg = 0;
        int posStar = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        int experience = 0;
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
                                        experience = Integer.parseInt(string.substring(posNeg + 1, posStar));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
        Teacher t = new Teacher(firstName, lastName, age, experience);
        boolean teacherExists=false;
        for ( Teacher teacher : teachers ) {
            if (t.compareTeacher(teacher)) {
                teacherExists = true;
            }
        }
        if (!teacherExists) {
            teachers.add(t);
        }
    }
}