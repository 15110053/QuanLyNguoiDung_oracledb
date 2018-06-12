package monhoc.baomatcsdl.dao;



import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import monhoc.baomatcsdl.model.users;

@Repository
public class userDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	public boolean CreateUser(users user) {
		Session session = sessionfactory.getCurrentSession();
		try {
			String hashpassword = DigestUtils.sha1Hex(user.getPassword());
			String sqlquery = String.format("create user %s identified by %s", user.getUsername(), user.getPassword());
			user.setPassword(hashpassword);
			session.createNativeQuery(sqlquery).executeUpdate();
			String grantstr = String.format("grant create session to %s", user.getUsername());
			session.createNativeQuery(grantstr).executeUpdate();
			String grantselectstr = String.format("grant select on admin.users to %s", user.getUsername());
			session.createNativeQuery(grantselectstr).executeUpdate();
			session.persist(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean login(String Username, String Password) {
		try {
			System.out.println("---------------------------------------------------------");
			
			System.out.println("---------------------------------------------------------");
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public List<users> getalluser() {
		Session session = sessionfactory.getCurrentSession();
		List<users> listuser = new ArrayList<users>();
		try {
			listuser = session.createQuery("from users").getResultList();
			return listuser;
		}catch(Exception ex) {
			ex.printStackTrace();
			return listuser;
		}
	}
	
	public List gettablespace() {
		Session session = sessionfactory.getCurrentSession();
		List listuser = new ArrayList();
		try {
			listuser = session.createNativeQuery("select tablespace_name from dba_tablespaces "
					+ "where tablespace_name not in ('SYSTEM','SYSAUX','UNDOTBS1')").getResultList();
			return listuser;
		}catch(Exception ex) {
			ex.printStackTrace();
			return listuser;
		}
	}
	
	public List getprofile() {
		Session session = sessionfactory.getCurrentSession();
		List listprofile = new ArrayList();
		try {
			listprofile = session.createNativeQuery("select DISTINCT profile from dba_profiles "
					+ "where profile not in ('MYPASSWORD','DEFAULT','ORA_STIG_PROFILE')").getResultList();
			return listprofile;
		}catch(Exception ex) {
			ex.printStackTrace();
			return listprofile;
		}
	}
	
	public users finduser(String username) {
		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from users where username like :username");
			query.setParameter("username", username);
			users user = (users)query.uniqueResult();
			return user;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}	
	}
	
	public boolean modifyuser(String username, String tablespace, String profile) {
		try {
			Session session = sessionfactory.getCurrentSession();
			String querystr = String.format("alter user %s DEFAULT TABLESPACE %s profile %s ", username, tablespace, profile);
			session.createNativeQuery(querystr).executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}
	
	public boolean deleteuser(String username) {
		try {
			Session session = sessionfactory.getCurrentSession();
			String querystr = String.format("drop user %s cascade", username);
			session.createNativeQuery(querystr).executeUpdate();
			Query query = session.createQuery("from users where username like :username");
			query.setParameter("username", username);
			users user = (users)query.uniqueResult();
			session.delete(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}
}