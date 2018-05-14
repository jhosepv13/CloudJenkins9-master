package com.bazan.gestion.services;

import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.LoginException;
import com.bazan.gestion.model.Employee;

public interface SecurityService {

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
