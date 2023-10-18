package andreademasi.entities;

import javax.persistence.*;

@Entity
public class Partecipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Person person;
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Partecipation() {
    }

    public Partecipation(Person person, Evento evento, Status status) {
        this.person = person;
        this.evento = evento;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", evento=" + evento +
                ", status=" + status +
                '}';
    }
}
