package final_project_2.controllers;

import final_project_2.models.User;
import final_project_2.services.LoginService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService; //WHY DO ME NEED THIS?
    }

    @PostMapping(value = "/submit")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
    public String submitUser(@ModelAttribute("user") User user) {
        loginService.submitUser(user);
        return "redirect:/nik/tests";
    }

}
