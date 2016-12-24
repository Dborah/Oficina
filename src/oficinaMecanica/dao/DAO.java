package oficinaMecanica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import oficinaMecanica.jpa.JPAUtil;


/*
 * Cria uma Classe parametrizada para servir de unidade de
 * persistência genérica para encapsular as operações de dados.
 */
public class DAO<T> {
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	//Adiciona um novo objeto no banco.
	public void adiciona(T t) {
		//Obtém o EntityManager.
		EntityManager em = new JPAUtil().getEntityManager();
		//Abre a transação
		em.getTransaction().begin();
		//Monitora o objeto que será persistido.
		em.persist(t);
		//Envia a transação.
		em.getTransaction().commit();
		//Fecha o EntityManager
		em.close();
	}//adiciona()

	//Atualiza um objeto no banco.
	public void atualiza(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}//atualiza()

	//Remove um objeto do banco.
	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		/*
		 * Remove o objeto solicitado. Para que a remoção seja realizada,
		 * é necessário obter o contexto do objeto persistido, através do método
		 * merge, assim como o objeto recuperado do banco, o método remove é capaz
		 * de remove-lo da memória.
		 */
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}//remove()

	//Obtém todos os dados existentes no banco.
	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();		
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);		
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}//listaTodos()
	
	//Busca um elemento pelo seu id no banco.
	public T buscaPorId(Long id){
		EntityManager em = new JPAUtil().getEntityManager();
		return em.find(classe, id);		
	}//buscaPorId()
}
