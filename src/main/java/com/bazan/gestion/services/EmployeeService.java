package com.bazan.gestion.services;

import java.util.List;

import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.model.Employee;

public interface EmployeeService {

	Employee find(int employee_id) throws DAOException, EmptyResultException;

	List<Employee> findAll() throws DAOException, EmptyResultException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException;
}
