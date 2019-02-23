package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="testresult")
public class TestResult {


    @Id
    private int testResultId;
    private int examId;
    private int userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String trueAnswer;
    private String falseAnswer;
    private String cheatControl;

    public int getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrueanswer() {
        return trueAnswer;
    }

    public void setTrueanswer(String trueanswer) {
        this.trueAnswer = trueanswer;
    }

    public String getFalseanswer() {
        return falseAnswer;
    }

    public void setFalseanswer(String falseanswer) {
        this.falseAnswer = falseanswer;
    }

    public String getCheatControl() {
        return cheatControl;
    }

    public void setCheatControl(String cheatControl) {
        this.cheatControl = cheatControl;
    }

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
