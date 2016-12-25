package oficinaMecanica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oficinaMecanica.dao.DAO;
import oficinaMecanica.modelo.Cliente;
import oficinaMecanica.modelo.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void gravar(){
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		if(usuario.getIdusuario() == null) dao.adiciona(usuario);
		else dao.atualiza(usuario);
		
		usuario = new Usuario();
		usuarios = dao.listaTodos();
	}
	
	
	public List<Usuario> getUsuarios(){
		if(usuarios == null){
			usuarios = new DAO(Usuario.class).listaTodos();
		}
		return usuarios;
	}
	
	
	public void remove(Usuario usuario){
		try{
			DAO<Usuario> dao = new DAO<>(Usuario.class);
			dao.remove(usuario);
			usuarios = dao.listaTodos();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este usuário pode ser removido."));
		}
	}
	
	public void cancela(){
		this.usuario = new Usuario();
	}

}
