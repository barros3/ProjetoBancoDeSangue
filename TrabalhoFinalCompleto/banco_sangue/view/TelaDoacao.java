package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.BancoDeDados;
import model.CadastroDeClientes;
import model.CadastroDeVendas;
import model.Cliente;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class TelaDoacao extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lbVendas;
	private JTextField tfPessoa;
	private JTextField tfProduto;
	private JTextField tfQuantidade;
	private JTable tablePesquista;
	private JTable tablePesquista1;
	private JTable tableVenda = new JTable();
	private Venda venda = new Venda();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadTableCliente(String buscar) throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CPF", "Telefone", "Email", "Endereço" });

		Map<Integer, Cliente> mapaCliente = new HashMap<Integer, Cliente>();
		try {
			mapaCliente = (Map<Integer, Cliente>) BancoDeDados.buscaBancoDadosClientes();
			Collection contC = mapaCliente.values();
			Iterator interador = contC.iterator();
			while (interador.hasNext()) {
				Cliente clienteTemp = (Cliente) interador.next();
				modelo.addRow(new Object[] { clienteTemp.getIdCliente(), clienteTemp.getNome(), clienteTemp.getCpf(),
						clienteTemp.getTelefone(), clienteTemp.getEmail(), clienteTemp.getEndereco() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tablePesquista1.setModel(modelo);
		tablePesquista1.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePesquista1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int k = tablePesquista1.getSelectedRow();
				int idCliente = (int) tablePesquista1.getValueAt(k, 0);
				String nome = (String) tablePesquista1.getValueAt(k, 1);
				String cpf = (String) tablePesquista1.getValueAt(k, 2);
				String telefone = (String) tablePesquista1.getValueAt(k, 3);
				String email = (String) tablePesquista1.getValueAt(k, 4);
				String endereco = (String) tablePesquista1.getValueAt(k, 5);

				Cliente c = new Cliente(idCliente, nome, cpf, telefone, email, endereco);
				CadastroDeClientes.clienteVenda = c;
				tfPessoa.setText(CadastroDeClientes.clienteVenda.getNome());

			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
	}

	public void loadTableItensVenda() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Id Item", "Descrição", "Quantidade Venda", "Valor" });

		try {

			for (int i = 0; i < venda.getListaVenda().size(); i++) {
				ItemVenda vendaTemp = venda.getListaVenda().get(i);
				modelo.addRow(new Object[] { vendaTemp.getIdItem(), vendaTemp.getProduto().getNomeProduto(),
						vendaTemp.getQuantidade(),
						(vendaTemp.getProduto().getValorProduto() * vendaTemp.getQuantidade()) });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tableVenda.setModel(modelo);
		tableVenda.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableVenda.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int k = tableVenda.getSelectedRow();
				int id = (int) tableVenda.getValueAt(k, 0);
				venda.listaVenda.remove((id - 1));
				for (int i = 0; i < venda.getListaVenda().size(); i++) {
					ItemVenda vendaTemp = venda.getListaVenda().get(i);
					vendaTemp.setIdItem((i + 1));
				}
				try {
					loadTableItensVenda();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadTableProduto(String buscar) throws Exception {
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
		tablePesquista.setModel(modelo);
		tablePesquista.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePesquista.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int k = tablePesquista.getSelectedRow();
				int id = (int) tablePesquista.getValueAt(k, 0);
				String nome = (String) tablePesquista.getValueAt(k, 1);
				int quant = (int) tablePesquista.getValueAt(k, 2);
				double valor = (double) tablePesquista.getValueAt(k, 3);

				Produto p = new Produto(id, nome, quant, valor);
				CadastroDeVendas.produtoVenda = p;
				tfProduto.setText(CadastroDeVendas.produtoVenda.getNomeProduto());

			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
	}

	JScrollPane scrollPane = new JScrollPane();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoacao frame = new TelaDoacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDoacao() {
		setClosable(true);
		setTitle("Tela de Doa\u00E7\u00E3o");
		setName("Doacao");
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 61, 778, 400);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbCliente = new JLabel("Pessoa:");
		lbCliente.setBounds(39, 11, 42, 22);
		panel.add(lbCliente);

		tfPessoa = new JTextField();
		tfPessoa.setBounds(39, 33, 300, 22);
		panel.add(tfPessoa);
		tfPessoa.setColumns(10);

		JButton btnBuscarPessoa = new JButton("");
		btnBuscarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tablePesquista1 = new JTable();
					scrollPane.setViewportView(tablePesquista1);
					loadTableCliente(tfPessoa.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscarPessoa.setIcon(new ImageIcon("icon\\search.png"));
		btnBuscarPessoa.setBounds(349, 27, 32, 32);
		panel.add(btnBuscarPessoa);

		JLabel lbTipoSanguineo = new JLabel("Tipo Sanguineo:");
		lbTipoSanguineo.setBounds(39, 61, 195, 22);
		panel.add(lbTipoSanguineo);

		tfProduto = new JTextField();
		tfProduto.setBounds(39, 83, 300, 22);
		panel.add(tfProduto);
		tfProduto.setColumns(10);

		JButton btnBuscarProduto = new JButton("");
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tablePesquista = new JTable();
					scrollPane.setViewportView(tablePesquista);
					loadTableProduto(tfProduto.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscarProduto.setIcon(new ImageIcon("icon\\search.png"));
		btnBuscarProduto.setBounds(349, 77, 32, 32);
		panel.add(btnBuscarProduto);

		JLabel lbQuantidade = new JLabel("Quantidade:");
		lbQuantidade.setBounds(407, 61, 68, 22);
		panel.add(lbQuantidade);

		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(407, 83, 80, 22);
		panel.add(tfQuantidade);
		tfQuantidade.setColumns(10);

		Label label = new Label("Pesquisa:");
		label.setBounds(39, 115, 62, 22);
		panel.add(label);

		scrollPane.setBounds(39, 137, 700, 100);
		panel.add(scrollPane);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(39, 248, 700, 100);
		panel.add(scrollPane1);

		scrollPane1.setViewportView(tableVenda);

		JButton btnSalvar = new JButton("Add Doa\u00E7\u00E3o");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemVenda ivTemp = new ItemVenda();
				ivTemp.setProduto(CadastroDeVendas.produtoVenda);
				ivTemp.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
				ivTemp.setIdItem(venda.listaVenda.size() + 1);
				venda.listaVenda.add(ivTemp);
				try {
					loadTableItensVenda();
					tfValorTotal.setText(String.valueOf(venda.getTotalVenda()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(497, 83, 138, 23);
		panel.add(btnSalvar);

		JButton btnFinalizarVenda = new JButton("Finalizar Doa\u00E7\u00E3o");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDeVendas cadastroDeVendas = new CadastroDeVendas();
				venda.setClienteVenda(CadastroDeClientes.clienteVenda);
				venda.setValorTotal(Double.valueOf(tfValorTotal.getText()));
				venda.getClienteVenda().setTotalCompras(venda.getValorTotal());
				try {
					cadastroDeVendas.adicionaProduto(venda);
					venda.listaVenda.clear();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					loadTableItensVenda();
					tfValorTotal.setText("" + venda.getValorTotal());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnFinalizarVenda.setBounds(320, 362, 120, 32);
		panel.add(btnFinalizarVenda);
		
		JLabel lblDoeSangueDoe = new JLabel("Doe sangue. Sangue \u00E9 vida.");
		lblDoeSangueDoe.setBounds(10, 380, 138, 14);
		panel.add(lblDoeSangueDoe);

		lbVendas = new Label("Tela de Doa\u00E7\u00E3o");
		lbVendas.setForeground(Color.WHITE);
		lbVendas.setBackground(new Color(128, 0, 0));
		lbVendas.setAlignment(Label.CENTER);
		lbVendas.setFont(new Font("Arial", Font.BOLD, 18));
		lbVendas.setBounds(0, 0, 798, 60);
		getContentPane().add(lbVendas);
	}
}
