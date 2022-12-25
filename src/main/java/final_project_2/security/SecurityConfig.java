//package final_project_2.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity(debug = true)
//public class SecurityConfig {
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        //CSS should always be accessible for all
//        return (web) -> web.ignoring().antMatchers("/css/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                //start the creating process of authorization settings. This will be covered in depth in the authorization chapter.
//                //all requests should be authenticated
//                .authorizeRequests(auth -> auth.anyRequest().authenticated())
//                //formLogin() is used to indicate that an HTML form is going to be used to retrieve a username and password.
//                //this also adds the UsernamePasswordAuthenticationFilter to the filter chain
//                .formLogin();
//        return http.build();
//    }
//
//    //don't worry about the password encoder just yet
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}



//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        //this bean creates an in memory repository of users.
//        //add a user to the cache with username "admin" password "hi" and a ROLE_USER
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("hi"))
//                        .roles("USER").build());
//    }

