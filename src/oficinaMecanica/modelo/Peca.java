package oficinaMecanica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Peca {
	@Id
	@SequenceGenerator(name="peca_id", sequenceName="peca_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="peca_id")
	
	private Long id;
	@NotEmpty(message = "O nome deve ser informado")
	private String nome;
	@NotEmpty(message = "O fornecedor deve ser informado")
	private String fornecedor;
	@NotEmpty(message = "O tipo deve ser informado")
	private String tipo;
	@NotEmpty(message = "A marca deve ser informada")
	private String marca;
	@Column(nullable = false)
	private Integer quantidade;
	
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
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
