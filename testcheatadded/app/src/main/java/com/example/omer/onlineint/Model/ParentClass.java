package com.example.omer.onlineint.Model;

import java.io.Serializable;

public class ParentClass implements Serializable {

    private TestExam testExam;
    private ClassicExam classicExam;
    private String exam;
    private String examDuration;

    public String getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(String examDuration) {
        this.examDuration = examDuration;
    }

    public ParentClass(String exam) {
        this.exam = exam;
    }

    public ParentClass() {
    }

    public TestExam getTestExam() {
        return testExam;
    }

    public void setTestExam(TestExam testExam) {
        this.testExam = testExam;
    }

    public ClassicExam getClassicExam() {
        return classicExam;
    }

    public void setClassicExam(ClassicExam classicExam) {
        this.classicExam = classicExam;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}
