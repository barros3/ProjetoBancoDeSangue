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

import controller.BancoDeDados;
import model.ItemVenda;
import model.Venda;

public class TelaListaCadastroVenda extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tableListaVenda;
	private JButton btnFecharListaVenda;
	private Label lbListaCadastroVenda;
	@SuppressWarnings("unused")
	private Venda venda = new Venda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroVenda frame = new TelaListaCadastroVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadTableListaItensVenda() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Id Item", "Descrição", "Quantidade Venda", "Valor" });

		Map<Integer, Venda> mapaVenda = new HashMap<Integer, Venda>();
		try {
			mapaVenda = (Map<Integer, Venda>) BancoDeDados.buscaBancoDadosVendas();
			Collection contV = mapaVenda.values();
			Iterator interador = contV.iterator();
			while (interador.hasNext()) {
				ItemVenda ItemvendaTemp = (ItemVenda) interador.next();
				modelo.addRow(new Object[] { ItemvendaTemp.getIdItem(), ItemvendaTemp.getProduto(),
						ItemvendaTemp.getQuantidade(), ItemvendaTemp.getProduto().getValorProduto() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tableListaVenda.setModel(modelo);
		tableListaVenda.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroVenda() throws Exception {
		setToolTipText("Vendas");
		setTitle("Vendas");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tableListaVenda = new JTable();
		scrollPane.setViewportView(tableListaVenda);
		loadTableListaItensVenda();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnFecharListaVenda = new JButton("Fechar");
		btnFecharListaVenda.setBounds(10, 11, 100, 22);
		panel.add(btnFecharListaVenda);

		lbListaCadastroVenda = new Label("Vendas");
		lbListaCadastroVenda.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroVenda);
		lbListaCadastroVenda.setBackground(new Color(0, 128, 128));
		lbListaCadastroVenda.setFont(new Font("Arial", Font.PLAIN, 18));
		lbListaCadastroVenda.setAlignment(Label.CENTER);
	}
}
