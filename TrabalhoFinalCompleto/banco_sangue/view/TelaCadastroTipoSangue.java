package view;

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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import controller.CadastroTipoSangue;
import model.TipoSangue;

public class TelaCadastroTipoSangue extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTipoSangue;
	private Label lbCadastro;
	private JTextField tfId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTipoSangue frame = new TelaCadastroTipoSangue();
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
	public TelaCadastroTipoSangue() throws Exception {
		CadastroTipoSangue cadastroTpSangue = new CadastroTipoSangue();

		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setName("Cadastro de Pessoa");
		setSize(new Dimension(600, 446));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setTitle("Cadastro de Tipo Sanguineo");
		setClosable(true);

		setBounds(150, 50, 600, 400);
		getContentPane().setLayout(null);

		lbCadastro = new Label("Cadastro de Tipo Sanguineo");
		lbCadastro.setForeground(Color.WHITE);
		lbCadastro.setBackground(new Color(128, 0, 0));
		lbCadastro.setBounds(0, 0, 598, 60);
		getContentPane().add(lbCadastro);
		lbCadastro.setName("CadastroTipoSangue");
		lbCadastro.setFont(new Font("Arial", Font.BOLD, 18));
		lbCadastro.setAlignment(Label.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 60, 580, 300);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbIdTipoSangue = new JLabel("ID:");
		lbIdTipoSangue.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lbIdTipoSangue.setBounds(56, 60, 52, 22);
		panel.add(lbIdTipoSangue);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(115, 60, 40, 22);
		tfId.setText("" + (CadastroTipoSangue.getTamanhoBancoTpSangue() + 1));
		panel.add(tfId);
		tfId.setColumns(10);

		Label lbTipoSangue = new Label("Tipo Sanguineo:");
		lbTipoSangue.setBounds(10, 89, 98, 22);
		panel.add(lbTipoSangue);
		lbTipoSangue.setAlignment(Label.RIGHT);

		tfTipoSangue = new JTextField();
		tfTipoSangue.setBounds(115, 89, 350, 22);
		panel.add(tfTipoSangue);
		tfTipoSangue.setColumns(10);

		tfTipoSangue.setEditable(false);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfTipoSangue.setEditable(true);
				try {
					tfId.setText("" + (CadastroTipoSangue.getTamanhoBancoTpSangue() + 1));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		btnNovo.setBounds(125, 266, 100, 23);
		panel.add(btnNovo);

		JButton btnSalvarTipoSangue = new JButton("Salvar");
		btnSalvarTipoSangue.setBounds(235, 266, 100, 23);
		panel.add(btnSalvarTipoSangue);
		btnSalvarTipoSangue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoSangue tpSangue = new TipoSangue(tfTipoSangue.getText());
				try {
					cadastroTpSangue.adicionaTipoSangue(tpSangue);
					tfId.setText("" + (CadastroTipoSangue.getTamanhoBancoTpSangue() + 1));
					tfTipoSangue.setText("");
					tfTipoSangue.requestFocus();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(tfTipoSangue, "Adicioando com sucesso!");
			}

		});
		btnSalvarTipoSangue.setName("Salvar");

		JButton btFecharTelaCadastroCliente = new JButton("Fechar");
		btFecharTelaCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btFecharTelaCadastroCliente.setBounds(345, 266, 100, 23);
		panel.add(btFecharTelaCadastroCliente);
	}
}
