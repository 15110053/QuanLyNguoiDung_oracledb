package monhoc.baomatcsdl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import monhoc.baomatcsdl.dao.userDAO;
import monhoc.baomatcsdl.model.users;

@Service
public class userService {

	@Autowired 
	userDAO userdao;
	
	@Transactional
	public boolean CreateUser(users user) {
		return userdao.CreateUser(user);
	}
	
	@Transactional
	public boolean login(String Username, String Password) {
		return userdao.login(Username, Password);
	}
	
	@Transactional
	public List<users> getalluser() {
		return userdao.getalluser();
	}
	
	@Transactional
	public List gettablespace() {
		return userdao.gettablespace();
	}
	
	@Transactional
	public List getprofile() {
		return userdao.getprofile();
	}
	
	@Transactional
	public users finduser(String username) {
		return userdao.finduser(username);
	}
	
	@Transactional
	public boolean modifyuser(String username, String tablespace, String profile) {
		return userdao.modifyuser(username, tablespace, profile);
	}
	
	@Transactional
	public boolean deleteuser(String username) {
		return userdao.deleteuser(username);
	}
}
