package final_project_2.services;

import final_project_2.models.User;
import final_project_2.repositories.TestRepository;
import final_project_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;

@Service
@Component
public interface UserService extends UserDetailsService {

    User saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

   User loadUserByName(String name);

}
