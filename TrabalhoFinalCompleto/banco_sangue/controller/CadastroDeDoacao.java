package controller;

import java.io.EOFException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.Doacao;

public class CadastroDeDoacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, Doacao> cadastroDoacao = new HashMap<Integer, Doacao>();
	public static int finalDoacao = 1;
	public static Doacao doacaoSangue;
	
	@SuppressWarnings("unchecked")
	public void adicionaDoacao(Doacao v) throws Exception {
		BancoDeDados.verificaBDDoacao();
		try{
			cadastroDoacao = (Map<Integer, Doacao>) BancoDeDados.buscaBBDoacao();
			CadastroDeDoacao.finalDoacao = cadastroDoacao.size();
			v.setIdDoacao(finalDoacao + 1);
			cadastroDoacao.put(v.getIdDoacao(), v);
			BancoDeDados.gravaDoacaoBD(cadastroDoacao);
		} catch (EOFException e){
			CadastroDeDoacao.finalDoacao = cadastroDoacao.size();
			v.setIdDoacao(finalDoacao+1);
			cadastroDoacao.put(v.getIdDoacao(), v);
			BancoDeDados.gravaDoacaoBD(cadastroDoacao);
		}
	}

}
