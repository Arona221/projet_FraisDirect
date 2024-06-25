package projet.spring.sp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import projet.spring.sp.entites.Sentiment;
import projet.spring.sp.service.SentimentService;

import javax.print.attribute.standard.Media;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "Sentiment",produces = MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;
    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }
   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping( consumes = APPLICATION_JSON_VALUE)

    public  void creer(@RequestBody Sentiment sentiment) {
    this.sentimentService.creer(sentiment);
    }
    @GetMapping (produces = APPLICATION_JSON_VALUE)
    public @ResponseBody List<Sentiment> AffichageSentiment() {
        return this.sentimentService.AffichageSentiment();
    }
    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public Sentiment getSentimentParID(@PathVariable int id) {
        return this.sentimentService.getSentimentparID(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public  void supprimerSentimentParID(@PathVariable int id) {
        this.sentimentService.supprimerSentimentParID(id);
    }
}
