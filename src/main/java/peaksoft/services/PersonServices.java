package peaksoft.services;

import peaksoft.models.Person;

import java.util.List;

/**
 * name : kutman
 **/
public interface PersonServices {
    void save(Person person);
    List<Person> getAll();
    void deleteBiId(Long id);
    public void update(Person person);
    Person getById(Long id);
}
