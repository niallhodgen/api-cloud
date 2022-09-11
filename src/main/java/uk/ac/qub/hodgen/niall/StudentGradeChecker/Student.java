package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer studentId;
    private Integer studentNumber;
    private String studentName;
    private Integer programming;
    private Integer computingFoundations;
    private Integer databases;
    private Integer webDevelopment;
    private Integer softwareEngineering;
    private Integer dataAnalysis;
    private Integer userExperience;
    private Integer cloudComputing;
    public Student() {
    }

    public Student(Integer studentNumber, String studentName, Integer programming, Integer computingFoundations, Integer databases, Integer webDevelopment, Integer softwareEngineering, Integer dataAnalysis, Integer userExperience, Integer cloudComputing) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.programming = programming;
        this.computingFoundations = computingFoundations;
        this.databases = databases;
        this.webDevelopment = webDevelopment;
        this.softwareEngineering = softwareEngineering;
        this.dataAnalysis = dataAnalysis;
        this.userExperience = userExperience;
        this.cloudComputing = cloudComputing;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getProgramming() {
        return programming;
    }

    public void setProgramming(Integer programming) {
        this.programming = programming;
    }

    public Integer getComputingFoundations() {
        return computingFoundations;
    }

    public void setComputingFoundations(Integer computingFoundations) {
        this.computingFoundations = computingFoundations;
    }

    public Integer getDatabases() {
        return databases;
    }

    public void setDatabases(Integer databases) {
        this.databases = databases;
    }

    public Integer getWebDevelopment() {
        return webDevelopment;
    }

    public void setWebDevelopment(Integer webDevelopment) {
        this.webDevelopment = webDevelopment;
    }

    public Integer getSoftwareEngineering() {
        return softwareEngineering;
    }

    public void setSoftwareEngineering(Integer softwareEngineering) {
        this.softwareEngineering = softwareEngineering;
    }

    public Integer getDataAnalysis() {
        return dataAnalysis;
    }

    public void setDataAnalysis(Integer dataAnalysis) {
        this.dataAnalysis = dataAnalysis;
    }

    public Integer getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(Integer userExperience) {
        this.userExperience = userExperience;
    }

    public Integer getCloudComputing() {
        return cloudComputing;
    }

    public void setCloudComputing(Integer cloudComputing) {
        this.cloudComputing = cloudComputing;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", studentName='" + studentName + '\'' +
                ", programming=" + programming +
                ", computingFoundations=" + computingFoundations +
                ", databases=" + databases +
                ", webDevelopment=" + webDevelopment +
                ", softwareEngineering=" + softwareEngineering +
                ", dataAnalysis=" + dataAnalysis +
                ", userExperience=" + userExperience +
                ", cloudComputing=" + cloudComputing +
                '}';
    }
}
