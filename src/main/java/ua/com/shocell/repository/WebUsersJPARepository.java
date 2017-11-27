package ua.com.shocell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.shocell.models.WebUsers;

@Repository
public interface WebUsersJPARepository extends JpaRepository<WebUsers, Long>{
    WebUsers findByLogin(String login);
    Boolean deleteByLogin(String login);
}
