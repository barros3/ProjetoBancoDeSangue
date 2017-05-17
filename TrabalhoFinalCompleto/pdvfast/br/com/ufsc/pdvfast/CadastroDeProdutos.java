package br.com.ufsc.pdvfast;

import java.io.EOFException;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CadastroDeProdutos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer, Produto> cadastroProdutos = new HashMap<Integer, Produto>();
	public static int finalProduto = 1;

	@SuppressWarnings("unchecked")
	public static int getTamanhoBancoProduto() throws Exception {
		File diretorio = new File("arquivosBD");
		File arquivo = new File("arquivosBD\\Produto.dat");
		try {
			if (!diretorio.exists()) {
				diretorio.mkdir();
				return 0;
			} else if (!arquivo.exists()) {
				arquivo.createNewFile();
				return 0;
			} else {
				Map<Integer, Produto> tmp = (Map<Integer, Produto>) BancoDeDados.buscaBancoDadosProdutos();
				int retorno = tmp.size();
				return retorno;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public void adicionaProduto(Produto p) throws Exception {
		BancoDeDados.verificaBancoDadosProdutos();
		try {
			cadastroProdutos = (Map<Integer, Produto>) BancoDeDados.buscaBancoDadosProdutos();
			CadastroDeProdutos.finalProduto = cadastroProdutos.size();
			p.setIdProduto(finalProduto + 1);
			cadastroProdutos.put(p.getIdProduto(), p);
			BancoDeDados.gravaProdutoBancoDados(cadastroProdutos);
		} catch (EOFException e) {
			CadastroDeProdutos.finalProduto = cadastroProdutos.size();
			p.setIdProduto(finalProduto + 1);
			cadastroProdutos.put(p.getIdProduto(), p);
			BancoDeDados.gravaProdutoBancoDados(cadastroProdutos);
		}
	}
}