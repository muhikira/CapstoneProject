package org.muhikira.departmentservice.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.muhikira.departmentservice.Dto.DepartmentDto;
import org.muhikira.departmentservice.service.impl.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

  private DepartmentService departmentService;

  // Build save department REST API
  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
    DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
    DepartmentDto department = departmentService.getDepartmentById(id);
    return ResponseEntity.ok(department);
  }

  @GetMapping
  public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
    return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
  }
}
