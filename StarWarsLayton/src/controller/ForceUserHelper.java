package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ForceUser;

/**  
* Taylor Layton - tglayton
* CIS171 22149
* Sep 13, 2023
* Windows 10 
*/
public class ForceUserHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StarWars");

	public void insertCharacter(ForceUser user) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public ForceUser searchForCharacterByName(String name) {
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<ForceUser> typedQuery = em.createQuery("select u from ForceUser u where u.name = :selectedName", ForceUser.class);
	    typedQuery.setParameter("selectedName", name);
	    typedQuery.setMaxResults(1);

	    ForceUser found;
	    try {
	        found = typedQuery.getSingleResult();
	    } catch (Exception e) {
	        found = null;
	    }

	    em.close();
	    return found;
	}
	
	public List<ForceUser> showAllForceUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<ForceUser> allCharacters = em.createQuery("SELECT u FROM ForceUser u").getResultList();
		return allCharacters;
	}

	public void deleteCharacter(ForceUser character) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ForceUser> typedQuery = em.createQuery("select u from ForceUser u where u.name = :selectedName", ForceUser.class);
		typedQuery.setParameter("selectedName", character.getName());
		typedQuery.setMaxResults(1);
		ForceUser result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ForceUser searchForCharacterById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ForceUser found = em.find(ForceUser.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCharacter(ForceUser toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}
}