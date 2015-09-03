package service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Registrant;

public class RegistrationService extends JpaService {
	
	public RegistrationService(){
		entityManagerFactory = Persistence.createEntityManagerFactory("arw");
	}
	
	public void register(Registrant r){
		openTransaction();
		try{
			entityManager.persist(r);
		} finally {
			closeTransaction();
		}
	}
	
	public Collection<Registrant> getRegistrants(){
		openTransaction();
		try{
			Query q = entityManager.createQuery("Select r from Registrant r");
			List<Registrant> resultList = q.getResultList();
			return resultList;
		} finally {
			closeTransaction();
		}
	}
	
	 
}
