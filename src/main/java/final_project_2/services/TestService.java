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
        test1.getQuestions().get(1).getAnswers().add(new Answer(1l, "T1 Q2 A1"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(2l, "T1 Q2 A2"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(3l, "T1 Q2 A3"));
        test1.getQuestions().get(1).getAnswers().add(new Answer(4l, "T1 Q2 A4"));

        test1.getQuestions().add(new Question(3l, "T1 Q3", new ArrayList()));
        test1.getQuestions().get(2).getAnswers().add(new Answer(1l, "T1 Q3 A1"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(2l, "T1 Q3 A2"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(3l, "T1 Q3 A3"));
        test1.getQuestions().get(2).getAnswers().add(new Answer(4l, "T1 Q3 A4"));

        Test test2 = new Test(2l, "Test 2", new ArrayList<>());
        test2.getQuestions().add(new Question(1l, "T2 Q1", new ArrayList()));
        test2.getQuestions().get(0).getAnswers().add(new Answer(1l, "T2 Q1 A1"));
        test2.getQuestions().get(0).getAnswers().add(new Answer(2l, "T2 Q1 A2"));
        test2.getQuestions().get(0).getAnswers().add(new Answer(3l, "T2 Q1 A3"));

        test2.getQuestions().add(new Question(2l, "T2 Q2", new ArrayList()));
        test2.getQuestions().get(1).getAnswers().add(new Answer(1l, "T2 Q2 A1"));
        test2.getQuestions().get(1).getAnswers().add(new Answer(2l, "T2 Q2 A2"));
        test2.getQuestions().get(1).getAnswers().add(new Answer(3l, "T2 Q2 A3"));

        Test test3 = new Test(3l, "Test 3", new ArrayList<>());
        test3.getQuestions().add(new Question(1l, "T3 Q1", new ArrayList()));
        test3.getQuestions().get(0).getAnswers().add(new Answer(1l, "T3 Q1 A1"));
        test3.getQuestions().get(0).getAnswers().add(new Answer(2l, "T3 Q1 A2"));
        test3.getQuestions().get(0).getAnswers().add(new Answer(3l, "T3 Q1 A3"));

        test3.getQuestions().add(new Question(2l, "T3 Q2", new ArrayList()));
        test3.getQuestions().get(1).getAnswers().add(new Answer(1l, "T3 Q2 A1"));
        test3.getQuestions().get(1).getAnswers().add(new Answer(2l, "T3 Q2 A2"));
        test3.getQuestions().get(1).getAnswers().add(new Answer(3l, "T3 Q2 A3"));

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
