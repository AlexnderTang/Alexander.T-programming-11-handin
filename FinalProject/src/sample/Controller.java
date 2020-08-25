package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;

public class Controller {
    public TextField teacherFirstName;
    public TextField teacherLastName;
    public TextField teacherAge;
    public TextField teacherExperience;
    public Button btnCreateTeacher;
    public ListView listTeacher;
    public Button btnDeleteTeacher;
    public Label lblTeacherEx;
    public Label lblTeacherAge;
    public Label lblTeacherName;
    public TextField studentFirstName;
    public TextField studentLastName;
    public TextField studentAge;
    public Label lblStudentName;
    public Label lblLicenseTest;
    public ListView listStudent;
    public CheckBox checkNDT;
    public CheckBox checkFLT;
    public Label lblStudentAge;
    public ComboBox ChoiceTeacher;
    public ComboBox ChoiceStudent;
    public Label lblDate;
    public Label lblStudent;
    public Label lblTeacher;
    public DatePicker datePicker;
    public ListView listBookTest;
    public Button btnCreateTest;
    public ChoiceBox ChoiceTime;
    public Label bookTestTime;
    public Label bookTestDate;
    public Label bbokTestTeacher;
    public Label bookTestStudent;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<BookTest> BookTests;

    //Teacher class
    public void createTeacher(ActionEvent actionEvent) {
        String firstName = teacherFirstName.getText();
        String lastName = teacherLastName.getText();
        int age = Integer.parseInt(teacherAge.getText());
        int experience = Integer.parseInt(teacherExperience.getText());
        listTeacher.getItems().add(new Teacher(firstName, lastName, age, experience));
        teacherFirstName.clear();
        teacherLastName.clear();
        teacherAge.clear();
        teacherExperience.clear();
    }

    public void deleteTeacher(ActionEvent actionEvent) throws IOException {
        Teacher t;
        t = (Teacher) listTeacher.getSelectionModel().getSelectedItem();
        listTeacher.getItems().remove(t);
        ChoiceTeacher.getItems().remove(t);
        File file = new File("Teacher.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String lineToRemove = t.getFirstName() + "," + t.getLastName() + "." + t.getAge() + "-" + t.getExperience() + "*\r";
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.equals(lineToRemove)) {
                writer.write("");
            }
            writer.close();
            reader.close();
        }
        teachers.remove(t);
        lblTeacherName.setText("");
        lblTeacherAge.setText("");
        lblTeacherEx.setText("");

    }

    public void saveTeachers(ActionEvent actionEvent) throws IOException {
        ObservableList<Teacher> myTeachers = listTeacher.getItems();
        for ( Teacher t : myTeachers ) {
            t.writeToFile();
        }
        listTeacher.getItems().clear();
        lblTeacherName.setText("");
        lblTeacherAge.setText("");
        lblTeacherEx.setText("");
    }

    public void loadTeachers(ActionEvent actionEvent) throws IOException {
        listTeacher.getItems().clear();
        ChoiceTeacher.getItems().clear();
        teachers = CreateTeacher.createAllTeachers("Teacher.txt");

        for ( Teacher t : teachers ) {
            listTeacher.getItems().add(t);
            ChoiceTeacher.getItems().add(t);
        }
        lblTeacherName.setText("");
        lblTeacherAge.setText("");
        lblTeacherEx.setText("");
    }

    public void displayTeachers(MouseEvent mouseEvent) {
        Teacher t;
        t = (Teacher) listTeacher.getSelectionModel().getSelectedItem();
        lblTeacherName.setText(t.getFirstName() + "." + t.getLastName());
        lblTeacherAge.setText(Integer.toString(t.getAge()));
        lblTeacherEx.setText(Integer.toString(t.getExperience()));
    }

    //Student Class
    public void createStudent(ActionEvent actionEvent) {
        String firstName = studentFirstName.getText();
        String lastName = studentLastName.getText();
        int age = Integer.parseInt(studentAge.getText());

        if (checkFLT.isSelected()) {
            listStudent.getItems().add(new Student(firstName, lastName, age, "Full License Test"));
        }
        if (checkNDT.isSelected()) {
            listStudent.getItems().add(new Student(firstName, lastName, age, "New Driver Test"));
        }
        studentAge.clear();
        studentFirstName.clear();
        studentLastName.clear();
        checkNDT.setDisable(false);
        checkNDT.setSelected(false);
        checkFLT.setDisable(false);
        checkFLT.setSelected(false);
    }

    public void displayStudents(MouseEvent mouseEvent) {
        Student s;
        s = (Student) listStudent.getSelectionModel().getSelectedItem();
        lblStudentName.setText(s.getFirstName() + "." + s.getLastName());
        lblStudentAge.setText(Integer.toString(s.getAge()));
        lblLicenseTest.setText(s.getLicenseTest());
    }

    public void saveStudent(ActionEvent actionEvent) throws IOException {
        lblStudentAge.setText("");
        lblStudentName.setText("");
        lblLicenseTest.setText("");
        ObservableList<Student> myStudents = listStudent.getItems();
        for ( Student s : myStudents ) {
            s.writeToFile();
        }
        listStudent.getItems().clear();
    }

    public void loadStudent(ActionEvent actionEvent) throws IOException {
        lblStudentAge.setText("");
        lblStudentName.setText("");
        lblLicenseTest.setText("");
        listStudent.getItems().clear();
        ChoiceStudent.getItems().clear();
        students = CreateStudent.createAllStudents("Student.txt");
        for ( Student s : students ) {
            listStudent.getItems().add(s);
            ChoiceStudent.getItems().add(s);
        }
    }

    public void fullLicenseTest(ActionEvent actionEvent) {
        checkFLT.setSelected(true);
        checkNDT.setDisable(true);
    }

    public void newDriverTest(ActionEvent actionEvent) {
        checkNDT.setSelected(true);
        checkFLT.setDisable(true);
    }

    public void deleteStudent(ActionEvent actionEvent) throws IOException {
        lblStudentAge.setText("");
        lblStudentName.setText("");
        lblLicenseTest.setText("");
        Student s;
        s = (Student) listStudent.getSelectionModel().getSelectedItem();
        listStudent.getItems().remove(s);
        ChoiceTeacher.getItems().remove(s);
        File file = new File("Student.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String lineToRemove = s.getFirstName() + "," + s.getLastName() + "." + s.getAge() + "-" + s.getLicenseTest() + "*\r";
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.equals(lineToRemove)) {
                writer.write("");
            }
            writer.close();
            reader.close();

            students.remove(s);
        }
    }

    public void createTestBook(ActionEvent actionEvent) throws IOException {
        LocalDate ld = datePicker.getValue();
        Student s = (Student) ChoiceStudent.getSelectionModel().getSelectedItem();
        Teacher t = (Teacher) ChoiceTeacher.getSelectionModel().getSelectedItem();
        String time = (String) ChoiceTime.getSelectionModel().getSelectedItem();
        BookTest bk = new BookTest(s, t, ld, time);
        listBookTest.getItems().add(bk);
    }

    public void displayBookTest(MouseEvent mouseEvent) {
        BookTest bk=(BookTest) listBookTest.getSelectionModel().getSelectedItem();
        bookTestDate.setText(bk.getLd().toString());
        bbokTestTeacher.setText(bk.getT().toString());
        bookTestStudent.setText(bk.getS().toString());
        bookTestTime.setText(bk.getTime());
    }

    public void activateBtn(ActionEvent actionEvent) {
        btnCreateTest.setDisable(false);
    }

    public void deleteBookTest(ActionEvent actionEvent) throws IOException {
        BookTest bk = (BookTest) listBookTest.getSelectionModel().getSelectedItem();
        listBookTest.getItems().remove(bk);
        BookTests.remove(bk);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String formattedDate = bk.getLd().format(formatter);

        File file = new File("BookTest.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String lineOne = (bk.getS().getFirstName() + "," + bk.getS().getLastName() + "." + bk.getS().getAge() + "_" + bk.getS().getLicenseTest() + "*" + bk.getT().getFirstName() + "^" + bk.getT().getLastName() + "#" + bk.getT().getAge() + "!" + bk.getT().getExperience() + "'" + formattedDate + "~\r");
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            if ((currentLine.equals(lineOne))) {
                writer.write("");

            }
        }
        writer.close();
        reader.close();
        bookTestDate.setText("");
        bbokTestTeacher.setText("");
        bookTestStudent.setText("");
        bookTestTime.setText("");
    }

    public void loadBookTest(ActionEvent actionEvent) throws IOException {
        BookTests = CreateBookTest.createAllBookTests("BookTest.txt");
        for ( BookTest b : BookTests ) {
            listBookTest.getItems().add(b);
        }
        bookTestDate.setText("");
        bbokTestTeacher.setText("");
        bookTestStudent.setText("");
        bookTestTime.setText("");
    }

    public void saveBookTest(ActionEvent actionEvent) throws IOException {
        ObservableList<BookTest> myBookTest = listBookTest.getItems();
        for ( BookTest b : myBookTest ) {
            b.writeToFile();
        }
        listBookTest.getItems().clear();
    }

    public void displayTime(MouseEvent mouseEvent) {
        ArrayList<String> time = new ArrayList<>();
        time.add("1pm");
        time.add("2pm");
        time.add("3pm");
        time.add("4pm");
        time.add("5pm");
        time.add("10am");
        time.add("11am");
        time.add("Noon");
        for ( String s : time ) {
            if (!ChoiceTime.getItems().contains(s)) {
                ChoiceTime.getItems().add(s);
            }
        }
        bookTestDate.setText("");
        bbokTestTeacher.setText("");
        bookTestStudent.setText("");
        bookTestTime.setText("");
    }
}