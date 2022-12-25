package final_project_2;

import final_project_2.models.Test;
import final_project_2.models.User;
import final_project_2.services.TestService;
import final_project_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FinalProject2Application implements CommandLineRunner {

	@Autowired
	UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FinalProject2Application.class, args);
	}


	    @Override
    public void run(String... args) throws Exception {

//        Authority userAuth = Authority.builder().authority(RoleEnum.ROLE_USER).build();
//        if (authorityRepo.findAll().isEmpty()) {
//            authorityRepo.save(userAuth);
//        }

        if (userService.getAllUsers().isEmpty()) {
            userService.saveUser(
                    new User("user", passwordEncoder.encode("user"))
            );
        }
    }

//	@Autowired
//	private TestService testService;
//
//		@Override
//		public void run(String... args) throws Exception {
//
//				testService.getAllTests(Arrays.asList(
//								Test.builder()
//										.name("Test 1")
//										.questions()
//										.answer(1)
//										.build(),
//								Test.builder().testName("Test 2").question("Question Two").answer(2).build(),
//								Test.builder().testName("Test 3").question("Question Two").answer(3).build()
//						)
//				);
//
//		}


}


