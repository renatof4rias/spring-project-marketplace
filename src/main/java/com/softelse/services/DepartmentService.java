package com.softelse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softelse.entities.Department;
import com.softelse.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<Department> findAll(){
		return repository.findAll();
	}
	
	public Department findById(Long id) {
		Optional<Department> obj = repository.findById(id);
		return obj.get();
	}
	
}
