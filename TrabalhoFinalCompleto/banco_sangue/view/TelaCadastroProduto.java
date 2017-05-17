package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import model.CadastroDeProdutos;
import model.Produto;

public class TelaCadastroProduto extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfProduto;
	private JTextField tfValor;
	private Label lbCadastroProduto;
	private JTextField tfIdProduto;
	private JTextField tfQuantidadeProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() throws Exception {
		CadastroDeProdutos cadastroProdutos = new CadastroDeProdutos();
		setTitle("Cadastro de Produto");
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setClosable(true);
		setBounds(150, 50, 600, 400);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 60, 580, 300);
		getContentPane().add(panel);
		panel.setLayout(null);

		lbCadastroProduto = new Label("Cadastro de Produto");
		lbCadastroProduto.setBackground(new Color(0, 128, 128));
		lbCadastroProduto.setBounds(0, 0, 598, 60);
		lbCadastroProduto.setFont(new Font("Arial", Font.PLAIN, 18));
		lbCadastroProduto.setAlignment(Label.CENTER);
		getContentPane().add(lbCadastroProduto);

		JButton btnSalvarProduto = new JButton("Salvar");
		btnSalvarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int quantidadeProduto = Integer.parseInt(tfQuantidadeProduto.getText());
				Double valor = Double.parseDouble(tfValor.getText());
				Produto produto = new Produto(tfProduto.getText(), quantidadeProduto, valor);
				tfIdProduto.setText("" + produto.getIdProduto());
				try {
					cadastroProdutos.adicionaProduto(produto);
					tfIdProduto.setText("" + (CadastroDeProdutos.getTamanhoBancoProduto() + 1));
					tfProduto.setText("");
					tfQuantidadeProduto.setText("");
					tfValor.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSalvarProduto.setBounds(240, 265, 100, 23);
		panel.add(btnSalvarProduto);
		btnSalvarProduto.setName("Salvar");

		Label lbProduto = new Label("Produto:");
		lbProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbProduto.setBounds(56, 73, 55, 22);
		panel.add(lbProduto);
		lbProduto.setAlignment(Label.RIGHT);

		tfProduto = new JTextField();
		tfProduto.setBounds(115, 73, 350, 22);
		panel.add(tfProduto);
		tfProduto.setColumns(10);

		Label lbValor = new Label("Valor:");
		lbValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbValor.setBounds(56, 102, 55, 22);
		panel.add(lbValor);
		lbValor.setName("Valor");
		lbValor.setAlignment(Label.RIGHT);

		MaskFormatter mascaraCampo = new MaskFormatter("####.##");
		tfValor = new JFormattedTextField(mascaraCampo);
		tfValor.setBounds(115, 102, 80, 22);
		panel.add(tfValor);
		tfValor.setColumns(10);

		JLabel lbIdProduto = new JLabel("ID:");
		lbIdProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbIdProduto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lbIdProduto.setBounds(56, 44, 55, 22);
		panel.add(lbIdProduto);

		tfIdProduto = new JTextField();
		tfIdProduto.setEditable(false);
		tfIdProduto.setBounds(115, 44, 40, 22);
		tfIdProduto.setText("" + (CadastroDeProdutos.getTamanhoBancoProduto() + 1));
		panel.add(tfIdProduto);
		tfIdProduto.setColumns(10);

		tfQuantidadeProduto = new JTextField();
		tfQuantidadeProduto.setBounds(277, 102, 80, 22);
		panel.add(tfQuantidadeProduto);
		tfQuantidadeProduto.setColumns(10);

		JLabel lbQuantidadeDoProduto = new JLabel("Quantidade:");
		lbQuantidadeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbQuantidadeDoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lbQuantidadeDoProduto.setBounds(205, 102, 68, 22);
		panel.add(lbQuantidadeDoProduto);
	}
}
