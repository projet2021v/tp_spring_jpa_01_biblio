package myapp.services;

import java.util.List;


@SuppressWarnings("hiding")
public interface ICrud<Object> {
	
	Object add(Object o);
	Object selectOne(int id);
	List<Object> selectAll();
	void udpate(Object o);
	void delete(Object o);
	
}

