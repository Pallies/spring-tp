package fr.diginamic.hotel.controller;

import fr.diginamic.hotel.controller.reponse.ResponseEntityManager;
import fr.diginamic.hotel.entite.Client;
import fr.diginamic.hotel.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController extends ResponseEntityManager {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<Client> clientList(@RequestParam Integer start, Integer size) {
        return clientService.paginationClientList(start, size);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Client> clientById(@PathVariable(name = "numero") Integer id) {
        Client client = clientService.findclientById(id);
        if(client != null)
            return  ResponseEntityBuilderValid(client);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        try{
            return ResponseEntityBuilderValid(clientService.saveClient(client));
        }catch (ConstraintViolationException e){
            return ResponseEntityBuilderError(e.getMessage());
        }
    }


    @PostMapping("save-all")
    public ResponseEntity<?> saveClient( @RequestBody List<Client> clients) {
        try {
            return ResponseEntityBuilderValid(clientService.saveAll(clients));
        }catch (ConstraintViolationException e){
            return ResponseEntityBuilderError(e.getMessage());
        }
    }
}
