package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	
	Entreprise addEntreprise(Entreprise entreprise);
	void deleteEntrepriseById(String id);
	Entreprise updateEntreprise(Entreprise entreprise);
	List<Entreprise> retrieveAllEntreprise(); 
	Entreprise retrieveEntrepriseById(String id);
}
