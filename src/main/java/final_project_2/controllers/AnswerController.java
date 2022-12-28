package final_project_2.controllers;

import final_project_2.models.Answer;
import final_project_2.models.User;
import final_project_2.services.AnswerService;
import final_project_2.services.TestService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//@Transactional
@Controller
@Component
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping(value = "/submitAnswer", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
     public String saveAnswer(@RequestParam MultiValueMap<String, String> values, HttpServletRequest request) {

//        System.out.println(values.keySet());
//
//        System.out.println(values);
        for(String questionId:values.keySet()){
//            System.out.println(questionId);
            System.out.println(values.get(questionId).get(0));

        }
//        System.out.println(request);
        return "answers";

    }

}
