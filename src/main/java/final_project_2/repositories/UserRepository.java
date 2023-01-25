package final_project_2.repositories;

import final_project_2.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


//    User findByName(String username);
    User findByName(String name);

}
