package com.registration.Dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.entity.Git_employee;

@WebServlet("/git")
public class Git extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Git_employeeBo gbo;

    @Override
    public void init() throws ServletException {
        super.init();
        gbo = new Git_employeeBo();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        int salary = Integer.parseInt(req.getParameter("salary"));

        Git_employee ge = new Git_employee(id, username, email, department, salary);

        int result = gbo.save(ge);
        if (result > 0) {
            out.print("Employee details saved successfully!");
            RequestDispatcher rd = req.getRequestDispatcher("git.jsp");
            rd.forward(req, resp);
        } else {
            out.print("<h1>Failed! This employee already exists.</h1>");
        }
    }
}
