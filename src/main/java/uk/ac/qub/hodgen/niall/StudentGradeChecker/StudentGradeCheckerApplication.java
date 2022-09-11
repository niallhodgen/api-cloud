package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.UnsupportedEncodingException;



/**
 * @author - Niall Hodgen [40040160]
 *
 * StudentGradeCheckerAPI handles various HTTP requests to AWS hosted PostgreSQL database
 *
 * GET: returns all students along with module scores
 * POST: adds new student (student number, name, module names + marks)
 * PUT: updates any of the above values by primary key (studentId)
 * DELETE: delete any student by primary key (studentId)
 */
@SpringBootApplication
public class StudentGradeCheckerApplication {






	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(StudentGradeCheckerApplication.class, args);



	}






}

