package bitirme.service;

import bitirme.model.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class ExamServiceWebImp implements ExamServiceWeb {


	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<ClassicExam> findAllClassic() {

        String query ="FROM ClassicExam";
        return (List<ClassicExam>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<TestExam> findAllTest() {
		String query ="FROM TestExam";
		return (List<TestExam>) entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<ClassicExam> findClassicExamById(int classicExamId) {
		String query ="FROM ClassicExam as clsexam where clsexam.examId=" +classicExamId;
		return (List<ClassicExam>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<TestExam> findTestExamById(int examId) {
		String query ="FROM TestExam as tstexam where tstexam.examId=" +examId;
		return (List<TestExam>) entityManager.createQuery(query).getResultList();
	}

	@Override
	public void createClassicExam(ClassicExam exam) {
		entityManager.persist(exam);
	}

	@Override
	public void createTestExam(TestExam exam) {
		entityManager.persist(exam);
	}

	@Override
	public void updateExam(ClassicExam exam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExam(int id) {
		entityManager.remove(id);

	}

	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public List<User> findAllUser() {
		String query ="FROM User";
		return (List<User>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<User> findUser(int userId, String name, String lname) {
		String query = "FROM User as user WHERE user.userId = "+userId;// + " & user.name = "+name +" & user.surname = " + lname;

		return (List<User>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<TestResult> findAllTestResult() {
		String query ="FROM TestResult";
        return (List<TestResult>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<ClassicResult> findAllClassicResult() {
		String query ="FROM ClassicResult";
        return (List<ClassicResult>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<ClassicResult> findClassicResultById(int examId) {
		String query ="FROM ClassicResult as clsrslt where clsrslt.classicExamId=" +examId;
		return (List<ClassicResult>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<TestResult> findTestResultById(int examId) {
		String query ="FROM TestResult as tstrslt where tstrslt.examId=" +examId;
		return (List<TestResult>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public void createQuestion(Question question) {
		entityManager.persist(question);
		
	}
	@Override
	public List<Question> findAllQuestionInExam(int examId) {

		String query ="FROM Question as ques where ques.examId=" +examId;
		return (List<Question>) entityManager.createQuery(query).getResultList();
	}

}
