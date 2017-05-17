package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class BancoDeDados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/************************************************************/
	/* METÓDOS PARA VERIFICAR SE PASTA E BANCO DE DADOS EXISTEM */
	/************************************************************/
	public static void verificaBancoDadosClientes() throws IOException {
		File diretorio = new File("arquivosBD");
		File arquivo = new File("arquivosBD\\Cliente.dat");

		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
	}

	public static void verificaBancoDadosProdutos() throws IOException {
		File diretorio = new File("arquivosBD");
		File arquivo = new File("arquivosBD\\Produto.dat");
		try {
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void verificaBancoDadosVendas() throws IOException {
		File diretorio = new File("arquivosBD");
		File arquivo = new File("arquivosBD\\Venda.dat");
		try {
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/******************************************************/
	/* METÓDOS PARA GRAVAR DADOS NO BANCO DE DADOS CRIADO */
	/******************************************************/
	public static void gravaClienteBancoDados(Map<Integer, Cliente> cadastroClientes) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arquivosBD\\Cliente.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);

		streamObjeto.writeObject(cadastroClientes);
		streamObjeto.close();
		arquivo.close();
	}

	public static void gravaProdutoBancoDados(Map<Integer, Produto> cadastroProdutos) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arquivosBD\\Produto.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);

		streamObjeto.writeObject(cadastroProdutos);
		streamObjeto.close();
		arquivo.close();
	}

	public static void gravaVendaBancoDados(Map<Integer, Venda> cadastroVendas) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arquivosBD\\Venda.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);

		streamObjeto.writeObject(cadastroVendas);
		streamObjeto.close();
		arquivo.close();
	}

	/***************************************************************************/
	/*
	 * METÓDOS PARA DESERIALIZAR O BANCO DE DADOS E FAZER A LEITURA DOS OBJETOS.
	 */
	/**
	 * @return
	 *************************************************************************/

	@SuppressWarnings("unchecked")
	public static Object buscaBancoDadosClientes() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arquivosBD\\Cliente.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);

		Object mapClientes = (Map<Integer, Cliente>) abrirObjeto.readObject();

		abrirObjeto.close();
		abrirArquivo.close();
		return mapClientes;
	}

	@SuppressWarnings("unchecked")
	public static Object buscaBancoDadosProdutos() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arquivosBD\\Produto.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);

		Object mapProdutos = (Map<Integer, Produto>) abrirObjeto.readObject();

		abrirObjeto.close();
		abrirArquivo.close();
		return mapProdutos;
	}

	@SuppressWarnings("unchecked")
	public static Object buscaBancoDadosVendas() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arquivosBD\\Venda.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);

		Object mapProdutos = (Map<Integer, Venda>) abrirObjeto.readObject();

		abrirObjeto.close();
		abrirArquivo.close();
		return mapProdutos;
	}
}
