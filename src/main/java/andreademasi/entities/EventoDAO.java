package andreademasi.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento salvato con successo");
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void findByIdAndDelete(long id) {
        Evento foundEvent = em.find(Evento.class, id);

        if (foundEvent != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundEvent);
            transaction.commit();
            System.out.println("L'evento con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("L'evento con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Evento evento) {
        em.refresh(evento);
        System.out.println("L'evento e' stato refreshato");
    }


}
