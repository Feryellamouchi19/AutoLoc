package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    List<Agence> retrieveAllAgences();
    Agence addAgence(Agence a);
    Agence updateAgence(Agence a);
    Agence retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);
    List<Agence> addAgences(List<Agence> agences);

    // Scénario 4 : Rechercher les agences situées dans une ville donnée
    List<Agence> findByVille(String ville);
}