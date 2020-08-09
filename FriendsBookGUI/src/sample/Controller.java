package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    public TextField textFirstName;
    public TextField textAge;
    public ListView friendList;
    public TextField textLastName;
    public Label infoName;
    public Label infoAge;
    public Label infoGender;
    public Button btnDelete;
    public TextField textGender;
    public Button btnCreate;
    public CheckBox checkOther;
    public CheckBox checkFemale;
    public CheckBox checkMale;


    public void createFriend(ActionEvent actionEvent) {
        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        int age= Integer.parseInt(textAge.getText());

        if (checkMale.isSelected()){
            Friend friend = new Friend(firstName, lastName, age, "Male");
            friendList.getItems().add(friend);}

        if (checkFemale.isSelected()){
            Friend friend = new Friend(firstName, lastName, age, "Female");
            friendList.getItems().add(friend);}

        if (checkOther.isSelected()){
            Friend friend = new Friend(firstName, lastName, age, "Other");
            friendList.getItems().add(friend);}

        checkFemale.setDisable(false);
        checkMale.setDisable(false);
        checkOther.setDisable(false);
        btnCreate.setDisable(true);
        checkMale.setSelected(false);
        checkOther.setSelected(false);
        checkFemale.setSelected(false);
        textFirstName.clear();
        textLastName.clear();
        textAge.clear();
        textGender.clear();
    }


    public void displayFriend(MouseEvent mouseEvent) {
        Friend friend;
        friend = (Friend) friendList.getSelectionModel().getSelectedItem();
        infoName.setText(friend.getFirstName() + "\t" + friend.getLastName());
        infoAge.setText(Integer.toString(friend.getAge()));
        infoGender.setText(friend.getGender());
        btnDelete.setDisable(false);


    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend friend;
        friend = (Friend) friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(friend);
        infoName.setText("");
        infoAge.setText("");
        infoGender.setText("");
        btnDelete.setDisable(true);
    }


    public void selectFemale(ActionEvent actionEvent) {
        checkMale.setDisable(true);
        checkOther.setDisable(true);
        checkFemale.setSelected(true);
        btnCreate.setDisable(false);
    }

    public void selectMale(ActionEvent actionEvent) {
        checkMale.setSelected(true);
        checkOther.setDisable(true);
        checkFemale.setDisable(true);
        btnCreate.setDisable(false);
    }

    public void selectOther(ActionEvent actionEvent) {
        checkMale.setDisable(true);
        checkOther.setSelected(true);
        checkFemale.setDisable(true);
        btnCreate.setDisable(false);
    }
}

