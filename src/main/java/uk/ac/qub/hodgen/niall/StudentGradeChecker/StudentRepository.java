package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repository annotation provides import for interface that has a whole host of useful database actions
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Equivalent of SELECT * FROM student WHERE student_id = ?
    Optional<Student> findStudentByStudentId(Integer studentId);

    Optional<Student> findStudentByStudentNumber(Integer studentNumber);
}
