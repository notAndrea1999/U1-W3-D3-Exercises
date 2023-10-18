package andreademasi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

/*
        try {
            EventoDAO eventoDAO = new EventoDAO(em);
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            Date data1 = new Date("01/01/2021");
            Date data2 = new Date("01/01/2023");
            Supplier<Evento> eventoSupplier = () -> new Evento(faker.book().title(), faker.date().between(data1, data2), faker.medical().symptoms(), tipoEvento.randomTipoEvento(), rndm.nextInt(0, 200));
            List<Evento> eventoList = new ArrayList<>();

            for (int i = 0; i < 1; i++) {
                eventoList.add(eventoSupplier.get());
            }

            // Save with For loop

            for (int i = 0; i < eventoList.size(); i++) {
                eventoDAO.save(eventoList.get(i));
            }



    } catch (Exception ex) {
            System.err.println(ex);


        } finally {
            em.close();
            emf.close();
        }
        */


    }
}
