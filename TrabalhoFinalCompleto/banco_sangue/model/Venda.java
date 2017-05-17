package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Venda implements Serializable, Comparable<Venda> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<ItemVenda> listaVenda;
	private Cliente clienteVenda;
	private int indice;
	private double valorTotal;
	
	public Venda(){
		this.listaVenda = new ArrayList<ItemVenda>();
		setClienteVenda(new Cliente());
	}	
	public ArrayList<ItemVenda> getListaVenda() {
		return listaVenda;
	}
	public void setListaVenda(ArrayList<ItemVenda> listaVenda) {
		this.listaVenda = listaVenda;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public float getTotalVenda(){
		int retorno = 0;
		for (int i = 0; i < this.listaVenda.size(); i++){
			double valor = (this.listaVenda.get(i).getQuantidade() * this.listaVenda.get(i).getProduto().getValorProduto());
			retorno += valor;
		}
		return retorno;
	}
	public Cliente getClienteVenda() {
		return clienteVenda;
	}
	public  void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}
	@Override
	public int compareTo(Venda o) {
		if (this.clienteVenda.getTotalCompras() > o.clienteVenda.getTotalCompras()) {
            return -1;
        }
        if (this.clienteVenda.getTotalCompras() < o.clienteVenda.getTotalCompras()) {
            return 1;
        }

		
		return 0;
	}
	
	public static int compareToId(int id, Venda o) {
		if (id < o.clienteVenda.getIdCliente()) {
            return -1;
        }
        if (id > o.clienteVenda.getIdCliente()) {
            return 1;
        }

		
		return 0;
	}	
}
