package ua.com.shocell.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.shocell.models.WebUsers;

@Transactional
public interface WebUserDaoImpl extends CrudRepository<WebUsers, Long>{

    WebUsers findByLogin(String login);

    WebUsers deleteByLogin(String login);


}
