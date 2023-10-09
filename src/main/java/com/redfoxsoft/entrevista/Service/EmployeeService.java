package com.redfoxsoft.entrevista.Service;

import com.redfoxsoft.entrevista.Entity.Employee;
import com.redfoxsoft.entrevista.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MoneyCalculatorService moneyCalculatorService;
    public Employee addEmployee (Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findByName(String nameEmployee){
        return employeeRepository.findByName(nameEmployee);
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


}
