package fr.cavp.ctx.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.cavp.ctx.model.Huissier;
import fr.cavp.ctx.model.Tgi;

@Stateless
public class GestionHuissier {
	@PersistenceContext
	private EntityManager entityManager;
	
	private Query query;

	public void createHuissier(Huissier huissier) {
		entityManager.persist(huissier);
	}

	public Huissier findHuissierById(Long id) {
		return entityManager.find(Huissier.class, id);
	}


	@SuppressWarnings("unchecked")
	public List<Huissier> findHuissierAll() {
		return entityManager.createQuery(
		"select h from Huissier h").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Huissier> findHuissierByTgi(Tgi tgi) {
		query = entityManager.createQuery("select h from Huissier h where h.tgi = :tgi");
		query.setParameter("tgi",tgi);
		
		return query.getResultList();
	}


}
