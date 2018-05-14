package com.bazan.gestion.dao;

import java.util.List;

import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.model.Departament;

public interface DepartamentDAO {
	
	List<Departament> findAllDepartament() throws DAOException, EmptyResultException;

	Departament findDepartament(int department_id) throws DAOException, EmptyResultException;

	void create(String name, String description, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String description, String city) throws DAOException;
	
	Departament findDepartmentByName(String name) throws DAOException, EmptyResultException;

	
}
