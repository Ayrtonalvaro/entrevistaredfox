package com.redfoxsoft.entrevista.Controller;

import com.redfoxsoft.entrevista.Entity.Employee;
import com.redfoxsoft.entrevista.Service.EmployeeService;
import com.redfoxsoft.entrevista.Service.MoneyCalculatorService;
import com.redfoxsoft.entrevista.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @Autowired
    private MoneyCalculatorService moneyCalculatorService;

    @PostMapping("/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{nameEmployee}")
    public ResponseEntity<Map<Integer, Integer>> calculateMoney(@PathVariable String nameEmployee){
        Map<Integer, Integer> amountMoney = new HashMap<>();
        Optional<Employee> employee = employeeService.findByName(nameEmployee);
        if(employee.isPresent()){
            Integer salary = employee.get().getSalary();
            amountMoney = MoneyCalculatorService.moneyCalculate(salary);
        }
        return new ResponseEntity<>(amountMoney, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.findById(id).get();
        employee.setSalary(employeeDto.getSalary());
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>("Employee updated", HttpStatus.OK);

    }

}
