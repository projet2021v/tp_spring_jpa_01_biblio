package myapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "auteur", length = 50,nullable = false)
	private String auteur;
	
	@Column(name = "titre", length = 255,nullable = false)
	private String titre;
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="id_liv", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_emp", referencedColumnName="id"))
	private Set<Emprunt> empruntLivres;
	
	public Livre() {
		empruntLivres = new HashSet<Emprunt>();
	}
		
	public Livre(String auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
		empruntLivres = new HashSet<Emprunt>();
	}

	public int getId() {
		return id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Emprunt> getEmpruntLivres() {
		return empruntLivres;
	}
	
	public void setEmpruntLivres(Set<Emprunt> empruntLivres) {
		this.empruntLivres = empruntLivres;
	}
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", auteur=" + auteur + ", titre=" + titre + "]";
	}
	
}
