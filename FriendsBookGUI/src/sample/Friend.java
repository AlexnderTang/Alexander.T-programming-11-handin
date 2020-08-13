package sample;

import java.io.*;
import java.util.ArrayList;

public class Friend {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String friendGroup;


    public Friend(String firstName, String lastName, int age, String gender,String friendGroup) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.friendGroup=friendGroup;
}


    public void writeToFile() throws IOException{
        FileWriter fw= new FileWriter(getFriendGroup()+".txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + "." + lastName + ",\r");
        bw.write(Integer.toString(age) + ":\r");
        bw.write(gender +"-\r");
        bw.write(friendGroup + "*\r");
        bw.write(";\r");
        bw.close();
    }


    //Getters

    public String getFriendGroup() {
        return friendGroup;
    }

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

    public boolean compareFriend(Friend f){
        if((this.firstName.equals(f.getFirstName()))&&(this.lastName.equals(f.getLastName()))){
            return true;
        }
        else return false;
    }
}
