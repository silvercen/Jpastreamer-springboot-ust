package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }
    @GetMapping("/groupByEducation/paymentTier/{tier}")
    public Map<String, Long> groupEmployeesByEducationUnderPaymentTier(@PathVariable("tier") int paymentTier) {
        return employeeService.groupEmployeesByEducationUnderPaymentTier(paymentTier);
    }
    @GetMapping("/countByGender")
    public Map<String, Long> countEmployeesByGender() {
        return employeeService.countEmployeesByGender();
    }

    @GetMapping("/countByAge")
    public Map<Integer, Long> countEmployeesByAge() {
        return employeeService.countEmployeesByAge();
    }
}
