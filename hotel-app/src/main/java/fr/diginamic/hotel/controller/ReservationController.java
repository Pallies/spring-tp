package fr.diginamic.hotel.controller;

import fr.diginamic.hotel.controller.reponse.ResponseEntityManager;
import fr.diginamic.hotel.entite.Reservation;
import fr.diginamic.hotel.exception.BadRequestException;
import fr.diginamic.hotel.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservations")
public class ReservationController extends ResponseEntityManager {


    private final ReservationService service;

    public ReservationController(ReservationService reservationService) {
        service = reservationService;
    }

    @PostMapping("/{hotel}")
    public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation, @PathVariable String hotel) {
        try {
            return ResponseEntityBuilderValid(service.saveReservation(reservation,hotel));
        } catch (BadRequestException e) {
            return ResponseEntityBuilderError(e.getMessage());
        }
    }
}
