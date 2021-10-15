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

import myapp.entities.Livre;
import myapp.services.ICrud;

@Service
@Repository
@Transactional
@Qualifier("daoLivre")
public class DaoLivre implements ICrud<Livre> {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public Livre add(Livre o) {
		em.persist(o);
		System.err.println("update Livre with id " + o.getId());
		return o;
	}

	@Override
	public Livre selectOne(int id) {
		Livre o = em.find(Livre.class, id);
		return o;
	}

	@Override
	public List<Livre> selectAll() {
		TypedQuery<Livre> q = em.createQuery("select l from Livre l", Livre.class);
		return q.getResultList();
	}

	@Override
	public void update(Livre o) {
		Livre l = em.find(Livre.class, o.getId());
		l.setAuteur(o.getAuteur());
		l.setTitre(o.getTitre());
		l.setEmpruntLivres(o.getEmpruntLivres());
		em.merge(l);
		System.err.println("update Livre with id " + l.getId());
		
	}

	@Override
	public void delete(Livre o) {
		Livre l = em.find(Livre.class, o.getId());
		em.remove(l);
		System.err.println("delete Livre with id " + o.getId());
	}

}
