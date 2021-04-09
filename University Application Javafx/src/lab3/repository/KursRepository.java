package lab3.repository;//package lab3.lab3.repository.ICrudRepository
import lab3.model.Kurs;

import java.util.List;

public class KursRepository implements ICrudRepository<Kurs> {

    private List<Kurs> kursList;

    @Override
    public String toString() {
        
        return "KursRepository{" +
                "kursList=" + kursList +
                '}';
    }

    public KursRepository(List<Kurs> kursList) {

        this.kursList = kursList;
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }

    @Override
    public Kurs findOne(Long id) {
         for( Kurs k :  kursList)
             if(k.getId().equals(id))
                 return k;
        return null;
    }



    @Override
    public List<Kurs> findAll() {
        return kursList;
    }

    @Override
    public Kurs save(Kurs entity) {
        if(!kursList.contains(entity)) {
            kursList.add(entity);
            return null;
        }
        return entity;

    }

    @Override
    public Kurs delete(Long id) {
        Kurs k = findOne(id);
        if(k==null) {
            return null;
        }
        kursList.remove(k);
        return k;
    }

    @Override
    public Kurs update(Kurs entity) {
        long id= entity.getId();
        if(findOne(id)!=null){
            kursList.set(kursList.indexOf(findOne(id)),entity);
            return null;
        }
    return entity;

    }

}
