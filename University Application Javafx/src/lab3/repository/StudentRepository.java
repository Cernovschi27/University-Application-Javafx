package lab3.repository;

import lab3.model.Student;
import java.util.List;

public class StudentRepository implements ICrudRepository<Student>{


    List<Student> studentList;

    @Override
    public String toString() {
        return "StudentRepository{" +
                "studentList=" + studentList +
                '}';
    }
    public StudentRepository(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    @Override
    public Student findOne(Long id) {
        for( Student s :  studentList)
            if(s.getStudentID().equals(id))
                return s;
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student save(Student entity) {
        if(!studentList.contains(entity)) {
            studentList.add(entity);
            return null;
        }
        return entity;
    }

    @Override
    public Student delete(Long id) {
        Student s = findOne(id);
        if(s==null) {
            return null;
        }
        studentList.remove(s);
        return s;
    }


    @Override
    public Student update(Student entity) {
        long id= entity.getStudentID();
        if(findOne(id)!=null){
            studentList.set(studentList.indexOf(findOne(id)),entity);
            return null;
        }
        return entity;
    }


}
