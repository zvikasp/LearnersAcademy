package com.learner.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learner.database.SubjectDao;
import com.learner.model.Subject;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the subject.
 * 
 */

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao;

	public void init() {
		subjectDao = new SubjectDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertSubject(request, response);
				break;
			case "delete":
				deleteSubject(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateSubject(request, response);
				break;
			default:
				listSubject(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Subject> listSubject = subjectDao.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Subject existingSubject = subjectDao.getSubject(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		request.setAttribute("subject", existingSubject);
		dispatcher.forward(request, response);
	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String classId = request.getParameter("classId");
		Subject newSubject = new Subject(name, classId);
		subjectDao.saveSubject(newSubject);
		response.sendRedirect("subject?action=list");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String classId = request.getParameter("classId");
		Subject subject = new Subject(id, name, classId);
		subjectDao.updateSubject(subject);
		response.sendRedirect("subject?action=list");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		subjectDao.deleteSubject(id);
		response.sendRedirect("subject?action=list");
	}
}