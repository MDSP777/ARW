package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Registrant;
import model.RegistrationType;

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
	
	public double calculateTotalRevenue(){
		openTransaction();
		try{
			double total = 0;
			TypedQuery<Registrant> q = entityManager.createQuery("SELECT r FROM Registrant r", Registrant.class);
			TypedQuery<RegistrationType> q2 = entityManager.createQuery("SELECT r FROM RegistrationType r", RegistrationType.class);
			Collection<Registrant> registrants = q.getResultList();
			Collection<RegistrationType> rtype = q2.getResultList();
			Map<String, Double> rTypes = convertToMap(rtype);
			for(Registrant r: registrants){
				total+=rTypes.get(r.getMembershipType().getTypeName());
			}
			return total;
		} finally {
			closeTransaction();
		}
	}

	private Map<String, Double> convertToMap(Collection<RegistrationType> rtype) {
		Map<String, Double> rTypes = new HashMap<>();
		for(RegistrationType r: rtype){
			rTypes.put(r.getTypeName(), r.getAmount());
		}
		return rTypes;
	}
	
	 
}
