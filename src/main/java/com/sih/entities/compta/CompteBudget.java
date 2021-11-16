package com.sih.entities.compta;

import javax.persistence.*;

import com.sih.entities.general.Exercice;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
public class CompteBudget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigBdg;
    private double PopositionMaire;
    private double voteCoseil;
    private double accordTutel;
    private double realisation;
    private double engagement;
    @ManyToOne(targetEntity = TypeBudget.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypBdg", referencedColumnName = "idTypBdg")
    private TypeBudget typBdg;
    @ManyToOne(targetEntity = Compte.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCpte", referencedColumnName = "idCpte")
    private Compte cpte;
    @ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "codExo", referencedColumnName = "codExo")
    private Exercice exo;

    public CompteBudget() {
    }

    public CompteBudget(double popositionMaire, double voteCoseil, double accordTutel, double realisation, double engagement, TypeBudget typBdg, Compte cpte, Exercice exo) {
        PopositionMaire = popositionMaire;
        this.voteCoseil = voteCoseil;
        this.accordTutel = accordTutel;
        this.realisation = realisation;
        this.engagement = engagement;
        this.typBdg = typBdg;
        this.cpte = cpte;
        this.exo = exo;
    }

    public Long getIdLigBdg() {
        return idLigBdg;
    }

    public void setIdLigBdg(Long idLigBdg) {
        this.idLigBdg = idLigBdg;
    }

    public double getPopositionMaire() {
        return PopositionMaire;
    }

    public void setPopositionMaire(double popositionMaire) {
        PopositionMaire = popositionMaire;
    }

    public double getVoteCoseil() {
        return voteCoseil;
    }

    public void setVoteCoseil(double voteCoseil) {
        this.voteCoseil = voteCoseil;
    }

    public double getAccordTutel() {
        return accordTutel;
    }

    public void setAccordTutel(double accordTutel) {
        this.accordTutel = accordTutel;
    }

    public double getRealisation() {
        return realisation;
    }

    public void setRealisation(double realisation) {
        this.realisation = realisation;
    }

    public double getEngagement() {
        return engagement;
    }

    public void setEngagement(double engagement) {
        this.engagement = engagement;
    }

    public TypeBudget getTypBdg() {
        return typBdg;
    }

    public void setTypBdg(TypeBudget typBdg) {
        this.typBdg = typBdg;
    }

    public Compte getCpte() {
        return cpte;
    }

    public void setCpte(Compte cpte) {
        this.cpte = cpte;
    }

    public Exercice getExo() {
        return exo;
    }

    public void setExo(Exercice exo) {
        this.exo = exo;
    }

    @Override
    public String toString() {
        return "LigneBudgetaire{" +
                "idLigBdg=" + idLigBdg +
                ", PopositionMaire=" + PopositionMaire +
                ", voteCoseil=" + voteCoseil +
                ", accordTutel=" + accordTutel +
                ", realisation=" + realisation +
                ", engagement=" + engagement +
                ", typBdg=" + typBdg +
                ", cpte=" + cpte +
                ", exo=" + exo +
                '}';
    }
}
