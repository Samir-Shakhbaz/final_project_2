package final_project_2.controllers;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import final_project_2.models.User;
//import final_project_2.services.AnswerService;

import final_project_2.services.AnswerService;
import final_project_2.services.QuestionService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Component
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @PostMapping(value = "/saveanswer")
    public String saveAnswer(@ModelAttribute("answer") Answer answer) {
        answerService.saveAnswer(answer);
        return "redirect:/answer-list";
    }

    @GetMapping("/answer-list")
    public String showAnswerListPage(Model model) {
        List<Answer> answerList = answerService.getAllAnswers();
        model.addAttribute("answerList", answerList);
        return "answer-list";
    }

    @GetMapping("/new-answer")
    public String ShowNewAnswerPage(Model model) {
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "new-answer";
    }

    @GetMapping("/editanswer/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-answer");
        Answer answer = answerService.getAnswer(id);
        mav.addObject("answer", answer);
        return mav;
    }

    @PostMapping("/updateanswer/{id}")
    public String updateAnswer(@PathVariable(name = "id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
        if (!id.equals(answer.getId())) {
            model.addAttribute("message",
                    "Cannot update, answer id " + answer.getId()
                            + " doesn't match id to be updated: " + id + ".");
            return "error-page";
        }
        answerService.saveAnswer(answer);
        return "redirect:/answer-list";
    }

    @RequestMapping("/deleteanswer/{id}")
    public String deleteAnswer(@PathVariable(name = "id") Long id) {
        answerService.deleteAnswer(id);
        return "redirect:/answer-list";
    }

    @PostMapping(value = "/submitAnswer", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveAnswer(@RequestParam MultiValueMap<String, String> values, HttpServletRequest request) {

        for (String questionId : values.keySet()) {
            System.out.println(values.get(questionId).get(0));
        }
        return "answers";
    }

    @GetMapping("/question/assign/{id}")
    public String assignQuestion(@PathVariable(name = "id") Long id, Model model) {
        Answer answer = answerService.getAnswer(id);
        List<Question> questionList = questionService.getAvailableQuestion();
        model.addAttribute("answer", answer);
        model.addAttribute("questionList", questionList);
        return "assign-question";
    }

    @PostMapping("question/assign")
    public String saveQuestionAssignment(@RequestParam("answerId") Long answerId, @RequestParam("questionId") Long questionId) {
        Question question = questionService.getQuestion(questionId);
        Answer answer = answerService.getAnswer(answerId);
//        test.setQuestion(question);
//        newTestService.saveTest(test);
        answer.setQuestion(question);
        answerService.saveAnswer(answer);
        return "redirect:/answer-list";
    }

    @RequestMapping("remove/question/{id}")
    public String removeQuestion(@PathVariable(name = "id") Long answerId) {
        Answer answer = answerService.getAnswer(answerId);
        answer.setQuestion(null);
        answerService.saveAnswer(answer);
        return"redirect:/answer-list";
    }

}
