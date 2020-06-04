package edu.iteahome.springdatajpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persoana")
public class Persoana {


    @Id
    @Column(name = "identificator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identificator;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "persoana")
    private Set<Masina> masina;

    public Persoana() {
    }

    public Persoana(String nume) {
        this.nume = nume;
    }

    public long getIdentificator() {
        return identificator;
    }

    public String getNume() {
        return nume;
    }

    public Set<Masina> getMasina() {
        return masina;
    }
}
