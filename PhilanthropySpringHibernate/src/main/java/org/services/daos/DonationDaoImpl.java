package org.services.daos;

import java.io.Serializable;
import java.util.List;

import org.services.entity.Donation;
import org.services.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.training.utils.GlobalLogger;

@Service
public class DonationDaoImpl implements Dao<Donation>{
	
	@Autowired
	private HibernateTemplate template;

	public Object add(Donation object) {
		GlobalLogger.getLogger().info("Adding Donation:\n" + object);
		Object key = template.save(object);
		return key;
	}

	public Donation find(Serializable key) {
		GlobalLogger.getLogger().info("Finding Donation with id " + key);
		Donation result = (Donation) template.get(Donation.class, key);
		return result;
	}

	public List<Donation> findAll() {
		return (List<Donation>) template.find("FROM Donation");
	}

}
