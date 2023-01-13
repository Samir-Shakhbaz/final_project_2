package final_project_2.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

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

    @OneToOne(mappedBy = "test")
    private Question question;

        public Test(Long id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.question = question;
    }
}



