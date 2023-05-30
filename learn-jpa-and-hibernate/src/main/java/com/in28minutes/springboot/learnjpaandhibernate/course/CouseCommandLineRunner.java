package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataRepository;

@Component
public class CouseCommandLineRunner implements CommandLineRunner {

	
	@Autowired
	private CourseSpringDataRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Course(1, "Lean AWS Now", "in28minutes"));
		repository.save(new Course(2, "Lean Azure Now", "in28minutes"));
		repository.save(new Course(3, "Lean DevOps Now", "in28minutes"));
		
		repository.deleteById((long) 1);
		
		System.out.println(repository.findById((long) 2));
		System.out.println(repository.findById((long) 3));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Lean DevOps Now"));
		
	}

}
