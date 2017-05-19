package br.com.ufsc.testesClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import controller.BancoDeDados;
import model.Venda;
import view.TelaListaCadastroCliente;
import view.TelaListaCadastroVenda;
import view.TelaVendas;

//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;

@SuppressWarnings("unused")
public class Testes {

	@SuppressWarnings({ })
	public static void main(String[] args) throws Exception {
		TelaListaCadastroCliente venda = new TelaListaCadastroCliente();
		
	
		venda.atualizaTableClientes();
		
		
		
		
		
		
		
		
		
		
		
//		CadastroDeProdutos cadastroP = new CadastroDeProdutos();
//		CadastroDeClientes cadastroC = new CadastroDeClientes();
//		List<ItemVenda> aitv = new ArrayList<ItemVenda>();
//		ItemVenda itv = new ItemVenda();
//		Produto produto = new Produto("Chachorro Quente",10, 7.5);
//		Produto produto2 = new Produto("X Salada",13, 11);
//		Produto produto3 = new Produto("X Tudo",22, 17.30);
//		Produto produto4 = new Produto("X Calota",17, 55.5);
//		Cliente cliente = new Cliente("Guilherme", "12345678910", "99132155", "guimente@gui.com", "rua rio branco");
//		Cliente cliente2 = new Cliente("Bruno", "12345678911", "88951254", "bruno@bruno.com", "Rufino Orgige");
//		Cliente cliente3 = new Cliente("Peruchi", "12345678912", "91165239", "peruchi@academia.com", "avenida Sete de Setembro");
//		Cliente cliente4 = new Cliente("Leonardo", "12345678913", "35215300", "leo.gay@peladinhonacan.com", "rua das Flores");
//		
//		cadastroP.adicionaProduto(produto);
//		cadastroP.adicionaProduto(produto2);
//		cadastroP.adicionaProduto(produto3);
//		cadastroP.adicionaProduto(produto4);
//		cadastroC.adicionaCliente(cliente);
//		cadastroC.adicionaCliente(cliente2);
//		cadastroC.adicionaCliente(cliente3);
//		cadastroC.adicionaCliente(cliente4);
//		
//		itv.setProduto(produto);
//		itv.setQuantidade(5);
//		aitv.add(itv);
//		itv.setProduto(produto2);
//		itv.setQuantidade(5);
//		aitv.add(itv);
//		itv.setProduto(produto3);
//		itv.setQuantidade(5);
//		aitv.add(itv);
//		itv.setProduto(produto4);
//		itv.setQuantidade(5);
//		aitv.add(itv);
//		System.out.println(aitv.size());
//		
//		for(int i = 0; i < aitv.size(); i++){
//		System.out.println(produto.getNomeProduto());
//		System.out.println(produto2.getNomeProduto());
//		System.out.println(produto3.getNomeProduto());
//		System.out.println(produto4.getNomeProduto());
//			System.out.println(aitv.get(0).getProduto().getNomeProduto());
//			System.out.println(aitv.get(1).getProduto().getNomeProduto());
//			System.out.println(aitv.get(2).getProduto().getNomeProduto());
//			System.out.println(aitv.get(3).getProduto().getNomeProduto());
//		}
//		aitv.remove(2);
//		System.out.println("\n");
//		for(int i = 0; i < aitv.size(); i++){
//			System.out.println(aitv.get(i).getProduto().getNomeProduto());
//		}
//		
//		
//		Map<Integer, Venda> tmp = new HashMap<Integer, Venda>();
//		tmp = (Map<Integer, Venda>) BancoDeDados.buscaBancoDadosVendas();
//		Collection contp = tmp.values();
//		Iterator ip = contp.iterator();
//		while (ip.hasNext()) {
//			Venda temp = (Venda) ip.next();
//			System.out.println("\n");
//			System.out.println(temp.getClienteVenda().getNome());
//			for(int i = 0; i < temp.listaVenda.size();i++){
//				System.out.println("\n"+temp.listaVenda.get(i).getProduto().getNomeProduto());
//			}
//		}
//		
//		Map<Integer, Cliente> tmc = new HashMap<Integer, Cliente>();
//		tmc = ((Map<Integer, Cliente>) BancoDeDados.buscaBancoDadosClientes());
//		Collection contc = tmc.values();
//		Iterator ic = contc.iterator();		
//		while (ic.hasNext()) {
//			Cliente temc = (Cliente) ic.next();
//			System.out.println("\n");
//			System.out.println(temc.getNome() + temc.getIdCliente());
//		}
//		
//		int a= 5;
//		double b = 1.5;
//		
//		System.out.println((a * b));
//		
	}
}
