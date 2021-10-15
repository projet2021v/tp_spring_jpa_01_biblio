package myapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
		
	private String prenom;
	
	@OneToMany(mappedBy="clientE")
	private Set<Emprunt> emprunts;
	
	public Client() {
		this.emprunts = new HashSet<Emprunt>();
	}

	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.emprunts = new HashSet<Emprunt>();
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	
}
