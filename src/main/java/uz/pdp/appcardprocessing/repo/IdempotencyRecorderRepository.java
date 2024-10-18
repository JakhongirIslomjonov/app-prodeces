package uz.pdp.appcardprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appcardprocessing.entity.IdempotencyRecorder;

import java.util.UUID;

public interface IdempotencyRecorderRepository extends JpaRepository<IdempotencyRecorder, UUID> {
}