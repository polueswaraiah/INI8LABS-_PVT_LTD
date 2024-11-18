INI8LABS_PVT_LABS PROJECT
=========================
Overview
--------
The Employee Management System is a web application developed to manage employee details including personal information, department, and salary. The system allows users to view, add, edit, and delete employee records. It is built using Java, JSP, Servlets, and MySQL for the back-end, and HTML and CSS for the front-end. This project follows the Model-View-Controller (MVC) architecture and uses Java Beans and JDBC to handle database operations.

Features
--------
View Employee Details:List all employees with details like ID, Username, Email, Department, and Salary.
---------------------
Add New Employee: Allows the user to add a new employee to the database.
----------------
Edit Employee Details: Edit an existing employee's details such as their department and salary.
---------------------
Delete Employee: Delete an employee record from the database.
---------------
Responsive Design:The application uses CSS to make the page layout responsive and user-friendly.
-----------------

 Technologies Used
 =================
Back-End:
--------
Java (Servlets, JSP)
JDBC (Java Database Connectivity)
MySQL (Database)

Front-End:
---------
HTML
CSS
Installation
Prerequisites
Java 8 or later
MySQL Server
Apache Tomcat (or any other Java servlet container)
A database created in MySQL for employee records


*** Setup Instructions ***
==========================
Set up the MySQL database:

Create a database employee_db.

Create a table employees with the following structure:

sql:
----
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department VARCHAR(255),
    salary DECIMAL(10, 2)
);

Configure the database connection:
In the Git_employeeBo.java file, configure the database connection using JDBC.
Deploy the project:

Place the project folder in the webapps directory of your Tomcat server.
Start your Tomcat server.
Open the application in your browser:

Go to http://localhost:8080/EmployeeDetails/ to view the employee management page.
Usage
View Employee Details: The home page will display a list of all employees with their details.
---------------------
Add New Employee: Click the "Add New Employee" link to add a new employee.
----------------
Edit Employee: Click the "Edit" link next to an employee's record to update their details.
-------------
Delete Employee: Click the "Delete" link next to an employee's record to remove it from the system.
---------------


*** Directory Structure ***
===========================
/EmployeeDetails
    /WEB-INF
        /classes
            com/registration/Dao
                Git_employeeBo.java
            com/registration/entity
                Git_employee.java
        /lib
        /web.xml
    /jsp
        AddEmployee.jsp
        edit.jsp
        delete.jsp
    /css
        styles.css
    index.jsp
/WEB-INF/classes: Contains Java classes for database operations and entity beans.
/jsp: Contains JSP files for the user interface (Add, Edit, Delete, etc.).
/css: Contains CSS for styling the web pages.

Example Screenshots:
--------------------
Employee Details Page
Edit Employee Page

Future Enhancements:
====================
Implement validation for input fields.
Add pagination for employee listing.
Implement error handling for database operations.
Integrate logging for better debugging and tracking.
Enhance security features such as input validation and prevention of SQL injection.
