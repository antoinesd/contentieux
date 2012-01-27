package fr.cavp.ctx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Huissier
 * 
 */
@Entity
public class Huissier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nom;

	// tribunal de grande instance
	@ManyToOne
	private Tgi tgi;

	// mandats affectés à l'huissier
	@OneToMany(mappedBy="huissier")
	private List<Mandat> mandats = new ArrayList<Mandat>();
	
	public Huissier() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Tgi getTgi() {
		return tgi;
	}

	public void setTgi(Tgi tgi) {
		this.tgi = tgi;
	}

	public void setMandats(List<Mandat> mandats) {
		this.mandats = mandats;
	}

	public List<Mandat> getMandats() {
		return mandats;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		return builder.toString();
	}

}
