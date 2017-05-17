package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import model.BancoDeDados;
import model.Cliente;

public class TelaListaCadastroCliente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lbListaCadastroCliente;
	private JTable tableListaCliente;
	private JScrollPane scrollPane;
	private JButton btnRemoverClienteLista;
	private JButton btnEditarClienteLista;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroCliente frame = new TelaListaCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadTableListaCliente() throws Exception {
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
		tableListaCliente.setModel(modelo);
		tableListaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	public void atualizaTableClientes() throws Exception {
		Map<Integer, Cliente> mapaAtualizaCliente = new HashMap<Integer, Cliente>();
		for (int i = 0; i < tableListaCliente.getRowCount(); i++) {
			int idCliente = (int) tableListaCliente.getValueAt(i, 0);
			String nome = (String) tableListaCliente.getValueAt(i, 1);
			String cpf = (String) tableListaCliente.getValueAt(i, 2);
			String telefone = (String) tableListaCliente.getValueAt(i, 3);
			String email = (String) tableListaCliente.getValueAt(i, 4);
			String endereco = (String) tableListaCliente.getValueAt(i, 5);
			Cliente clienteAtualizado = new Cliente(idCliente, nome, cpf, telefone, email, endereco);
			mapaAtualizaCliente.put(clienteAtualizado.getIdCliente(), clienteAtualizado);
		}
		BancoDeDados.gravaClienteBancoDados(mapaAtualizaCliente);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroCliente() throws Exception {
		setToolTipText("Cadastro de clientes");
		setTitle("Cadastro de clientes");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tableListaCliente = new JTable();
		scrollPane.setViewportView(tableListaCliente);
		loadTableListaCliente();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnRemoverClienteLista = new JButton("Remover");
		btnRemoverClienteLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tableListaCliente.getModel()).removeRow(tableListaCliente.getSelectedRow());
			}
		});
		btnRemoverClienteLista.setBounds(10, 70, 100, 23);
		panel.add(btnRemoverClienteLista);

		btnEditarClienteLista = new JButton("Editar");
		btnEditarClienteLista.setBounds(10, 40, 100, 23);
		panel.add(btnEditarClienteLista);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizaTableClientes();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(10, 10, 100, 23);
		panel.add(btnSalvar);

		lbListaCadastroCliente = new Label("Cadastro de clientes");
		lbListaCadastroCliente.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroCliente);
		lbListaCadastroCliente.setBackground(new Color(0, 128, 128));
		lbListaCadastroCliente.setFont(new Font("Arial", Font.PLAIN, 18));
		lbListaCadastroCliente.setAlignment(Label.CENTER);
	}
}
