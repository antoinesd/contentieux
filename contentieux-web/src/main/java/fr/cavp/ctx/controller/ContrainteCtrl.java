package fr.cavp.ctx.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.cavp.ctx.model.Contrainte;
import fr.cavp.ctx.service.GestionContrainte;

@Named
@SessionScoped
public class ContrainteCtrl implements Serializable{
	
	
	private static final long serialVersionUID = 1890105586410387102L;
	
	@Inject
	private GestionContrainte gestionContrainte;
	private Contrainte contrainte;
	private Contrainte contrainteSelected;
	private Integer dossier;
	private boolean afficher;
	//private int nbContraintes;
	//private BigDecimal mtDuTotal;
	private List<Contrainte> contraintes;

	@PostConstruct
	public void doFindContrainteAll() {
		contraintes = gestionContrainte.findContrainteAll();
		//return "/contrainte/contrainteList";
	}

	public Contrainte getContrainte() {
		return contrainte;
	}

	public void setContrainte(Contrainte contrainte) {
		this.contrainte = contrainte;
	}

	public Integer getDossier() {
		return dossier;
	}

	public void setDossier(Integer dossier) {
		this.dossier = dossier;
	}

	public boolean isAfficher() {
		return afficher;
	}

	public void setAfficher(boolean afficher) {
		this.afficher = afficher;
	}

	public Contrainte getContrainteSelected() {
		return contrainteSelected;
	}

	public void setContrainteSelected(Contrainte contrainteSelected) {
		this.contrainteSelected = contrainteSelected;
	}

	public int getNbContraintes() {
		return contraintes.size();
	}

	
	public BigDecimal getMtDuTotal() {
		return gestionContrainte.calculerMtDuTotal(contraintes);
	}

	public List<Contrainte> getContraintes() {
		return contraintes;
	}

	public void setContraintes(List<Contrainte> contraintes) {
		this.contraintes = contraintes;
	}

}
