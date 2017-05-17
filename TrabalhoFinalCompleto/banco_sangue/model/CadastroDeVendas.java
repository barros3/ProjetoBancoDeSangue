package model;

import java.io.EOFException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CadastroDeVendas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer, Venda> cadastroVendas = new HashMap<Integer, Venda>();
	public static int finalVendas = 1;
	public static Produto produtoVenda;

	@SuppressWarnings("unchecked")
	public void adicionaProduto(Venda v) throws Exception {
		BancoDeDados.verificaBancoDadosVendas();
		try {
			cadastroVendas = (Map<Integer, Venda>) BancoDeDados.buscaBancoDadosVendas();
			CadastroDeVendas.finalVendas = cadastroVendas.size();
			v.setIndice(finalVendas + 1);
			cadastroVendas.put(v.getIndice(), v);
			BancoDeDados.gravaVendaBancoDados(cadastroVendas);
		} catch (EOFException e) {
			CadastroDeVendas.finalVendas = cadastroVendas.size();
			v.setIndice(finalVendas + 1);
			cadastroVendas.put(v.getIndice(), v);
			BancoDeDados.gravaVendaBancoDados(cadastroVendas);
		}
	}
}