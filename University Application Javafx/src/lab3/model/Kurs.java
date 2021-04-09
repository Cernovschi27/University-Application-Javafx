package lab3.model;

import java.util.ArrayList;
import java.util.List;

public class Kurs {

    public static List<Kurs> allCourses = new ArrayList<>();

    private String name;
    private long teacherId;
    private int maxNoStudents;
    private List<Integer> enrolledStudentsIds;
    private int noCredits;

    private Long courseId;

    private static int id = 1;


    public Kurs(Long courseId, String name, long teacherId, int maxNoStudents, int noCredits, List<Integer> enrolledStudentsIds ){
        this.courseId = courseId;

        this.name = name;
        this.teacherId = teacherId;
        this.maxNoStudents = maxNoStudents;
        this.noCredits = noCredits;
        this.enrolledStudentsIds = enrolledStudentsIds;
       // allCourses.add(this);
    }

    public Kurs(String name, long teacherId, int maxNoStudents, int noCredits, List<Integer> enrolledStudentsIds) {

        this.courseId = (long) id; id += 1;

        this.name = name;
        this.teacherId = teacherId;
        this.maxNoStudents = maxNoStudents;
        this.noCredits = noCredits;
        this.enrolledStudentsIds = enrolledStudentsIds;
      //  allCourses.add(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getEnrolledStudentsIds() {
        return enrolledStudentsIds;
    }

    public void setEnrolledStudentsIds(List<Integer> enrolledStudentsIds) {
        this.enrolledStudentsIds = enrolledStudentsIds;
    }

    public int getMaxNoStudents() {
        return maxNoStudents;
    }

    public void setMaxNoStudents(int maxNoStudents) {
        this.maxNoStudents = maxNoStudents;
    }

    public int getNoCredits() {
        return noCredits;
    }

    public void setNoCredits(int noCredits) {
        this.noCredits = noCredits;
    }

    public Long getId() {
        return courseId;
    }

    public void setId(Long id) {
        this.courseId = id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }


    @Override
    public String toString() {
        return courseId + " " + name + " nrCredite=" + noCredits + " locuri=" + maxNoStudents + " idStudenti" + enrolledStudentsIds;

    }
}