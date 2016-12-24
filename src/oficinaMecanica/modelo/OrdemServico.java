package oficinaMecanica.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrdemServico {
	@Id
	@SequenceGenerator(name="ordemServico_id", sequenceName="ordemServico_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordemServico_id")
	
	private Long idos;
	
	@OneToOne
	private Veiculo veiculo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataOrcamento, dataServico;
	private String servico, status;
	private Double valor;
	
	//getters and setters
	public Long getIdos() {
		return idos;
	}
	public void setIdos(Long idos) {
		this.idos = idos;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Calendar getDataOrcamento() {
		return dataOrcamento;
	}
	public void setDataOrcamento(Calendar dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}
	public Calendar getDataServico() {
		return dataServico;
	}
	public void setDataServico(Calendar dataServico) {
		this.dataServico = dataServico;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
