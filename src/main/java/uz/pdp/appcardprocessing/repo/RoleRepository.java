package uz.pdp.appcardprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appcardprocessing.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}