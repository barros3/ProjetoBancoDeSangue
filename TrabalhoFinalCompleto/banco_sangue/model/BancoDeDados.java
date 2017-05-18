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
	
	public static void verificaBDPessoa() throws IOException {
		File diretorio = new File("arqBD");
		File arquivo = new File("arqBD\\Pessoa.dat");
		
		if (!diretorio.exists()){
			diretorio.mkdir();
		}
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
	}
	
	public static void verificaBDTipoSangue() throws IOException {
		File diretorio = new File("arqBD");
		File arquivo = new File("arqBD\\TipoSangue.dat");
		
		if (!diretorio.exists()){
			diretorio.mkdir();
		}
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
	}
	

	/******************************************************/
	/* METÓDOS PARA GRAVAR DADOS NO BANCO DE DADOS CRIADO */
	/******************************************************/
	
	public static void gravaPessoaBD(Map<Integer, Pessoa> cadastroPessoa) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arqBD\\Pessoa.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);
		
		streamObjeto.writeObject(cadastroPessoa);
		streamObjeto.close();
		arquivo.close();
	}
	
	public static void gravaTipoSangueBD(Map<Integer, TipoSangue> cadastroTpSangue) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arqBD\\TipoSangue.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);
		
		streamObjeto.writeObject(cadastroTpSangue);
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
	public static Object buscaBDPessoa() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arqBD\\Pessoa.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);
		
		Object mapPessoa = (Map<Integer, Pessoa>) abrirObjeto.readObject();
		
		abrirObjeto.close();
		abrirArquivo.close();
		return mapPessoa;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Object buscaDBTipoSangue() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arqBD\\TipoSangue.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);
		
		Object mapTipoSangue = (Map<Integer, TipoSangue>) abrirObjeto.readObject();
		
		abrirObjeto.close();
		abrirArquivo.close();
		return mapTipoSangue;
		
	}
	
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
