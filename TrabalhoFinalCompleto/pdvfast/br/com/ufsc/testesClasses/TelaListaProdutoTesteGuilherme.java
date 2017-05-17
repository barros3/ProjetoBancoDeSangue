package br.com.ufsc.testesClasses;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.ufsc.pdvfast.BancoDeDados;
import br.com.ufsc.pdvfast.Cliente;
import br.com.ufsc.pdvfast.Produto;
import br.com.ufsc.pdvfast.Venda;

@SuppressWarnings("unused")
public class TelaListaProdutoTesteGuilherme {
	private JFrame janela;
	private JPanel painelPrincipal;
	private Venda venda = new Venda();
	private JTable table;
	private JButton botaoSair;

	/**
	 * @wbp.nonvisual location=130,279
	 */

	public static void main(String[] args) {
		// new TelaListaProduto().relProduto();
		new TelaListaProdutoTesteGuilherme().relClienteTop10();
		new TelaListaProdutoTesteGuilherme().relCliente();
	}

	private void relProduto() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotaoSair();
		tableProduto(null);
		mostraJanela();
	}

	private void relCliente() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotaoSair();
		tableCliente(null);
		mostraJanela();
	}

	private void relClienteTop10() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotaoSair();
		tableClienteTop10(null);
		mostraJanela();
	}

	private void preparaJanela() {
		janela = new JFrame("Lista Produto");
		janela.setAlwaysOnTop(true);
		janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void mostraJanela() {
		janela.pack();
		// janela.setSize(268, 145);
		janela.setVisible(true);
	}

	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.getContentPane().add(painelPrincipal, BorderLayout.CENTER);
	}

	private void preparaBotaoSair() {
		botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelPrincipal.add(botaoSair);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void tableProduto(final java.awt.event.ActionEvent evt) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Id Produto", "Descrição", "Valor" });
		Map<Integer, Produto> tmp = new HashMap<Integer, Produto>();
		try {
			tmp = (Map<Integer, Produto>) BancoDeDados.buscaBancoDadosProdutos();
			Collection contp = tmp.values();
			Iterator ip = contp.iterator();
			while (ip.hasNext()) {
				Produto temp = (Produto) ip.next();
				model.addRow(new Object[] { temp.getIdProduto(), temp.getNomeProduto(), temp.getValorProduto() });
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		painelPrincipal.add(scroll);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void tableCliente(final java.awt.event.ActionEvent evt) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Id Cliente", "Nome", "Cpf", "Telefone", "Email", "Endereço" });
		Map<Integer, Cliente> tmp = new HashMap<Integer, Cliente>();
		try {
			tmp = (Map<Integer, Cliente>) BancoDeDados.buscaBancoDadosClientes();
			Collection contp = tmp.values();
			Iterator ip = contp.iterator();
			while (ip.hasNext()) {
				Cliente temp = (Cliente) ip.next();
				model.addRow(new Object[] { temp.getIdCliente(), temp.getNome(), temp.getCpf(), temp.getTelefone(),
						temp.getEmail(), temp.getEndereco() });
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		painelPrincipal.add(scroll);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void tableClienteTop10(final java.awt.event.ActionEvent evt) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Id Cliente", "Nome", "Cpf", "Total Compras" });
		Map<Integer, Venda> tmp = new HashMap<Integer, Venda>();
		try {
			tmp = (Map<Integer, Venda>) BancoDeDados.buscaBancoDadosVendas();
			Collection contc = tmp.values();
			Iterator jc = contc.iterator();
			Iterator ic = contc.iterator();
			double maior = 1000000;
			while (ic.hasNext()) {
				int cont = 0;

				Venda temp = null;
				while (jc.hasNext()) {
					Venda temp1 = (Venda) jc.next();
					if (temp1.getValorTotal() < maior) {
						temp = temp1;
					}
				}
				cont++;
				maior = temp.getValorTotal();
				model.addRow(new Object[] { temp.getClienteVenda().getIdCliente(), temp.getClienteVenda().getNome(),
						temp.getClienteVenda().getCpf(), temp.getValorTotal() });
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		painelPrincipal.add(scroll);
	}

	public Venda getVendas() {
		return venda;
	}

	public void setVendas(Venda venda) {
		this.venda = venda;
	}
}

// table.addMouseListener(new MouseListener() {
// public void mouseClicked(MouseEvent e) {
// System.out.println("opa");
// int k = table.getSelectedRow();
// int id = (int) table.getValueAt(k, 0);
// String nome = (String) table.getValueAt(k, 1);
// int quant = (int) table.getValueAt(k, 2);
// double valor = (double) table.getValueAt(k, 3);
//
// Produto p = new Produto(id,nome,quant, valor);
// System.out.println(p.getQuantidade() + p.getNomeProduto() +
// p.getValorProduto());
// Venda.produtoVenda = p;
//
// }
//
// public void mousePressed(MouseEvent e) {
// }
//
// public void mouseReleased(MouseEvent e) {
// }
//
// public void mouseEntered(MouseEvent e) {
// }
//
// public void mouseExited(MouseEvent e) {
// }
// });
