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
import model.Doacao;
import model.NovaDoacao;

public class TelaListaCadastroDoacao extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tableListaDoacao;
	private JButton btnFecharListaDoacao;
	private Label lbListaCadastroDoação;
	@SuppressWarnings("unused")
	private Doacao doacao = new Doacao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroDoacao frame = new TelaListaCadastroDoacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadTableListaDoacao() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Id Doação", "Nome", "CPF", "Telefone", "Email", "Endereço", "Tipo Sangue", "Quantidade", "Dt Doação" });

		Map<Integer, Doacao> mapaDoacao = new HashMap<Integer, Doacao>();
		try {
			mapaDoacao = (Map<Integer, Doacao>) BancoDeDados.buscaBBDoacao();
			Collection contV = mapaDoacao.values();
			Iterator interador = contV.iterator();
			while (interador.hasNext()) {
				NovaDoacao NovaDoacaoTemp = (NovaDoacao) interador.next();
				modelo.addRow(new Object[] { NovaDoacaoTemp.getIdDoacao(), NovaDoacaoTemp.getPessoaDoar().getNome(), NovaDoacaoTemp.getPessoaDoar().getCpf(), 
						NovaDoacaoTemp.getPessoaDoar().getTelefone(), NovaDoacaoTemp.getPessoaDoar().getEmail(), NovaDoacaoTemp.getPessoaDoar().getEndereco(),
						NovaDoacaoTemp.getPessoaDoar().getTipoSangue(), NovaDoacaoTemp.getDoacao().getDtDoacao() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tableListaDoacao.setModel(modelo);
		tableListaDoacao.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroDoacao() throws Exception {
		setToolTipText("Lista de Doa\u00E7oes");
		setTitle("Lista de Doa\u00E7oes");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tableListaDoacao = new JTable();
		scrollPane.setViewportView(tableListaDoacao);
		loadTableListaDoacao();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnFecharListaDoacao = new JButton("Fechar");
		btnFecharListaDoacao.setBounds(10, 11, 100, 22);
		panel.add(btnFecharListaDoacao);

		lbListaCadastroDoação = new Label("Lista de Doa\u00E7\u00F5es");
		lbListaCadastroDoação.setForeground(Color.WHITE);
		lbListaCadastroDoação.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroDoação);
		lbListaCadastroDoação.setBackground(new Color(128, 0, 0));
		lbListaCadastroDoação.setFont(new Font("Arial", Font.BOLD, 18));
		lbListaCadastroDoação.setAlignment(Label.CENTER);
	}
}
