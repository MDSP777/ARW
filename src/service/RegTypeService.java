package service;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.RegistrationType;

@Repository
public class RegTypeService extends JpaService {
	public Collection<RegistrationType> findAllRegTypes(){
		openTransaction();
		try{
			TypedQuery<RegistrationType> q = entityManager.createQuery(
					"SELECT r From RegistrationType r", RegistrationType.class);
			return q.getResultList();
		} finally {
			closeTransaction();
		}
	}
	
	public RegistrationType findBy(String regName){
		openTransaction();
		try{
			TypedQuery<RegistrationType> q = entityManager.createQuery(
					"Select r from RegistrationType r "
					+ "where r.typeName = :name",RegistrationType.class)
					.setParameter("name", regName);
			return q.getSingleResult();
		} finally {
			closeTransaction();
		}
	}
	
	public void add(RegistrationType rt){
		openTransaction();
		try{
			entityManager.merge(rt);
		} finally {
			closeTransaction();
		}
	}
}
