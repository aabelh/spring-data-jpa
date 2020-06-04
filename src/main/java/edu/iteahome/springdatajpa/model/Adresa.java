package edu.iteahome.springdatajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "adresa")
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "identificator")
    private int identificator;

    @Column(name = "adresa")
    private String adresa;



    public Adresa() {
    }

    public Adresa(int identificator, String adresa) {
        this.identificator = identificator;
        this.adresa = adresa;
    }

    public int getIdentificator() {
        return identificator;
    }

    public String getAdresa() {
        return adresa;
    }
}
