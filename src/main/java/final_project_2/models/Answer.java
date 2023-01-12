package final_project_2.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "answers")
@Builder
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;
    String name;
    //correct answers boolean

//    @ManyToOne
//    @JoinColumn (name = "question_id")
//    private Question question;

    public Answer(long id, String name) {
        this.id = id;
        this.name = name;

    }
}
