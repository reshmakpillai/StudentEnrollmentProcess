package com.student.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.project1.model.Student;

import jakarta.servlet.http.HttpSession;


@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private EnrollmentRepo emrollmentRepo;
	
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
            return "redirect:/index";
        }
		return password; 
       }
    
    
	
	

}
