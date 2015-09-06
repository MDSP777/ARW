package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import model.Registrant;
import model.RegistrationType;

@Repository
public class RegistrationService extends JpaService {
	
	public void register(Registrant r){
		openTransaction();
		try{
			validate(r);
			entityManager.persist(r);
		} finally {
			closeTransaction();
		}
	}
	
	private void validate(Registrant r){
		TypedQuery<Registrant> q = entityManager.createQuery(
			"Select r from Registrant r order by r.surname, r.firstName, r.middleName", Registrant.class);
		List<Registrant> registrants = q.getResultList();
		for(Registrant entry: registrants){
			if(r.hasIdenticalNameWith(entry)){
				throw new DataAccessException
				("Error during registration, a registrant with the same name already exists.") {
					private static final long serialVersionUID = 1L;
				};
			}
		}
	}
	
	public Collection<Registrant> getRegistrants(){
		openTransaction();
		try{
			TypedQuery<Registrant> q = entityManager.createQuery(
					"Select r from Registrant r order by r.surname, r.firstName, r.middleName", Registrant.class);
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
