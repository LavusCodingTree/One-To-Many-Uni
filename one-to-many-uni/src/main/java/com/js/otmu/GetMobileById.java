package com.js.otmu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMobileById {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		//EntityTransaction et = em.getTransaction();
		
		Mobile m = em.find(Mobile.class, 1);
		
		if(m!=null) {
			System.out.println();
			System.out.println("Mobile Id = "+m.getId());
			System.out.println(("Mobile Name = "+m.getName()));
			System.out.println("Mobile Brand = "+m.getBrand());
			System.out.println("Mobile Price = "+m.getPrice());
			
			System.out.println("====================================");
			
			List<Sim> sims =  m.getSims();
			if(sims.size()>0) {
				for(Sim s : sims) {
					System.out.println();
					System.out.println("Sim id = "+s.getId());
					System.out.println("Sim provider = "+s.getProvider());
					System.out.println("Sim Type = "+s.getType());
					
					System.out.println("=======================================");
				}
			}else {
				System.out.println("No Sim Avaliable");
			}
		}else {
			System.out.println("No Mobile Found in the Given Id");
		}
	}
}
