package com.stark.springbootgraphql.resolver;

import com.stark.springbootgraphql.entity.Employee;
import com.stark.springbootgraphql.service.EmployeeService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final EmployeeService employeeService;

    public EmployeeResolver(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    public Employee employee(Long id) {
        return employeeService.getEmployeeById(id);
    }

    @MutationMapping
    public Employee createEmployee(String name, String department, Double salary) {
        return employeeService.createEmployee(name, department, salary);
    }

    @MutationMapping
    public Employee updateEmployee(Long id, String name, String department, Double salary) {
        return employeeService.updateEmployee(id, name, department, salary);
    }

    @MutationMapping
    public String deleteEmployee(Long id) {
        return employeeService.deleteEmployee(id);
    }
}