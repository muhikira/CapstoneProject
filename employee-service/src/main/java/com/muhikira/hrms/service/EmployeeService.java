package com.muhikira.hrms.service;

import com.muhikira.hrms.dto.DepartmentDto;
import com.muhikira.hrms.dto.EmployeeDto;
import com.muhikira.hrms.exception.DepartmentNotFoundException;
import com.muhikira.hrms.mapper.EmployeeMapper;
import com.muhikira.hrms.model.Employee;
import com.muhikira.hrms.repository.EmployeeRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final DepartmentServiceClient departmentServiceClient;

  public EmployeeDto createEmployee(Employee employee) {
    departmentServiceClient
        .getDepartmentById(employee.getDepartmentId())
        .onErrorResume(
            e -> {
              throw new DepartmentNotFoundException(
                  "Department not found for ID: " + employee.getDepartmentId());
            })
        .block();

    // If department is not found, an exception is thrown.
    // If it exists, save the employee with the departmentId.
    Employee savedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.toDto(savedEmployee);
  }

  public List<EmployeeDto> getAllEmployees() {
    return employeeRepository.findAll().stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public Optional<EmployeeDto> getEmployeeById(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);

    return employee.map(emp -> {
      DepartmentDto departmentDto = departmentServiceClient.getDepartmentById(emp.getDepartmentId()).block();

      if (departmentDto != null) {
        emp.setDepartmentId(departmentDto.getId());
      }
      return EmployeeMapper.toDto(emp);
    });
  }

  public List<EmployeeDto> getEmployeesByFirstName(String firstName) {
    return employeeRepository.findByFirstName(firstName).stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public List<EmployeeDto> getEmployeesByLastName(String lastName) {
    return employeeRepository.findByLastName(lastName).stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public List<EmployeeDto> getEmployeesByDepartmentId(Long departmentId) {
    return employeeRepository.findByDepartmentId(departmentId).stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public List<EmployeeDto> getEmployeesBySalary(BigDecimal salary) {
    return employeeRepository.findBySalaryGreaterThanEqual(salary).stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public List<EmployeeDto> getEmployeesByAge(int age) {
    return employeeRepository.findByAge(age).stream()
        .map(EmployeeMapper::toDto)
        .toList();
  }

  public EmployeeDto updateEmployee(Long id, Employee employeeDetails) {
    Employee employee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

    employee.setFirstName(employeeDetails.getFirstName());
    employee.setLastName(employeeDetails.getLastName());
    employee.setEmail(employeeDetails.getEmail());
    employee.setPhone(employeeDetails.getPhone());
    employee.setDateOfBirth(employeeDetails.getDateOfBirth());
    employee.setPlaceOfBirth(employeeDetails.getPlaceOfBirth());
    employee.setPosition(employeeDetails.getPosition());
    employee.setDepartmentId(employeeDetails.getDepartmentId());
    employee.setHireDate(employeeDetails.getHireDate());
    employee.setSalary(employeeDetails.getSalary());

    Employee employee1 = employeeRepository.save(employee);
    return EmployeeMapper.toDto(employee1);
  }

  public void deleteEmployee(Long id) {
    Employee employee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    employeeRepository.delete(employee);
  }
}
