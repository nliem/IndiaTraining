package org.services.daos;

import java.io.Serializable;

import org.services.entity.ShoppingCart;
import org.services.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service
//Service layer... not really a component. 
public class ShoppingCartDaoImpl implements Dao<ShoppingCart> {
	
	@Autowired
	//if you're autowiring, this attribute sure as hell shouldn't be static :( 
	private HibernateTemplate hibernateTemplate;
	
	public ShoppingCartDaoImpl(){
		super();
	}

	public Object add(ShoppingCart object) {
		//in managed environment (container) can get the session
		//in unmanaged we need to create
		//that's why before we used factory.openSession()
		Object key = hibernateTemplate.save(object);
		return key;
	}

	public ShoppingCart find(Serializable key) {
		ShoppingCart result = (ShoppingCart) hibernateTemplate.get(ShoppingCart.class, key);
		return result;
	}

}
