package uk.ac.qub.hodgen.niall.StudentGradeChecker;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HTTPRequestTest {

    private static final String BASE_URL = "http://localhost:8080/student";
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDetails() throws Exception {

        String url = BASE_URL + "/find";

        this.mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("studentNumber", "50050154"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testSaveDetails() throws Exception {

        String url = BASE_URL + "/save";

        this.mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("studentNumber", "50050132")
                        .param("studentName", "Ricky Bobby")
                        .param("programming", "70")
                        .param("computingFoundations", "65")
                        .param("databases", "78")
                        .param("webDevelopment", "78")
                        .param("softwareEngineering", "78")
                        .param("dataAnalysis", "67")
                        .param("userExperience", "77")
                        .param("cloudComputing", "90"))
                .andDo(print()).andExpect(status().isOk());
    }

//    @Test
//    public void testStudentNumberAlreadyExists() throws Exception {
//
//        String url = BASE_URL + "/save";
//        String message = "Student number has already registered marks on our system - please check carefully and try again. If you are still having issues please contact the system admin";
//
//        this.mockMvc.perform(post(url)
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//                        .param("studentNumber", "50050154")
//                        .param("studentName", "Ricky Bobby")
//                        .param("programming", "70")
//                        .param("computingFoundations", "65")
//                        .param("databases", "78")
//                        .param("webDevelopment", "78")
//                        .param("softwareEngineering", "78")
//                        .param("dataAnalysis", "67")
//                        .param("userExperience", "77")
//                        .param("cloudComputing", "90"))
//                .andDo(print()).andExpect(result -> assertEquals (message, result.getResolvedException().getMessage()));
//    }


}
