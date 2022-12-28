package final_project_2.models;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
@Builder
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;


    @ManyToOne
    @JoinColumn (name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    // correct answer id



    public Question(Long id, String name, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public Question(String hello) {
    }
}

