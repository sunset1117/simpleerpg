package model.dao;

import java.util.Date;

import org.hibernate.Session;
//originalVersion1.0
//alphaTest
import model.CustomerBean;
import model.CustomerDAO;
import model.hibernate.HibernateUtil;

public class CustomerDAOHibernate implements CustomerDAO {
	private Session session;
	public CustomerDAOHibernate(Session session) {
		this.session = session;
	}	
	public Session getSession() {
		return session;
	}
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CustomerDAO customerDao = new CustomerDAOHibernate(session);
		
		CustomerBean select = customerDao.select("Alex");
		System.out.println("select="+select);
		
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}
	@Override
	public CustomerBean select(String custid) {
		return this.getSession().get(CustomerBean.class, custid);
	}
	@Override
	public boolean update(byte[] password, String email, Date birth, String custid) {
		CustomerBean temp = 
				this.getSession().get(CustomerBean.class, custid);
		if(temp!=null) {
			temp.setPassword(password);
			temp.setEmail(email);
			temp.setBirth(birth);
			return true;
		}
		return false;
	}
}
