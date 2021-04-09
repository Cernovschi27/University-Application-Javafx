package lab3.controller;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lab3.StartApp;
import lab3.model.Kurs;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.utility.CSVReader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuSceneController implements Initializable {

    public static ObservableList<Kurs> courseList = FXCollections.observableList(CSVReader.readCourses()); // trebuie citite prima data cursurile
    public static ObservableList<Student> studentList = FXCollections.observableList(CSVReader.readStudents());
    public static ObservableList<Teacher> teacherList = FXCollections.observableList(CSVReader.readTeachers());

    public Button studentButton;
    public Button courseButton;
    public Button coursesButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void studentButtonOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        Stage newStage = new Stage();
        newStage.setTitle("Student Window");
        StartApp.startStage(newStage, "view/studentScene.fxml"); // creez stage nou

    }

    public void teacherButtonOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        Stage newStage = new Stage();
        newStage.setTitle("Teacher Window");
        StartApp.startStage(newStage, "view/teacherScene.fxml"); // creez stage nou

    }

    public void coursesButtonOnMouseClick(MouseEvent mouseEvent) throws IOException {

        Stage newStage = new Stage();
        newStage.setTitle("Course Window");
        StartApp.startStage(newStage, "view/coursesScene.fxml");
    }

}
