package final_project_2.controllers;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import final_project_2.services.AnswerService;
//import final_project_2.services.TestService;
import final_project_2.services.NewTestService;
import final_project_2.services.QuestionService;
import final_project_2.services.UserService;
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

//    @Autowired
//    TestService testService;

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

//    @Autowired
//    private final TestService testService;
//
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }
//
//

    @GetMapping("/test-list")
    public String vewTestList(Model model) {
        // Here you call the service to retrieve all the customers
        final List<Test> testList = newTestService.getAllTests();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("testList", testList);
        return "test-list";
    }

    @PostMapping(value = "/savetest")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
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
        // Here you call the service to retrieve all the customers
        final List<Test> testList = newTestService.getAllTests();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("testList", testList);
        return "home";
    }

    @GetMapping("/test/assign/{id}")
    public String assignTest(@PathVariable(name="id") Long id, Model model){
        Question question = questionService.getQuestion(id);

        List<Test> testList = newTestService.getAvailableTest();
        model.addAttribute("question", question);
        model.addAttribute("testList", testList);
        return "new-question";

    }



    @GetMapping("/hello")
    public String greeting() {
        return "Hello and welcome!";
    }



    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/nik/tests")
    public String getTestsPage(Model model) {

        // <Type of object> <name> = ... <something that return >
        List<Test> tests = newTestService.getAllTests(); // == new Test(1l, "Test 1", questions())

        model.addAttribute("allTests", tests);

        return "tests";
    }

//    @GetMapping("/nik/tests/{id}")
//    public String getTestPage(Model model, @PathVariable Integer id) {
//
//        // <Type of object> <name> = ... <something that return >
//        Test test = newTestService.get(id); // == new Test(1l, "Test 1", questions())
//        Answer answer = answerService.get(id);
//
//        model.addAttribute("testObject", test);
//        model.addAttribute("answer", answer);
//
//       return "test";
//    }

    @GetMapping("/testQ")
    public String getTestsPageQ(Model model) {

        // <Type of object> <name> = ... <something that return >
        List<Test> tests = newTestService.getAllTests(); // == new Test(1l, "Test 1", questions())

        model.addAttribute("allTests", tests);

        return "testQ";
    }

    @GetMapping("/test1")
    public String setQuestion1() {
       return "test1";
    }

    @GetMapping("/test2")
    public String setQuestion2() {
        return "test2";
    }

    @GetMapping("/test3")
    public String setQuestion3() {
        return "test3";
    }

    @GetMapping("/test4")
    public String setQuestion4() {
        return "test4";
    }

   @GetMapping("/test5")
   public String setQuestion5() {
        return "test5";
   }

   //Questions for test 1

    @GetMapping("/test1q1")
    public String test1q1() {
        return "question1";
    }

    @GetMapping("/test1q2")
    public String test1q2() {
        return "question2";
    }

    @GetMapping("/test1q3")
    public String test1q3() {
        return "question3";
    }

    @GetMapping("/test1q4")
    public String test1q4() {
        return "question4";
    }

    @GetMapping("/test1q5")
    public String test1q5() {
        return "question5";
    }


    //Questions for test 2

    @GetMapping("/test2q1")
    public String test2q1() {
        return "question1";
    }

    @GetMapping("/test2q2")
    public String test2q2() {
        return "question2";
    }

    @GetMapping("/test2q3")
    public String test2q3() {
        return "question3";
    }

    @GetMapping("/test2q4")
    public String test2q4() {
        return "question4";
    }

    @GetMapping("/test2q5")
    public String test2q5() {
        return "question5";
    }


    //Questions for test 3

    @GetMapping("/test3q1")
    public String test3q1() {
        return "question1";
    }

    @GetMapping("/test3q2")
    public String test3q2() {
        return "question2";
    }

    @GetMapping("/test3q3")
    public String test3q3() {
        return "question3";
    }

    @GetMapping("/test3q4")
    public String test3q4() {
        return "question4";
    }

    @GetMapping("/test3q5")
    public String test3q5() {
        return "question5";
    }

    //Questions for test 4

    @GetMapping("/test4q1")
    public String test4q1() {
        return "question1";
    }

    @GetMapping("/test4q2")
    public String test4q2() {
        return "question2";
    }

    @GetMapping("/test4q3")
    public String test4q3() {
        return "question3";
    }

    @GetMapping("/test4q4")
    public String test4q4() {
        return "question4";
    }

    @GetMapping("/test4q5")
    public String test4q5() {
        return "question5";
    }


    //Questions for test 5

    @GetMapping("/test5q1")
    public String test5q1() {
        return "question1";
    }

    @GetMapping("/test5q2")
    public String test5q2() {
        return "question2";
    }

    @GetMapping("/test5q3")
    public String test5q3() {
        return "question3";
    }

    @GetMapping("/test5q4")
    public String test5q4() {
        return "question4";
    }

    @GetMapping("/test5q5")
    public String test5q5() {
        return "question5";
    }


    @GetMapping("/tests")
    public List <String >whatever() {

        List<String> tests = new ArrayList<String>();
        tests.add("Test 1");
        tests.add("Test 2");
        tests.add("Test 3");
        tests.add("Test 4");
        tests.add("Test 5");

        return tests;

    }

        @GetMapping("/objects")
        public List <Test> tests() {
            List<Test> list = new ArrayList<>();
            list.add(new Test(1l, "Test 1", questions()));
            list.add(new Test(2l, "Test 2", new ArrayList<>(questions())));
            list.add(new Test(3l, "Test 3", new ArrayList<>(questions())));
            list.add(new Test(2l, "Test 4", new ArrayList<>(questions())));
            list.add(new Test(3l, "Test 5", new ArrayList<>(questions())));

            return list;
        }

    @GetMapping("/objects/questions")
    public List <Question> questions() {
        List<Question> listQ = new ArrayList<>();
        listQ.add(new Question(1l, "Question 1", new ArrayList<>(answers())));
        listQ.add(new Question(2l, "Question 2", new ArrayList<>(answers())));
        listQ.add(new Question(3l, "Question 3", new ArrayList<>(answers())));
        listQ.add(new Question(4l, "Question 4", new ArrayList<>(answers())));
        listQ.add(new Question(4l, "Question 5", new ArrayList<>(answers())));

        return listQ;
    }

    @GetMapping("/answers")
    public List <Answer> answers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(1l, "Answer 1"));
        answers.add(new Answer(2l, "Answer 2"));
        answers.add(new Answer(3l, "Answer 3"));
        answers.add(new Answer(4l, "Answer 4"));

        return answers;
    }


    }


