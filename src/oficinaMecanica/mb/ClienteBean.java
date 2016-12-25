package oficinaMecanica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oficinaMecanica.dao.DAO;
import oficinaMecanica.modelo.Cliente;

@SessionScoped
@ManagedBean
public class ClienteBean {
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public void gravar(){
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		if(cliente.getId() == null) dao.adiciona(cliente);
		else dao.atualiza(cliente);
		
		cliente = new Cliente();
		clientes = dao.listaTodos();
	}
	
	public List<Cliente> getClientes(){
		if(clientes == null){
			clientes = new DAO(Cliente.class).listaTodos();
		}
		return clientes;
	}
	
	public void remove(Cliente cliente){
		try{
			DAO<Cliente> dao = new DAO<>(Cliente.class);
			dao.remove(cliente);
			clientes = dao.listaTodos();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este cliente n�o pode ser removido."));
		}
	}
	
	public void cancela(){
		this.cliente = new Cliente();
	}
}
