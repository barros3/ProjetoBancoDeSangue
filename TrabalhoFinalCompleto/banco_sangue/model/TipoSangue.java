package model;

import java.io.Serializable;

public class TipoSangue implements Serializable, Comparable<TipoSangue>{
	
	private static final long serialVersionUID = 1L;
	private int idTpSangue;
	private String tipoSangue;
	private double estoque = 0;
	private double totalEstoque = 0;
	
	public TipoSangue(String tipoSangue, double estoque) {
		setTipoSangue(tipoSangue);
		setEstoque(estoque);
	}

	public TipoSangue(int idTpSangue, String tipoSangue, double estoque) {
		setIdTpSangue(idTpSangue);
		setTipoSangue(tipoSangue);
		setEstoque(estoque);
	}
	
	public TipoSangue() {
		
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
	public double getEstoque() {
		return estoque;
	}
	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}
	public double getTotalEstoque() {
		return totalEstoque;
	}
	public void setTotalEstoque(double totalEstoque) {
		this.totalEstoque += totalEstoque;
	}
	
	
	@Override
	public int compareTo(TipoSangue o) {
		if (this.getTotalEstoque() > o.getTotalEstoque()) {
            return -1;
        }
        if (this.getTotalEstoque() < o.getTotalEstoque()) {
            return 1;
        }
		return 0;
	}
	

}
