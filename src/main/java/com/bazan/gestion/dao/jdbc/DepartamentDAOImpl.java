package com.bazan.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bazan.gestion.dao.DepartamentDAO;
import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.mapper.DepartamentMapper;
import com.bazan.gestion.model.Departament;

@Repository
public class DepartamentDAOImpl implements DepartamentDAO{

	private static final Logger logger = LoggerFactory.getLogger(DepartamentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Departament> findAllDepartament() throws DAOException, EmptyResultException {
		
		String query = "SELECT department_id, name, description, city FROM departments";

		try {

			List<Departament> department= jdbcTemplate.query(query, new DepartamentMapper());
			//
			return department;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Departament findDepartament(int department_id) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, description, city"
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { department_id };

		try {

			Departament emp = (Departament) jdbcTemplate.queryForObject(query, params, new DepartamentMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String name, String description, String city) throws DAOException {
		
		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,? )";

		Object[] params = new Object[] { name, description, city};

		Departament emp = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			emp = this.findDepartmentByName(name);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

		
	}

	@Override
	public void delete(String name) throws DAOException {
		
		String query = "DELETE FROM  departments WHERE name= ? ";

		Object[] params = new Object[] { name};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(String name, String description, String city) throws DAOException {
		
		String query = "UPDATE departments SET description = ?, city = ? WHERE name = ? ";

		Object[] params = new Object[] { name, description, city};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
}
		
		
	}
	
	@Override
	public Departament findDepartmentByName(String name) throws DAOException, EmptyResultException {

		String query = "SELECT department_id, name, description, city"
				+ " FROM departments WHERE name = ? ";

		Object[] params = new Object[] { name };

		try {

			Departament department = jdbcTemplate.queryForObject(query, params, new DepartamentMapper());
			//
			return department;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
