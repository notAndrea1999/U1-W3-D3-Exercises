package andreademasi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    private String titolo;
    private Date data_evento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;
    private int numero_massimo_partecipanti;

    private Set<Partecipation> partecipationSet;

    private Location location;

    public Evento() {
    }

    public Evento(String titolo, Date data_evento, String descrizione, andreademasi.entities.tipoEvento tipoEvento, int numero_massimo_partecipanti, Set<Partecipation> partecipationSet, Location location) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
        this.partecipationSet = partecipationSet;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getData_evento() {
        return data_evento;
    }

    public void setData_evento(Date data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public andreademasi.entities.tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(andreademasi.entities.tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                '}';
    }
}
