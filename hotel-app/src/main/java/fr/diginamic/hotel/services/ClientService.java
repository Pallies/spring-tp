package fr.diginamic.hotel.services;

import fr.diginamic.hotel.entite.Client;
import fr.diginamic.hotel.exception.BadRequestException;
import fr.diginamic.hotel.exception.ErrorHotel;
import fr.diginamic.hotel.repository.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client findClientByNumero(String numero) {
        return repository.findClientByNumero(numero).orElse(null);
    }

    public List<Client> paginationClientList(Integer start, Integer size) {
        return this.repository.findAll(
                PageRequest.of(start, size)
        ).toList();
    }

    public Client saveClient(@Valid Client client)  throws ConstraintViolationException{
        return repository.save(client);
    }

    @Transactional
    public List<Client> saveAll(@Valid List<Client> clients) throws ConstraintViolationException {
        List<Client> clientsAsSave = new ArrayList<>();
        for ( Client c : clients) {
            clientsAsSave.add(saveClient(c));
        }
        return clientsAsSave;
    }

    /**
     * contrôle si le client existe sinon lève une exception
     * @param numeroClient
     * @throws BadRequestException
     */
    public void ControlClientExist(String numeroClient) throws BadRequestException {
        boolean isClientExist = repository.findAll()
                .stream().map(Client::getNumero)
                .collect(Collectors.toList())
                .contains(numeroClient);
        if (!isClientExist)
            throw new BadRequestException(ErrorHotel.NOT_CLIENT, List.of(" "));
    }
}
