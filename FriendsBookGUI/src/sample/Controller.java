package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;

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
    public Button btnSave;
    public Button btnLoad;
    public Label labelFriendGroup;
    public Label labelGroup;
    public Label textFriendGroup;
    public CheckBox checkFamily;
    public CheckBox checkBFFs;
    public CheckBox checkOtherGroup;


    public void createFriend(ActionEvent actionEvent) {
        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        int age = Integer.parseInt(textAge.getText());
        String friendGroup = labelFriendGroup.getText();

        if (checkMale.isSelected()) {
            friendList.getItems().add(new Friend(firstName, lastName, age, "Male", friendGroup));
        }
        if (checkFemale.isSelected()) {
            friendList.getItems().add(new Friend(firstName, lastName, age, "Female", friendGroup));
        }

        if (checkOther.isSelected()) {
            friendList.getItems().add(new Friend(firstName, lastName, age, "Other", friendGroup));
        }
        checkFamily.setDisable(false);
        checkOtherGroup.setDisable(false);
        checkBFFs.setDisable(false);
        checkFamily.setSelected(false);
        checkBFFs.setSelected(false);
        checkOtherGroup.setSelected(false);
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
        infoName.setText(friend.getFirstName() + " " + friend.getLastName());
        infoAge.setText(Integer.toString(friend.getAge()));
        infoGender.setText(friend.getGender());
        btnDelete.setDisable(false);


    }

    public void deleteFriend(ActionEvent actionEvent) throws IOException {
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
    }

    public void selectMale(ActionEvent actionEvent) {
        checkMale.setSelected(true);
        checkOther.setDisable(true);
        checkFemale.setDisable(true);
    }

    public void selectOther(ActionEvent actionEvent) {
        checkMale.setDisable(true);
        checkOther.setSelected(true);
        checkFemale.setDisable(true);
    }


    public void loadGroup(ActionEvent actionEvent) throws IOException {
       friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends(labelGroup.getText() + ".txt");
        for ( Friend f : friends ) {
            friendList.getItems().add(f);
                }
        }
    public void saveGroup(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myFriend = friendList.getItems();
        for ( Friend f : myFriend ) {
            f.writeToFile();
        }
        friendList.getItems().clear();
    }

    public void selectFamily(ActionEvent actionEvent) {
        labelFriendGroup.setText("Family");
        checkOtherGroup.setDisable(true);
        checkBFFs.setDisable(true);
        checkFamily.setSelected(true);
        btnCreate.setDisable(false);
    }

    public void selectBFFs(ActionEvent actionEvent) {
        labelFriendGroup.setText("BFFs");
        checkOtherGroup.setDisable(true);
        checkBFFs.setSelected(true);
        checkFamily.setDisable(true);
        btnCreate.setDisable(false);
    }

    public void selectOtherGroup(ActionEvent actionEvent) {
        labelFriendGroup.setText("Other");
        checkFamily.setDisable(true);
        checkBFFs.setDisable(true);
        checkOtherGroup.setSelected(true);
        btnCreate.setDisable(false);
    }

    public void Family(ActionEvent actionEvent) {
        labelGroup.setText("Family");
    }
        public void BFFs (ActionEvent actionEvent){
        labelGroup.setText("BFFs");
        }

        public void Other (ActionEvent actionEvent){
        labelGroup.setText("Other");
        }
    }
