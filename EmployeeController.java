package com.employee.employee.controller;

import com.employee.employee.dao.Employee;
import com.employee.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public Map<String,Object> addEmployee(@RequestBody Employee employee){
        Map<String,Object> map = new HashMap<>();
        if (employee != null){
            String firstName = employee.getFirst_name();
            String lastName = employee.getLast_name();
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

    @GetMapping("/getAll")
    public List<Map<String,Object>> getAllEmp(){
        List<Map<String, Object>> list = employeeService.getAllEmp();
        if(list != null){
            return list;
        }else{
            return null;
        }
    }

    @PutMapping("/update")
    public Map updateEmp(@RequestBody Map<String,Object> request){
        Map<String,String> map = new HashMap<>();
        if(request != null){
            String first_name = request.get("first_name").toString();
            String id = request.get("id").toString();
            Integer res = employeeService.updateEmp(id,first_name);
            if(res != null && res !=0){
                map.put("code","200");
                map.put("msg","success");
            }else{
                map.put("code","500");
                map.put("msg","failed");
            }
        }
        return map;
    }

    @DeleteMapping("/delete")
    public Map deleteEmp(@RequestBody Map<String,Object> request){
        Map<String,String> map = new HashMap<>();
        if(request != null){
            String id = request.get("id").toString();
            Integer res = employeeService.deleteEmp(id);
            if(res != null && res !=0){
                map.put("code","200");
                map.put("msg","success");
            }else{
                map.put("code","500");
                map.put("msg","failed");
            }
        }
        return map;
    }
}
