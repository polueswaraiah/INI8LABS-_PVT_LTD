<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.registration.Dao.Git_employeeBo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
    <style>
		.h1{
			position: relative;
			padding-bottom: 50px;
			color: #B80000;
			text-align: center;
			font-size: large;
			
		}
		
		
		</style>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Git_employeeBo employeeBo = new Git_employeeBo();
        int result = employeeBo.delete(id);
        if (result > 0) {
    %>
        <h2>Employee deleted successfully!</h2>
      <%  RequestDispatcher rd = request.getRequestDispatcher("git.jsp");
			rd.include(request, response); %>
    <% } else { %>
        <h2>Failed to delete employee. Please try again.</h2>
    <% } %>
</body>
</html>
