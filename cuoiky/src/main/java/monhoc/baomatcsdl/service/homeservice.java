package monhoc.baomatcsdl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monhoc.baomatcsdl.dao.homedao;
import monhoc.baomatcsdl.model.users;

@Service
public class homeservice {

	@Autowired
	homedao homeDAO;
	
	@Transactional
	public List<users> testthoi(){
		return homeDAO.testthoi();
	}
}
