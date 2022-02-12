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

import com.learner.database.GradeDao;
import com.learner.model.Grade;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GradeDao gradeDao;

	public void init() {
		gradeDao = new GradeDao();
	}

	public GradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				insertGrade(request, response);
				break;
			case "delete":
				deleteGrade(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateGrade(request, response);
				break;
			default:
				listGrade(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listGrade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Grade> listGrade = gradeDao.getAllClasses();
		request.setAttribute("listgrade", listGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Grade existingUser = gradeDao.getGrade(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade-form.jsp");
		request.setAttribute("grade", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertGrade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		Grade newGrade = new Grade(name);
		gradeDao.saveGrade(newGrade);
		response.sendRedirect("grade?action=list");
	}

	private void updateGrade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Grade grade = new Grade(id, name);
		gradeDao.updateGrade(grade);
		response.sendRedirect("grade?action=list");
	}

	private void deleteGrade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		gradeDao.deleteGrade(id);
		response.sendRedirect("grade?action=list");
	}

}
