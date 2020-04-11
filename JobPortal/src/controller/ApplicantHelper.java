package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Applicant;

public class ApplicantHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");

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
				"select app from Applicant app where app.fName = :selectedFName and app.lName = :selectedLName",
				Applicant.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFName", toDelete.getfName());
		typedQuery.setParameter("selectedLName", toDelete.getlName());

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

	public List<Applicant> searchForApplicantByLastName(String lastName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Applicant> typedQuery = em.createQuery("select app from Applicant app where app.fName = :selectedLastName", Applicant.class);
		typedQuery.setParameter("selectedName", lastName);

		List<Applicant> foundLastName = typedQuery.getResultList();
		em.close();
		return foundLastName;
	}

	public List<Applicant> searchForItemByEdLevel(String educationLevel) {
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
