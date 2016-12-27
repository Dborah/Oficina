package oficinaMecanica.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import oficinaMecanica.dao.DAO;
import oficinaMecanica.dao.OrdemServicoDAO;
import oficinaMecanica.modelo.OrdemServico;

@SessionScoped
@ManagedBean
public class OSBean {
	OrdemServico os = new OrdemServico();
	private List<OrdemServico> oss;
	private List<OrdemServico> oss_status;

	public OrdemServico getOs() {
		return os;
	}

	public void setOs(OrdemServico os) {
		this.os = os;
	}
	
	public void gravar(){
		DAO<OrdemServico> dao = new DAO<>(OrdemServico.class);
		Calendar cal = Calendar.getInstance();
		
		if(os.getIdos() == null){
			os.setDataOrcamento(cal);
			os.setStatus("Criada");
			dao.adiciona(os);
		}
		else dao.atualiza(os);
		
		os = new OrdemServico();
		oss = dao.listaTodos();
	}

	public List<OrdemServico> getOss() {
		if(oss == null){
			oss = new DAO<OrdemServico>(OrdemServico.class).listaTodos();
		}
		return oss;
	}
	
	public void buscarOS(String status) {
		oss_status = new OrdemServicoDAO().getByVeiculo(status);
}
	public List<OrdemServico> getOss_status() {
			return oss_status;

	}

	public void atualizaStatus(OrdemServico os,String status){
		DAO<OrdemServico> dao = new DAO<>(OrdemServico.class);
		os.setStatus(status);
		dao.atualiza(os);
	}
	
	public void atualizaStatusEData(OrdemServico os,String status){
		DAO<OrdemServico> dao = new DAO<>(OrdemServico.class);
		Calendar cal = Calendar.getInstance();
		os.setDataServico(cal);
		os.setStatus(status);
		dao.atualiza(os);
	}
	
	

}
