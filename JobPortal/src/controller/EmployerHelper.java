package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Employer;

public class EmployerHelper {

	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JobPortal");

	public void insertEmployer(Employer emp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}

	public List<Employer> showAllEmployer() {
		EntityManager em = emfactory.createEntityManager();
		List<Employer> allEmployer = em.createQuery("SELECT i FROM Employer i").getResultList();
		return allEmployer;
	}

	public void deleteItem(Employer toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employer> typedQuery = em.createQuery(
				"select emp from Employer emp where emp.company = :selectedCompany",
				Employer.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCompany", toDelete.getCompany());
		

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Employer result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Employer searchForEmployerById(int empToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employer found = em.find(Employer.class, empToEdit);
		em.close();
		return found;
	}

	public void updateEmployer(Employer toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Employer> searchForEmployerByCompany(String company) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employer> typedQuery = em.createQuery("select emp from Employer emp where emp.company = :selectedCompany", Employer.class);
		typedQuery.setParameter("selectedCompany", company);

		List<Employer> found = typedQuery.getResultList();
		em.close();
		return found;
	}

	
	
	public void cleanUp(){
		emfactory.close();
	}
}
	
