package lab3.repository;


import lab3.model.Teacher;
import java.util.List;

public class TeacherRepository implements ICrudRepository<Teacher>{

    private List<Teacher> teacherList;

    public TeacherRepository(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public Teacher findOne(Long id) {
        for( Teacher t :  teacherList)
            if(t.getId().equals(id))
                return t;
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherList;
    }

    @Override
    public Teacher save(Teacher entity) {
        if(!teacherList.contains(entity)) {
            teacherList.add(entity);
            return null;
        }
        return entity;
    }

    @Override
    public Teacher delete(Long id) {
        Teacher t = findOne(id);
        if(t==null) {
            return null;
        }
        teacherList.remove(t);
        return t;
    }

    @Override
    public Teacher update(Teacher entity) {
        long id = entity.getId();
        if(findOne(id)!=null){
            teacherList.set(teacherList.indexOf(findOne(id)), entity);
            return null;
        }
        return entity;
    }
}
