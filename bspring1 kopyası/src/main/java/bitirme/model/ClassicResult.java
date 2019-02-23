package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="classicresult")
public class ClassicResult {

	@Id
    private int classicResultId;
    private int userId;
    private int classicExamId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String cheatControl;
    private String answer;

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

    public int getClassicResultId() {
        return classicResultId;
    }

    public void setClassicResultId(int classicResultId) {
        this.classicResultId = classicResultId;
    }

    public String getCheatControl() {
        return cheatControl;
    }

    public void setCheatControl(String cheatControl) {
        this.cheatControl = cheatControl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClassicExamId() {
		return classicExamId;
	}

	public void setClassicExamId(int classicExamId) {
		this.classicExamId = classicExamId;
	}
}
