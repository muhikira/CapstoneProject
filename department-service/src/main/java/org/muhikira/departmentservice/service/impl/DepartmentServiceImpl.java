package org.muhikira.departmentservice.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.muhikira.departmentservice.Dto.DepartmentDto;
import org.muhikira.departmentservice.Mapper.DepartmentMapper;
import org.muhikira.departmentservice.entity.Department;
import org.muhikira.departmentservice.exception.DepartmentNotFoundException;
import org.muhikira.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId){
      return departmentRepository.findById(departmentId)
          .map(DepartmentMapper::mapToDepartmentDto)  // Map to DTO if present
          .orElseThrow(() -> new DepartmentNotFoundException("Department not found with ID: " + departmentId));
    }

    @Override
    public List<DepartmentDto> getAllDepartments(){
      return departmentRepository.findAll().stream()
          .map(DepartmentMapper::mapToDepartmentDto)
          .toList();

    }
}