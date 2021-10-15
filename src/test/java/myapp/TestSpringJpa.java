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
		daoC.udpate(c);
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
		daoL.udpate(l);
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
		daoE.udpate(e);
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

}
