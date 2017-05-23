package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double quantidade;
	List<TipoSangue> tiposSanguineos;

	public Estoque(double quantidade) {
		tiposSanguineos = new ArrayList<TipoSangue>();
		setQuantidade(quantidade);
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
