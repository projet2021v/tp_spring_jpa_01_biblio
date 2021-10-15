package myapp;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.entities.Client;
import myapp.services.ICrud;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDaoClient {

	@Autowired
	ICrud<Client> daoC;
	
	@Before
	public void beforeEachTest() {
		System.out.println("===========================================");
	}
	
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
		List<Client> liste = daoC.selectAll();
		for(Client i : liste ) {
			System.out.println(i.toString());
		}
	}
	
	
}
