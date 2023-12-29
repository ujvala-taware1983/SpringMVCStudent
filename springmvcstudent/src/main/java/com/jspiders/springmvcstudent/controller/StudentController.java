package com.jspiders.springmvcstudent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvcstudent.pojo.AdminPOJO;
import com.jspiders.springmvcstudent.pojo.StudentPOJO;
import com.jspiders.springmvcstudent.service.AdminService;
import com.jspiders.springmvcstudent.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private AdminService adminService;
	
	// Home Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Home";
		}
		map.addAttribute("msg", "Please login to proceed..!!");
		return "Login";
	}
	
	// Add Page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Add";
		}
		map.addAttribute("msg", "Please login to proceed..!!");
		return "Login";
	}
	
	//Add Data Controller
	@PostMapping("/add")
	public String add(@SessionAttribute(name = "login", required = false) AdminPOJO login, 
					@RequestParam String name,
					@RequestParam Long contact,
					@RequestParam String address,
					@RequestParam String course,
					ModelMap map) {
	if (login != null) {
		StudentPOJO student = service.addStudent(name, contact, address, course);	
		if(student != null) {
		//success response
		map.addAttribute("msg", "Data added successfully");
		return "Add";
	}
	//Failure response
	map.addAttribute("msg", "Data not added successfully");
	return "Add";
	}
	map.addAttribute("msg", "Please login to proceed..!!");
	return "Login";
	}
	
	// Search Page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Search";
		}
		map.addAttribute("msg", "Please login to proceed..!!");
		return "Login";
	}

	// Search Data Controller
		@PostMapping("/search")
		public String search(@SessionAttribute(name = "login", required = false) AdminPOJO login, 
															@RequestParam int id, ModelMap map) {
			if (login != null) {
				StudentPOJO student = service.searchStudent(id);
				if (student != null) {
					// Success response
					map.addAttribute("msg", "Student data found..!!");
					map.addAttribute("student", student);
					return "Search";
				}
				// Failure response
				map.addAttribute("msg", "Data not found..!!");
				return "Search";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}
		
		// Remove Page Controller
		@GetMapping("/remove")
		public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
			if (login != null) {
				List<StudentPOJO> students = service.searchAllStudents();
				map.addAttribute("studentList", students);
				return "Remove";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}

		// Remove Data Controller
		@PostMapping("/remove")
		public String remove(@SessionAttribute(name = "login", required = false) AdminPOJO login, @RequestParam int id, ModelMap map) {
			if (login != null) {
				StudentPOJO student = service.searchStudent(id);
				if (student != null) {
					// Success response
					service.removeStudent(id);
					List<StudentPOJO> students = service.searchAllStudents();
					map.addAttribute("studentList", students);
					map.addAttribute("msg", "Data removed successfully..!!");
					return "Remove";
				}
				// Failure response
				List<StudentPOJO> students = service.searchAllStudents();
				map.addAttribute("studentList", students);
				map.addAttribute("msg", "Data does not exist..!!");
				return "Remove";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}
		
		// Update Page Controller
		@GetMapping("/update")
		public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
			if (login != null) {
				List<StudentPOJO> students = service.searchAllStudents();
				map.addAttribute("studentList", students);
				return "Update";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}
		
		// Update Form Controller
		@PostMapping("/update")
		public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO login, @RequestParam int id, ModelMap map) {
			if (login != null) {
				StudentPOJO student = service.searchStudent(id);
				if (student != null) {
					//Success response
					map.addAttribute("student", student);
					return "Update";
				}
				//Failure response
				map.addAttribute("msg", "Data not found..!!");
				List<StudentPOJO> students = service.searchAllStudents();
				map.addAttribute("studentList", students);
				return "Update";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}
		
		// Update Data Controller
		@PostMapping("/updateData")
		public String update(@SessionAttribute(name = "login", required = false) AdminPOJO login,
							@RequestParam int id,
							@RequestParam String name,
							@RequestParam long contact,
							@RequestParam String address,
							@RequestParam String course,
							ModelMap map) {
			if (login != null) {
				StudentPOJO student = service.searchStudent(id);
				if (student != null) {
					//Success response
					service.updateStudent(id, name, contact, address, course);
					map.addAttribute("msg", "Data updated successfully..!!");
					List<StudentPOJO> students = service.searchAllStudents();
					map.addAttribute("studentList", students);
					return "Update";
				}
				//Failure response
				map.addAttribute("msg", "Data not updated..!!");
				return "Update";
			}
			map.addAttribute("msg", "Please login to proceed..!!");
			return "Login";
		}
		
		//Create Admin Page Controller
		@GetMapping("/create")
		public String createAdminPage() {
			return "Admin";
		}
		
		//Create Admin Data Controller
		@PostMapping("/create")
		public String createAdmin(@RequestParam String username,
									@RequestParam String password,
									ModelMap map) {
			AdminPOJO admin = adminService.addAdmin(username, password);
			if (admin != null) {
				//Success response
				map.addAttribute("msg", "Account created successfully..!!");
				return "Login";
			}
			//Failure response
			map.addAttribute("msg", "Account not created..!!");
			return "Login";
		}
		
		//Login Controller
		@PostMapping("/login")
		public String login(@RequestParam String username,
							@RequestParam String password,
							ModelMap map,
							HttpServletRequest request) {
			AdminPOJO admin = adminService.login(username, password);
			if (admin != null) {
				//Success response
				HttpSession session = request.getSession();
				session.setAttribute("login", admin);
				return "Home";
			}
			//Failure response
			map.addAttribute("msg", "Invalid username or password");
			return "Login";
		}
		
		
		// Logout Controller
		@GetMapping("/logout")
		public String logout(ModelMap map, HttpSession session) {
			map.addAttribute("msg", "Logged out successfully..!!");
			session.invalidate();
			return "Login";
		}


}

