package model;

import java.io.Serializable;

public class TipoSangue extends Estoque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idTpSangue;
	private String tipoSangue;
	
	public TipoSangue(String tipoSangue, double qtdSangue) {
		super(qtdSangue);
		setTipoSangue(tipoSangue);
	}
	
	public TipoSangue() {
		super(0);
	}
	
	public TipoSangue(int idTpSangue, String tipoSangue, double qtdSangue) {
		super(qtdSangue);
		setIdTpSangue(idTpSangue);
		setTipoSangue(tipoSangue);
	}
	
	public int getIdTpSangue() {
		return idTpSangue;
	}
	public void setIdTpSangue(int idTpSangue) {
		this.idTpSangue = idTpSangue;
	}
	public String getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	

}
