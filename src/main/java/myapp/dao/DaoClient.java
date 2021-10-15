package myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myapp.entities.Client;
import myapp.services.ICrud;

@Service
@Repository
@Transactional
@Qualifier("daoClient")
public class DaoClient implements ICrud<Client> {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	@Override
	public Client add(Client o) {
		em.persist(o);
		System.err.println("add Client with id " + o.getId());
		return o;
	}
	
	@Override
	public Client selectOne(int id) {
		Client o = em.find(Client.class, id);
		return o;
	}

	@Override
	public List<Client> selectAll() {
		TypedQuery<Client> q = em.createQuery("select c from Client c", Client.class);
		return q.getResultList();
	}

	@Override
	public void udpate(Client o) {
		Client c = em.find(Client.class, o.getId());
		c.setNom(o.getNom());
		c.setPrenom(o.getPrenom());
		c.setEmprunts(o.getEmprunts());
		em.merge(c);
		System.err.println("update Client with id " + c.getId());
	}

	@Override
	public void delete(Client o) {
		Client c = em.find(Client.class, o.getId());
		em.remove(c);
		System.err.println("delete Client with id " + o.getId());
	}

	

}
