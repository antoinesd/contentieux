package fr.cavp.ctx.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.cavp.ctx.model.Tgi;

@Stateless
public class GestionTgi {
	@PersistenceContext
	private EntityManager entityManager;

	private Query query;

	public void createTgi(Tgi tgi) {
		entityManager.persist(tgi);
	}

	public Tgi findTgiById(Long id) {
		return entityManager.find(Tgi.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tgi> findTgiAll() {
		return entityManager.createQuery("select t from Tgi t").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Tgi> findTgiByDept(String dept) {
		query = entityManager
				.createQuery("select t from Tgi t where t.dept = :dept");
		query.setParameter("dept", dept);

		return query.getResultList();

	}

}
