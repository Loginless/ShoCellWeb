package ua.com.shocell.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.shocell.models.WebUsers;

@Repository()
public interface WebUsersRepository extends CrudRepository<WebUsers, Long>{

    WebUsers findByLogin(String login);

    WebUsers findByPassword(String password);


    WebUsers deleteByLogin(String login);




}
