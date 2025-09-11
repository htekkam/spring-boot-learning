package com.techie.springboot.basics.service;

import com.techie.springboot.basics.entity.Department;
import com.techie.springboot.basics.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> findAllDepartments();

    public Department getDepartmentById(long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
