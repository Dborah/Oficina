package oficinaMecanica.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import oficinaMecanica.modelo.Usuario;

public class Testes {
	public static void main(String[] args) {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("oficinaMecanica");
		EntityManager manager = factory.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("deborah");
		usuario.setSenha("1234");
		usuario.setPapel("admin");
		
		//abre a transação
		manager.getTransaction().begin(); 
		//persiste o objeto 
		manager.persist(usuario);
		//commita a transação 
		manager.getTransaction().commit(); 
		manager.close();
		factory.close();
	}

}
