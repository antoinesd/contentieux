package fr.cavp.ctx.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.cavp.ctx.model.Contrainte;

@Stateless
public class GestionContrainte {
	@PersistenceContext
	private EntityManager entityManager;
	//private Query query;

	public void createContrainte(Contrainte contrainte) {
		entityManager.persist(contrainte);
	}

	public Contrainte findContrainteById(Long id) {
		return entityManager.find(Contrainte.class, id);
	}


	@SuppressWarnings("unchecked")
	public List<Contrainte> findContrainteAll() {
		return entityManager.createQuery(
		"select c from Contrainte c").getResultList();
	}


	public BigDecimal calculerMtDuTotal(List<Contrainte> contraintes) {
		BigDecimal total = new BigDecimal("0");
		for (Contrainte contrainte : contraintes){
			total = total.add(contrainte.getMontantDu());
		}
		return total;
	}

}
