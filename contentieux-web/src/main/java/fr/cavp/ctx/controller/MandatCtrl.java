package fr.cavp.ctx.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.cavp.ctx.model.Contrainte;
import fr.cavp.ctx.model.Huissier;
import fr.cavp.ctx.model.Mandat;
import fr.cavp.ctx.model.Tgi;
import fr.cavp.ctx.service.GestionHuissier;
import fr.cavp.ctx.service.GestionMandat;
import fr.cavp.ctx.service.GestionTgi;

@Named
@SessionScoped
public class MandatCtrl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4235320680544513481L;

	@Inject
	GestionHuissier gestionHuissier;

	@Inject
	GestionMandat gestionMandat;

	@Inject
	GestionTgi gestionTgi;

	private Contrainte contrainte;
	private Huissier huissierSelected; // huissier affecté au mandat
	private List<Tgi> tgis;
	private Tgi tgiSelected;

	private Date dateCreation;

	// public void doFindHuissiers(ValueChangeEvent event) {
	// tgiId = (Long) event.getNewValue();
	// findHuissiers();
	// }

	private void findTgis() {
		tgis = gestionTgi.findTgiAll();
		tgiSelected = tgis.get(0);
	}
	
	public String doCreateMandat() {
		Mandat mandat = new Mandat(dateCreation, huissierSelected, contrainte);
		gestionMandat.createMandat(mandat);
		return "mandat.create";
	}
	
	public String doInitMandat() {
			dateCreation = new Date();
			findTgis();
			return "mandat.create";
	}
	

	public Contrainte getContrainte() {
		return contrainte;
	}

	public void setContrainte(Contrainte contrainte) {
		this.contrainte = contrainte;
	}

	public Huissier getHuissierSelected() {
		return huissierSelected;
	}

	public void setHuissierSelected(Huissier huissier) {
		this.huissierSelected = huissier;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Tgi> getTgis() {
		return tgis;
	}

	public void setTgis(List<Tgi> tgis) {
		this.tgis = tgis;
	}

	public Tgi getTgi() {
		return tgiSelected;
	}

	public void setTgi(Tgi tgi) {
		this.tgiSelected = tgi;
	}

	public Tgi getTgiSelected() {
		return tgiSelected;
	}

	public void setTgiSelected(Tgi tgiSelected) {
		this.tgiSelected = tgiSelected;
	}


}
