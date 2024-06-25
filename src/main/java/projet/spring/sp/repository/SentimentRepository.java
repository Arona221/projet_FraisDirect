package projet.spring.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.spring.sp.entites.Sentiment;

public interface SentimentRepository  extends JpaRepository<Sentiment, Integer> {
}
