package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);

    Vehicule affecterVehicule(Long idVehicule, Long idAgence);

    // Scénario 1 : Rechercher tous les véhicules ayant une marque précise
    List<Vehicule> findByMarque(String marque);

    // Scénario 2 : Rechercher tous les véhicules d'une catégorie donnée
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Scénario 3 : Rechercher les véhicules ayant un statut DISPONIBLE
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findVehiculesDisponibles();

    // Scénario 5 : Rechercher les véhicules dont la marque contient une chaîne saisie
    List<Vehicule> findByMarqueContaining(String chaine);

    // Scénario 8 : Rechercher les véhicules dont le tarif est supérieur à un montant (100 DT)
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findVehiculesTarifSuperieurA100();

    // Scénario 11 : Rechercher les véhicules d'une marque donnée ET ayant le statut DISPONIBLE
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
    List<Vehicule> findVehiculesByMarqueAndDisponible(String marque);
}