package fr.cavp.ctx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Mandat
 * 
 */
@Entity
public class Mandat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateCreation; // date de creation du mandat

	@Temporal(TemporalType.DATE)
	private Date dateSignification; // date de signification de la contrainte
	
	private String refHuisssier; // reference du dossier chez l'huissier
	
	private String interlocuteur; // nom de l'interlocuteur au sein de l'�tude huissier
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Huissier huissier;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Contrainte contrainte;
	
	public Mandat() {
		super();
	}
	
	/**
	 * Constructeur avec date de création, huissier et contrainte
	 * @param dateCreation
	 * @param huissier
	 * @param contrainte
	 */
	public Mandat(Date dateCreation, Huissier huissier, Contrainte contrainte) {
		super();
		this.dateCreation = dateCreation;
		this.huissier = huissier;
		this.contrainte = contrainte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateSignification() {
		return dateSignification;
	}

	public void setDateSignification(Date dateSignification) {
		this.dateSignification = dateSignification;
	}

	public String getRefHuisssier() {
		return refHuisssier;
	}

	public void setRefHuisssier(String refHuisssier) {
		this.refHuisssier = refHuisssier;
	}

	public String getInterlocuteur() {
		return interlocuteur;
	}

	public void setInterlocuteur(String interlocuteur) {
		this.interlocuteur = interlocuteur;
	}

	public Huissier getHuissier() {
		return huissier;
	}

	public void setHuissier(Huissier huissier) {
		this.huissier = huissier;
	}

	public void setContrainte(Contrainte contrainte) {
		this.contrainte = contrainte;
	}

	public Contrainte getContrainte() {
		return contrainte;
	}

}
