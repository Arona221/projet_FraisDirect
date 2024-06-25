package projet.spring.sp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projet.spring.sp.entites.Client;
import projet.spring.sp.service.ClientService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "Client")

public class ClientController {
    private ClientService clientService ;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)

    public  void Creer (@RequestBody Client client)
    {
        this.clientService.Creer(client);

    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> recherche()
    {
        return this.clientService.recherche();
    }
    @GetMapping( path ="{id}" ,produces= APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id )
    {
        return this.clientService.lire(id);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path ="{id}", produces = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id , @RequestBody Client client)
    {
        this.clientService.modifier(id ,client);
    }

}
