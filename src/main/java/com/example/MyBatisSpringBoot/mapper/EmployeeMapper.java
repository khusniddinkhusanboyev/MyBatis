package com.example.MyBatisSpringBoot.mapper;

import com.example.MyBatisSpringBoot.model.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Results({

            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "salary", column = "salary")
    })
    @Select("select * from employees")
    List<Employee> getAll();
    @Insert("insert into employees(name,salary) values(#{name},#{salary})")
    /*@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)*/
    void insert(Employee employee);
    @Select("SELECT id, name, salary from employees WHERE id = #{id}")
    Employee selectEmployee(@Param("id") int id);

    @Insert("INSERT INTO employees(id,name,salary) VALUES(#{id},#{name}, #{salary})")
    void save(@RequestBody Employee employee);

    @Update("UPDATE employees SET name=#{name}, salary =#{salary} WHERE id =#{id}")
    void updateEmployee(@RequestBody Employee employee);

    @Delete("DELETE FROM employees WHERE id =#{id}")
    void deleteEmployee(@Param("id") int id);

}
