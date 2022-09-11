package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
    return studentRepository.findAll();
}

    public Optional<Student> findStudent(Integer studentNumber) {

        return studentRepository.findStudentByStudentNumber(studentNumber);
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByStudentNumber(
                student.getStudentNumber());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Student number has already registered marks on our system - " +
                    "please check carefully and try again. If you are still having issues please contact" +
                    " the system admin");
        }
studentRepository.save(student);

        //Test purposes
        //System.out.println(student);
    }

    public void deleteStudent(Integer studentId) {
       boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    

    @Transactional // Entity goes into a 'managed state', so there is no need for DB query language

    public void updateStudent(Integer studentId, Integer studentNumber, String studentName, Integer programming, Integer computingFoundations, Integer databases, Integer softwareEngineering, Integer webDevelopment, Integer dataAnalysis, Integer userExperience, Integer cloudComputing) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist"
                ));
        if (studentName != null &&
                studentName.length() > 0 &&
                !Objects.equals(student.getStudentName(), studentName)) {
            student.setStudentName(studentName);
        }

        if (studentNumber != null &&
                studentNumber > 0 &&
                !Objects.equals(student.getStudentNumber(), studentNumber)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByStudentNumber(studentNumber);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("Student number already taken");
            }
            student.setStudentNumber(studentNumber);
        }

        if (computingFoundations != null &&
                computingFoundations >= 0 &&
                // WARNING: objects methods may not apply to primitives such as Integer
                !Objects.equals(student.getComputingFoundations(), computingFoundations)) {
            student.setComputingFoundations(computingFoundations);
        }

        if (programming != null &&
                programming >= 0 &&
                !Objects.equals(student.getProgramming(), programming)) {
            student.setProgramming(programming);
        }

        if (databases != null &&
                databases >= 0 &&
                !Objects.equals(student.getDatabases(), databases)) {
            student.setDatabases(databases);
        }
        if (webDevelopment != null &&
                webDevelopment >= 0 &&
                !Objects.equals(student.getWebDevelopment(), webDevelopment)) {
            student.setWebDevelopment(webDevelopment);
        }
        if (softwareEngineering != null &&
                softwareEngineering >= 0 &&
                !Objects.equals(student.getSoftwareEngineering(), softwareEngineering)) {
            student.setSoftwareEngineering(softwareEngineering);
        }
        if (dataAnalysis != null &&
                dataAnalysis >= 0 &&
                !Objects.equals(student.getDataAnalysis(), dataAnalysis)) {
            student.setDataAnalysis(dataAnalysis);
        }
        if (userExperience != null &&
                userExperience >= 0 &&
                !Objects.equals(student.getUserExperience(), userExperience)) {
            student.setUserExperience(userExperience);
        }
        if (cloudComputing != null &&
                cloudComputing >= 0 &&
                !Objects.equals(student.getCloudComputing(), cloudComputing)) {
            student.setCloudComputing(cloudComputing);
        }
    
    }
}


