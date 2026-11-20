package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository VR;
    private final AgenceRepository AR;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) VR.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return VR.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return VR.save(v);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return VR.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        VR.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return (List<Vehicule>) VR.saveAll(vehicules);
    }

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = VR.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Agence agence = AR.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);

        return VR.save(vehicule);
    }

    @Override
    public List<Vehicule> findByMarque(String marque) {
        return VR.findByMarque(marque);
    }

    @Override
    public List<Vehicule> findByCategorie(CategorieVehicule categorie) {
        return VR.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> findByStatut(StatutVehicule statut) {
        return VR.findByStatut(statut);
    }

    @Override
    public List<Vehicule> findVehiculesDisponibles() {
        return VR.findByStatut(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> findByMarqueContaining(String chaine) {
        return VR.findByMarqueContaining(chaine);
    }

    @Override
    public List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif) {
        return VR.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> findVehiculesTarifSuperieurA100() {
        return VR.findByTarifJournalierGreaterThan(BigDecimal.valueOf(100));
    }

    @Override
    public List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut) {
        return VR.findByMarqueAndStatut(marque, statut);
    }

    @Override
    public List<Vehicule> findVehiculesByMarqueAndDisponible(String marque) {
        return VR.findByMarqueAndStatut(marque, StatutVehicule.DISPONIBLE);
    }
}