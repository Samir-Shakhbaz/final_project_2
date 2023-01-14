package final_project_2.controllers;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import final_project_2.services.AnswerService;
//import final_project_2.services.TestService;
import final_project_2.services.NewTestService;
import final_project_2.services.QuestionService;
import final_project_2.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
public class TestController {

    @Autowired
    NewTestService newTestService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test-list")
    public String vewTestList(@NotNull Model model) {
        final List<Test> testList = newTestService.getAllTests();
        model.addAttribute("testList", testList);
        return "test-list";
    }

    @PostMapping("/savetest")
    public String saveTest(@ModelAttribute("test") Test test) {
        newTestService.saveTest(test);
        return "redirect:/test-list";
    }

    @GetMapping("/new-test")
    public String ShowNewTestPage(Model model) {
        Test test = new Test();
        model.addAttribute("test", test);
        return "new-test";
    }

    @GetMapping("/edittest/{id}")
    public ModelAndView showEditTestPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-test");
        Test test = newTestService.getTest(id);
        modelAndView.addObject("test", test);
        return modelAndView;
    }

    @PostMapping("/updatetest/{id}")
    public String updateTest(@PathVariable(name = "id") Long id, @ModelAttribute("test") Test test, Model model) {
        if (!id.equals(test.getId())) {
            model.addAttribute("message",
                    "Cannot update, test id " + test.getId()
                            + " doesn't match id to be updated: " + id + ".");
            return "error-page";
        }
            newTestService.saveTest(test);
            return "redirect:/test-list";
    }

    @RequestMapping("/deletetest/{id}")
    public String deleteTest(@PathVariable(name = "id") Long id) {
        newTestService.deleteTest(id);
        return "redirect:/test-list";
    }

    @GetMapping("/")
    public String vewHomePage(Model model) {
        final List<Test> testList = newTestService.getAllTests();
        model.addAttribute("testList", testList);
        return "home";
    }

    @GetMapping("/test/assign/{id}")
    public String assignTest(@PathVariable(name = "id") Long id, Model model) {
        Question question = questionService.getQuestion(id);
        List<Test> testList = newTestService.getAvailableTest();
        model.addAttribute("question", question);
        model.addAttribute("testList", testList);
        return "assign-test";
    }

    @PostMapping("test/assign")
    public String saveTestAssignment(@RequestParam("questionId") Long questionId, @RequestParam("testId") Long testId) {
        Test test = newTestService.getTest(testId);
        test.setQuestion(questionService.getQuestion(questionId));
        newTestService.saveTest(test);
        return "redirect:/question-list";
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello and welcome!";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/nik/tests")
    public String getTestsPage(Model model) {
        List<Test> tests = newTestService.getAllTests();
        model.addAttribute("allTests", tests);
        return "tests";
    }

//    @GetMapping("/nik/tests/{id}")
//    public String getTestPage(Model model, @PathVariable Integer id) {
//       Test test = newTestService.get(id);
//       Answer answer = answerService.get(id);
//       model.addAttribute("testObject", test);
//       model.addAttribute("answer", answer);
//       return "test";
//    }

    @GetMapping("/testQ")
    public String getTestsPageQ(Model model) {
        List<Test> tests = newTestService.getAllTests();
        model.addAttribute("allTests", tests);
        return "testQ";
    }
}


