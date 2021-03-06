package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Applicant;

public class ApplicantHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JobPortal");

	public void insertApplicant(Applicant app) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(app);
		em.getTransaction().commit();
		em.close();
	}

	public List<Applicant> showAllApplicants() {
		EntityManager em = emfactory.createEntityManager();
		List<Applicant> allApplicants = em.createQuery("SELECT i FROM Applicant i").getResultList();
		return allApplicants;
	}

	public void deleteItem(Applicant toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Applicant> typedQuery = em.createQuery(
				"select app from Applicant app where app.username = :selectedUsername",
				Applicant.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedUsername", toDelete.getUsername());
		

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Applicant result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Applicant searchForApplicantById(int appToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Applicant found = em.find(Applicant.class, appToEdit);
		em.close();
		return found;
	}

	public void updateApplicant(Applicant toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public Applicant searchForApplicantByUsername(String username) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Applicant> typedQuery = em.createQuery("select app from Applicant app where app.username = :selectedUsername", Applicant.class);
		typedQuery.setParameter("selectedUsername", username);
		
		typedQuery.setMaxResults(1);			
			
		Applicant found;
		
		try {
		found = typedQuery.getSingleResult();
		}
		catch(Exception e) {
			found = new Applicant("e", "e", "e", "e");
		}
		em.close();
		
		return found;
	}

	public List<Applicant> searchForApplicantByEdLevel(String educationLevel) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Applicant> typedQuery = em.createQuery("select app from Applicant app where app.educationLevel = :selectedEdLevel", Applicant.class);
		typedQuery.setParameter("selectedEdLevel", educationLevel);

		List<Applicant> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
