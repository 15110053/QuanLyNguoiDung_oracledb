package monhoc.baomatcsdl.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import monhoc.baomatcsdl.model.users;
import monhoc.baomatcsdl.service.homeservice;

@Controller
public class HomeController {

	@Autowired
	UserCredentialsDataSourceAdapter ds;
	
	@Autowired
	homeservice homeSERVICE;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<users> listemp = homeSERVICE.testthoi();
		model.addAttribute("listemp",listemp);
		return "home";
	}
	
	@GetMapping("/register")
	public String registerpage(Model model) {
		return "register";
	}
	@GetMapping("/")
	public String login(Model model) {
		return "login";
	}
}
