package sample;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CreateBookTest {
    private static Student s;
    private static Teacher t;
    private static LocalDate ld;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<BookTest> BookTests = new ArrayList<>();

    //Requires: fileName
    //Modifies: this, BookTests
    //Effects: As br.readLine, parseBookTest the lines that aren't  ";"
    public static ArrayList createAllBookTests(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String bookTestString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                bookTestString += line;
            } else {
                parseBookTest(bookTestString);
                bookTestString = "";
            }
        }
        return BookTests;
    }

    //Requires: A string
    //Modifies: this, BookTests
    //Effects: Reads BookTest.txt and creates BookTest objects. If the created BookTest does not have the same student or date&time as existing BookTests, then add to the BookTest ArrayList
    public static void parseBookTest(String string) {
        int posDot = 0;
        int posComma = 0;
        int posNeg = 0;
        int posStar = 0;
        int posWiggle = 0;
        int posArrow = 0;
        int hashTag = 0;
        int exclamation = 0;
        int apostrophe = 0;
        int posQuestions=0;
        String studentFirstName = "";
        String studentLastName = "";
        String teacherFirstName = "";
        String teacherLastName = "";
        int teacherAge =0;
         int studentAge =1;
        int teacherExperience = 0;
        String studentLicenseTest = "";
        String ld = "";
        String time="";
        for ( int i = 0; i < string.length(); i++ ) {
            if (string.substring(i, i + 1).equals(",")) {
                posComma = i;
                studentFirstName = string.substring(0, posComma);
                for ( int x = 0; x < string.length(); x++ ) {
                    if (string.substring(x, x + 1).equals(".")) {
                        posDot = x;
                        studentLastName = string.substring(posComma + 1, posDot);
                        for ( int z = 0; z < string.length(); z++ ) {
                            if (string.substring(z, z + 1).equals("_")) {
                                posNeg = z;
                                studentAge = Integer.parseInt(string.substring(posDot+1, posNeg));
                                for ( int y = 0; y < string.length(); y++ ) {
                                    if (string.substring(y, y + 1).equals("*")) {
                                        posStar = y;
                                        studentLicenseTest = string.substring(posNeg+1, posStar);
                                        for ( int q = 0; q < string.length(); q++ ) {
                                            if (string.substring(q, q + 1).equals("^")) {
                                                posArrow = q;
                                                teacherFirstName = string.substring(posStar + 1, posArrow);
                                                for ( int w = 0; w < string.length(); w++ ) {
                                                    if (string.substring(w, w + 1).equals("#")) {
                                                        hashTag = w;
                                                        teacherLastName = string.substring(posArrow + 1, hashTag);
                                                        for ( int a = 0; a < string.length(); a++ ) {
                                                            if (string.substring(a, a + 1).equals("!")) {
                                                                exclamation = a;
                                                                teacherAge = Integer.parseInt(string.substring(hashTag + 1, exclamation));
                                                                for ( int s = 0; s < string.length(); s++ ) {
                                                                    if (string.substring(s, s + 1).equals("'")) {
                                                                        apostrophe = s;
                                                                        teacherExperience = Integer.parseInt(string.substring(exclamation + 1, apostrophe));
                                                                        for ( int e = 0; e < string.length(); e++ ) {
                                                                            if (string.substring(e, e + 1).equals("?")) {
                                                                                posQuestions = e;
                                                                                ld = string.substring(apostrophe + 1, posQuestions);
                                                                                for(int p=0;p<string.length();p++){
                                                                                    if(string.substring(p,p+1).equals("~")){
                                                                                        posWiggle=p;
                                                                                        time=string.substring(posQuestions+1,posWiggle);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Student s = new Student(studentFirstName, studentLastName, studentAge, studentLicenseTest);
        Teacher t = new Teacher(teacherFirstName, teacherLastName, teacherAge, teacherExperience);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(ld, formatter);
        BookTest bk=new BookTest(s,t,dateTime,time);
        boolean bookTestExists=false;
        for ( BookTest b: BookTests ) {
            if (bk.compareBookTest(b)) {
                bookTestExists = true;
            }
        }
        if (!bookTestExists) {
            BookTests.add(bk);
        }
    }
}
