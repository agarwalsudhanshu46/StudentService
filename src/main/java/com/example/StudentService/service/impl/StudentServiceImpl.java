package com.example.StudentService.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentService.repository.StudentRepository;
import com.example.StudentService.service.StudentService;
import com.example.sid.pdfGenratorDemo.dto.response.Student;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;



	private Student map(com.example.StudentService.entity.Student StudentEntity) {
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
		.setFieldAccessLevel(Configuration.AccessLevel.PACKAGE_PRIVATE)
		.setMethodAccessLevel(Configuration.AccessLevel.PACKAGE_PRIVATE);
		Student student = modelMapper.map(StudentEntity, Student.class);
		return student;

	}



	public List<Student> getStudents() {
		List<com.example.StudentService.entity.Student> students = studentRepository.findAll();
		List<Student> StudentDtos = students.stream().map(entity -> map(entity)).collect(Collectors.toList());
		return StudentDtos;
	}
	
	
	

}
