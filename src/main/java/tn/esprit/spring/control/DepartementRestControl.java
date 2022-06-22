package tn.esprit.spring.control;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;


@RestController
public class DepartementRestControl {
	
	@Autowired
	IDepartementService idepartementservice;
	
	 // http://localhost:8082/timesheet-devops/ajouterDepartement
	@PostMapping("/ajouterDepartement")
	 @ResponseBody
    public Departement ajouterDepartement(@RequestBody Departement departement) {
		return idepartementservice.addDepartement(departement);
      //  return departement.getId();
    }
	
	
	// http://localhost:8082/timesheet-devops/deleteEntrepriseById/1
    @DeleteMapping("/deleteDepartementById/{iddepartement}") 
	@ResponseBody 
	public void deleteDepartementById(@PathVariable("identreprise") int departementId)
	{
    	idepartementservice.deleteDepartementById(departementId);
	}
    
    
    
  
    // http://localhost:8082/timesheet-devops/getDepartementById/1
    @GetMapping("/getDepartementById/{iddepartement}")
    @ResponseBody
	public Departement getDepartementById(@PathVariable("iddepartement") int departementId) {

		return idepartementservice.retrieveDepartementById(departementId);
	}
    
    
    
 // http://localhost:8082/timesheet-devops/getAllDepartement
    @GetMapping("/getAllDepartement")
    @ResponseBody
    public List<Departement> getAllDepartement() {

		return idepartementservice.retrieveAllDepartement();
	}
    
  


    
   
}
