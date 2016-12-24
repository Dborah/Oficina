package oficinaMecanica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oficinaMecanica.dao.DAO;
import oficinaMecanica.modelo.Veiculo;

@SessionScoped
@ManagedBean
public class VeiculoBean {
	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> veiculos;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void gravar(){
		DAO<Veiculo>dao = new DAO<>(Veiculo.class);
		if(veiculo.getId() == null) dao.adiciona(veiculo);
		else dao.atualiza(veiculo);
		
		veiculo = new Veiculo();
		veiculos = dao.listaTodos();
	}
	
	public List<Veiculo> getVeiculos(){
		if(veiculos == null){
			veiculos = new DAO(Veiculo.class).listaTodos();
		}
		return veiculos;
	}
	
	public void remove(Veiculo veiculo){
		try{
			DAO<Veiculo> dao = new DAO<>(Veiculo.class);
			dao.remove(veiculo);
			veiculos = dao.listaTodos();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este veiculo n�o pode ser removido."));
		}
	}
	
	public void cancela(){
		this.veiculo= new Veiculo();
	}
}
