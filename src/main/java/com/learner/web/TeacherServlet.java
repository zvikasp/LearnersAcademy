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

import com.learner.database.TeacherDao;
import com.learner.model.Teacher;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the teacher.
 * 
 */

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;

	public void init() {
		teacherDao = new TeacherDao();
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
				insertTeacher(request, response);
				break;
			case "delete":
				deleteTeacher(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateTeacher(request, response);
				break;
			default:
				listTeacher(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Teacher> listTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherDao.getTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		request.setAttribute("teacher", existingTeacher);
		dispatcher.forward(request, response);
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String classId = request.getParameter("classId");
		Teacher newTeacher = new Teacher(name, email, classId);
		teacherDao.saveTeacher(newTeacher);
		response.sendRedirect("teacher?action=list");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String classId = request.getParameter("classId");
		Teacher teacher = new Teacher(id, name, email, classId);
		teacherDao.updateTeacher(teacher);
		response.sendRedirect("teacher?action=list");
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(id);
		response.sendRedirect("teacher?action=list");
	}
}