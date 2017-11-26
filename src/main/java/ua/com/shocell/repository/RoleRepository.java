package ua.com.shocell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.shocell.models.Role;

@Repository()
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
