package model;

import java.io.EOFException;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CadastroDeClientes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer, Cliente> cadastroClientes = new HashMap<Integer, Cliente>();
	public static int finalCliente = 1;
	//public static Cliente clienteVenda;
	
	@SuppressWarnings("unchecked")
	public static int getTamanhoBancoCliente() throws Exception {
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
				Map<Integer, Produto> tmp = (Map<Integer, Produto>) BancoDeDados.buscaBancoDadosClientes();
				int retorno = tmp.size();
				return retorno;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/*
	 * MÉTODO QUE VERIFICA SE O BANCO DE DADOS(BD) EXISTE, SE EXISTIR ELE BUSCA O
	 * BD, DEPOIS ELE INSERE UM ITEM CLIENTE E SOBRESCREVE O BANCO NOVAMENTE
	 * COM A NOVA INFORMAÇÃO.
	 */

	@SuppressWarnings("unchecked")
	public void adicionaCliente(Cliente c) throws Exception {
		BancoDeDados.verificaBancoDadosClientes();
		try {
			cadastroClientes = (Map<Integer, Cliente>) BancoDeDados.buscaBancoDadosClientes();
			CadastroDeClientes.finalCliente = cadastroClientes.size();
			c.setIdCliente(finalCliente + 1);
			cadastroClientes.put(c.getIdCliente(), c);
			BancoDeDados.gravaClienteBancoDados(cadastroClientes);
		} catch (EOFException e) {
			CadastroDeClientes.finalCliente = cadastroClientes.size();
			c.setIdCliente(finalCliente + 1);
			cadastroClientes.put(c.getIdCliente(), c);
			BancoDeDados.gravaClienteBancoDados(cadastroClientes);
		}
	}
}