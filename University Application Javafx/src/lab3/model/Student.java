package lab3.model;

import lab3.controller.MainMenuSceneController;
import lab3.utility.CSVReader;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private Long studentID;
    private List<Integer> enrolledClassList;
    private int enrolledClassesCreditNumber;

    static int idToBeGiven = 1;


    public Student(String firstName, String lastName, List<Integer> courseIds){
        super(firstName, lastName);
        this.studentID = (long) idToBeGiven; idToBeGiven += 1;
        this.enrolledClassList = courseIds;
        this.enrolledClassesCreditNumber = this.calculateNoCredits();
        updateCourseIds();

    }

    public Student(String firstName, String lastName, Long studentID){
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledClassList = new ArrayList<>();
        this.enrolledClassesCreditNumber = this.calculateNoCredits();
    }

    public Student(Student s){
        super(s.getFirstName(), s.getLastName());
        this.studentID = s.getStudentID();
        this.enrolledClassList = s.getEnrolledClassList();
        this.enrolledClassesCreditNumber = this.calculateNoCredits();
        
    }

    public Student(Long studentID, String firstName, String lastName, List<Integer> enrolledClassList) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledClassList = enrolledClassList;
        this.enrolledClassesCreditNumber = calculateNoCredits();

        updateCourseIds();

    }

    private void updateCourseIds(){
        if(enrolledClassList.size() == 0) return;
        int lastAddedCourse = enrolledClassList.get(enrolledClassList.size() - 1);
        for(Kurs k: Kurs.allCourses){
            if( (long) lastAddedCourse == k.getId() ){     // daca studentul tocmai ce a fost inscris la acest curs
                List<Integer> newStudentIds = k.getEnrolledStudentsIds();
                newStudentIds.add(Math.toIntExact(this.studentID));
                k.setEnrolledStudentsIds(newStudentIds);
            }
        }
    }

    private int calculateNoCredits(){
        List<Kurs> allCourses= MainMenuSceneController.courseList;
        //List<Kurs> allCourses = Kurs.allCourses;
        int noCourses = allCourses.size();

        int sum = 0;
        for(Integer i: enrolledClassList) {             // merg prin id-urile cursurilor la care e inscris elevul
            for (Kurs allCours : allCourses) {       // merg prin cursuri
                if (Long.parseLong(String.valueOf(i)) == allCours.getId())
                    sum += allCours.getNoCredits();
            }
        }
        return sum;
    }

    public Long getStudentID() { return studentID; }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public List<Integer> getEnrolledClassList() {
        return enrolledClassList;
    }

    public void setEnrolledClassList(List<Integer> enrolledClassList) {
        this.enrolledClassList = enrolledClassList;
        this.enrolledClassesCreditNumber = calculateNoCredits();
    }

    public int getEnrolledClassesCreditNumber() {
        return enrolledClassesCreditNumber;
    }

    public void setEnrolledClassesCreditNumber(int enrolledClassesCreditNumber) {
        this.enrolledClassesCreditNumber = enrolledClassesCreditNumber;
    }

    @Override
    public String toString() {
        return studentID + " - " + getFirstName() + " " + getLastName() + "; courses:" + enrolledClassList;
    }

    @Override
    public boolean equals(Object o) {


        if (o == this) {
            return true;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student s = (Student) o;

        return studentID == s.getStudentID();
    }

}