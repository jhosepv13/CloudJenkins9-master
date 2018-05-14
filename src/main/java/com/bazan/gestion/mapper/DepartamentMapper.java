package com.bazan.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bazan.gestion.model.Departament;


public class DepartamentMapper implements RowMapper<Departament>{

	public Departament mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departament emp = new Departament();
		emp.setName(rs.getString("name"));
		emp.setDescription(rs.getString("description"));
		emp.setCity(rs.getString("city"));
		return emp;
	}
	
}
