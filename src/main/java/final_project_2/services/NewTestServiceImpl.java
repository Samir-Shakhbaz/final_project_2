package final_project_2.services;

import final_project_2.models.Test;
import final_project_2.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class NewTestServiceImpl implements NewTestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // The save function uses an INSERT query in the DB.
    @Override
    @Transactional
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    @Transactional
    public List<Test> saveAllTests(List<Test> testList) {return testRepository.saveAll(testList);

    }


}
