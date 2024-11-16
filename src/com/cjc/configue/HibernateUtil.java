package com.cjc.configue;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.cjc.model.Employee;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		Map<String, String> map = new HashMap<>();

		// Database properties driverclass, url , username ,password
		map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/fd29");
		map.put(Environment.USER, "root");
		map.put(Environment.PASS, "root");

		// Hibernate Properties HBM2DDL auto , Dialect , show sqwl , format sql
		map.put(Environment.HBM2DDL_AUTO, "update");
		map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		map.put(Environment.SHOW_SQL, "true");
		map.put(Environment.FORMAT_SQL, "false");

		// 2nd Level Cache properties
		map.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();

		MetadataSources mds = new MetadataSources(registry);

		mds.addAnnotatedClass(Employee.class);

		Metadata md = mds.getMetadataBuilder().build();

		SessionFactory sf = md.getSessionFactoryBuilder().build();

		return sf;
	}

}
