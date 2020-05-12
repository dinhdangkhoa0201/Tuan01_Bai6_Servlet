package fit.se.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.types.ObjectId;

import fit.se.entities.Person;

public class PersonDAO {
	private EntityManager em = null;

	public PersonDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public boolean insert(Person p) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean delete(Person p) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Person.class, p.getId()));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean update(Person p) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {
		return em.createNamedQuery("getAll").getResultList();
	}
	
	public Person getPerson(ObjectId id) {
		return em.find(Person.class, id);
	}
}