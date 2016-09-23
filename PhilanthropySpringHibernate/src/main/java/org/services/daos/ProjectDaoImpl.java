package org.services.daos;

import java.io.Serializable;
import java.util.List;

import org.services.entity.Project;
import org.services.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.training.utils.GlobalLogger;

@Service
public class ProjectDaoImpl implements Dao<Project>{
	
	@Autowired
	private HibernateTemplate template;

	public Object add(Project object) {
		GlobalLogger.getLogger().info("Adding Project:\n" + object);
		Object key = template.save(object);
		return key;
	}

	public Project find(Serializable key) {
		GlobalLogger.getLogger().info("Finding project with id " + key);
		Project result = (Project) template.get(Project.class, key);
		return result;
	}

	public List<Project> findAll() {
		return (List<Project>) template.find("FROM Project");
	}

}
