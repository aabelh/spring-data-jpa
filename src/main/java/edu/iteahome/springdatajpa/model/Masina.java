package edu.iteahome.springdatajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "masina")
public class Masina {


    @Id
    @Column(name = "numar_inmatriculare")
    private String nrInmatriculare;
    @Column(name = "marca")
    private String marca;
    @Column(name = "an_fabricatie")
    private int anFabricatie;

    @ManyToOne
    @JoinColumn(name = "id_persoana", nullable = false)
    private Persoana persoana;

    public Masina() {
    }

    public Masina(String nrInmatriculare, String marca, int anFabricatie, Persoana persoana) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.persoana = persoana;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }
}
