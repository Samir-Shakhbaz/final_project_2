package final_project_2.controllers;

import final_project_2.models.Question;
import final_project_2.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/new-question")
    public String showNewQuestionPage(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "new-question";
    }

    @PostMapping(value = "/savequestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        questionService.saveQuestion(question);
        return "redirect:/question-list";
    }

    @GetMapping("/question-list")
    public String showQuestionListPage(Model model){

        return "question-list";
    }

}
