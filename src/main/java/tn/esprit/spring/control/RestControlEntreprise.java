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

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RestController
public class RestControlEntreprise {
	
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	
	@PostMapping("/ajouterEntreprise")
    public Long ajouterEntreprise(@PathVariable("Entreprise") Entreprise entreprise) {
        ientrepriseservice.addEntreprise(entreprise);
        return entreprise.getId();
    }
	
	
	// http://localhost:8081/timesheet-devops/deleteEntrepriseById/1
    @DeleteMapping("/deleteEntrepriseById/{identreprise}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("identreprise")String entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
	}
    
    
    // http://localhost:8081/timesheet-devops/getEntrepriseById/1
    @GetMapping(value = "getEntrepriseById/{identreprise}")
    @ResponseBody
	public Entreprise getEntrepriseById(@PathVariable("identreprise") String entrepriseId) {

		return ientrepriseservice.retrieveEntrepriseById(entrepriseId);
	}

}
