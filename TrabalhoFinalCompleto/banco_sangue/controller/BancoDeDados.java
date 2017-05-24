package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

import model.Doacao;
import model.Pessoa;
import model.Produto;
import model.TipoSangue;
import model.Venda;

public class BancoDeDados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Verificar se o banco de dados existe
	 */
	
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
	
	public static void verificaBDDoacao() throws IOException {
		File diretorio = new File("arqBD");
		File arquivo = new File("arqBD\\Doacao.dat");
		
		if (!diretorio.exists()){
			diretorio.mkdir();
		}
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
	}
	

	/*
	 * Gravar no banco de dados
	 */
	
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
	
	public static void gravaDoacaoBD(Map<Integer, Doacao> cadastroDoacao) throws Exception {
		FileOutputStream arquivo = new FileOutputStream("arqBD\\Doacao.dat");
		ObjectOutputStream streamObjeto = new ObjectOutputStream(arquivo);
		
		streamObjeto.writeObject(cadastroDoacao);
		streamObjeto.close();
		arquivo.close();
	}
	
	
	/*
	 * Buscano banco de dados
	 * @return
	 */

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
	public static Object buscaBBDoacao() throws Exception {
		FileInputStream abrirArquivo = new FileInputStream("arqBD\\Doacao.dat");
		ObjectInputStream abrirObjeto = new ObjectInputStream(abrirArquivo);

		Object mapDoacao = (Map<Integer, Doacao>) abrirObjeto.readObject();

		abrirObjeto.close();
		abrirArquivo.close();
		return mapDoacao;
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
