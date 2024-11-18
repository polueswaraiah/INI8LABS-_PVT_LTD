package com.registration.Dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.entity.Git_employee;

/**
 * Servlet implementation class Edit2
 */
@WebServlet("/edit2")
public class Edit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Git_employeeBo gemp = new Git_employeeBo();
		 Git_employee ge = new Git_employee();
		 int id =Integer.parseInt(request.getParameter("id"));
		 String name = request.getParameter("username");
		 String email = request.getParameter("email");
		 int salary = Integer.parseInt(request.getParameter("salary")); 
		 ge.setId(id);
		 ge.setUsername(name);
		 ge.setEmail(email);
		 ge.setSalary(salary);
		 int i = gemp.update(ge);
		 if(i == 1) {
			 RequestDispatcher rd = request.getRequestDispatcher("git.jsp");
			 rd.forward(request, response);
		 }
		 
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
