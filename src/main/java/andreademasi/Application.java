package andreademasi;

import andreademasi.entities.Evento;
import andreademasi.entities.EventoDAO;
import andreademasi.entities.tipoEvento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;
import java.util.function.Supplier;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        try {
            EventoDAO eventoDAO = new EventoDAO(em);
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            Date data1 = new Date("01/01/2021");
            Date data2 = new Date("01/01/2023");
            Supplier<Evento> eventoSupplier = () -> new Evento(faker.book().title(), faker.date().between(data1, data2), faker.medical().symptoms(), tipoEvento.randomTipoEvento(), rndm.nextInt(0, 200));
            List<Evento> eventoList = new ArrayList<>();

//            for (int i = 0; i < 5; i++) {
//                eventoList.add(eventoSupplier.get());
//            }

            // Save with For loop

//            for (int i = 0; i < eventoList.size(); i++) {
//            eventoDAO.save(eventoList.get(i));
//            }

            // Find by Id
            Evento test1 = eventoDAO.findById(8);
            if (test1 != null) {
                System.out.println(test1);
            }

            // Find and delete by Id
            eventoDAO.findByIdAndDelete(2);

            // Refresh
            Evento test2 = eventoDAO.findById(10);
            if (test2 != null) {
                test2.setTitolo("Prova di refresh");
                System.out.println("Statto di test2 prima del refresh: " + test2);

                eventoDAO.refresh(test2);
                System.out.println("Statto di test2 dopo il refresh: " + test2);
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();
            emf.close();
        }


    }
}
