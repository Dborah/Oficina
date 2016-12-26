package oficinaMecanica.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import oficinaMecanica.dao.UsuarioDAO;
import oficinaMecanica.modelo.Usuario;

//A anota��o abaixo, faz com que as informa��es sejam guardadas durante toda a sess�o da aplica��o.
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
	
	//Verifica se o usu�rio � v�lido
	public String efetuaLogin(){
		//Verifica se as informa��es s�o v�lidas
		boolean loginValido = UsuarioDAO.usuarioExiste(usuario);
			
		
		//Caso sejam, redireciona para a p�gina inicial da aplica��o
		if(loginValido){
			Usuario papel = UsuarioDAO.buscaPorPapel(usuario.getUsuario());
			if(papel.getPapel().equalsIgnoreCase("recepcionista")) return "recepcionista?faces-redirect=true";
			else if(papel.getPapel().equalsIgnoreCase("mecanico")) return "mecanico?faces-redirect=true";
				else if(papel.getPapel().equalsIgnoreCase("gerente")) return "gerente?faces-redirect=true";
					else if(papel.getPapel().equalsIgnoreCase("administrador")) return "administrador?faces-redirect=true";
						else return "login?faces-redirect=true";}
		else{
			//Caso n�o seja, limpa os dados inseridos e redireciona para a tela de login
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
