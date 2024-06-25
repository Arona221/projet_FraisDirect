package projet.spring.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.spring.sp.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
    Client findByEmail(String email);

}
