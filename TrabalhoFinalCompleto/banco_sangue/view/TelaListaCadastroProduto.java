package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import model.BancoDeDados;
import model.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaCadastroProduto extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tableListaProduto;
	private JButton btnRemoverProdutoLista;
	private JButton btnEditarProdutoLista;
	private Label lbListaCadastroProduto;
	private JButton btnNewButton;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadTableListaProduto() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Quantidade Estoque", "Valor" });

		Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>();
		try {
			mapaProduto = (Map<Integer, Produto>) BancoDeDados.buscaBancoDadosProdutos();
			Collection contC = mapaProduto.values();
			Iterator interador = contC.iterator();
			while (interador.hasNext()) {
				Produto produtoTemp = (Produto) interador.next();
				modelo.addRow(new Object[] { produtoTemp.getIdProduto(), produtoTemp.getNomeProduto(),
						produtoTemp.getQuantidade(), produtoTemp.getValorProduto() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tableListaProduto.setModel(modelo);
		tableListaProduto.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	public void atualizaTableProduto() throws Exception {
		Map<Integer, Produto> mapaAtualizaProduto = new HashMap<Integer, Produto>();
		for (int i = 0; i < tableListaProduto.getRowCount(); i++) {
			int idProduto = (int) tableListaProduto.getValueAt(i, 0);
			String nomeProduto = (String) tableListaProduto.getValueAt(i, 1);
			int qtd = (int) tableListaProduto.getValueAt(i, 2);
			double valorProduto = (double) tableListaProduto.getValueAt(i, 3);
			Produto produtoAtualizado = new Produto(idProduto, nomeProduto, qtd, valorProduto);
			mapaAtualizaProduto.put(produtoAtualizado.getIdProduto(), produtoAtualizado);
		}
		 BancoDeDados.gravaProdutoBancoDados(mapaAtualizaProduto);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroProduto frame = new TelaListaCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroProduto() throws Exception {
		setToolTipText("");
		setTitle("Cadastro de produtos");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tableListaProduto = new JTable();
		scrollPane.setViewportView(tableListaProduto);
		loadTableListaProduto();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnRemoverProdutoLista = new JButton("Remover");
		btnRemoverProdutoLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel) tableListaProduto.getModel()).removeRow(tableListaProduto.getSelectedRow());
			}
		});
		btnRemoverProdutoLista.setBounds(10, 70, 100, 23);
		panel.add(btnRemoverProdutoLista);

		btnEditarProdutoLista = new JButton("Editar");
		btnEditarProdutoLista.setBounds(10, 40, 100, 23);
		panel.add(btnEditarProdutoLista);

		btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizaTableProduto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 10, 100, 23);
		panel.add(btnNewButton);

		lbListaCadastroProduto = new Label("Cadastro de produtos");
		lbListaCadastroProduto.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroProduto);
		lbListaCadastroProduto.setBackground(new Color(0, 128, 128));
		lbListaCadastroProduto.setFont(new Font("Arial", Font.PLAIN, 18));
		lbListaCadastroProduto.setAlignment(Label.CENTER);
	}
}
