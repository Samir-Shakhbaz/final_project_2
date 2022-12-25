package final_project_2.controllers;

import final_project_2.models.Answer;
import final_project_2.models.User;
import final_project_2.services.AnswerService;
import final_project_2.services.TestService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Transactional
@Controller
@Component
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping(value = "/submitAnswer")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
    public String saveAnswer(@ModelAttribute("answer") Answer answer) {
        answerService.saveAnswers(answer);
        return "answers";
    }

}
