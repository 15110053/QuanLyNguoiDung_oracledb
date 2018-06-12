package monhoc.baomatcsdl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class profiledao {

	@Autowired
	SessionFactory sessionfactory;

	public List listprofile() {
		List listprofile = new ArrayList();
		try {
			Session session = sessionfactory.getCurrentSession();
			listprofile = session.createNativeQuery("select profile,resource_name,limit from dba_profiles "
					+ "where profile not in ('MYPASSWORD','DEFAULT','ORA_STIG_PROFILE') and limit not in ('DEFAULT') "
					+ "order by profile, resource_name").getResultList();
			List listchanged = new ArrayList();
			for (int i = 0; i < listprofile.size();) {
				Object[] obj;
				obj = new Object[0];
				obj = new Object[1];
				obj = new Object[2];
				obj = new Object[3];
				obj = new Object[4];
				for (int j = 0; j < 3; j++) {
					Object[] profile = (Object[])listprofile.get(i);
					obj[0] = profile[0];
					obj[j+1]=profile[2];
					i++;
				}
				listchanged.add(obj);
			}
			return listchanged;
		} catch (Exception ex) {
			ex.printStackTrace();
			return listprofile;
		}
	}

	public boolean addprofile(String profilename, String spu, String ct, String it) {
		try {
			Session session = sessionfactory.getCurrentSession();
			if(spu.equals("")) spu = "unlimited";
			if(ct.equals("")) ct = "unlimited";
			if(it.equals("")) it = "unlimited";
			String sqlquery = String.format("CREATE PROFILE %s LIMIT SESSIONS_PER_USER %s CONNECT_TIME %s IDLE_TIME %S",
					profilename, spu, ct, it);
			session.createNativeQuery(sqlquery).executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteprofile(String profilename) {
		try {
			Session session = sessionfactory.getCurrentSession();
			String sqlquery = String.format("drop profile %s", profilename);
			session.createNativeQuery(sqlquery).executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean modifyprofile(String profilename, String spu, String ct, String it) {
		try {
			Session session = sessionfactory.getCurrentSession();
			if(spu.equals("")) spu = "unlimited";
			if(ct.equals("")) ct = "unlimited";
			if(it.equals("")) it = "unlimited";
			String sqlquery = String.format("ALTER PROFILE %s LIMIT SESSIONS_PER_USER %s CONNECT_TIME %s IDLE_TIME %S",
					profilename, spu, ct, it);
			session.createNativeQuery(sqlquery).executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
