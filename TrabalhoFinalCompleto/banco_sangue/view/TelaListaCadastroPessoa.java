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
import model.Pessoa;
import javax.swing.JLabel;

public class TelaListaCadastroPessoa extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lbListaCadastroPessoa;
	private JTable tablePessoas;
	private JScrollPane scrollPane;
	private JButton btnRemoverPessoaLista;
	private JButton btnEditarClienteLista;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroPessoa frame = new TelaListaCadastroPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadTableListaPessoa() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CPF", "Telefone", "Email", "Endereço", "Tipo Sangue" });

		Map<Integer, Pessoa> mapaCliente = new HashMap<Integer, Pessoa>();
		try {
			mapaCliente = (Map<Integer, Pessoa>) BancoDeDados.buscaBDPessoa();
			Collection contC = mapaCliente.values();
			Iterator interador = contC.iterator();
			while (interador.hasNext()) {
				Pessoa pessoaTemp = (Pessoa) interador.next();
				modelo.addRow(new Object[] { pessoaTemp.getIdPessoa(), pessoaTemp.getNome(), pessoaTemp.getCpf(),
						pessoaTemp.getTelefone(), pessoaTemp.getEmail(), pessoaTemp.getEndereco(), pessoaTemp.getTipoSangue() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tablePessoas.setModel(modelo);
		tablePessoas.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	public void atualizaTablePessoa() throws Exception {
		Map<Integer, Pessoa> mapaAtualizaPessoa = new HashMap<Integer, Pessoa>();
		for (int i = 0; i < tablePessoas.getRowCount(); i++) {
			int idPessoa = (int) tablePessoas.getValueAt(i, 0);
			String nome = (String) tablePessoas.getValueAt(i, 1);
			String cpf = (String) tablePessoas.getValueAt(i, 2);
			String telefone = (String) tablePessoas.getValueAt(i, 3);
			String email = (String) tablePessoas.getValueAt(i, 4);
			String endereco = (String) tablePessoas.getValueAt(i, 5);
			String tipoSangue = (String) tablePessoas.getValueAt(i, 6);
			Pessoa pAtualizada = new Pessoa(idPessoa, nome, cpf, telefone, email, endereco, tipoSangue);
			mapaAtualizaPessoa.put(pAtualizada.getIdPessoa(), pAtualizada);
		}
		BancoDeDados.gravaPessoaBD(mapaAtualizaPessoa);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroPessoa() throws Exception {
		setToolTipText("Lista de Pesoas");
		setTitle("Lista de Pessoas");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tablePessoas = new JTable();
		scrollPane.setViewportView(tablePessoas);
		loadTableListaPessoa();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnRemoverPessoaLista = new JButton("Remover");
		btnRemoverPessoaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tablePessoas.getModel()).removeRow(tablePessoas.getSelectedRow());
			}
		});
		btnRemoverPessoaLista.setBounds(10, 70, 100, 23);
		panel.add(btnRemoverPessoaLista);

		btnEditarClienteLista = new JButton("Editar");
		btnEditarClienteLista.setBounds(10, 40, 100, 23);
		panel.add(btnEditarClienteLista);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizaTablePessoa();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(10, 10, 100, 23);
		panel.add(btnSalvar);

		lbListaCadastroPessoa = new Label("Lista de Pessoas Cadastradas");
		lbListaCadastroPessoa.setForeground(new Color(255, 255, 255));
		lbListaCadastroPessoa.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroPessoa);
		lbListaCadastroPessoa.setBackground(new Color(128, 0, 0));
		lbListaCadastroPessoa.setFont(new Font("Arial", Font.BOLD, 18));
		lbListaCadastroPessoa.setAlignment(Label.CENTER);
	}
}
