package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    // Afficher tous les employés
    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    // Afficher un employé par son ID
    @GetMapping("/{idEmploye}")
    public Employe getEmploye(@PathVariable Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    // Ajouter un employé
    @PostMapping
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    // Modifier un employé
    @PutMapping
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }

    // Supprimer un employé
    @DeleteMapping("/{idEmploye}")
    public void deleteEmploye(@PathVariable Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }

    // Désaffecter un employé de son agence
    @PutMapping("/{idEmploye}/desaffecter")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    // Affecter un employé à une agence
    @PutMapping("/{idEmploye}/affecter/{idAgence}")
    public Employe affecterEmploye(
            @PathVariable Long idEmploye,
            @PathVariable Long idAgence) {

        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}