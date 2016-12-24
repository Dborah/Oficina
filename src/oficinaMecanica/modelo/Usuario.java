package oficinaMecanica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {
	@Id
	@SequenceGenerator(name="usuario_id", sequenceName="usuario_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id")
	
	private Long idusuario;
	@NotEmpty(message = "Voc� deve inserir seu nome de usu�rio para acessar a aplica��o.")
	private String usuario;
	@NotEmpty(message = "Voc� deve inserir sua senha para acessar a aplica��o.")
	private String senha;
	@NotEmpty(message = "Voc� deve inserir a func�o do usu�rio para acessar a aplica��o.")
	private String papel;
	
	//getters and setters
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
}
