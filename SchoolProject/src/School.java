import java.util.ArrayList;

//School class
public class School {

    //The following Arraylists contain Teacher objects, Student objects, and courses in the school
    private ArrayList<Teacher> teacherlist = new ArrayList<>();
    private ArrayList<Student> studentlist = new ArrayList<>();
    private ArrayList<String> coursesList = new ArrayList<>();

    //The fields: classroom, schoolName, washroom, adn courses are instance variables of the Student class
    private double classroom;
    private String schoolName;
    private double washroom;
    private String courses;

    //The constructor instantiates the object, School. It also takes in parameters so the fields can also be initialized when the object is being created.
    public School(double classroom, String schoolName, double washroom){
        this.classroom = classroom;
        this.schoolName = schoolName;
        this.washroom = washroom;
    }

    //add courses to courseList
    public void addCourses(String courses){
        coursesList.add(courses);
    }

    //shows coursesList
    public ArrayList<String> getCoursesList(){
        return coursesList;
    }

    //adds Teacher to teacherList
    public void addteacher(Teacher teacher) {
        teacherlist.add(teacher);
    }

    //removes last Teacher from teacherList
    public void remteacher() {
        teacherlist.remove(teacherlist.size() - 1);
    }

    //adds Student to studentList
    public void addstudent(Student student) {
        studentlist.add(student);
    }

    //removes last Student from studentList
    public void remstudent() {
        studentlist.remove(studentlist.size() - 1);
    }

    //shows teacherList
    public ArrayList<Teacher> getTeacherList() {
        return teacherlist;
    }

    //shows studentList
    public ArrayList<Student> getStudentList() {
        return studentlist;
    }

    //Getter for washroom
    public double getWashroom(){
        return washroom;
    }

    //Setter for washroom
    public void setWashroom(double washroom){
        this.washroom = washroom;
    }

    //Getter for schoolName
    public String getSchoolName(){
        return schoolName;
    }

    //Setter for schoolName
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    //Getter for classroom
    public double getClassroom(){
        return classroom;
    }

    //Setter for classroom
    public void setClassroom(double classroom){
        this.classroom = classroom;
    }

    //Getter for courses
    public String getCourses() {
        return courses;
    }

    //Setter for courses
    public void setCourses(String courses) {
        this.courses = courses;
    }
}
