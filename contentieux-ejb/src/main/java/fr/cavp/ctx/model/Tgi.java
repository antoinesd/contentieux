package fr.cavp.ctx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Tgi
 * 
 */
@Entity
public class Tgi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nom;

	private String dept;
	
	@OneToMany(mappedBy="tgi",fetch=FetchType.EAGER)
	private List<Huissier> huissiers;
	
	public Tgi() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Huissier> getHuissiers() {
		return huissiers;
	}

	public void setHuissiers(List<Huissier> huissiers) {
		this.huissiers = huissiers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom);
		return builder.toString();
	}

}
