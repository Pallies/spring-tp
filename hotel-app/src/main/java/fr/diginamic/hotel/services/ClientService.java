package fr.diginamic.hotel.services;

import fr.diginamic.hotel.entite.Client;
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

    public Client findclientById(Integer id) {
        return repository.findById(id).orElse(null);
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
}
