<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.registration.Dao.Git_employeeBo, com.registration.entity.Git_employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #DED0B6;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 300px;
}

.box {
	margin-bottom: 20px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	background-color: #4caf50;
	color: white;
	border: none;
	border-radius: 4px;
	width: 300px;
	margin-top: 15px;
	padding: 10px;
	cursor: pointer;
}

button:hover {
	background-color: #294B29;
}
</style>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Git_employeeBo employeeBo = new Git_employeeBo();
        Git_employee employee = employeeBo.getEmployeebyId(id);
    %>
    <div class="container">
        <h2>Edit Employee</h2>
        <form action="edit2" method="post">
            <input type="hidden" name="id" value="<%= employee.getId() %>">
            <input type="text" name="username" value="<%= employee.getUsername() %>" required>
            <input type="email" name="email" value="<%= employee.getEmail() %>" required>
            <input type="text" name="department" value="<%= employee.getDepartment() %>" required>
            <input type="number" name="salary" value="<%= employee.getSalary() %>" required>
            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>
