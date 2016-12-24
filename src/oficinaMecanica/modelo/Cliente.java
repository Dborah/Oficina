package oficinaMecanica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	@Id
	@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_id")
	
	
	private Long id;
	@NotEmpty(message = "O nome deve ser informado")
	private String nome;
	@NotEmpty(message = "O telefone deve ser informado")
	private String telefone;
	private String placaVeiculo;
	@NotEmpty(message = "O CPF deve ser informado")
	@CPF(message = "CPF inválido")
	private String cpf;
	@NotEmpty(message = "O endereço deve ser informado")
	private String endereco;
	@NotEmpty(message = "O email deve ser informado")
	private String email;
	

	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
