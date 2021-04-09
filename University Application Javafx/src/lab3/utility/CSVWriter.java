package lab3.utility;

import lab3.model.Student;
import lab3.model.Teacher;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public static void addStudent(Student s) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("src/lab3/Studenti", true));
        String stringToAppend = String.format("\n%s,%s,%s", s.getFirstName(),s.getLastName(),s.getStudentID());
        output.append(stringToAppend);
        output.close();
    }
    public static void addTeacher(Teacher t) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("src/lab3/Profesori", true));
        String stringToAppend = String.format("\n%s,%s,%s", t.getFirstName(),t.getLastName(),t.getTeacherID());
        output.append(stringToAppend);
        output.close();
    }

    public static void overwriteTeachers(List<Teacher> lt) throws IOException {

        FileOutputStream writer = new FileOutputStream("src/lab3/Profesori");
        writer.write(("").getBytes());
        writer.close();
        // golesc fisierul

        BufferedWriter output = new BufferedWriter(new FileWriter("src/lab3/Profesori", true));
        for(Teacher t: lt){
            String stringToAppend = String.format("%s,%s,%s\n", t.getFirstName(),t.getLastName(),t.getTeacherID());
            output.append(stringToAppend);
        }
        output.close();
    }

}