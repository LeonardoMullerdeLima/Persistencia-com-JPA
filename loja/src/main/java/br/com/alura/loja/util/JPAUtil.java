package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
	// "loja" é o nome dado no arquivo persistence.xml
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
