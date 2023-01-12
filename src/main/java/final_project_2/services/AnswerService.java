package final_project_2.services;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import final_project_2.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAllTests() {
        return answers;
    }

    private List<Answer> answers;
    @Transactional
    public Answer saveAnswer(Answer answer){return answerRepository.save(answer);}


    public AnswerService() {
        List<Answer> list = new ArrayList<>();
        Answer answer = new Answer();
        answer.setId(1l);

//    public Answer get(Integer id){
//        return getAllAnswers().get(id-1);
//    }
//
//    public void checkAnswer(){
//
//        int[] correctAnswer = {3,5,9,11,22};
//        boolean contains = IntStream.of(correctAnswer).anyMatch(x -> x == 5);
//        System.out.println(contains);
//    }
//
//
//    @Autowired
//    AnswerRepository answerRepository;
//
//    public Answer saveAnswers(Answer answer) {
//        return answerRepository.save(answer);
//    }
//    List<Answer> getAllAnswers() {
//        return getAllAnswers();
//    }

    }

    public Answer get(Integer id) {
        return getAllTests().get(id - 1);
    }
}


