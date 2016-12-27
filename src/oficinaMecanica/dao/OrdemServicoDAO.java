package oficinaMecanica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import oficinaMecanica.jpa.JPAUtil;
import oficinaMecanica.modelo.OrdemServico;

public class OrdemServicoDAO {
	
	public List<OrdemServico> getByStatus(String status){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		/*
		 * Sintaxe do JPQL de busca: 
		 * 
		 * 	from Usuario u where u.usuario = :pUsuario and u.senha = :pSenha;
		 */
		Query query = manager.createQuery("from OrdemServico u where u.status = :pStatus");
		query.setParameter("pStatus",status);
		List<OrdemServico> lista = query.getResultList();
		manager.close();
		return lista;
	}
	

}
