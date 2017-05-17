package br.com.ufsc.pdvfast.telas;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import br.com.ufsc.pdvfast.CadastroDeClientes;
import br.com.ufsc.pdvfast.Cliente;

public class TelaCadastroCliente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JFormattedTextField tfCpf;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private Label lbCadastro;
	private JTextField tfId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() throws Exception {
		CadastroDeClientes cadastroCliente = new CadastroDeClientes();

		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setName("Cadastro de Cliente");
		setSize(new Dimension(450, 0));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setTitle("Cadastro de Cliente");
		setClosable(true);

		setBounds(150, 50, 600, 400);
		getContentPane().setLayout(null);

		lbCadastro = new Label("Cadastro de Cliente");
		lbCadastro.setBackground(new Color(0, 128, 128));
		lbCadastro.setBounds(0, 0, 598, 60);
		getContentPane().add(lbCadastro);
		lbCadastro.setName("CadastroDeCliente");
		lbCadastro.setFont(new Font("Arial", Font.PLAIN, 18));
		lbCadastro.setAlignment(Label.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 60, 580, 300);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbIdCliente = new JLabel("ID:");
		lbIdCliente.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lbIdCliente.setBounds(56, 15, 52, 22);
		panel.add(lbIdCliente);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(115, 15, 40, 22);
		tfId.setText("" + (CadastroDeClientes.getTamanhoBancoCliente() + 1));
		panel.add(tfId);
		tfId.setColumns(10);

		Label lbNome = new Label("Nome:");
		lbNome.setBounds(56, 44, 52, 22);
		panel.add(lbNome);
		lbNome.setAlignment(Label.RIGHT);

		tfNome = new JTextField();
		tfNome.setBounds(115, 44, 350, 22);
		panel.add(tfNome);
		tfNome.setColumns(10);

		Label lbCpf = new Label("CPF:");
		lbCpf.setBounds(56, 73, 52, 22);
		panel.add(lbCpf);
		lbCpf.setAlignment(Label.RIGHT);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValidCharacters("0123456789");
			tfCpf = new JFormattedTextField(mascaraCpf);
			tfCpf.setBounds(115, 73, 350, 22);
			panel.add(tfCpf);
			tfCpf.setColumns(11);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro: " + ex);
		}

		Label lbTelefone = new Label("Telefone:");
		lbTelefone.setBounds(54, 102, 57, 22);
		panel.add(lbTelefone);
		lbTelefone.setAlignment(Label.RIGHT);

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(###) ####-####");
			mascaraTelefone.setValidCharacters("0123456789");
			mascaraTelefone.setPlaceholderCharacter('_');
			tfTelefone = new JFormattedTextField(mascaraTelefone);
			tfTelefone.setBounds(115, 102, 350, 22);
			panel.add(tfTelefone);
			tfTelefone.setColumns(11);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro: " + ex);
		}

		Label lbEmail = new Label("Email:");
		lbEmail.setBounds(56, 131, 52, 22);
		panel.add(lbEmail);
		lbEmail.setAlignment(Label.RIGHT);

		tfEmail = new JTextField();
		tfEmail.setBounds(115, 131, 350, 22);
		panel.add(tfEmail);
		tfEmail.setColumns(10);

		Label lbEndereco = new Label("Endere\u00E7o:");
		lbEndereco.setBounds(54, 160, 57, 22);
		panel.add(lbEndereco);
		lbEndereco.setAlignment(Label.RIGHT);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(115, 160, 350, 22);
		panel.add(tfEndereco);
		tfEndereco.setColumns(10);

		tfNome.setEditable(false);
		tfCpf.setEditable(false);
		tfTelefone.setEditable(false);
		tfEmail.setEditable(false);
		tfEndereco.setEditable(false);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNome.setEditable(true);
				tfCpf.setEditable(true);
				tfTelefone.setEditable(true);
				tfEmail.setEditable(true);
				tfEndereco.setEditable(true);
				try {
					tfId.setText("" + (CadastroDeClientes.getTamanhoBancoCliente() + 1));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNovo.setBounds(125, 266, 100, 23);
		panel.add(btnNovo);

		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.setBounds(235, 266, 100, 23);
		panel.add(btnSalvarCliente);
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente(tfNome.getText(), tfCpf.getText(), tfTelefone.getText(),
						tfEmail.getText(), tfEndereco.getText());
				try {
					cadastroCliente.adicionaCliente(cliente);
					tfId.setText("" + (CadastroDeClientes.getTamanhoBancoCliente() + 1));
					tfNome.setText("");
					tfNome.requestFocus();
					tfCpf.setText("");
					tfTelefone.setText("");
					tfEmail.setText("");
					tfEndereco.setText("");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(tfNome, "Adicioando com sucesso!");
			}

		});
		btnSalvarCliente.setName("Salvar");

		JButton btFecharTelaCadastroCliente = new JButton("Fechar");
		btFecharTelaCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btFecharTelaCadastroCliente.setBounds(345, 266, 100, 23);
		panel.add(btFecharTelaCadastroCliente);
	}
}
