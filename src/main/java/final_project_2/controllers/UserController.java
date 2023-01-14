package final_project_2.controllers;

import final_project_2.models.User;
//import final_project_2.services.TestService;
import final_project_2.services.NewTestService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Transactional
@Controller
public class UserController {

    @Autowired
    NewTestService newTestService;

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService; //WHY DO ME NEED THIS?
    }

    @GetMapping("/createaccount")
    public String createaccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createaccount";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user-list";
    }

    @GetMapping("/user-list")
    public String registeredUsersList(Model model) {
        final List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/about")
        public String about(){
        return "about";
    }

//    @RequestMapping("/delete/{id}") //FOR ADMINISTRATOR
//    public String deleteUser(@PathVariable(name = "id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/user-list";
//    }

}
