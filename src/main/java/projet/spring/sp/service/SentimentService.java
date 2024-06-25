package projet.spring.sp.service;

import org.springframework.stereotype.Service;
import projet.spring.sp.entites.Client;
import projet.spring.sp.entites.Sentiment;
import projet.spring.sp.entites.enums.TypeSentiment;
import projet.spring.sp.repository.SentimentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SentimentService {
    private  ClientService clientService;
   private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment) {
        Client client=this.clientService.lireouCreer(sentiment.getClient());
        sentiment.setClient(client);
        if (sentiment.getText().contains("pas"))
        {
            sentiment.setType(TypeSentiment.NEGATIF);
        }else
        {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);

    }

    public List<Sentiment> AffichageSentiment() {
        return this.sentimentRepository.findAll();
    }

    public Sentiment getSentimentparID(int id) {
        Optional <Sentiment> optionalSentiment=this.sentimentRepository.findById(id);
        return optionalSentiment.orElse(null);

    }

    public void supprimerSentimentParID(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
