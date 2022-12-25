//package final_project_2.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import lombok.*;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "authorities")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Authority implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private RoleEnum authority;
//
//    public String getAuthority() {
//        return authority.name();
//    }
//}