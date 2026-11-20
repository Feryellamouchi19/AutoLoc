package tn.esprit.autoloc.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScenariosServiceTest {

    @Mock
    private VehiculeRepository vehiculeRepository;

    @Mock
    private AgenceRepository agenceRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private VehiculeServiceImpl vehiculeService;

    @InjectMocks
    private AgenceServiceImpl agenceService;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    void testScenario1_FindByMarque() {
        Vehicule v = new Vehicule();
        v.setMarque("Renault");
        when(vehiculeRepository.findByMarque("Renault")).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findByMarque("Renault");
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Renault", results.get(0).getMarque());
        verify(vehiculeRepository).findByMarque("Renault");
    }

    @Test
    void testScenario2_FindByCategorie() {
        Vehicule v = new Vehicule();
        v.setCategorie(CategorieVehicule.SUV);
        when(vehiculeRepository.findByCategorie(CategorieVehicule.SUV)).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findByCategorie(CategorieVehicule.SUV);
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(CategorieVehicule.SUV, results.get(0).getCategorie());
        verify(vehiculeRepository).findByCategorie(CategorieVehicule.SUV);
    }

    @Test
    void testScenario3_FindByStatutDisponible() {
        Vehicule v = new Vehicule();
        v.setStatut(StatutVehicule.DISPONIBLE);
        when(vehiculeRepository.findByStatut(StatutVehicule.DISPONIBLE)).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findVehiculesDisponibles();
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(StatutVehicule.DISPONIBLE, results.get(0).getStatut());
        verify(vehiculeRepository).findByStatut(StatutVehicule.DISPONIBLE);
    }

    @Test
    void testScenario4_FindByVille() {
        Agence a = new Agence();
        a.setVille("Tunis");
        when(agenceRepository.findByVille("Tunis")).thenReturn(List.of(a));

        List<Agence> results = agenceService.findByVille("Tunis");
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Tunis", results.get(0).getVille());
        verify(agenceRepository).findByVille("Tunis");
    }

    @Test
    void testScenario5_FindByMarqueContaining() {
        Vehicule v = new Vehicule();
        v.setMarque("Peugeot");
        when(vehiculeRepository.findByMarqueContaining("eug")).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findByMarqueContaining("eug");
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(vehiculeRepository).findByMarqueContaining("eug");
    }

    @Test
    void testScenario8_FindByTarifGreaterThan() {
        Vehicule v = new Vehicule();
        v.setTarifJournalier(new BigDecimal("120.00"));
        when(vehiculeRepository.findByTarifJournalierGreaterThan(BigDecimal.valueOf(100))).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findVehiculesTarifSuperieurA100();
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(vehiculeRepository).findByTarifJournalierGreaterThan(BigDecimal.valueOf(100));
    }

    @Test
    void testScenario11_FindByMarqueAndStatut() {
        Vehicule v = new Vehicule();
        v.setMarque("Toyota");
        v.setStatut(StatutVehicule.DISPONIBLE);
        when(vehiculeRepository.findByMarqueAndStatut("Toyota", StatutVehicule.DISPONIBLE)).thenReturn(List.of(v));

        List<Vehicule> results = vehiculeService.findVehiculesByMarqueAndDisponible("Toyota");
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(vehiculeRepository).findByMarqueAndStatut("Toyota", StatutVehicule.DISPONIBLE);
    }

    @Test
    void testScenario14_FindByDateDebutAfter() {
        LocalDate date = LocalDate.of(2026, 1, 1);
        Reservation r = new Reservation();
        r.setDateDebut(LocalDate.of(2026, 6, 1));
        when(reservationRepository.findByDateDebutAfter(date)).thenReturn(List.of(r));

        List<Reservation> results = reservationService.findByDateDebutAfter(date);
        assertNotNull(results);
        assertEquals(1, results.size());
        verify(reservationRepository).findByDateDebutAfter(date);
    }
}
