package andreademasi.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location salvata con successo");
    }

    public Location findById(long id) {
        return em.find(Location.class, id);
    }

    public void findByIdAndDelete(long id) {
        Location foundLocation = em.find(Location.class, id);

        if (foundLocation != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundLocation);
            transaction.commit();
            System.out.println("La location con id: " + id + " e' stata eliminata con successo");
        } else {
            System.out.println("La location con id: " + id + " non e' stata trovata");
        }

    }

    public void refresh(Partecipation partecipation) {
        em.refresh(partecipation);
        System.out.println("La location e' stata refreshata");
    }
}
