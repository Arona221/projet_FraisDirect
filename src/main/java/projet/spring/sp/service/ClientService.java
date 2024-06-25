package projet.spring.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projet.spring.sp.entites.Client;
import projet.spring.sp.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private   ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public  void Creer (Client client)
    {
        Client client1= this.clientRepository.findByEmail(client.getEmail());
        if(client1==null)
        {
            this.clientRepository.save(client);
        }


    }
    public List<Client> recherche()
    {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient= this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }
    public Client lireouCreer(Client clientAcreer) {
        Client client1= this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(client1==null)
        {
            this.clientRepository.save(clientAcreer);
        }
        return client1;
    }

    public void modifier(int id, Client client) {
        Client client1= this.lire(id);
        if(client1.getId()==client.getId())
        {
            client1.setEmail(client.getEmail());
            client1.setTelephone(client.getTelephone());
            this.clientRepository.save(client1);
        }


    }
}
