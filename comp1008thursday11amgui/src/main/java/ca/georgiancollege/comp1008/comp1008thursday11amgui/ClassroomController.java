package ca.georgiancollege.comp1008.comp1008thursday11amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassroomController {

    @FXML
    private Label errorMessage;

    @FXML
    private Polygon student1Body;

    @FXML
    private Circle student1Head;

    @FXML
    private Label student1Label;

    @FXML
    private Polygon student2Body;

    @FXML
    private Circle student2Head;

    @FXML
    private Label student2Label;

    @FXML
    private Polygon student3Body;

    @FXML
    private Circle student3Head;

    @FXML
    private Label student3Label;

    @FXML
    private Polygon student4Body;

    @FXML
    private Circle student4Head;

    @FXML
    private Label student4Label;

    @FXML
    private Polygon student5Body;

    @FXML
    private Circle student5Head;

    @FXML
    private Label student5Label;

    @FXML
    private Polygon student6Body;

    @FXML
    private Circle student6Head;

    @FXML
    private Label student6Label;

    @FXML
    private Polygon student7Body;

    @FXML
    private Circle student7Head;

    @FXML
    private Label student7Label;

    @FXML
    private Polygon student8Body;

    @FXML
    private Circle student8Head;

    @FXML
    private Label student8Label;

    @FXML
    private Polygon student9Body;

    @FXML
    private Circle student9Head;

    @FXML
    private Label student9Label;

    @FXML
    private TextField studentName;

    @FXML
    private ComboBox<String> colourChoice;

    // Integer ArrayList holds different seat values for the class
    private ArrayList<Integer> seats = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    // String ArrayList holds different possible student colours
    private ArrayList<String> colours = new ArrayList<>(Arrays.asList("Red", "Blue", "Yellow",
            "Green", "Purple", "Orange", "Cyan", "Pink", "Magenta"));

    @FXML
    void initialize(){
        // on stage start, errorMessage is set to blank
        errorMessage.setText("");
        // all colours in ArrayList stored in ComboBox
        colourChoice.getItems().addAll(colours);
        // default ComboBox value of red set
        colourChoice.setValue("Red");
    }

    void seatCheck(Polygon body, Circle head, Label name, String colour){
        // student body and head colour set to colour argument value
        body.setStyle("-fx-fill: " + colour + ";");
        head.setStyle("-fx-fill: " + colour + ";");
        // colour used is removed from ArrayList
        colours.remove(colour);
        // name argument set to student label
        name.setText(studentName.getText());
        // if seats ArrayList is empty after adding a student, display a congratulations message
        if(seats.isEmpty()){
            errorMessage.setText("Class is full!");
            errorMessage.setStyle("-fx-text-fill: green;");
        }
    }

    int findRandomSeat(){
        // Collections class used to shuffle seats ArrayList
        Collections.shuffle(seats);
        // seat at index 0 chosen and removed from ArrayList
        int seatChoice = seats.get(0);
        seats.remove(0);
        // value is returned
        return seatChoice;
    }

    @FXML
    void onAddStudent(ActionEvent event) {
        // error message is set to blank
        errorMessage.setText("");
        // colour variable stores ChoiceBox value
        String colour = colourChoice.getValue();
        // if seats ArrayList is empty, no more seats are available so an error message is displayed
        if(seats.isEmpty()){
            errorMessage.setText("Class is full!");
            errorMessage.setStyle("-fx-text-fill: red;");
        }
        // else if studentName input is blank an error message is displayed
        else if(studentName.getText().isBlank()){
            errorMessage.setText("Student name is required!");
        }
        // else if studentName is too short (under 3 characters) an error message is displayed
        else if(studentName.getText().length() < 3){
            errorMessage.setText("Name is too short!");
        }
        // else if colours ArrayList does not contain chosen colour, it is already in use so an error is displayed
        else if(!colours.contains(colour)){
            errorMessage.setText("Colour already in use!");
        }
        // else the student is added
        else {
            // seatChoice stores value from method
            int seatChoice = findRandomSeat();
            // enhanced switch statement alters student body, head, and label based on case value from seatChoice
            switch (seatChoice) {
                case 9 -> seatCheck(student9Body, student9Head, student9Label, colour);
                case 8 -> seatCheck(student8Body, student8Head, student8Label, colour);
                case 7 -> seatCheck(student7Body, student7Head, student7Label, colour);
                case 6 -> seatCheck(student6Body, student6Head, student6Label, colour);
                case 5 -> seatCheck(student5Body, student5Head, student5Label, colour);
                case 4 -> seatCheck(student4Body, student4Head, student4Label, colour);
                case 3 -> seatCheck(student3Body, student3Head, student3Label, colour);
                case 2 -> seatCheck(student2Body, student2Head, student2Label, colour);
                default -> seatCheck(student1Body, student1Head, student1Label, colour);
            }
        }
    }

}
