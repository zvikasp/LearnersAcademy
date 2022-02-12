package com.learner.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernate.HibernateUtil;
import com.learner.model.User;

public class UserDao {

	public boolean validate(String userName, String password) {
		User user = null;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("FROM User WHERE username=:userName");
			query.setParameter("userName", userName);
			user = query.uniqueResult();
			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}