package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Job;

public class JobHelper {


	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JobPortal");

	public void insertJob(Job j) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}

	public List<Job> showAllJob() {
		EntityManager em = emfactory.createEntityManager();
		List<Job> allJob = em.createQuery("SELECT i FROM Job i").getResultList();
		return allJob;
	}

	public void deleteItem(Job toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> typedQuery = em.createQuery(
				"select j from Job j where j.title = :selectedTitle",
				Job.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCompany", toDelete.getTitle());
		

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Job result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Job searchForJobById(int jToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Job found = em.find(Job.class, jToEdit);
		em.close();
		return found;
	}

	public void updateJob(Job toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Job> searchForJobByTitle(String company) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> typedQuery = em.createQuery("select j from Job j where j.title = :selectedTitle", Job.class);
		typedQuery.setParameter("selectedCompany", company);

		List<Job> found = typedQuery.getResultList();
		em.close();
		return found;
	}

	
	
	public void cleanUp(){
		emfactory.close();
	}
}