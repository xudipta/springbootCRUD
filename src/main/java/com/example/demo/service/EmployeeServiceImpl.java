package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }
    @Override
    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }
    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
        return this.employeeRepository.findAll(pageable);
    }

}
