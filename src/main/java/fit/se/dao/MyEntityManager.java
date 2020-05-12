package fit.se.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	
	private EntityManager em;
	private static MyEntityManager instance;
	
	private MyEntityManager() {
		em = Persistence.createEntityManagerFactory("Bai06Servlet").createEntityManager();
	}
	
	public synchronized static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

}
