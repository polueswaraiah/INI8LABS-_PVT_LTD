package com.registration.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.registration.entity.Git_employee;

public class Git_employeeBo implements Git_interface {

    static final String URL = "jdbc:mysql://localhost:3306/jdbcclasses";
    static final String USERNAME = "root";
    static final String PASSWORD = "harish";

    static final String INSERT_SQL = "INSERT INTO Git_employee (ID, USERNAME, EMAIL, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?, ?)";
    static final String UPDATE_SQL = "UPDATE Git_employee SET USERNAME = ?, EMAIL = ?, SALARY = ? WHERE ID = ?";
    static final String DELETE_SQL = "DELETE FROM Git_employee WHERE ID = ?";
    static final String SELECT_ALL_SQL = "SELECT * FROM Git_employee";
    static final String SELECT_BY_ID_SQL = "SELECT * FROM Git_employee WHERE ID = ?";

    private Connection connection;

    // Constructor to initialize DB connection
    public Git_employeeBo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Git_employee ge) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
            ps.setInt(1, ge.getId());
            ps.setString(2, ge.getUsername());
            ps.setString(3, ge.getEmail());
            ps.setString(4, ge.getDepartment());
            ps.setInt(5, ge.getSalary());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Git_employee ge) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, ge.getUsername());
            ps.setString(2, ge.getEmail());
            ps.setInt(3, ge.getSalary());
            ps.setInt(4, ge.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Git_employee> getall() {
        List<Git_employee> employees = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
            while (rs.next()) {
                Git_employee ge = new Git_employee();
                ge.setId(rs.getInt("ID"));
                ge.setUsername(rs.getString("USERNAME"));
                ge.setEmail(rs.getString("EMAIL"));
                ge.setDepartment(rs.getString("DEPARTMENT"));
                ge.setSalary(rs.getInt("SALARY"));
                employees.add(ge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Git_employee getEmployeebyId(int id) {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Git_employee ge = new Git_employee();
                ge.setId(rs.getInt("ID"));
                ge.setUsername(rs.getString("USERNAME"));
                ge.setEmail(rs.getString("EMAIL"));
                ge.setDepartment(rs.getString("DEPARTMENT"));
                ge.setSalary(rs.getInt("SALARY"));
                return ge;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
