package com.javainuse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Empleado;
import com.javainuse.model.EmpleadoDTO;
import com.javainuse.service.EmpleadoDetailsService;

@RestController
public class EmpleadosController {
	
	@Autowired
	private EmpleadoDetailsService empleadoDetailsService;
	
	@GetMapping( "/empleados" )
	public Iterable<Empleado> getEmpleados() {
		return empleadoDetailsService.getAll();
	}
	 
	@GetMapping( "/empleado/{id}" )
	public Optional<Empleado> getEmpleadoById(@PathVariable Long id) {
		
		return empleadoDetailsService.getById(id);
	}
	
	@PostMapping("/empleado" )
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> insertEmpleado(@RequestBody EmpleadoDTO empleado) {
		return ResponseEntity.ok(empleadoDetailsService.save(empleado));
	}

	@PutMapping("/empleado/{id}" )
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public void updateEmpleado(@RequestBody EmpleadoDTO empleado, @PathVariable Long id) {
		empleadoDetailsService.update(empleado, id);
	}
	
	@DeleteMapping("/empleado/{id}" )
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public String updateEmpleado(@PathVariable Long id) {
		empleadoDetailsService.delete(id);
		
		return "Eliminado";
	}
}
