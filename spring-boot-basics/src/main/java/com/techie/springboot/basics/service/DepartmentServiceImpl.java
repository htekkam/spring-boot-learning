package com.techie.springboot.basics.service;

import com.techie.springboot.basics.entity.Department;
import com.techie.springboot.basics.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("Department not available"));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        Department oldRecord = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equals(department.getDepartmentName())){
            oldRecord.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equals(department.getDepartmentCode())){
            oldRecord.setDepartmentName(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equals(department.getDepartmentAddress())){
            oldRecord.setDepartmentName(department.getDepartmentAddress());
        }

        return departmentRepository.save(oldRecord);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
