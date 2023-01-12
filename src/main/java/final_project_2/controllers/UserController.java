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

//    @Autowired
//    TestService testService;

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService; //WHY DO ME NEED THIS?
    }

    @GetMapping("/createaccount")
    public String createaccount(Model model) {
        // Here a new (empty) Customer is created and then sent to the view
        User user = new User();
        model.addAttribute("user", user);
        return "createaccount";
    }

    @PostMapping(value = "/save")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user-list";
    }

    @GetMapping("/user-list")
    public String registeredUsersList(Model model) {
        // Here you call the service to retrieve all the customers
        final List<User> userList = userService.getAllUsers();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "deleted";
    }



//    @RequestMapping("/delete/{id}") //FOR ADMINISTRATOR
//    public String deleteUser(@PathVariable(name = "id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/user-list";
//    }


}
