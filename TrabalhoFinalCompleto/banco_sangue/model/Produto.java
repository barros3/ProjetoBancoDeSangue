package model;

import java.io.Serializable;

public class Produto extends Estoque implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private int idProduto;
	private String nomeProduto;
	private double valorProduto;

	public Produto(String nomeProduto, int quantidadeDeProdutos, double valorProduto) {
		super(quantidadeDeProdutos);
		setNomeProduto(nomeProduto);
		setValorProduto(valorProduto);
	}

	public Produto() {
		super(0);
	}

	public Produto(int idProduto, String nomeProduto, int quantidadeDeProdutos, double valorProduto) {
		super(quantidadeDeProdutos);
		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setValorProduto(valorProduto);
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
}
