package com.example.restfulservice.controller;

import com.example.restfulservice.dao.DepartmentDao;
import com.example.restfulservice.dao.EmployeeDao;
import com.example.restfulservice.model.Department;
import com.example.restfulservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

/**
 * @author corn
 * @version 1.0.0
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC自动将请求参数与入参对象的属性一一绑定:请求参数的名字和javaBean的属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //System.out.println("emp " + employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String modifyEmp(Employee employee) {
        // 修改员工数据
        employeeDao.save(employee);
        //System.err.println(employee);
        // 返回员工列表
        // 注意不能用return一个模板页面，因为Tomcat7以后不支持
        // 会导致hiddenHttpMethodFilter失效
        // 这里应该重定向
        return  "redirect:/emps";
    }

}
