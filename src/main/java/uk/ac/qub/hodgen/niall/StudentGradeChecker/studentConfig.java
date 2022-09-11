package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bob = new Student(
                    50050154,
                    "Robert Marley",
                    67,
                    65,
                    76,
                    66,
                    77,
                    88,
                    99,
                    100
            );

            Student rob = new Student(
                    20045678,
                    "Rob Coulter",
                    56,
                    65,
                    76,
                    66,
                    77,
                    82,
                    56,
                    100
            );

            repository.saveAll(
                    List.of(bob, rob)
            );
        };
    }
}
