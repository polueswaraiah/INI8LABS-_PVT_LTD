package com.registration.Dao;

import java.util.List;
import com.registration.entity.Git_employee;

public interface Git_interface {
    int save(Git_employee ge);
    int update(Git_employee ge);
    int delete(int id);
    List<Git_employee> getall();
    Git_employee getEmployeebyId(int id);
}
