package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
    }

    @PutMapping("/{idVehicule}/affecter-agence/{idAgence}")
    public Vehicule affecterVehicule(
            @PathVariable Long idVehicule,
            @PathVariable Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    // Scénario 1 : Rechercher tous les véhicules ayant une marque précise
    @GetMapping("/search/marque/{marque}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable String marque) {
        return vehiculeService.findByMarque(marque);
    }

    // Scénario 2 : Rechercher tous les véhicules d'une catégorie donnée
    @GetMapping("/search/categorie/{categorie}")
    public List<Vehicule> getVehiculesByCategorie(@PathVariable CategorieVehicule categorie) {
        return vehiculeService.findByCategorie(categorie);
    }

    // Scénario 3 : Rechercher les véhicules ayant un statut DISPONIBLE
    @GetMapping("/search/disponibles")
    public List<Vehicule> getVehiculesDisponibles() {
        return vehiculeService.findVehiculesDisponibles();
    }

    @GetMapping("/search/statut/{statut}")
    public List<Vehicule> getVehiculesByStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.findByStatut(statut);
    }

    // Scénario 5 : Rechercher les véhicules dont la marque contient une chaîne saisie
    @GetMapping("/search/marque-contenant/{chaine}")
    public List<Vehicule> getVehiculesByMarqueContaining(@PathVariable String chaine) {
        return vehiculeService.findByMarqueContaining(chaine);
    }

    // Scénario 8 : Rechercher les véhicules dont le tarif est supérieur à 100 DT
    @GetMapping("/search/tarif-superieur/{tarif}")
    public List<Vehicule> getVehiculesByTarifGreaterThan(@PathVariable BigDecimal tarif) {
        return vehiculeService.findByTarifJournalierGreaterThan(tarif);
    }

    @GetMapping("/search/tarif-superieur-100")
    public List<Vehicule> getVehiculesTarifSuperieur100() {
        return vehiculeService.findVehiculesTarifSuperieurA100();
    }

    // Scénario 11 : Rechercher les véhicules d'une marque donnée ET ayant le statut DISPONIBLE
    @GetMapping("/search/marque/{marque}/disponible")
    public List<Vehicule> getVehiculesByMarqueAndDisponible(@PathVariable String marque) {
        return vehiculeService.findVehiculesByMarqueAndDisponible(marque);
    }

    @GetMapping("/search/marque-et-statut")
    public List<Vehicule> getVehiculesByMarqueAndStatut(
            @RequestParam String marque,
            @RequestParam StatutVehicule statut) {
        return vehiculeService.findByMarqueAndStatut(marque, statut);
    }
}