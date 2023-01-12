package final_project_2.services;

import final_project_2.models.Question;
import final_project_2.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    public Question saveQuestion(Question question) throws IllegalArgumentException {
        return questionRepository.save(question);
    }

    List<Question> saveAllQuestion(List<Question> questionList){ return questionRepository.saveAll(questionList); }

}
