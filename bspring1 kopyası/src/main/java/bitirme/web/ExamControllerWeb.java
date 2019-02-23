package bitirme.web;

import bitirme.model.*;
import bitirme.service.ExamServiceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ExamControllerWeb {

	
	@SpringBootApplication
	public class AppConfig {

	    @Value("${spring.mvc.view.prefix}")
	    private String prefix = "/WEB-INF/jsp/";

	    @Value("${spring.mvc.view.suffix}")
	    private String suffix = ".jsp";

	    /*@Value("${spring.view.view-names}")
	    private String viewNames = "jsp/*";*/

	    /*@Bean
	    InternalResourceViewResolver jspViewResolver() {
	        final InternalResourceViewResolver vr = new InternalResourceViewResolver();
	        vr.setPrefix(prefix);
	        vr.setSuffix(suffix);
	        vr.setViewClass(JstlView.class);
	        vr.setViewNames("jsp/*");
	        return vr;
	    }*/
	}
	
	@Autowired
	private ExamServiceWeb examServiceWeb;
	private int flag = 0;

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping("/")
	public String login() {
		flag = 1;
		return "login";
	}

	@RequestMapping("/home")
	public String home() {

		if(flag == 1)
			return "home";
		else
			return "login";
	}

	@RequestMapping(value="/exams",method=RequestMethod.GET)
	public String exams(Model model) {
		//System.out.println("controller");
		//System.out.println();
		System.out.println("!");
        model.addAttribute("clsexam", examServiceWeb.findAllClassic());
		model.addAttribute("tstexam", examServiceWeb.findAllTest());
        return "exams";
	}
	@RequestMapping(value="/exams",method=RequestMethod.POST)
	public String handleFormSubmit(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "examtype", required = false) String examtype,Model model) {
		System.out.println(id + examtype);
		/*if(examtype == "test")
		{*/
			model.addAttribute("tstexam",examServiceWeb.findTestExamById(Integer.parseInt(id)));
			model.addAttribute("clsexam",examServiceWeb.findClassicExamById(Integer.parseInt(id)));
		/*}
		else if(examtype == "classic")
		{
			model.addAttribute("clsexam",examServiceWeb.findTestExamById(Integer.parseInt(id)));
		}*/
		return "exams";

	}

	@RequestMapping(value="/candidates",method=RequestMethod.GET)
	public String candidates(Model model) {
        model.addAttribute("candidate", examServiceWeb.findAllUser());
		return "candidates";
	}
	@RequestMapping(value="/candidates",method=RequestMethod.POST)
	public String handleFormSubmitUser(@RequestParam(value = "id", required = false) String id,
										@RequestParam(value = "name", required = false) String name,
										@RequestParam(value = "lname", required = false) String lname,
										Model model) {
		model.addAttribute("tstexam",examServiceWeb.findUser(Integer.parseInt(id), name, lname));
		return "candidates";

	}
	/*@RequestMapping("/addexam")
	public String addExm() {
		return "addexam";
	}*/

	@RequestMapping(value="/results",method=RequestMethod.GET)
	public String results(Model model) {
		model.addAttribute("clsresult", examServiceWeb.findAllClassicResult());
		model.addAttribute("tstresult", examServiceWeb.findAllTestResult());
		return "results";
	}

    @ModelAttribute
    public ClassicResult initResultModel() {
        return new ClassicResult();
    }

    @RequestMapping(value="/results",method=RequestMethod.POST)
    public String handleFormSubmitResults(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "examtype", required = false) String examtype,Model model) {
		System.out.println(id + examtype);
		model.addAttribute("tstexam",examServiceWeb.findTestResultById(Integer.parseInt(id)));
		model.addAttribute("clsexam",examServiceWeb.findClassicResultById(Integer.parseInt(id)));
		return "results";
    }
		
    @RequestMapping(value="/exams/new/classic",method=RequestMethod.GET)
    public ModelAndView newClassicExam() {
	      return new ModelAndView("addclassicexam", "clsExam", new ClassicExam());
	   }

	@ModelAttribute
	public ClassicExam initModelClassicExam() {
		return new ClassicExam();
	}


	@RequestMapping(value="/exams/new/classic",method=RequestMethod.POST)
	/*public String handleFormSubmit(@ModelAttribute("clsexam") ClassicExam clsexam) {
		//clsexam.setExamId(0);
		examServiceWeb.createClassicExam(clsexam);
		System.out.println(clsexam.getDuration());
		return "redirect:/exams";
	}*/
	/*public String handleFormSubmit(@RequestParam(value = "duration", required = false) String duration,
								   @RequestParam(value = "examstartingdate", required = false) Date examstartingdate,
								   @RequestParam(value = "examenddate", required = false) Date examenddate,
								   @RequestParam(value = "number", required = false) String number,
								   @RequestParam(value = "format", required = false) String format
								   ,Model model) {*/
	public String handleFormSubmit(@ModelAttribute ClassicExam cExam) {
		/*ClassicExam cExam = new ClassicExam();
		System.out.println(duration);
		cExam.setDuration(duration);
		cExam.setExamFinishingDate(examenddate);
		cExam.setExamStartingDate(examstartingdate);
		cExam.setFormat(format);
		cExam.setNumber(number);*/
		
		examServiceWeb.createClassicExam(cExam);
		return "redirect:/exams";
	}

	@RequestMapping(value="/exams/new/test",method=RequestMethod.GET)
		public ModelAndView newTestExam() {
		      return new ModelAndView("addtestexam", "tstExam", new TestExam());
		   }

	@ModelAttribute
	public TestExam initModelTestExam() {
		return new TestExam();
	}

	@RequestMapping(value="/exams/new/test",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute TestExam tstexam) {
		System.out.println(tstexam.getDuration());
		
		examServiceWeb.createTestExam(tstexam);
		return "redirect:/exams";
	}

	@RequestMapping(value="/candidates/new",method=RequestMethod.GET)
	public String newCandidate() {
		return "addcandidate";
	}

	@ModelAttribute
	public User initUserModel() {
		return new User();
	}

	@RequestMapping(value="/candidates/new",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute User user) {
		examServiceWeb.createUser(user);
		return "redirect:/candidates";
	}
	
	@RequestMapping(value="/questions/new",method=RequestMethod.GET)
	public String newQuestion() {
		return "addquestion";
	}

	@ModelAttribute
	public Question initQuestionModel() {
		return new Question();
	}

	@RequestMapping(value="/questions/new",method=RequestMethod.POST)
	public String handleFormSubmitQuestion(@ModelAttribute Question question) {
		examServiceWeb.createQuestion(question);
		return "redirect:/questions";
	}
}
