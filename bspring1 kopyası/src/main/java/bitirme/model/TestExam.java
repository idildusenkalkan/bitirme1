package bitirme.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="testexam")
public class TestExam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int examId;

    //sınavın süresi
    private String duration;
    private String number;
    private String format;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date examStartingDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date examFinishingDate;

    //@OneToMany(targetEntity=Question.class ,mappedBy = "examId", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    //private List<Question> questions= new ArrayList<Question>();

    public TestExam() {
    }

    /*public TestExam(int examId, List<Question> questions) {
        this.examId = examId;
        this.questions = questions;
    }*/

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    /*public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }*/

    public Date getExamStartingDate() {
        return examStartingDate;
    }

    public void setExamStartingDate(Date examStartingDate) {
        this.examStartingDate = examStartingDate;
    }

    public Date getExamFinishingDate() {
        return examFinishingDate;
    }

    public void setExamFinishingDate(Date examFinishingDate) {
        this.examFinishingDate = examFinishingDate;
    }

    public String format() {
        return format;
    }

    public void setformat(String format) {
        this.format = format;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString(){
        return "TestExam{" +
                "examId=" + examId +
                ", starting date for exam='" + examStartingDate + '\'' +
                ", last day for exam=" + examFinishingDate +
                //", number of questions=" + questions.size() +
                ", duration=" + duration +
                '}';
    }
}


