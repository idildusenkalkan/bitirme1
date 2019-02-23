package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="usersexam")
public class UsersExam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    private int examId;
    private String userPassword;

    public UsersExam() {
    }

    public UsersExam(int userId, int examId) {
        this.userId = userId;
        this.examId = examId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
