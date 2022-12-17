package final_project_2.services;

import final_project_2.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //CHANGED INTERFACE TO CLASS TO FIX consider defining a bean of type
@Component
public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

}
