package com.employee.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    NamedParameterJdbcTemplate template;
    public String addEmp(String firstName, String lastName, String email) {
        Integer res = null;
        String SQL = "insert into employee.employee_profiles (first_name,last_name,email)\n" +
                        "values (:first_name,:last_name,:email)";
          res = template.update(SQL,new MapSqlParameterSource().addValue("first_name",firstName)
                .addValue("last_name",lastName)
                .addValue("email",email));
          if(res != null){
              return "success";
          }
        return null;
    }

    public List<Map<String,Object>> getAllEmp() {
        try {
            return template.queryForList("SELECT * FROM employee.employee_profiles", new MapSqlParameterSource());
        } catch (DataAccessException e) {
            return null;
        }
    }

    public Integer updateEmp(String id,String firstName) {
        return template.update("update employee.employee_profiles set first_name=:first where id=:id",
               new MapSqlParameterSource().addValue("id",id).addValue("first",firstName));
    }

    public Integer deleteEmp(String id) {
        return template.update("delete from employee.employee_profiles where id=:id",
               new MapSqlParameterSource().addValue("id",id));
    }
}
