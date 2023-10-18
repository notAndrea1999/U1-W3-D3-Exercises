package andreademasi.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("Persona salvata con successo");
    }

    public Person findById(long id) {
        return em.find(Person.class, id);
    }

    public void findByIdAndDelete(long id) {
        Person foundPerson = em.find(Person.class, id);

        if (foundPerson != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPerson);
            transaction.commit();
            System.out.println("La persona con id: " + id + " e' stata eliminata con successo");
        } else {
            System.out.println("La persona con id: " + id + " non e' stata trovata");
        }

    }

    public void refresh(Person person) {
        em.refresh(person);
        System.out.println("La persona e' stata refreshata");
    }
}
