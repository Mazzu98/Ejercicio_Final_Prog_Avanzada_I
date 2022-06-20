package com.javainuse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.EmpleadoDao;
import com.javainuse.model.Empleado;
import com.javainuse.model.EmpleadoDTO;

@Service
public class EmpleadoDetailsService {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	public Empleado save(EmpleadoDTO empleado) {
		Empleado newEmpleado = new Empleado();
		newEmpleado.setName(empleado.getName());
		newEmpleado.setSecondname(empleado.getSecondname());
		newEmpleado.setSalary(empleado.getSalary());
		return empleadoDao.save(newEmpleado);
	}
	
	public void update(EmpleadoDTO empleado, long id) {
				
		empleadoDao.updateById(empleado.getName(), empleado.getSecondname(), empleado.getSalary(), id);
	}
	
	public Iterable<Empleado> getAll() {
		return empleadoDao.findAll();
	}
	
	public Optional<Empleado> getById(Long id) {
		return empleadoDao.findById(id);
	}
	
	public void delete(Long id) {
		empleadoDao.deleteById(id);
	}
}
