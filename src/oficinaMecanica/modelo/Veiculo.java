package oficinaMecanica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Veiculo {
	@Id
	@SequenceGenerator(name="veiculo_id", sequenceName="veiculo_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo_id")
	
	private Long id;
	@NotEmpty(message = "A marca deve ser informada")
	private String marca;
	@NotEmpty(message = "O modelo deve ser informado")
	private String modelo;
	@NotEmpty(message = "A placa deve ser informada")
	private String placa;
	@NotEmpty(message = "O ano deve ser informado")
	private String anoFabricacao;
	@NotEmpty(message = "O ano do modelo deve ser informado")
	private String anoModelo;
	
	@ManyToOne
	private Cliente cliente;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
