package model;

import java.io.Serializable;

public class ItemVenda extends Venda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idItem;
	private Produto produto;
	private int quantidade;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public ItemVenda() {
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
