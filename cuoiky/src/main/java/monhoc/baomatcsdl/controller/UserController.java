package monhoc.baomatcsdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import monhoc.baomatcsdl.model.users;
import monhoc.baomatcsdl.service.userService;

@Controller
public class UserController {

	@Autowired
	userService userservice;

	@Autowired
	UserCredentialsDataSourceAdapter ds;

	@PostMapping("/createuser")
	public @ResponseBody String home(@RequestBody users user) {
		if (userservice.CreateUser(user) == true)
			return "{\"result\":\"success\"}";
		return "{\"result\":\"fail\"}";
	}

	@PostMapping("/login")
	public @ResponseBody String handleLogin(@RequestBody users user) {
		try {
			ds.setUsername(user.getUsername());
			ds.setPassword(user.getPassword());
			return "{\"result\":\"success\"}";
		} catch (Exception ex) {
			return "{\"result\":\"" + ex + "\"}";
		}
	}

	@GetMapping("/registerpage")
	public String registerpage(Model model) {
		return "register";
	}

	@GetMapping("/modifypage")
	public String modifypage(Model model, @RequestParam String username) {
		try {
			List listtablespace = userservice.gettablespace();
			model.addAttribute("listtablespace", listtablespace);
			List listprofile = userservice.getprofile();
			model.addAttribute("listprofile", listprofile);
			users user = userservice.finduser(username);
			model.addAttribute("user", user);
			return "modifyuser";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "errorpage";
		}
	}

	@GetMapping("/adminpage")
	public String adminpage(Model model) {
		try {
			List<users> listuser = userservice.getalluser();
			model.addAttribute("listuser", listuser);
			return "adminpage";	
		}catch(Exception ex){
			return "errorpage";
		}
	}

	@GetMapping("/modifyuser")
	public String modifyuser(Model model, @RequestParam String username, @RequestParam String tablespace,
			@RequestParam String profile) {
		if (userservice.modifyuser(username, tablespace, profile))
			return "redirect:/adminpage";
		return "errorpage";
	}

	@GetMapping("/deleteuser")
	public @ResponseBody String home(@RequestParam String username) {
		if (userservice.deleteuser(username) == true)
			return "{\"result\":\"success\"}";
		return "{\"result\":\"fail\"}";
	}
}
