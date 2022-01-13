package fr.diginamic.hotel.services;

import com.fasterxml.jackson.core.io.IOContext;
import fr.diginamic.hotel.entite.Client;
import fr.diginamic.hotel.entite.Reservation;
import fr.diginamic.hotel.exception.BadRequestException;
import fr.diginamic.hotel.repository.ClientRepository;
import fr.diginamic.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ReservationService {


    private final ClientRepository clientRepository;

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository,ClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository=clientRepository;
    }

    public Reservation saveReservation(Reservation reservation) throws BadRequestException {
        String numeroClient = reservation.getClient().getNumero();
        boolean isClientExist = clientRepository.findAll()
                .stream().map(Client::getNumero)
                .collect(Collectors.toList())
                .contains(numeroClient);
        if (!isClientExist)
            throw new BadRequestException("{ messages : numéro client non trouvé }");
        return repository.save(reservation);
    }
}
