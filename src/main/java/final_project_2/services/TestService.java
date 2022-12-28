package final_project_2.services;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private List<Test> tests;

    public TestService(){
        List<Test> list = new ArrayList<>();

        Test test1 = new Test(1l, "Test 1", new ArrayList<>());

        test1.getQuestions().add(new Question(1l, "How much is 2x2?", new ArrayList()));
        test1.getQuestions().get(0).getAnswers().add(new Answer(1l, " one"));
        test1.getQuestions().get(0).getAnswers().add(new Answer(2l, " two"));
        test1.getQuestions().get(0).getAnswers().add(new Answer(3l, " three"));
        test1.getQuestions().get(0).getAnswers().add(new Answer(4l, " four"));

        test1.getQuestions().add(new Question(2l, "T1 Q2", new ArrayList()));
        test1.getQuestions().get(1).getAnswers().add(new Answer(5l, "T1 Q2 A1"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(6l, "T1 Q2 A2"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(7l, "T1 Q2 A3"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(8l, "T1 Q2 A4"));

        test1.getQuestions().add(new Question(3l, "T1 Q3", new ArrayList()));
        test1.getQuestions().get(2).getAnswers().add(new Answer(9l, "T1 Q3 A1"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(10l, "T1 Q3 A2"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(11l, "T1 Q3 A3"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(12l, "T1 Q3 A4"));

        Test test2 = new Test(2l, "Test 2", new ArrayList<>());
        test2.getQuestions().add(new Question(4l, "T2 Q1", new ArrayList()));
        test2.getQuestions().get(0).getAnswers().add(new Answer(13l, "T2 Q1 A1"));
        test2.getQuestions().get(0).getAnswers().add(new Answer(14l, "T2 Q1 A2"));
        test2.getQuestions().get(0).getAnswers().add(new Answer(15l, "T2 Q1 A3"));

        test2.getQuestions().add(new Question(5l, "T2 Q2", new ArrayList()));
        test2.getQuestions().get(1).getAnswers().add(new Answer(16l, "T2 Q2 A1"));
        test2.getQuestions().get(1).getAnswers().add(new Answer(17l, "T2 Q2 A2"));
        test2.getQuestions().get(1).getAnswers().add(new Answer(18l, "T2 Q2 A3"));

        Test test3 = new Test(3l, "Test 3", new ArrayList<>());
        test3.getQuestions().add(new Question(6l, "T3 Q1", new ArrayList()));
        test3.getQuestions().get(0).getAnswers().add(new Answer(19l, "T3 Q1 A1"));
        test3.getQuestions().get(0).getAnswers().add(new Answer(20l, "T3 Q1 A2"));
        test3.getQuestions().get(0).getAnswers().add(new Answer(21l, "T3 Q1 A3"));

        test3.getQuestions().add(new Question(7l, "T3 Q2", new ArrayList()));
        test3.getQuestions().get(1).getAnswers().add(new Answer(22l, "T3 Q2 A1"));
        test3.getQuestions().get(1).getAnswers().add(new Answer(23l, "T3 Q2 A2"));
        test3.getQuestions().get(1).getAnswers().add(new Answer(24l, "T3 Q2 A3"));

        list.add(test1);
        list.add(test2);
        list.add(test3);

        tests = list; // HAVEN'T SEEN THIS BEFORE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    public List<Test> getAllTests(){
        return tests;
    }

    public Test get(Integer id){
        return getAllTests().get(id-1);
    }

}
