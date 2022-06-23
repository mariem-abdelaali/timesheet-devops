package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	
	Entreprise addEntreprise(Entreprise entreprise);
	void deleteEntrepriseById(int id);
	Entreprise updateEntreprise(Entreprise entreprise);
	List<Entreprise> retrieveAllEntreprise(); 
	Entreprise retrieveEntrepriseById(int id);
	public int ajouterDepartement(Departement dep);
	public void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);	
	//public boolean deleteDepartementById(int depId);
}
