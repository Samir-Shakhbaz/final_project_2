package final_project_2.services;

import final_project_2.models.Answer;
import final_project_2.models.Question;
import final_project_2.models.Test;
import final_project_2.repositories.QuestionRepository;
import final_project_2.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    @Transactional
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    List<Question> saveAllQuestion(List<Question> questionList){ return questionRepository.saveAll(questionList); }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id)
                .orElse(null);
    }

    public List<Question> getAvailableQuestion() {
        return getAllQuestions().stream().filter(c -> c.getAnswer() == null)
                .collect(Collectors.toList());
    }

//    public List<Question> getAvailableQuestion() {
//        return getAllQuestions().stream().filter(c -> c.getTest() == null)
//                .collect(Collectors.toList());
//    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

}
