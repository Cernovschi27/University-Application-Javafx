package lab3.utility;

import lab3.model.Kurs;
import lab3.model.Student;
import lab3.model.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {


    public static List<List<String>> readFile(String file){
        List<List<String>> toReturn = new ArrayList<>();

        String line;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            while( (line = br.readLine()) != null){
                
                String[] data = line.split(",");
                toReturn.add(Arrays.asList(data));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(br != null){
                try{
                    br.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return toReturn;
    }

    public static List<Student> readStudents(){
        List<Student> studentList = new ArrayList<>();

        List<List<String>> unparsedStudents = readFile("src/lab3/Studenti");
        for(List<String> l: unparsedStudents){

            Student s = new Student(l.get(1),l.get(2), l.subList(3, l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
            studentList.add(s);
        }
        return studentList;
    }

    public static List<Teacher> readTeachers(){
        List<Teacher> teacherList = new ArrayList<>();

        List<List<String>> unparsedTeachers = readFile("src/lab3/Profesori");
        for(List<String> l: unparsedTeachers){

            Teacher t = new Teacher(l.get(1),l.get(2), l.subList(3, l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );

            teacherList.add(t);
        }
        return teacherList;
    }

    public static List<Kurs> readCourses(){
        List<Kurs> localCourseList = new ArrayList<>();

        List<List<String>> unparsedCourses = readFile("src/lab3/Cursuri");
        for(List<String> l:unparsedCourses){

            Kurs k = new Kurs(l.get(1), Long.parseLong(l.get(2)), Integer.parseInt(l.get(3)), Integer.parseInt(l.get(4)), l.subList(5, l.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));

            localCourseList.add(k);
        }
        return localCourseList;
    }

}