package com.chentx.tables.module03.model;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    public static void main(String[] args) {
//        Employee employee = new Employee().
        Employee employee = Employee.EmployeeBuilder.create("server").withAge(45).build();
        System.out.println(employee.getEmployeeNumber() + "  " + employee.getAge());

        Employee employeeOne = Employee.EmployeeBuilder.anEmployee().withAge(46).build();


    }


}