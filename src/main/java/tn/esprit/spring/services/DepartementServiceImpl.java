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
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	DepartementRepository departementRepoistory;
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	@Override
	public Departement addDepartement(Departement departement) {
		
		Departement e_saved = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method addDepartement :");
			e_saved  = departementRepoistory.save(departement); 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("add with Success");
			
		} catch (Exception e) {
			l.error("Out of Method addDepartement with Errors : " + e); 
		}
		return e_saved;
	}

	@Override
	public void deleteDepartementById(int id) {
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method deleteDepartementById :");
			departementRepoistory.deleteById(id); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteDepartementById() : " + e);
			l.error("Out of Method deleteDepartementById with Errors : " + e); 
		}
		
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		
		Departement departementUpdated = null; 
		
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method updateDepartement :");
			departementUpdated = departementRepoistory.save(departement); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in updateDepartement() : " + e);
			l.error("Out of Method updateDepartement with Errors : " + e); 
		}
		
		return departementUpdated; 
	}

	@Override
	public List<Departement> retrieveAllDepartement() {
		List<Departement> departements = null; 
		try {
			
			l.info("In Method retrieveAllUsers :");
			departements = (List<Departement>) departementRepoistory.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Departement departement : departements) {
				l.debug("Departement :" + departement.getName()); 
			} 
			l.info("Out of Method retrieveAllDepartement with Success" + departements.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllDepartement with Errors : " + e); 
		}

		return departements;
	}

	@Override
	public Departement retrieveDepartementById(int id) {
		Departement departement = null; 
		try {
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method retrieveDepartementById :");
			departement =  departementRepoistory.findById(id).get(); 
			// TODO Log à ajouter à la fin de la méthode 
			
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveDepartementById() : " + e);
			l.error("Out of Method retrieveDepartementById with Errors : " + e); 
		}

		return departement; 
	}
}
