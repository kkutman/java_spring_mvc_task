package peaksoft.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.PersonDao;
import peaksoft.models.Person;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class PersonServicesImpl implements PersonServices{
    private final PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public void deleteBiId(Long id) {
        personDao.deleteBiId(id);
    }

    @Override
    public void update( Person person) {
        personDao.update(person.getId(), person);
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }
}
