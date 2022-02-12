package com.learner.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.learner.model.Grade;

/**
 * CRUD database operations
 */
public class GradeDao {

	/**
	 * Save Class
	 * 
	 * @param user
	 */
	public void saveGrade(Grade grade) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(grade);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update User
	 * 
	 * @param user
	 */
	public void updateGrade(Grade grade) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(grade);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete User
	 * 
	 * @param id
	 */
	public void deleteGrade(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a class object
			Grade grade = session.get(Grade.class, id);
			if (grade != null) {
				session.delete(grade);
				System.out.println("grade is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get User By ID
	 * 
	 * @param id
	 * @return
	 */
	public Grade getGrade(int id) {

		Transaction transaction = null;
		Grade grade = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			grade = session.get(Grade.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return grade;
	}

	/**
	 * Get all Classes
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Grade> getAllClasses() {

		Transaction transaction = null;
		List<Grade> listOfGrade = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an class object

			listOfGrade = session.createQuery("from Grade").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfGrade;
	}
}
