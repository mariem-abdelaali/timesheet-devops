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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {

	/*

	@Autowired
	IEntrepriseService entr;
	
	@Test
	@Order(1)
	public void testretrieveAllEntreprise() {
	List<Entreprise> listEntreprises = entr.retrieveAllEntreprise();
	Assertions.assertEquals(0, listEntreprises.size());
	}
	
	@Test
	@Order(2)
	 public void testAddEntreprise() throws ParseException {
	 Entreprise e =new Entreprise("Google", "Google");
	 Entreprise entrepriseAdded = entr.addEntreprise(e);
	 Assertions.assertEquals (e.getName(), entrepriseAdded.getName());

	 }
	 
	 
	@Test
	@Order(3)
		public void testModifyEntreprise() throws ParseException  {
		 Entreprise e =new Entreprise("Meta", "Meta");
		 Entreprise entrepriseUpdated = entr.updateEntreprise(e);
			Assertions.assertEquals(e.getName(),entrepriseUpdated.getName());
			
			}
	 
	 
	@Test
	@Order(4)
		public void testRetrieveEntreprise() {
		Entreprise entrepriseRetrived = entr.retrieveEntrepriseById("1");
	    Assertions.assertEquals(1L, entrepriseRetrived.getId());
			}

		
	@Test
	@Order(5)
		public void testDeleteEntreprise() {
		entr.deleteEntrepriseById("1");
		Assertions.assertNull(entr.retrieveEntrepriseById("1"));
		
		}*/
}
