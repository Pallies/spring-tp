package fr.diginamic.hotel.services;

import fr.diginamic.hotel.entite.Chambre;
import fr.diginamic.hotel.entite.Reservation;
import fr.diginamic.hotel.exception.BadRequestException;
import fr.diginamic.hotel.exception.ErrorHotel;
import fr.diginamic.hotel.repository.ChambreRepository;
import fr.diginamic.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {


    private final ClientService clientService;
    private final ChambreService chambreService;

    private final ReservationRepository repository;

    public ReservationService(
            ReservationRepository repository,
            ClientService clientService,
            ChambreService chambreService
    ) {
        this.repository = repository;
        this.clientService = clientService;
        this.chambreService = chambreService;
    }

    public Reservation saveReservation(Reservation reservation, String hotel) throws BadRequestException {
        // vérification de l'existance du client
        String numeroClient = reservation.getClient().getNumero();
        clientService.ControlClientExist(numeroClient);

        // vérification de l'existance des chambres dans l'hotel
        List<Chambre> chambers = reservation.getChambres();
        chambreService.controlChamberInHotelExist(hotel,chambers);

        return repository.save(reservation);
    }
}
