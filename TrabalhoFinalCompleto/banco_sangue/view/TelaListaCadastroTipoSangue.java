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
import model.TipoSangue;

public class TelaListaCadastroTipoSangue extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lbListaCadastroTpSangue;
	private JTable tableTipoSangue;
	private JScrollPane scrollPane;
	private JButton btnRemoverTipoSangueLista;
	private JButton btnEditarClienteLista;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCadastroTipoSangue frame = new TelaListaCadastroTipoSangue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadTableListaTpSangue() throws Exception {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Tipo Sanguineo", "Estoque (Litros)"});

		Map<Integer, TipoSangue> mapaTpSangue = new HashMap<Integer, TipoSangue>();
		try {
			mapaTpSangue = (Map<Integer, TipoSangue>) BancoDeDados.buscaDBTipoSangue();
			Collection contC = mapaTpSangue.values();
			Iterator interador = contC.iterator();
			while (interador.hasNext()) {
				TipoSangue tpSangueTemp = (TipoSangue) interador.next();
				modelo.addRow(new Object[] { tpSangueTemp.getIdTpSangue(), tpSangueTemp.getTipoSangue(), tpSangueTemp.getEstoque() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		tableTipoSangue.setModel(modelo);
		tableTipoSangue.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	public void atualizaTableTpSangue() throws Exception {
		Map<Integer, TipoSangue> mapaAtualizaTpSangue = new HashMap<Integer, TipoSangue>();
		for (int i = 0; i < tableTipoSangue.getRowCount(); i++) {
			int idTpSangue = (int) tableTipoSangue.getValueAt(i, 0);
			String tipoSangue = (String) tableTipoSangue.getValueAt(i, 1);
			Double estoque = (Double) tableTipoSangue.getValueAt(i, 2);
			TipoSangue tpSangueAtualizado = new TipoSangue(idTpSangue, tipoSangue, estoque);
			mapaAtualizaTpSangue.put(tpSangueAtualizado.getIdTpSangue(), tpSangueAtualizado);
		}
		BancoDeDados.gravaTipoSangueBD(mapaAtualizaTpSangue);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public TelaListaCadastroTipoSangue() throws Exception {
		setToolTipText("Lista de Tipos Sanguineos");
		setTitle("Lista de Tipos Sanguineos");
		setClosable(true);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(100, 50, 800, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 72, 650, 390);
		getContentPane().add(scrollPane);

		tableTipoSangue = new JTable();
		scrollPane.setViewportView(tableTipoSangue);
		loadTableListaTpSangue();

		JPanel panel = new JPanel();
		panel.setBounds(670, 71, 118, 391);
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		btnRemoverTipoSangueLista = new JButton("Remover");
		btnRemoverTipoSangueLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tableTipoSangue.getModel()).removeRow(tableTipoSangue.getSelectedRow());
			}
		});
		btnRemoverTipoSangueLista.setBounds(10, 70, 100, 23);
		panel.add(btnRemoverTipoSangueLista);

		btnEditarClienteLista = new JButton("Editar");
		btnEditarClienteLista.setBounds(10, 40, 100, 23);
		panel.add(btnEditarClienteLista);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizaTableTpSangue();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(10, 10, 100, 23);
		panel.add(btnSalvar);

		lbListaCadastroTpSangue = new Label("Lista de Tipos Sanguineos Cadastradas");
		lbListaCadastroTpSangue.setForeground(new Color(255, 255, 255));
		lbListaCadastroTpSangue.setBounds(0, 0, 798, 60);
		getContentPane().add(lbListaCadastroTpSangue);
		lbListaCadastroTpSangue.setBackground(new Color(128, 0, 0));
		lbListaCadastroTpSangue.setFont(new Font("Arial", Font.BOLD, 18));
		lbListaCadastroTpSangue.setAlignment(Label.CENTER);
	}
}
