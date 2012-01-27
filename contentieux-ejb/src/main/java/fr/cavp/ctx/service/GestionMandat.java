package fr.cavp.ctx.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.cavp.ctx.model.Mandat;

@Stateless
public class GestionMandat {
	@PersistenceContext
	private EntityManager entityManager;

	public void createMandat(Mandat mandat) {
		entityManager.persist(mandat);
	}

	public Mandat findMandatById(Long id) {
		return entityManager.find(Mandat.class, id);
	}


	@SuppressWarnings("unchecked")
	public List<Mandat> findMandatAll() {
		return entityManager.createQuery(
		"select h from Mandat h").getResultList();
	}

}
