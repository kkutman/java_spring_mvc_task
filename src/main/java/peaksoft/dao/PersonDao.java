package peaksoft.dao;

import peaksoft.models.Person;

import java.util.List;

/**
 * name : kutman
 **/
public interface PersonDao {
    void save(Person person);
    List<Person>getAll();
    void deleteBiId(Long id);
    void update(Long id,Person person);
    Person getById(Long id);
}
