package com.muhikira.hrms.mapper;

import com.muhikira.hrms.dto.EmployeeDto;
import com.muhikira.hrms.model.Employee;

public class EmployeeMapper {

  private EmployeeMapper() {}

  public static EmployeeDto toDto(Employee employee) {
    if (employee == null) {
      return null;
    }
    return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail(),
        employee.getPhone(),
        employee.getDateOfBirth(),
        employee.getPlaceOfBirth(),
        employee.getPosition(),
        employee.getDepartmentId(),
        employee.getHireDate(),
        employee.getSalary());
  }

  public static Employee toEntity(EmployeeDto employeeDto) {
    if (employeeDto == null) {
      return null;
    }
    return new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail(),
        employeeDto.getPhone(),
        employeeDto.getDateOfBirth(),
        employeeDto.getPlaceOfBirth(),
        employeeDto.getPosition(),
        employeeDto.getDepartmentId(),
        employeeDto.getHireDate(),
        employeeDto.getSalary());
  }
}
