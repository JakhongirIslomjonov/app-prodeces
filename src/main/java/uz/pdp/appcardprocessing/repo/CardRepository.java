package uz.pdp.appcardprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appcardprocessing.entity.Card;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

}