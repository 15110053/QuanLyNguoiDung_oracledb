package monhoc.baomatcsdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import monhoc.baomatcsdl.service.profileservice;

@Controller
public class profileController {
	
	@Autowired
	profileservice profilesevice;
	
	@GetMapping("/profile")
	public String profile(Model model) {
		List listprofile = profilesevice.listprofile();
		model.addAttribute("listprofile",listprofile);
		return "profile";
	}
	
	@GetMapping("/addprofile")
	public @ResponseBody String addprofile(@RequestParam String profilename, @RequestParam String spu, 
			@RequestParam String ct, @RequestParam String it) {
		
		try {
			profilesevice.addprofile(profilename, spu, ct, it);
			return "{\"result\":\"success\"}";
		}catch(Exception ex) {
			return "{\"result\":\""+ex+"\"}";
		}
	}
	
	@GetMapping("/deleteprofile")
	public @ResponseBody String deleteprofile(@RequestParam String profilename) {
		try {
			profilesevice.deleteprofile(profilename);
			return "{\"result\":\"success\"}";
		}catch(Exception ex) {
			return "{\"result\":\""+ex+"\"}";
		}
	}
	
	@GetMapping("/modifyprofile")
	public @ResponseBody String modifyprofile(@RequestParam String profilename, @RequestParam String spu, 
			@RequestParam String ct, @RequestParam String it) {
		try {
			profilesevice.modifyprofile(profilename, spu, ct, it);
			return "{\"result\":\"success\"}";
		}catch(Exception ex) {
			return "{\"result\":\""+ex+"\"}";
		}
	}
	
}
