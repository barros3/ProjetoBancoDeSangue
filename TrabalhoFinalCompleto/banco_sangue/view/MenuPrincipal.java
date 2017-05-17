package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JDesktopPane;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component Internal = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setName("PdvFast");
		setTitle("PDVFast");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\window.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 720);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 110, 1387, 572);
		contentPane.add(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 25);
		contentPane.add(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setBorder(null);
		menuBar.add(mnCadastro);

		JMenu mnListaCadastrosGeral = new JMenu("Cadastros");
		mnCadastro.add(mnListaCadastrosGeral);

		JMenuItem mntmCadastroGeralListaCliente = new JMenuItem("Clientes");
		mntmCadastroGeralListaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaCadastroCliente listaCliente = null;
				try {
					listaCliente = new TelaListaCadastroCliente();
					listaCliente.loadTableListaCliente();
				} catch (Exception e) {
					e.printStackTrace();
				}
				desktopPane.add(listaCliente);
				listaCliente.setVisible(true);
			}
		});
		mnListaCadastrosGeral.add(mntmCadastroGeralListaCliente);

		JMenuItem mntmCadastroGeralListaProduto = new JMenuItem("Produtos");
		mntmCadastroGeralListaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaCadastroProduto listaProduto = null;
				try {
					listaProduto = new TelaListaCadastroProduto();
					listaProduto.loadTableListaProduto();
				} catch (Exception p) {
					p.printStackTrace();
				}
				desktopPane.add(listaProduto);
				listaProduto.setVisible(true);
			}
		});
		mnListaCadastrosGeral.add(mntmCadastroGeralListaProduto);

		JMenu mnCadastrarNovo = new JMenu("Cadastrar");
		mnCadastro.add(mnCadastrarNovo);

		JMenuItem mntmCliente = new JMenuItem("Novo Cliente");
		mnCadastrarNovo.add(mntmCliente);
		mntmCliente.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCliente.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente cadastroDoCliente = null;
				try {
					cadastroDoCliente = new TelaCadastroCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.add(cadastroDoCliente);
				cadastroDoCliente.setVisible(true);
			}
		});
		mntmCliente.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		JMenuItem mntmProduto = new JMenuItem("Novo Produto");
		mnCadastrarNovo.add(mntmProduto);
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto cadastroDoProduto = null;
				try {
					cadastroDoProduto = new TelaCadastroProduto();
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.add(cadastroDoProduto);
				cadastroDoProduto.setVisible(true);
			}
		});
		mntmProduto.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmProduto.setHorizontalAlignment(SwingConstants.LEFT);
		mntmProduto.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		JMenu mnVendas = new JMenu("Vendas");
		mnCadastro.add(mnVendas);

		JMenuItem mntmVendasConcluidas = new JMenuItem("Concluidas");
		mntmVendasConcluidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaCadastroVenda listaVenda = null;
				try {
					listaVenda = new TelaListaCadastroVenda();
					listaVenda.loadTableListaItensVenda();
				} catch (Exception e) {
					e.printStackTrace();
				}
				desktopPane.add(listaVenda);
				listaVenda.setVisible(true);
			}
		});
		mnVendas.add(mntmVendasConcluidas);

		JMenu mnConsulta = new JMenu("Relat\u00F3rios");
		mnConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnConsulta);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRelatorios tr = new TelaRelatorios();
				tr.relProduto();
			}
		});
		mnConsulta.add(mntmProdutos);

		JMenu mnSair = new JMenu("Sair");
		mnSair.setHorizontalTextPosition(SwingConstants.CENTER);
		mnSair.setHorizontalAlignment(SwingConstants.CENTER);
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mnSair);

		JPanel panel = new JPanel();
		panel.setBounds(0, 24, 1367, 84);
		panel.setVerifyInputWhenFocusTarget(false);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAdicionaCliente = new JButton("");
		btnAdicionaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente cadastroDoCliente = null;
				try {
					cadastroDoCliente = new TelaCadastroCliente();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.add(cadastroDoCliente);
				cadastroDoCliente.setVisible(true);
			}
		});
		btnAdicionaCliente.setIcon(new ImageIcon("icon/add_contact.png"));
		btnAdicionaCliente.setBounds(94, 10, 64, 64);
		panel.add(btnAdicionaCliente);

		JButton btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto cadastroDoProduto = null;
				try {
					cadastroDoProduto = new TelaCadastroProduto();
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.add(cadastroDoProduto);

				cadastroDoProduto.setVisible(true);
			}
		});
		btnAdicionarProduto.setIcon(new ImageIcon("icon/box_add.png"));
		btnAdicionarProduto.setBounds(178, 10, 64, 64);
		panel.add(btnAdicionarProduto);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon("icon/delete.png"));
		btnSair.setBounds(262, 10, 64, 64);
		panel.add(btnSair);

		JButton btnVendas = new JButton("");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas vendas = new TelaVendas();
				desktopPane.add(vendas);
				vendas.setVisible(true);
			}
		});
		btnVendas.setIcon(new ImageIcon("icon/shopping_cart.png"));
		btnVendas.setBounds(10, 10, 64, 64);
		panel.add(btnVendas);
		panel.setVerifyInputWhenFocusTarget(false);
	}
}