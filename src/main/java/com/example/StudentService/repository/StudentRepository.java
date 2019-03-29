package com.example.StudentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentService.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
