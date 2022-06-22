package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	
	
	Departement addDepartement(Departement departement);
	void deleteDepartementById(int id);
	Departement updateDepartement(Departement departement);
	List<Departement> retrieveAllDepartement(); 
	Departement retrieveDepartementById(int id);
}