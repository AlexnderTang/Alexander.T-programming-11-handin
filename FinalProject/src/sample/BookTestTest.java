package sample;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BookTestTest {

    @Test
    public void testWriteToFile() throws IOException {
        //Keep count of how many lines the BookTest text file has
        File check = (new File("BookTest.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(check));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        //Create a BookTest
        Student s = new Student("student firstName", "student lastName", 16, "Student License");
        Teacher t = new Teacher("teacher firstName", "teacher lastname", 39, 5);
        String ld = "2018-08-22";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(ld, formatter);
        BookTest bk = new BookTest(s, t, dateTime, "1am");

        //write the BookTest to file
        bk.writeToFile();

        //Check if BookTest text file has 2 extra lines added
        BufferedReader secondReader = new BufferedReader(new FileReader(check));
        int extraLines = 0;
        while (secondReader.readLine() != null) extraLines++;
        secondReader.close();
        assertEquals(lines + 2, extraLines);

        // Check if the first extra line is s.getFirstName() + "," + s.getLastName() + "." + s.getAge() + "_" +  s.getLicenseTest()+ "*"+t.getFirstName() + "^" + t.getLastName() + "#" + t.getAge() + "!" + t.getExperience() + "'"+ ld +"?"+ time + "~\r"
        String text = "";
        int lineNumber;
        FileReader readFile = new FileReader(check);
        BufferedReader readBuffer = new BufferedReader(readFile);
        for ( lineNumber = 1; lineNumber < extraLines; lineNumber++ ) {
            if (lineNumber == lines + 1) {
                text = readBuffer.readLine();
            } else
                readBuffer.readLine();
        }
        assertEquals(bk.getS().getFirstName() + "," + bk.getS().getLastName() + "." + bk.getS().getAge() + "_" + bk.getS().getLicenseTest() + "*" + bk.getT().getFirstName() + "^" + bk.getT().getLastName() + "#" + bk.getT().getAge() + "!" + bk.getT().getExperience() + "'" + bk.getLd() + "?" + "1am" + "~", text);
        readFile.close();
        readBuffer.close();

        //Clear the lines from BookTest text File
        BufferedReader bReader = new BufferedReader(new FileReader(check));
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(check));

        int currentLine;

            for ( currentLine = 1; currentLine < extraLines + 1; currentLine++ ) {
                if ((currentLine == lines + 1) || (currentLine == lines + 2)) {
                    bWriter.write("");
                } else
                    bReader.readLine();
            }
            bWriter.close();
            bReader.close();
    }
    @Test
    public void testToString(){
        //Create a BookTest
        Student s = new Student("student firstName", "student lastName", 16, "Student License");
        Teacher t = new Teacher("teacher firstName", "teacher lastname", 39, 5);
        String ld = "2018-08-22";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(ld, formatter);
        BookTest bk = new BookTest(s, t, dateTime, "1am");
        //Check if bk.toString() is equal to bk.getS().toString() + "/" + bk.getT().toString() + "@" + ld + "/" + time
        assertEquals(bk.getS().toString() + "/" + bk.getT().toString() + "@" + ld + "/" + "1am",bk.toString());
    }
    @Test
    public void testCompareBookTest(){
        //Create a BookTest
        Student s = new Student("student firstName", "student lastName", 16, "Student License");
        Teacher t = new Teacher("teacher firstName", "teacher lastname", 39, 5);
        String ld = "2018-08-22";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(ld, formatter);
        BookTest one = new BookTest(s, t, dateTime, "1am");

        //Create a BookTest with different arguments except the date & time
        Student s2 = new Student("sf", "sl", 16, "Sl");
        Teacher t2 = new Teacher("tf", "tl", 39, 5);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime2 = LocalDate.parse(ld, formatter2);
        BookTest two = new BookTest(s2, t2, dateTime2, "1am");

        //CompareBookTest BookTest one and two. If the BookTests have the same student or date&time then return true.
        assertTrue(one.compareBookTest(two));

        //Create a BookTest with different arguments except the student
        Teacher t3 = new Teacher("tF", "tL", 32, 4);
        String ld3 = "2017-06-01";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate dateTime3 = LocalDate.parse(ld3, formatter3);
        BookTest three = new BookTest(s, t3, dateTime3, "2am");

        //CompareBookTest BookTest one and three. If the BookTests have the same student or date&time then return true
        assertTrue(one.compareBookTest(three));

    }
}