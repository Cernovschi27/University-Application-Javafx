package lab3.controller;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import lab3.model.Kurs;

import java.net.URL;
import java.util.ResourceBundle;

public class CoursesSceneController implements Initializable {

    public ListView<Kurs> courseListView;
    public ObservableList<Kurs> courseList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        courseList = MainMenuSceneController.courseList;
        courseListView.setItems(courseList);
    }

}
