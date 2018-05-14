package com.bazan.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bazan.gestion.dao.DepartamentDAO;
import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.model.Departament;

public class DepartamentServiceImpl implements DepartamentService {

	@Autowired
	private DepartamentDAO departmentDAO;
	
	@Override
	public Departament find(int department_id) throws DAOException, EmptyResultException {
		
		Departament emp = departmentDAO.findDepartament(department_id);

		return emp;
		
	}

	@Override
	public List<Departament> findAll() throws DAOException, EmptyResultException {
		
		List<Departament> emps = departmentDAO.findAllDepartament();
		return emps;
		
	}
	
}
