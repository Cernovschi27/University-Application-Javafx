package lab3.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Integer> courseIds;
    private Long teacherID;

    static int id = 1;

    public Teacher(String firstName, String lastName){
        super(firstName, lastName);
        this.teacherID = (long) id; id +=1 ;
        this.courseIds = new ArrayList<>();
    }

    public Teacher(String firstName, String lastName, List<Integer> courseIds){
        super(firstName, lastName);
        this.teacherID = (long) id; id +=1 ;
        this.courseIds = courseIds;
    }

    @Override
    public String toString() {
        return teacherID + " - " + getFirstName() + " " + getLastName() + "; courses:" + courseIds;

    }

    public Long getId() {
        return teacherID;
    }

    public void setId(Long id) {
        this.teacherID = id;
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }
}