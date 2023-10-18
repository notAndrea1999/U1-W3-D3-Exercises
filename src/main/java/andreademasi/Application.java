package andreademasi;

import andreademasi.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PersonDAO pd = new PersonDAO(em);
        LocalDate d1 = LocalDate.of(2021, 01, 01);

        Person p1 = new Person("Mario", "Biondi", "mariob@sobello.it", d1, Gender.M);
        Person p2 = new Person("Lucia", "Mora", "luciam@sobello.it", d1, Gender.F);
        Person p3 = new Person("Gianni", "Bruno", "giannib@sobello.it", d1, Gender.M);
        Person p4 = new Person("Marco", "Avaria", "marcom@sobello.it", d1, Gender.M);
        Person p5 = new Person("Adelina", "Ionio", "adelinai@sobello.it", d1, Gender.F);
//        pd.save(p1);
//        pd.save(p2);
//        pd.save(p3);
//        pd.save(p4);
//        pd.save(p5);


        LocationDAO ld = new LocationDAO(em);
        Location l1 = new Location("Location 1", "Roma");
        Location l2 = new Location("Location 2", "Milano");
        Location l3 = new Location("Location 3", "Napoli");
        Location l4 = new Location("Location 4", "Pesaro");
        Location l5 = new Location("Location 5", "Gerusalemme");
//        ld.save(l1);
//        ld.save(l2);
//        ld.save(l3);
//        ld.save(l4);
//        ld.save(l5);

        EventoDAO ed = new EventoDAO(em);
        LocalDate d2 = LocalDate.of(2023, 01, 01);
        Evento e1 = new Evento("Dance", d2, "Una bella Descrizione", tipoEvento.randomTipoEvento(), 200);
        // Evento e2 = new Evento("Dance2", d2, "Una bella Descrizione", tipoEvento.randomTipoEvento(), 200);
        // Evento e3 = new Evento("Dance3", d2, "Una bella Descrizione", tipoEvento.randomTipoEvento(), 200);
        // Evento e4 = new Evento("Dance4", d2, "Una bella Descrizione", tipoEvento.randomTipoEvento(), 200);
        // Evento e5 = new Evento("Dance5", d2, "Una bella Descrizione", tipoEvento.randomTipoEvento(), 200);

        Location foundLocation = ld.findById(1);
        Location foundLocation2 = ld.findById(4);

//        e1.setLocation(foundLocation2);
//        ed.save(e1);
//        ed.findByIdAndDelete(23);

//        ed.save(e1);
//        ed.save(e2);
//        ed.save(e3);
//        ed.save(e4);
//        ed.save(e5);

        PartecipationDAO partd = new PartecipationDAO(em);
        Person foundPerson = pd.findById(1);
        Evento foundEvent = ed.findById(26);
        Partecipation part1 = new Partecipation(foundPerson, foundEvent, Status.CONFERMATA);
        partd.save(part1);

        em.close();
        emf.close();
    }
}
