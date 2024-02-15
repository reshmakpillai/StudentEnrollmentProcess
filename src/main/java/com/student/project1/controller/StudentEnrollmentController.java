package com.student.project1.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.project1.model.Student;
import com.student.project1.model.Enrollment;
import com.student.project1.model.Program;

import jakarta.servlet.http.HttpSession;


@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
	@Autowired
	private ProgramRepo programRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
    @RequestMapping("/index")
    public String home()
    {
    return "index";
    }
    
    @PostMapping("/add")
	public @ResponseBody String add(@RequestParam("studentid") int studid,
	@RequestParam("firstname") String firstname,
	@RequestParam("lastname") String lastname,
	@RequestParam("username") String username,
	@RequestParam("password") String password,
	@RequestParam("address") String address,
	@RequestParam("city") String city,
	@RequestParam("postalcode") String postalcode
			)
	{
	Student student=new Student(studid,firstname,lastname,username,password,address,city,postalcode);
	studentRepo.save(student);
	return "redirect:/index";
	}
    
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
    		@RequestParam("password") String password, Model model, HttpSession session) {
        Student student = studentRepo.findByUsername(username);

        if (student != null && student.getPassword().equals(password)) {
            model.addAttribute("username", username);
            session.setAttribute("studentId", student.getStudid()); 
            System.out.println(username);
            return "redirect:/checkout";
        }
		return password; 
     }
  
    @RequestMapping("/checkout")
    public String checkout(Model model, HttpSession session)
    {
    	int studentId = (int) session.getAttribute("studentId");
    	model.addAttribute("studentId", studentId);
    	model.addAttribute("programs", programRepo.findAll());

    	return "checkout";
    }
    
    @RequestMapping("/profile")
    public String profile(Model model, HttpSession session)
    {
    	int studentId = (int) session.getAttribute("studentId");
        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            model.addAttribute("student", student);
            return "profile";
        } else {
            return "redirect:/login";
        }
    }
    
    @PostMapping("/edit")
    public @ResponseBody String edit(@RequestParam("studentid") int studid,
    		@RequestParam("firstname") String firstname,
    		@RequestParam("lastname") String lastname,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestParam("address") String address,
    		@RequestParam("city") String city,
    		@RequestParam("postalcode") String postalcode
    				)
    		{
    		Student student=new Student(studid,firstname,lastname,username,password,address,city,postalcode);
    		studentRepo.save(student);
    		return "redirect:/profile";
    		}
    
    @PostMapping("/payment")
    public @ResponseBody String payment(
    		@RequestParam("studentid") Student studentid,
    		@RequestParam("programcode") Program programcode,
    		@RequestParam("amountpaid") double amountpaid,
    		Model model,
    		HttpSession session	,Enrollment enrollments	)
    		{
    		
	    	int status = 1;
    		LocalDate paymentdate = (LocalDate) enrollments.setpaymentdate(LocalDate.now());
    		Enrollment enrollment=new Enrollment(studentid,programcode,paymentdate,amountpaid,status);
    		enrollmentRepo.save(enrollment);
            model.addAttribute("insertSuccess", true);
            return "redirect:/checkout";
    		}
    

}
