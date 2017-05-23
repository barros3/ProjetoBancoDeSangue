package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Doacao implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<NovaDoacao> listaDoacao;
	private Pessoa pessoaDoar;
	private int idDoacao;
	private String dtDoacao;
	
	public Doacao(){
		this.listaDoacao = new ArrayList<NovaDoacao>();
		setPessoaDoar(new Pessoa());
	}
	
	public ArrayList<NovaDoacao> getListaDoacao() {
		return listaDoacao;
	}
	public void setListaDoacao(ArrayList<NovaDoacao> listaDoacao) {
		this.listaDoacao = listaDoacao;
	}
	public Pessoa getPessoaDoar() {
		return pessoaDoar;
	}
	public void setPessoaDoar(Pessoa pessoaDoar) {
		this.pessoaDoar = pessoaDoar;
	}

	public int getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(int idDoacao) {
		this.idDoacao = idDoacao;
	}

	public String getDtDoacao() {
		return dtDoacao;
	}

	public void setDtDoacao(String dtDoacao) {
		this.dtDoacao = dtDoacao;
	}
	
	public static int compareToId(int id, Doacao o) {
		if (id < o.pessoaDoar.getIdPessoa()) {
            return -1;
        }
        if (id > o.pessoaDoar.getIdPessoa()) {
            return 1;
        }
		return 0;
	}	

}
