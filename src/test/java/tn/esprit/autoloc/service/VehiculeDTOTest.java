package tn.esprit.autoloc.service;

import org.junit.jupiter.api.Test;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculeDTOTest {

    @Test
    void testFromEntity() {
        Agence agence = new Agence();
        agence.setIdAgence(10L);

        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(1L);
        vehicule.setImmatriculation("123-TN-456");
        vehicule.setMarque("Renault");
        vehicule.setModele("Clio");
        vehicule.setCategorie(CategorieVehicule.CITADINE);
        vehicule.setTarifJournalier(new BigDecimal("120.00"));
        vehicule.setStatut(StatutVehicule.DISPONIBLE);
        vehicule.setAgence(agence);

        VehiculeDTO dto = VehiculeDTO.fromEntity(vehicule);

        assertNotNull(dto);
        assertEquals(1L, dto.getIdVehicule());
        assertEquals("123-TN-456", dto.getImmatriculation());
        assertEquals("Renault", dto.getMarque());
        assertEquals("Clio", dto.getModele());
        assertEquals(CategorieVehicule.CITADINE, dto.getCategorie());
        assertEquals(new BigDecimal("120.00"), dto.getTarifJournalier());
        assertEquals(StatutVehicule.DISPONIBLE, dto.getStatut());
        assertEquals(10L, dto.getIdAgence());
    }

    @Test
    void testToEntity() {
        VehiculeDTO dto = VehiculeDTO.builder()
                .idVehicule(2L)
                .immatriculation("789-TN-101")
                .marque("Peugeot")
                .modele("208")
                .categorie(CategorieVehicule.CITADINE)
                .tarifJournalier(new BigDecimal("110.00"))
                .statut(StatutVehicule.DISPONIBLE)
                .build();

        Vehicule vehicule = VehiculeDTO.toEntity(dto);

        assertNotNull(vehicule);
        assertEquals(2L, vehicule.getIdVehicule());
        assertEquals("789-TN-101", vehicule.getImmatriculation());
        assertEquals("Peugeot", vehicule.getMarque());
        assertEquals("208", vehicule.getModele());
        assertEquals(CategorieVehicule.CITADINE, vehicule.getCategorie());
        assertEquals(new BigDecimal("110.00"), vehicule.getTarifJournalier());
        assertEquals(StatutVehicule.DISPONIBLE, vehicule.getStatut());
    }
}
