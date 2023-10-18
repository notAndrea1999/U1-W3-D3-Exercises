package andreademasi.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipationDAO {
    private final EntityManager em;

    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipation partecipation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipation);
        transaction.commit();
        System.out.println("Persona salvata con successo");
    }

    public Partecipation findById(long id) {
        return em.find(Partecipation.class, id);
    }

    public void findByIdAndDelete(long id) {
        Partecipation foundPartecipation = em.find(Partecipation.class, id);

        if (foundPartecipation != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPartecipation);
            transaction.commit();
            System.out.println("La partecipazione con id: " + id + " e' stata eliminata con successo");
        } else {
            System.out.println("La partecipazione con id: " + id + " non e' stata trovata");
        }

    }

    public void refresh(Partecipation partecipation) {
        em.refresh(partecipation);
        System.out.println("La partecipazione e' stata refreshata");
    }
}
