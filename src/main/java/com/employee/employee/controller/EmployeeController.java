package com.employee.employee.controller;

import com.employee.dao.Employee;
import com.employee.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public Map<String, Object> addEmployee(@RequestBody Employee employee) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "success");
        if (employee != null){
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String email = employee.getEmail();
            String res = employeeService.addEmp(firstName, lastName, email);
            if(res != null){
                map.put("code","200");
                map.put("msg","success");
            }else{
                map.put("code","500");
                map.put("msg","failed");
            }

        }
        return map;
    }

    @GetMapping("/get")
    public List<Map<String, Object>> getAllEmp() {
        List<Map<String, Object>> list = employeeService.getAllEmp();
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    @PostMapping("/update")
    public Map updateEmp(@RequestBody Map<String, Object> request) {
        System.out.println("Update Map");
        System.out.println(request);
        Map<String, String> map = new HashMap<>();
        if (request != null) {
            String first_name = String.valueOf(request.get("firstName"));
            String last_name = String.valueOf(request.get("lastName"));
            String email = String.valueOf(request.get("email"));

            String id = String.valueOf(request.get("id")) ;
            Integer res = employeeService.updateEmp(id, first_name,last_name,email);
            if (res != null && res != 0) {
                map.put("code", "200");
                map.put("msg", "success");
            } else {
                map.put("code", "500");
                map.put("msg", "failed");
            }
        }
        return map;
    }

    @PostMapping("/get_by_id")
    public Map<String, Object> getEmp(@RequestBody Map<String, Object> request){
        Map<String, Object> map = employeeService.getEmpByid(request.get("id").toString());
        if(map != null){
            System.out.println(map);
            return map;
        }else{
            return null;
        }
    }

    @PostMapping("/delete")
    public Map deleteEmp(@RequestBody Map<String, Object> request) {
        Map<String, String> map = new HashMap<>();
        if (request != null) {
            String id = request.get("id").toString();
            Integer res = employeeService.deleteEmp(id);
            if (res != null && res != 0) {
                map.put("code", "200");
                map.put("msg", "success");
            } else {
                map.put("code", "500");
                map.put("msg", "failed");
            }
        }
        return map;
    }
}
