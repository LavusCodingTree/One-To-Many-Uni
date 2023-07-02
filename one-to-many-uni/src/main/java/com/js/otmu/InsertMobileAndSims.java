package com.js.otmu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertMobileAndSims {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Mobile m = new Mobile();
		m.setName("A32");
		m.setBrand("Samsung");
		m.setPrice(25000);
		
		Sim s1 = new Sim();
		s1.setProvider("Airtel");
		s1.setType("4G");
		
		Sim s2 = new Sim();
		s2.setProvider("Vodophone");
		s2.setType("5G");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(s1);
		sims.add(s2);
		
		m.setSims(sims);
		
		et.begin();
		em.persist(m);
		em.persist(s1);
		em.persist(s2);
		et.commit();
		
		System.out.println("Inserted");
		
		
	}

}
