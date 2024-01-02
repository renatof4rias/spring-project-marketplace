
package com.softelse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softelse.entities.Department;
import com.softelse.entities.Product;
import com.softelse.repositories.DepartmentRepository;
import com.softelse.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	private ProductRepository productReposity;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Department d1 = new Department(null, "Tech");
		Department d2 = new Department(null, "Pet");
		departmentRepository.saveAll(Arrays.asList(d1,d2));
		
		Product p1 = new Product(null, "Macbook Pro", 4000.0);
		Product p2 = new Product(null, "PC Gamer", 5000.0);
		Product p3 = new Product(null, "Pet House", 300.0);
		productReposity.saveAll(Arrays.asList(p1,p2,p3));
		
		p1.setDepartment(d1);
		p2.setDepartment(d1);
		p3.setDepartment(d2);
		
		d1.getProducts().add(p1);
		d1.getProducts().add(p2);
		d2.getProducts().add(p3);
		
		productReposity.saveAll(Arrays.asList(p1,p2, p3));
		departmentRepository.saveAll(Arrays.asList(d1,d2));
	}
	
}