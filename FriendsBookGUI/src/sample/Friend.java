package sample;

public class Friend {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;


    Friend(String firstName, String lastName, int age, String gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
}

    //Getters
    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public int getAge() {
        return age;

    }

    public String getGender() {
        return gender;
    }

    public String toString(){
        return firstName.charAt(0) + "." + lastName.charAt(0);
    }
}
