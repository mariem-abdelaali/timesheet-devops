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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RestController
public class RestControlEntreprise {
	
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	 // http://localhost:6080/ajouterEntreprise
	@PostMapping("/ajouterEntreprise")
	 @ResponseBody
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
		return ientrepriseservice.addEntreprise(entreprise);
        //return entreprise.getId();
    }
	
	
	// http://localhost:6080/deleteEntrepriseById/{identreprise}
	
    @DeleteMapping("/deleteEntrepriseById/{identreprise}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("identreprise") int entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
	}
    
    
    
  
    // http://localhost:6080/getEntrepriseById/{identreprise}
    @GetMapping("/getEntrepriseById/{identreprise}")
    @ResponseBody
	public Entreprise getEntrepriseById(@PathVariable("identreprise") int entrepriseId) {

		return ientrepriseservice.retrieveEntrepriseById(entrepriseId);
	}
    
    
    
 // http://localhost:6080/getAllEntreprise
    @GetMapping("/getAllEntreprise")
    @ResponseBody
    public List<Entreprise> getAllEntreprise() {

		return ientrepriseservice.retrieveAllEntreprise();
	}
    
  

	// http://localhost:6080/affecterDepartementAEntreprise/1/1
    @PutMapping(value = "/affecterDepartementAEntreprise/{iddept}/{identreprise}") 
	public void affecterDepartementAEntreprise(@PathVariable("iddept")int depId, @PathVariable("identreprise")int entrepriseId) {
		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
	}
    
   
	 // http://localhost:6080/getAllDepartementsNamesByEntreprise/1
    @GetMapping(value = "getAllDepartementsNamesByEntreprise/{identreprise}")
    @ResponseBody
	public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("identreprise") int entrepriseId) {
		return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
	}
}
