package myapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	private Date datedebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	private Date datefin;
	
	private int delai;
	
	/**
	 * clientE est un nom unique
	 * dans toutes mes entities
	 * car je vais utiliser
	 * "mappedBy"
	 * 
	 * REGLE @ManytoOne :  de relation
	 */
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client clientE; //Un lient FK : clé étrangére vers l'entite Client
	
	/**
	 * par mappedBy="empruntLivres"
	 * je récupère automatiquement
	 * les livres empruntés
	 */
	@ManyToMany(mappedBy="empruntLivres")
	private Set<Livre> livresE;


	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
		livresE = new HashSet<Livre>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Client getClientE() {
		return clientE;
	}

	public void setClientE(Client clientE) {
		this.clientE = clientE;
//		clientE.getEmprunts().add(this);
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id=");
		builder.append(id);
		builder.append(", datedebut=");
		builder.append(datedebut.getDay() + " " + datedebut.getMonth() + " " + datedebut.getYear());
		builder.append(", datefin=");
		builder.append(datefin.getDay() + " " + datefin.getMonth() + " " + datefin.getYear());
		builder.append(", delai=");
		builder.append(delai);
		builder.append("]");
		return builder.toString();
	}

	public Set<Livre> getLivresE() {
		return livresE;
	}

	public void setLivresE(Set<Livre> livresE) {
		this.livresE = livresE;
//		if(!this.livresE.isEmpty()) {
//			for(Livre l : livresE) {
//				l.getEmpruntLivres().add(this);
//			}
//		}
	}
	
	

}
