package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    Reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List<Reservation> addReservations(List<Reservation> reservations);

    // Scénario 14 : Rechercher les réservations dont la date de début est postérieure à une date donnée
    List<Reservation> findByDateDebutAfter(LocalDate dateDebut);
}