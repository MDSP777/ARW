package service;

import java.util.Collection;
import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Registrant;

@Repository
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
			TypedQuery<Registrant> q = entityManager.createQuery(
					"Select r from Registrant r", Registrant.class);
			List<Registrant> resultList = q.getResultList();
			return resultList;
		} finally {
			closeTransaction();
		}
	}
	
	 
}
