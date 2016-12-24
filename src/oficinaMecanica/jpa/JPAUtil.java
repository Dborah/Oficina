package oficinaMecanica.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * A classe JPAUtil foi criada para receber uma inst�ncia �nica para a conex�o com o banco de dados
 * disponibilizada pelo JPA.
 */
public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("oficinaMecanica");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}//class JPAUtil
