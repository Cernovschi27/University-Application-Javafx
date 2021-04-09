package lab3.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.utility.CSVWriter;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherSceneController implements Initializable {

    public ListView<Teacher> teacherListView;
    public ObservableList<Teacher> teacherList;

    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public Button registerTeacherButton;
    public TextArea seeCoursesTextArea;
    public Button seeTeachersButton;
    public TextArea notificationTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        seeTeachersButton.disableProperty().bind(
                Bindings.isNull(teacherListView.getSelectionModel().selectedItemProperty())
        );

        teacherList = MainMenuSceneController.teacherList;
        teacherListView.setItems(teacherList);

    }


    public void registerTeacherButtonOnMouseClick(MouseEvent mouseEvent) throws IOException {

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();

        Teacher t = new Teacher(firstName,lastName);
        teacherList.add(t);

        System.out.println("s a adaugat noul profesor, il puteti vedea mai sus. Iar repo ul in memorie este:");
        CSVWriter.addTeacher(t);    //sincronizare

    }

    public void seeCoursesButtonOnMouseClick(MouseEvent mouseEvent) {

        notificationTextArea.setText("");

        HashSet<Student> setToShow = new HashSet<>();

        ObservableList<Teacher> selectedItems = teacherListView.getSelectionModel().getSelectedItems();
        Teacher t = selectedItems.get(0);
        List<Integer> courseIdsTeacherTeachesAt = t.getCourseIds();

        for(Student s: MainMenuSceneController.studentList){                                // iau studentii pe rand
            List<Integer> courseIdsCurrentStudentEnrolledAt = s.getEnrolledClassList();

            for(Integer i : courseIdsCurrentStudentEnrolledAt){     // iau cursurile la care este studentul curent inscris
                for(Integer j: courseIdsTeacherTeachesAt){          // iau toate cursurile la care
                    if(i.equals(j)){
                        setToShow.add(s);

                    }
                }
            }
        }
        for(Student s: setToShow)
            notificationTextArea.setText(notificationTextArea.getText() + "\n" + s.getStudentID() + " - " + s.getFirstName() + " " + s.getLastName());
        if(setToShow.size() == 0)
            notificationTextArea.setText("This teacher does not teach any students at the moment!");
    }
}