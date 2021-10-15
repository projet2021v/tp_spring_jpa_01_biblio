package myapp;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.entities.Client;
import myapp.entities.Emprunt;
import myapp.entities.Livre;
import myapp.services.ICrud;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpringJpa {
	
	@Autowired
	@Qualifier("daoClient")
	ICrud<Client> daoC;
	
	@Autowired
	@Qualifier("daoLivre")
	ICrud<Livre> daoL;
	
	@Autowired
	@Qualifier("daoEmprunt")
	ICrud<Emprunt> daoE;
	
	@Before
	public void beforeEachTest() {
		System.out.println("===========================================");
	}
	
	////////////////////////////////////CLIENTS
	
	@Test
	public void t01AddClient() {
		Client c = new Client();
		c.setNom("LB");
		c.setPrenom("Ben");
		daoC.add(c);
		
		Client c2 = new Client();
		c2.setNom("LB");
		c2.setPrenom("Vince");
		daoC.add(c2);
	}
	
	@Test
	public void t02SelectAllClients() {
		List<Client> liste = daoC.selectAll();
		for(Client i : liste ) {
			System.out.println(i.toString());
		}
	}
	
	@Test
	public void t03UpdateClient() {
		Client c = daoC.selectOne(1);
		c.setPrenom("Marc");
		daoC.update(c);
		List<Client> liste = daoC.selectAll();
		for(Client i : liste ) {
			System.out.println(i.toString());
		}
	}
	
	@Test
	public void t04DeleteClient() {
		Client c = daoC.selectOne(1);
		daoC.delete(c);
		Client c2 = daoC.selectOne(2);
		daoC.delete(c2);
		List<Client> liste = daoC.selectAll();
		for(Client i : liste ) {
			System.out.println(i.toString());
		}
	}
	
	////////////////////////////////////LIVRES
	
	@Test
	public void t05AddLivre() {
		Livre l = new Livre();
		l.setAuteur("Jules Verne");
		l.setTitre("Voyage au centre de la Terre");
		daoL.add(l);
		
		Livre l2 = new Livre();
		l2.setAuteur("William Gibson");
		l2.setTitre("Neuromancien");
		daoL.add(l2);
	}
	
	@Test
	public void t06SelectAllLivres() {
		List<Livre> liste = daoL.selectAll();
		for(Livre i : liste) {
			System.out.println(i.toString());
		}
	}
	
	@Test
	public void t07UpdateLivre() {
		Livre l = daoL.selectOne(1);
		l.setTitre("Vingt mille lieux sous les mers");
		daoL.update(l);
		List<Livre> liste = daoL.selectAll();
		for(Livre i : liste) {
			System.out.println(i.toString());
		}
	}
	
	@Test
	public void t08DeleteLivre() {
		Livre l = daoL.selectOne(1);
		daoL.delete(l);
		Livre l2 = daoL.selectOne(2);
		daoL.delete(l2);
		List<Livre> liste = daoL.selectAll();
		for(Livre i : liste) {
			System.out.println(i.toString());
		}
	}
	
	////////////////////////////////////EMPRUNTS
	
	@Test
	public void t09AddEmprunt() {
		Emprunt e = new Emprunt();
		e.setDatedebut(new Date(2000, 01, 01));
		e.setDatefin(new Date(2030, 01, 01));
		e.setDelai(5);
		daoE.add(e);
		
		Emprunt e2 = new Emprunt();
		e2.setDatedebut(new Date(2000, 01, 01));
		e2.setDatefin(new Date(2040, 01, 01));
		e2.setDelai(5);
		daoE.add(e2);
	}
	
	@Test
	public void t10SelectAllEmprunts() {
		List<Emprunt> liste = daoE.selectAll();
		for(Emprunt i : liste) {
			System.out.println(i.toString());
		}
	}
	
	@Test
	public void t11UpdateEmprunt() {
		Emprunt e = daoE.selectOne(1);
		e.setDatedebut(new Date(2010, 01, 01));
		daoE.update(e);
		List<Emprunt> liste = daoE.selectAll();
		for(Emprunt i : liste) {
			System.out.println(i.toString());
		}
	}
	
	@Test 
	public void t12DeleteEmprunt() {
		Emprunt e = daoE.selectOne(1);
		daoE.delete(e);
		Emprunt e2 = daoE.selectOne(2);
		daoE.delete(e2);
		List<Emprunt> liste = daoE.selectAll();
		for(Emprunt i : liste) {
			System.out.println(i.toString());
		}
	}
	
	////////////////////////////////////RELATIONS ENTRE TABLES

	@Test
	public void t13AddLivresEmpruntsClientAndCombineThem() {
		Client c1 = new Client();
		c1.setNom("LB");
		c1.setPrenom("Ben");
		
		Client c2 = new Client();
		c2.setNom("LB");
		c2.setPrenom("Vince");
		
		
		Livre l1 = new Livre();
		l1.setAuteur("Jules Verne");
		l1.setTitre("Voyage au centre de la Terre");
			
		Livre l2 = new Livre();
		l2.setAuteur("William Gibson");
		l2.setTitre("Neuromancien");
		
		Livre l3 = new Livre();
		l3.setAuteur("Barnard Clavel");
		l3.setTitre("Amarok");
			
		Livre l4 = new Livre();
		l4.setAuteur("Simenon");
		l4.setTitre("Les frères Rico");
		

		daoL.add(l1);
		daoL.add(l2);
		daoL.add(l3);
		daoL.add(l4);
		
		daoC.add(c1);
		daoC.add(c2);
		
		
		//un 1er emprunt (c1 emprunte)
		Emprunt e1 = new Emprunt();
		e1.setDatedebut(new Date());
		e1.setDatefin(new Date());
		e1.setDelai(5);
		daoE.add(e1);
		
		e1.getLivresE().add(l1);
		l1.getEmpruntLivres().add(e1);
		daoL.update(l1);
		
		e1.getLivresE().add(l2);
		l2.getEmpruntLivres().add(e1);
		daoL.update(l2);
		
		e1.getLivresE().add(l3);
		l3.getEmpruntLivres().add(e1);
		daoL.update(l3);
		
		daoE.update(e1);
		
		c1.getEmprunts().add(e1);
		e1.setClientE(c1);
		daoC.update(c1);
		daoE.update(e1);
		
		
		//un 2ème emprunt (c2 emprunte)
		Emprunt e2 = new Emprunt();
		e2.setDatedebut(new Date());
		e2.setDatefin(new Date());
		e2.setDelai(5);
		daoE.add(e2);
		
		e2.getLivresE().add(l3);
		l3.getEmpruntLivres().add(e2);
		daoL.update(l3);
		
		daoE.update(e2);
		
		c2.getEmprunts().add(e2);
		e2.setClientE(c2);
		daoC.update(c2);
		daoE.update(e2);
		
		
		//un 3ème emprunt (c1 emprunte à nouveau)
		Emprunt e3 = new Emprunt();
		e3.setDatedebut(new Date());
		e3.setDatefin(new Date());
		e3.setDelai(5);
		daoE.add(e3);
		
		e3.getLivresE().add(l2);
		l2.getEmpruntLivres().add(e3);
		daoL.update(l2);
		
		e3.getLivresE().add(l4);
		l4.getEmpruntLivres().add(e3);
		daoL.update(l4);
		
		daoE.update(e3);
		
		c1.getEmprunts().add(e3);
		e3.setClientE(c1);
		daoC.update(c1);
		daoE.update(e3);
	}
}
