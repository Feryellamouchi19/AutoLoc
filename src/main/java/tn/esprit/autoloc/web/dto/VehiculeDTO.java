package tn.esprit.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculeDTO {

    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private StatutVehicule statut;
    private Long idAgence;

    // Convertir une entité Vehicule en VehiculeDTO
    public static VehiculeDTO fromEntity(Vehicule vehicule) {
        if (vehicule == null) {
            return null;
        }
        return VehiculeDTO.builder()
                .idVehicule(vehicule.getIdVehicule())
                .immatriculation(vehicule.getImmatriculation())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .categorie(vehicule.getCategorie())
                .tarifJournalier(vehicule.getTarifJournalier())
                .statut(vehicule.getStatut())
                .idAgence(vehicule.getAgence() != null ? vehicule.getAgence().getIdAgence() : null)
                .build();
    }

    // Convertir un VehiculeDTO en entité Vehicule
    public static Vehicule toEntity(VehiculeDTO dto) {
        if (dto == null) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(dto.getIdVehicule());
        vehicule.setImmatriculation(dto.getImmatriculation());
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setCategorie(dto.getCategorie());
        vehicule.setTarifJournalier(dto.getTarifJournalier());
        vehicule.setStatut(dto.getStatut());
        return vehicule;
    }
}
