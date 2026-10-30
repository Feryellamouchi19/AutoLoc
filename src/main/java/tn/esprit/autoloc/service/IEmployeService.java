package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;

public interface IEmployeService {

    List<Employe> retrieveAllEmployes();

    Employe addEmploye(Employe e);

    Employe updateEmploye(Employe e);

    Employe retrieveEmploye(Long idEmploye);

    void removeEmploye(Long idEmploye);

    List<Employe> addEmployes(List<Employe> employes);

    // Désaffecter un employé de son agence
    Employe desaffecterEmploye(Long idEmploye);

    // Affecter un employé à une agence
    Employe affecterEmploye(Long idEmploye, Long idAgence);
}