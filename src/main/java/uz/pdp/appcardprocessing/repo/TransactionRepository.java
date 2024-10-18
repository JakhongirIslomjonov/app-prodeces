package uz.pdp.appcardprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appcardprocessing.entity.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}