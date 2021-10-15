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

import myapp.entities.Emprunt;
import myapp.services.ICrud;

@Service
@Repository
@Transactional
@Qualifier("daoEmprunt")
public class DaoEmprunt implements ICrud<Emprunt> {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	@Override
	public Emprunt add(Emprunt o) {
		em.persist(o);
		System.err.println("add Emprunt with id " + o.getId());
		return o;
	}

	@Override
	public Emprunt selectOne(int id) {
		Emprunt o = em.find(Emprunt.class, id);
		return o;
	}

	@Override
	public List<Emprunt> selectAll() {
		TypedQuery<Emprunt> q = em.createQuery("select e from Emprunt e", Emprunt.class);
		return q.getResultList();
	}

	@Override
	public void update(Emprunt o) {
		Emprunt e = em.find(Emprunt.class, o.getId());
		e.setDatedebut(o.getDatedebut());
		e.setDatefin(o.getDatefin());
		e.setDelai(o.getDelai());
		e.setClientE(o.getClientE());
		e.setLivresE(o.getLivresE());
		em.merge(e);
		System.err.println("update Emprunt with id " + e.getId());
	}

	@Override
	public void delete(Emprunt o) {
		Emprunt e = em.find(Emprunt.class, o.getId());
		em.remove(e);
		System.err.println("delete Emprunt with id " + o.getId());
	}

}
