<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, com.registration.Dao.Git_employeeBo, com.registration.entity.Git_employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Details</title>
    <style>
    body {
        background-color: #F8F4EC;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .head {
        text-align: center;
        color: black;
        margin: 20px 0;
    }
    .box {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 10px;
        gap: 15px; /* Added gap between containers */
    }
    .container {
        display: inline-table;
        background-color: #E8D8C4;
        border: 2px solid #99BC85;
        width: 150pt;
        padding: 55pt;
        margin: 25pt;
        margin-bottom: 20px; /* Added space below each container */
    }
    .font {
        color: #503C3C;
        margin: 5px 0;
        font-size: 24px;
    }
    .anchor{
        text-decoration: none;
        color: #211C6A;
        padding: 10px;
        font-size: large;
    }
    #edit {
        background-color: green;
        color: white;
        font-size: medium;
        padding: 10px;
        border-radius: 5px;
        margin-right: 60px; /* Space between Edit and Delete buttons */
    	
    }
    #edit:hover {
        background-color: darkgreen;
    }
    #delete {
        background-color: red;
        color: white;
        font-size: medium;
        padding: 10px;
        border-radius: 5px;
    }
    #delete:hover {
        background-color: darkred;
    }
    /* Added space below the salary field */
    .container .font:last-child {
        margin-bottom: 15px;
    }
    /* Added space between buttons */
    .container .anchor {
        margin-top: 10px;
    }
    #add{
    	font-style: oblique;
    }
    #add:hover {
		color: red;
	}
    
</style>



</head>
<body>
    <h1 class="head">Employee Details</h1>
    <div class="box">
        
        <%
            Git_employeeBo employeeBo = new Git_employeeBo();
            List<Git_employee> employees = employeeBo.getall();
            for (Git_employee emp : employees) {
        %>
        <div class="container">
            <p class="font"><b>ID:</b> <%= emp.getId() %></p>
            <p class="font"><b>Username:</b> <%= emp.getUsername() %></p>
            <p class="font"><b>Email:</b> <%= emp.getEmail() %></p>
            <p class="font"><b>Department:</b> <%= emp.getDepartment() %></p>
            <p class="font"><b>Salary:</b> <%= emp.getSalary() %></p>
            <a href="edit.jsp?id=<%= emp.getId() %>" id="edit" class="anchor">Edit</a>
            <a href="delete.jsp?id=<%= emp.getId() %>" id="delete" class="anchor">Delete</a>
        </div>
        <% } %>
        
    </div>
    <a href="AddEmployee.jsp" class="anchor" id="add">Add New Employee</a>
</body>
</html>
