package oficinaMecanica.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import oficinaMecanica.jpa.JPAUtil;
import oficinaMecanica.modelo.Usuario;

public class UsuarioDAO {
	//Verifica se o login de usuário está correto, para liberar o acesso a aplicação.
	public static boolean usuarioExiste(Usuario usuario){
		//Obtém a conexão com o banco.
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		/*
		 * Sintaxe do JPQL de busca: 
		 * 
		 * 	from Usuario u where u.usuario = :pUsuario and u.senha = :pSenha;
		 */
		Query query = manager.createQuery("from Usuario u where u.usuario = :pUsuario and u.senha = :pSenha");
		query.setParameter("pUsuario", usuario.getUsuario());
		query.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		manager.close();
		return encontrado;
		
	}

}
