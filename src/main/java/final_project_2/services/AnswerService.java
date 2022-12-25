package final_project_2.services;

import final_project_2.models.Answer;
import final_project_2.models.User;
import final_project_2.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public Answer saveAnswers(Answer answer){return answerRepository.save(answer);}


    List<Answer> getAllAnswers(){return getAllAnswers();}


}
