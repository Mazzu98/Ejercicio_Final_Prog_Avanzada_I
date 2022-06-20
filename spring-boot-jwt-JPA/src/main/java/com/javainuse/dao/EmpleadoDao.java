package com.javainuse.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Empleado;

@Repository
public interface EmpleadoDao extends CrudRepository<Empleado, Long> {
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE empleados SET name = :name, secondname = :secondname, salary = :salary WHERE id = :id")
	void updateById(@Param("name") String name, @Param("secondname") String secondname, @Param("salary") Integer salary, @Param("id") Long id);
		
}