package oficinaMecanica.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class PerfilBean {
	 private String gerente = "Gerente";
	 private String mecanico = "Mecanico";
	 private String recepcionista = "Recepcionista";
	 private String administrador = "Administrador";
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getMecanico() {
		return mecanico;
	}
	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}
	public String getRecepcionista() {
		return recepcionista;
	}
	public void setRecepcionista(String recepcionista) {
		this.recepcionista = recepcionista;
	}
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	
}
