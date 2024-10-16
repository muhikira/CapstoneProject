package org.muhikira.departmentservice.service.impl;

import java.util.List;
import org.muhikira.departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();
}
