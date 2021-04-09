package lab3.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lab3.model.Kurs;
import lab3.model.Student;
import lab3.utility.CSVWriter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentSceneController implements Initializable {

    public ObservableList<Student> studentList;
    public ListView<Student> studentListView;


    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public Button courseRegisterButton;

    public TextField courseRegisterTextField;
    public Button registerStudentButton;

    public TextField studentIdTextField;
    public Button creditNumberButton;
    public TextArea notificationTextArea;

    public ObservableList<Kurs> courseList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        courseList = MainMenuSceneController.courseList;

        studentList = MainMenuSceneController.studentList;
        studentListView.setItems(studentList);

        studentList.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                studentListView.refresh();
            }
        });


        // fac anumite butoane "unavailable" atunci cand nu e selectat vreun student din lista
        creditNumberButton.disableProperty().bind(
                Bindings.isNull(studentListView.getSelectionModel().selectedItemProperty())
        );

        courseRegisterButton.disableProperty().bind(
                Bindings.isNull(studentListView.getSelectionModel().selectedItemProperty())
        );

    }


    public void registerStudentButtonOnMouseClick(MouseEvent mouseEvent) throws IOException {

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();

        Student s = new Student(firstName,lastName, new ArrayList<>());
        studentList.add(s);

        CSVWriter.addStudent(s);    // de sincronizat toate astea: interfata grafica - memorie - fisier !!

        notificationTextArea.setText(notificationTextArea.getText() +
                String.format("\nInregistrare reusita!\n Id-ul dvs este: %d", s.getStudentID())); // set invisible

    }

    public void courseRegisterButtonOnMouseClick(MouseEvent mouseEvent) {

        int toAddCourseId = Integer.parseInt(courseRegisterTextField.getText());
        int selectedStudentIndex = studentListView.getSelectionModel().getSelectedIndex();

        Student s = new Student(studentListView.getItems().get(selectedStudentIndex));
        s.getEnrolledClassList().add(toAddCourseId);
        studentList.set(selectedStudentIndex, new Student(s.getStudentID(), s.getFirstName(),s.getLastName(),s.getEnrolledClassList())); // fac un student nou, cu id-ul vechi

        for(Kurs k: courseList){
            if(k.getId() == toAddCourseId){

                k.getEnrolledStudentsIds().add( Integer.parseInt(String.valueOf(s.getStudentID())));
                courseList.set(courseList.indexOf(k),new Kurs(k.getId(),k.getName(),k.getTeacherId(),k.getMaxNoStudents(),k.getNoCredits(),k.getEnrolledStudentsIds()));
                return;
            }
        }
    }

    public void creditNumberButtonOnMouseClick(MouseEvent mouseEvent) {

        ObservableList<Student> selectedItems = studentListView.getSelectionModel().getSelectedItems();

        notificationTextArea.setText("Numarul de credite pentru studentul: \"" + selectedItems.get(0) + "\" este: " + selectedItems.get(0).getEnrolledClassesCreditNumber());
    }
}

