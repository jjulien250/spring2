package com.example.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_formation")
    private Date dateFormation;

    @Column(name = "lieu_formation")
    private String lieuFormation;

    @Column(name = "intitule_formation")
    private String intituleFormation;

    @Column(name = "frais_transport_train", nullable = true)
    private Double fraisTransportTrain = 0.0;

    @Column(name = "frais_transport_avion", nullable = true)
    private Double fraisTransportAvion = 0.0;

    @Column(name = "frais_transport_bus", nullable = true)
    private Double fraisTransportBus = 0.0;

    @Column(name = "frais_transport_voiture", nullable = true)
    private Double fraisTransportVoiture = 0.0;

    @Column(name = "frais_hebergement_hotel", nullable = true)
    private Double fraisHebergementHotel = 0.0;

    @Column(name = "frais_hebergement_airbnb", nullable = true)
    private Double fraisHebergementAirbnb = 0.0;

    @Column(name = "frais_restauration", nullable = true)
    private Double fraisRestauration = 0.0;

    @Column(nullable = false)
    private String status;

    public Expense() {
        this.status = "EN_ATTENTE";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateFormation() {
        return dateFormation;
    }

    public void setDateFormation(Date dateFormation) {
        this.dateFormation = dateFormation;
    }

    public String getLieuFormation() {
        return lieuFormation;
    }

    public void setLieuFormation(String lieuFormation) {
        this.lieuFormation = lieuFormation;
    }

    public String getIntituleFormation() {
        return intituleFormation;
    }

    public void setIntituleFormation(String intituleFormation) {
        this.intituleFormation = intituleFormation;
    }

    public Double getFraisTransportTrain() {
        return fraisTransportTrain;
    }

    public void setFraisTransportTrain(Double fraisTransportTrain) {
        this.fraisTransportTrain = fraisTransportTrain;
    }

    public Double getFraisTransportAvion() {
        return fraisTransportAvion;
    }

    public void setFraisTransportAvion(Double fraisTransportAvion) {
        this.fraisTransportAvion = fraisTransportAvion;
    }

    public Double getFraisTransportBus() {
        return fraisTransportBus;
    }

    public void setFraisTransportBus(Double fraisTransportBus) {
        this.fraisTransportBus = fraisTransportBus;
    }

    public Double getFraisTransportVoiture() {
        return fraisTransportVoiture;
    }

    public void setFraisTransportVoiture(Double fraisTransportVoiture) {
        this.fraisTransportVoiture = fraisTransportVoiture;
    }

    public Double getFraisHebergementHotel() {
        return fraisHebergementHotel;
    }

    public void setFraisHebergementHotel(Double fraisHebergementHotel) {
        this.fraisHebergementHotel = fraisHebergementHotel;
    }

    public Double getFraisHebergementAirbnb() {
        return fraisHebergementAirbnb;
    }

    public void setFraisHebergementAirbnb(Double fraisHebergementAirbnb) {
        this.fraisHebergementAirbnb = fraisHebergementAirbnb;
    }

    public Double getFraisRestauration() {
        return fraisRestauration;
    }

    public void setFraisRestauration(Double fraisRestauration) {
        this.fraisRestauration = fraisRestauration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
