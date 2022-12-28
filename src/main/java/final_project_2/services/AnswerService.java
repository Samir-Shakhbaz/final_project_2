package final_project_2.services;

import final_project_2.models.Answer;
import final_project_2.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AnswerService {


    public void checkAnswer(){

        int[] correctAnswer = {3,5,9,11,22};
        boolean contains = IntStream.of(correctAnswer).anyMatch(x -> x == 5);
        System.out.println(contains);
    }


    @Autowired
    AnswerRepository answerRepository;

    public Answer saveAnswers(Answer answer) {
        return answerRepository.save(answer);
    }
    List<Answer> getAllAnswers() {
        return getAllAnswers();
    }

        }

