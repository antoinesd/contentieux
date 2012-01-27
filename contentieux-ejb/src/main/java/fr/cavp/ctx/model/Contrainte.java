package fr.cavp.ctx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Contrainte
 * 
 */
@Entity
public class Contrainte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Integer dossier;
	private String periode;
	@Temporal(TemporalType.DATE)
	private Date dateEmission;
	@Column(columnDefinition="DECIMAL(9,2)")
	private BigDecimal montantDu = new BigDecimal(0);
	
	@OneToOne(mappedBy="contrainte")
	private Mandat mandat;
	
	public Contrainte() {
		super();
	}

	/**
	 * Teste si la contrainte est mandatée.
	 * @return true si la contrainte est mandatée
	 */
	public boolean isMandate(){
		if (getMandat()!=null){
			return true;
		}
		return false;		
	}
	
	public Integer getDossier() {
		return dossier;
	}

	public void setDossier(Integer dossier) {
		this.dossier = dossier;
	}

	public String getPeriode() {
		return this.periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public BigDecimal getMontantDu() {
		return montantDu;
	}

	public void setMontantDu(BigDecimal montantDu) {
		this.montantDu = montantDu;
	}

	public void setMandat(Mandat mandat) {
		this.mandat = mandat;
	}

	public Mandat getMandat() {
		return mandat;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contrainte [dossier=" + dossier + ", periode=" + periode
				+ ", dateEmission=" + dateEmission
				+ ", montantDu=" + montantDu + "]";
	}
	
	
}
