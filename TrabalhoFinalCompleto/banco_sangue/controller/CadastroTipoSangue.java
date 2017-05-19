package controller;

import java.io.EOFException;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.TipoSangue;

public class CadastroTipoSangue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Map<Integer, TipoSangue> cadastroTipoSangue = new HashMap<Integer, TipoSangue>();
	public static int finalTipoSangue = 1;
	
	@SuppressWarnings("unchecked")
	public static int getTamanhoBancoTpSangue() throws Exception {
		File diretorio = new File("arqBD");
		File arquivo = new File("arqBD\\TipoSangue.dat");
		try {
			if (!diretorio.exists()) {
				diretorio.mkdir();
				return 0;
			} else if (!arquivo.exists()) {
				arquivo.createNewFile();
				return 0;
			} else {
				Map<Integer, TipoSangue> tmp = (Map<Integer, TipoSangue>) BancoDeDados.buscaDBTipoSangue();
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
	public void adicionaTipoSangue(TipoSangue ts) throws Exception{
		BancoDeDados.verificaBDTipoSangue();
		try{
			cadastroTipoSangue = (Map<Integer, TipoSangue>) BancoDeDados.buscaDBTipoSangue();
			CadastroTipoSangue.finalTipoSangue = cadastroTipoSangue.size();
			ts.setIdTpSangue(finalTipoSangue+1);
			cadastroTipoSangue.put(ts.getIdTpSangue(), ts);
			BancoDeDados.gravaTipoSangueBD(cadastroTipoSangue);
		} catch (EOFException e) {
			CadastroTipoSangue.finalTipoSangue = cadastroTipoSangue.size();
			ts.setIdTpSangue(finalTipoSangue+1);
			cadastroTipoSangue.put(ts.getIdTpSangue(), ts);
			BancoDeDados.gravaTipoSangueBD(cadastroTipoSangue);
		}
		}
	}

