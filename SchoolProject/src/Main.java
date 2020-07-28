public class Main {
    public static void main(String[] args) {

        //Adding 10 Students to studentList
        School school = new School(12, "Prince of Wales", 5);
        school.addstudent(new Student("Dillon", "Liu", 11));
        school.addstudent(new Student("Jason", "Wang", 9));
        school.addstudent(new Student("Victor","Yao",11));
        school.addstudent(new Student("Alice", "Robertson",12));
        school.addstudent(new Student("Valencia","Li",10));
        school.addstudent(new Student("Richard","West",9));
        school.addstudent(new Student("Vincent","Sapal",8));
        school.addstudent(new Student("Alex","Tang", 11));
        school.addstudent(new Student("Emma","Louie", 12));
        school.addstudent(new Student("Yiwen","Wu", 9));

        //Adding 3 Teachers to teacherList
        school.addteacher(new Teacher("Linda", "Robertson", "English"));
        school.addteacher(new Teacher("Matthew","Yang", "Math"));
        school.addteacher(new Teacher("Robert","Wesley","Physics"));

        //Displaying both lists
        System.out.println("Students:" + school.getStudentList());
        System.out.println("Teachers:" + school.getTeacherList());

        //Removing 2 Students
        school.remstudent();
        school.remstudent();

        //Removing 1 Teacher
        school.remteacher();

        //Displaying both lists
        System.out.println("New Student List:" + school.getStudentList());
        System.out.println("New Teacher List" + school.getTeacherList());

    }
}
