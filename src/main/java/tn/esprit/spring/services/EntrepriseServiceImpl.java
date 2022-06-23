package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	
	@Autowired
	DepartementRepository departementRepository;
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		
		Entreprise e_saved = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method addEntreprise :");
			e_saved  = entrepriseRepoistory.save(entreprise); 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("add with Success");
			
		} catch (Exception e) {
			l.error("Out of Method addEntreprise with Errors : " + e); 
		}
		return e_saved;
	}

	@Override
	public void deleteEntrepriseById(int id) {
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method deleteEntrepriseById :");
			entrepriseRepoistory.deleteById(id); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteEntrepriseById() : " + e);
			l.error("Out of Method deleteEntrepriseById with Errors : " + e); 
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		
		Entreprise entrepriseUpdated = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method updateEntreprise :");
			entrepriseUpdated = entrepriseRepoistory.save(entreprise); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in updateEntreprise() : " + e);
			l.error("Out of Method updateEntreprise with Errors : " + e); 
		}
		
		return entrepriseUpdated; 
	}

	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
			
			l.info("In Method retrieveAllUsers :");
			entreprises = (List<Entreprise>) entrepriseRepoistory.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Entreprise entreprise : entreprises) {
				l.debug("Entreprise :" + entreprise.getName()); 
			} 
			l.info("Out of Method retrieveAllEntreprise with Success" + entreprises.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprise with Errors : " + e); 
		}

		return entreprises;
	}

	@Override
	public Entreprise retrieveEntrepriseById(int id) {
		Entreprise entreprise = null; 
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method retrieveEntrepriseById :");
			entreprise =  entrepriseRepoistory.findById(id).get(); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveEntrepriseById() : " + e);
			l.error("Out of Method retrieveEntrepriseById with Errors : " + e); 
		}

		return entreprise; 
	}
	
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entreprise = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> departementNames = new ArrayList<>();
		for(Departement dep : entreprise.getDepartements()){
			departementNames.add(dep.getName());
		}
		
		return departementNames;
	}
	
	
	public int ajouterDepartement(Departement dep) {
		departementRepository.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Entreprise entreprise = entrepriseRepoistory.findById(entrepriseId).get();
				Departement departement = departementRepository.findById(depId).get();
				
				departement.setEntreprise(entreprise);
				departementRepository.save(departement);
		
	}
}
