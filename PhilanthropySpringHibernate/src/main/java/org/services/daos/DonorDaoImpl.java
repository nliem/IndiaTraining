package org.services.daos;

import java.io.Serializable;
import java.util.List;

import org.services.entity.Donor;
import org.services.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.training.utils.GlobalLogger;

@Service
public class DonorDaoImpl implements Dao<Donor> {
	
	@Autowired
	private HibernateTemplate template;

	public Object add(Donor object) {
		GlobalLogger.getLogger().info("Adding Donor:\n" + object);
		Object key = template.save(object);
		return key;
	}

	public Donor find(Serializable key) {
		GlobalLogger.getLogger().info("Findng Donor with id " + key);
		Donor result = (Donor)template.get(Donor.class, key);
		return result;
	}

	public List<Donor> findAll() {
		
		return (List<Donor>) template.find("FROM Donor");
	}
	
}
