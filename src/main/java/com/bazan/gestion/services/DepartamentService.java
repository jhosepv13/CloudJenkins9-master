package com.bazan.gestion.services;

import java.util.List;

import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.model.Departament;

public interface DepartamentService {

	Departament find(int department_id) throws DAOException, EmptyResultException;

	List<Departament> findAll() throws DAOException, EmptyResultException;
	
}
