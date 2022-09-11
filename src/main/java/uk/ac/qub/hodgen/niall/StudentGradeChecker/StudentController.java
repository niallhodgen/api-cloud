package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path = "/student/")
public class StudentController {

    // Set response headers for ALL endpoints in controller in order to
    // meet validation requirements of client.

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-type", "application/json");

    }

    private final StudentService studentService;

    @Autowired // auto-instantiation of studentService above and used as method parameter
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

//    @GetMapping("/results")
//    public List<Student> getStudents() {
//
//        return studentService.getStudents();
//    }


    @PostMapping(path="/find", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Student> findStudent (@RequestBody String paramQuery) throws UnsupportedEncodingException {

        // Use ParamsSplitter class method to turn parameters into key:value map
        ParamsSplitter ps = new ParamsSplitter();
        Map<String, String> params = ps.splitQuery(paramQuery);

        // Locate student number from params
        Integer studentNumber = Integer.valueOf(params.get("studentNumber"));
        Optional<Student> stu = studentService.findStudent(studentNumber);
        Student student = stu.get();
        // Remove for confidentiality
        student.setStudentId(00000);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping(path="/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postBody (@RequestBody String paramQuery) throws UnsupportedEncodingException {

        // Use ParamsSplitter class method to turn parameters into key:value map
        ParamsSplitter ps = new ParamsSplitter();
        Map<String, String> params = ps.splitQuery(paramQuery);

        // Add mapped key values to new student object
        // Ensure numeric are converted to Integer
        Student s = new Student(
                Integer.valueOf(params.get("studentNumber")),
                params.get("studentName"),
                Integer.valueOf(params.get("programming")),
                Integer.valueOf(params.get("computingFoundations")),
                Integer.valueOf(params.get("databases")),
                Integer.valueOf(params.get("webDevelopment")),
                Integer.valueOf(params.get("softwareEngineering")),
                Integer.valueOf(params.get("dataAnalysis")),
                Integer.valueOf(params.get("userExperience")),
                Integer.valueOf(params.get("cloudComputing"))
                );

        // Add object to DB
        studentService.addNewStudent(s);

        String message =  "{\"message\": \"Results saved to database!\"}";

        return message;
    }


    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(required = false) Integer StudentNumber,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) Integer programming,
            @RequestParam(required = false) Integer computingFoundations,
            @RequestParam(required = false) Integer databases,
            @RequestParam(required = false) Integer softwareEngineering,
            @RequestParam(required = false) Integer webDevelopment,
            @RequestParam(required = false) Integer dataAnalysis,
            @RequestParam(required = false) Integer userExperience,
            @RequestParam(required = false) Integer cloudComputing) {
        studentService.updateStudent(studentId, StudentNumber, studentName, programming, computingFoundations, databases,
                softwareEngineering, webDevelopment, dataAnalysis, userExperience, cloudComputing);
    }

}
