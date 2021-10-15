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
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client clientE;
	
	@ManyToMany(mappedBy="empruntLivres")
	private Set<Livre> livresE;

	public Emprunt() {
		this.livresE = new HashSet<Livre>();
	}

	public Emprunt(Date datedebut, Date datefin, int delai) {
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.delai = delai;
		this.livresE = new HashSet<Livre>();
	}

	public int getId() {
		return id;
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
	}

	public Set<Livre> getLivresE() {
		return livresE;
	}
	
	public void setLivresE(Set<Livre> livresE) {
		this.livresE = livresE;
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
}
