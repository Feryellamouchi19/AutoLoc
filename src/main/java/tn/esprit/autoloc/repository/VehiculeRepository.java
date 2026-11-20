package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

    // Scénario 1 : Rechercher tous les véhicules ayant une marque précise
    List<Vehicule> findByMarque(String marque);

    // Scénario 2 : Rechercher tous les véhicules d'une catégorie donnée
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Scénario 3 : Rechercher les véhicules ayant un statut DISPONIBLE
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Scénario 5 : Rechercher les véhicules dont la marque contient une chaîne saisie
    List<Vehicule> findByMarqueContaining(String marque);

    // Scénario 8 : Rechercher les véhicules dont le tarif est supérieur à un montant (100 DT)
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarifJournalier);

    // Scénario 11 : Rechercher les véhicules d'une marque donnée ET ayant le statut DISPONIBLE
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
}