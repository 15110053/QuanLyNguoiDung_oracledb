package monhoc.baomatcsdl.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import monhoc.baomatcsdl.model.users;

@Repository
public class homedao {

	@Autowired
	SessionFactory sessionfactory;
		
	public List<users> testthoi(){
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("from users");
		return query.getResultList();
	}
}
