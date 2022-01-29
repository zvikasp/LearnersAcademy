package com.learner.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateUtil;
import com.learner.model.Grade;
import com.learner.model.Student;
import com.learner.model.Subject;
import com.learner.model.Teacher;

/**
 * Servlet implementation class LearnersApp
 */
@WebServlet("/LearnersApp")
public class LearnersApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LearnersApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession loginSession = request.getSession(false);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		RequestDispatcher rd = null;
		if (loginSession == null) {
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			out.close();
			return;
		} else {
			String username = (String) loginSession.getAttribute("username");
			out.print("<html><head>");
			out.print("<title>Learner's Academy</title>");
			out.print("<style>table, td, th {border: 1px solid black;}");
			out.print("table {border-collapse: collapse;}</style>");
			out.print("</head><body>");
			out.print("<h3>Welcome " + username + "&nbsp;&nbsp;&nbsp;");
			out.print("<a href='Logout'>Logout</a>");
			out.print("</h3>");
		}

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			// using HQL
			@SuppressWarnings("unchecked")
			List<Grade> list = session.createQuery("from Grade").list();
			out.print("<b>Learner's Academy Class Information</b><br><br>");
			for (Grade grade : list) {
				out.print("<b>" + grade.getClsId() + "</b>.&nbsp;<b>" + grade.getName() + "</b>");
				out.print("<br><br>");

				// Subjects
				List<Subject> subjects = grade.getSubjects();
				out.print("<table>");
				int subId = 0;
				out.print("<tr bgcolor=\"brown\"><th>Subject Id</th><th>Subject Name</th></tr>");
				for (Subject subject : subjects) {
					subId++;
					out.print("<tr>");
					out.print("<td>" + subId + "</td>");
					out.print("<td>" + subject.getName() + "</td>");
					out.print("<tr>");
				}
				out.print("</table>");
				out.print("<br>");

				// Students
				List<Student> students = grade.getStudents();
				out.print("<table>");
				int stuId = 0;
				out.print("<tr bgcolor=\"blue\"><th>Student Id</th><th>Student Name</th></tr>");
				for (Student student : students) {
					stuId++;
					out.print("<tr>");
					out.print("<td>" + stuId + "</td>");
					out.print("<td>" + student.getName() + "</td>");
					out.print("<tr>");
				}
				out.print("</table>");
				out.print("<br>");

				// Students
				List<Teacher> teachers = grade.getTeachers();
				out.print("<table>");
				int tId = 0;
				out.print("<tr bgcolor=\"green\"><th>Teacher Id</th><th>Teacher Name</th></tr>");
				for (Teacher teacher : teachers) {
					tId++;
					out.print("<tr>");
					out.print("<td>" + tId + "</td>");
					out.print("<td>" + teacher.getName() + "</td>");
					out.print("<tr>");
				}
				out.print("</table>");
				out.print("<br>");
			}
			session.close();
			out.print("</body></html>");

		} catch (Exception ex) {
			throw ex;
		}
	}

}
