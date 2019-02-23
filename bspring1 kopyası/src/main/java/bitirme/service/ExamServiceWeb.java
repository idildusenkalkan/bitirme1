package bitirme.service;

import bitirme.model.*;

import java.util.List;

//import com.bitirme.exception.ExamNotFoundException;

public interface ExamServiceWeb {
    public List<ClassicExam> findAllClassic();
	public List<TestExam> findAllTest();
	public List<User> findAllUser();
	public List<User> findUser(int userId, String name, String lname);
	List<ClassicExam> findClassicExamById(int examId);
	List<TestExam> findTestExamById(int examId);
	void createTestExam(TestExam exam);
	void createClassicExam(ClassicExam exam);
	void updateExam(ClassicExam exam);
	void deleteExam(int id);
	void createUser(User user);
	void createQuestion(Question question);
    public List<TestResult> findAllTestResult();
    public List<ClassicResult> findAllClassicResult();
    public List<Question> findAllQuestionInExam(int examId);
	List<ClassicResult> findClassicResultById(int examId);
	List<TestResult> findTestResultById(int examId);
}
