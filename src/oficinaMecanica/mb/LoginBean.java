package deborah.com.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import deborah.com.dao.UsuarioDAO;
import deborah.com.modelo.Usuario;

//A anotação abaixo, faz com que as informações sejam guardadas durante toda a sessão da aplicação.
@SessionScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new  Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Verifica se o usuário é válido
	public String efetuaLogin(){
		//Verifica se as informações são válidas
		boolean loginValido = UsuarioDAO.usuarioExiste(usuario);
		
		//Caso sejam, redireciona para a página inicial da aplicação
		if(loginValido) return "recepcionista?faces-redirect=true";
		else{
			//Caso não seja, limpa os dados inseridos e redireciona para a tela de login
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return usuario.getUsuario() != null;
	}
	
	public String logout(){
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
}
