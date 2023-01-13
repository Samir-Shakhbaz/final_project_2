package final_project_2.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "tests")
//@Builder
@Getter
@Setter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;


//    @OneToMany(mappedBy = "test")
//    private List<Question> questions;

//    @OneToMany
//    @JoinColumn(name = "question_id")
    private List <Question> questions;

    @OneToMany(mappedBy = "test")
    private Question question;


    public Test(Long id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;

    }
}



