package com.bazan.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bazan.gestion.dao.DepartamentDAO;
import com.bazan.gestion.exception.DAOException;
import com.bazan.gestion.exception.EmptyResultException;
import com.bazan.gestion.model.Departament;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DepartamentsDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(DepartamentsDAOTest.class);
	
	@Autowired
	private DepartamentDAO departamentDAO;
	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	

		
	@Test
	public void testFindDepartmentById() {

		try {
			//
			Departament emp = departamentDAO.findDepartament(50);

			Assert.assertNotNull(emp);

			Assert.assertEquals("Prueba2", emp.getName());
			Assert.assertEquals(":3", emp.getDescription());
			Assert.assertEquals("Miau x2", emp.getCity());

			logger.info(emp.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testFindAllDepartment() {

		try {
			//
			List<Departament> emps = departamentDAO.findAllDepartament();

			//Assert.assertEquals(emps.size(), 4);

			logger.info(emps.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

		
	}


	
	@Test
	public void testCreateEmployee() {

		logger.info("--");
		
		String NAME = "GUERRA3";
		//logger.info(LOGIN);
		String DESC = "GUERRA3";
		String CITY = "JOSE3";

		try {
			//
			departamentDAO.create(NAME, DESC, CITY);

			//
			Departament emp = departamentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(NAME, emp.getName());
			Assert.assertEquals(DESC, emp.getDescription());
			Assert.assertEquals(CITY, emp.getCity());
			
		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	
	/*@Test
	public void testUpdateDepartment() {

		String NAME = "RONALD2";
		//logger.info(LOGIN);
		String DESC = "MIYA2";
		String CITY = "JUNIN2";
	
		//logger.info(LOGIN);
		String UPDESC = "DE_LA_CRUZ";
		String UPCITY = "LIMA";
		
		try {
			//
			departamentDAO.create(NAME, DESC, CITY);
			//
			departamentDAO.update(NAME, UPDESC, UPCITY);
			//
			Departament emp = departamentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(UPDESC, emp.getDescription());
			Assert.assertEquals(UPCITY, emp.getCity());
			
		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}*/
	
	
	@Test
	public void testDeleteDepartment() {

		String LOGIN = "jromero";
		String PWD = "123";
		String FIRSTNAME = "Juan";

		try {
			//
			departamentDAO.create(LOGIN, PWD, FIRSTNAME );

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {

			departamentDAO.delete(LOGIN);

			departamentDAO.findDepartmentByName(LOGIN);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}
	
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
	

}
