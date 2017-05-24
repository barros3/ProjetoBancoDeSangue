package controller;

import java.io.EOFException;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.Pessoa;

public class CadastroDePessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Map<Integer, Pessoa> cadastroPessoa = new HashMap<Integer, Pessoa>();
	public static int finalPessoa = 1;
	public static Pessoa pessoaDoacao;
	
	@SuppressWarnings("unchecked")
	public static int getTamanhoBancoPessoa() throws Exception {
		File diretorio = new File("arqBD");
		File arquivo = new File("arqBD\\Pessoa.dat");
		try {
			if (!diretorio.exists()) {
				diretorio.mkdir();
				return 0;
			} else if (!arquivo.exists()) {
				arquivo.createNewFile();
				return 0;
			} else {
				Map<Integer, Pessoa> tmp = (Map<Integer, Pessoa>) BancoDeDados.buscaBDPessoa();
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
	 * BD, DEPOIS ELE INSERE UMA PESSOA E SOBRESCREVE O BANCO NOVAMENTE
	 * COM A NOVA INFORMAÇÃO.
	 */
	
	@SuppressWarnings("unchecked")
	public void adicionaPessoa(Pessoa p) throws Exception{
		BancoDeDados.verificaBDPessoa();
		try{
			cadastroPessoa = (Map<Integer, Pessoa>) BancoDeDados.buscaBDPessoa();
			CadastroDePessoa.finalPessoa = cadastroPessoa.size();
			p.setIdPessoa(finalPessoa+1);
			cadastroPessoa.put(p.getIdPessoa(), p);
			BancoDeDados.gravaPessoaBD(cadastroPessoa);
		} catch (EOFException e) {
			CadastroDePessoa.finalPessoa = cadastroPessoa.size();
			p.setIdPessoa(finalPessoa + 1);
			cadastroPessoa.put(p.getIdPessoa(), p);
			BancoDeDados.gravaPessoaBD(cadastroPessoa);
		}
		}
	}

