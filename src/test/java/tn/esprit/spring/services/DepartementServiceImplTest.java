package tn.esprit.spring.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DepartementServiceImplTest {

	

	@Autowired
	IDepartementService dep;
	
	@Test
	@Order(1)
	public void testretrieveAllDepartement() {
	List<Departement> listDepartements= dep.retrieveAllDepartement();
	Assertions.assertEquals(0, listDepartements.size());
	}
	
	@Test
	@Order(2)
	 public void testAddDepartement() throws ParseException {
		Departement d =new Departement ("Departement");
		Departement departementAdded = dep.addDepartement(d);
	 Assertions.assertEquals (d.getName(), departementAdded.getName());

	 }
	 
	 
	@Test
	@Order(3)
		public void testModifyDepartement() throws ParseException  {
		Departement d =new Departement("departement");
		Departement departementUpdated = dep.updateDepartement(d);
			Assertions.assertEquals(d.getName(),departementUpdated.getName());
			
			}
	 
	 
	@Test
	@Order(4)
		public void testRetrieveDepartement() {
		Departement departementRetrived = dep.retrieveDepartementById(1);
	    Assertions.assertEquals(1L, departementRetrived.getId());
			}

		
	@Test
	@Order(5)
		public void testDeleteDepartement() {
		dep.deleteDepartementById(1);
		Assertions.assertNull(dep.retrieveDepartementById(1));
		
		}
}
