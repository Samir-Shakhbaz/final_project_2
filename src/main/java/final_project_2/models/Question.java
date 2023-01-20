package final_project_2.models;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "questions")
//@Builder
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;

//    @OneToOne
//    @JoinColumn (name = "test_id")
//    private Test test;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    @ManyToOne(
//            cascade = CascadeType.ALL,
            optional = true
    )
    private Test test;


    @Override
    public String toString() { return ("Question# " + id + " " + " " + name);}

    //    @OneToMany
//    private List <Answer> answers;
}

