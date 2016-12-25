package oficinaMecanica.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import oficinaMecanica.dao.DAO;
import oficinaMecanica.modelo.Peca;

@SessionScoped
@ManagedBean
public class PecaBean {
	private Peca peca  = new Peca();
	private List<Peca> pecas;
	
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public void gravar(){
		DAO<Peca> dao = new DAO<>(Peca.class);
		if(peca.getId() == null) dao.adiciona(peca);
		else dao.atualiza(peca);
		
		peca = new Peca();
		pecas = dao.listaTodos();
	}
	
	public List<Peca> getPecas(){
		if(pecas == null){
			pecas = new DAO(Peca.class).listaTodos();
		}
		return pecas;
	}
	
	public void remove(Peca peca){
		try{
			DAO<Peca> dao = new DAO<>(Peca.class);
			dao.remove(peca);
			pecas = dao.listaTodos();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esta pe�a n�o pode ser removida."));
		}
	}
	
	public void cancela(){
		this.peca = new Peca();
	}
	
	

}
