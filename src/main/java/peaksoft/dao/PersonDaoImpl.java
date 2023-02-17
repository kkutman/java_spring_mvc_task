package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.models.Person;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDao{
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public void deleteBiId(Long id) {
        entityManager.remove(entityManager.find(Person.class,id));
    }

    @Override
    public void update(Long id,Person person) {
        Person person1 = entityManager.find(Person.class, id);
        person1.setName(person.getName());
        person1.setImage(person.getImage());
    }

    @Override
    public Person getById(Long id) {
        return entityManager.find(Person.class,id);
    }
}
