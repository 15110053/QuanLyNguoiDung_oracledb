package monhoc.baomatcsdl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import monhoc.baomatcsdl.dao.profiledao;

@Service
public class profileservice {

	@Autowired 
	profiledao profiledao;
	
	@Transactional
	public List listprofile() {
		return profiledao.listprofile();
	}
	
	@Transactional
	public boolean deleteprofile(String profilename) {
		return profiledao.deleteprofile(profilename);
	}
	
	@Transactional
	public boolean modifyprofile(String profilename, String spu, String ct, String it) {
		return profiledao.modifyprofile(profilename, spu, ct, it);
	}
	
	@Transactional
	public boolean addprofile(String profilename, String spu, String ct, String it) {
		return profiledao.addprofile(profilename, spu, ct, it);
	}
}
