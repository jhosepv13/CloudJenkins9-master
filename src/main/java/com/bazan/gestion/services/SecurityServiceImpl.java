package com.bazan.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazan.gestion.dao.EmployeeDAO;
import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.LoginException;
import com.bazan.gestion.model.Employee;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee validate(String login, String password) throws LoginException, DAOException {

		Employee emp = employeeDAO.validate(login, password);

		return emp;
	}

}
