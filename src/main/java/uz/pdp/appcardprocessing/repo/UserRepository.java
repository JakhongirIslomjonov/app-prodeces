package uz.pdp.appcardprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appcardprocessing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}