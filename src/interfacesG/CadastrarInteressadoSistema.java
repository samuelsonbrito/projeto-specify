package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CadastrarInteressadoSistema extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane2;
	private JTextField buscaInteressado;
	private JButton btnBuscar;
	private JButton lblPapelDesempenhado;
	private JTextField recebePapelDesempenhado;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton lblCadastrarInteressadoNo;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarInteressadoSistema frame = new CadastrarInteressadoSistema();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarInteressadoSistema() {
		setTitle("Cadastrar interessado no projeto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(415);
		table.setBounds(52, 88, 424, 268);
		
		scrollPane2 = new JScrollPane(table);
		scrollPane2.setBounds(13, 121, 500, 110);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane2.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane2.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		contentPane.add(scrollPane2);
		
		buscaInteressado = new JTextField();
		buscaInteressado.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		buscaInteressado.setForeground(SystemColor.controlShadow);
		buscaInteressado.setText("Insira o nome do interessado que deseja cadastrar");
		buscaInteressado.setBounds(12, 40, 410, 27);
		contentPane.add(buscaInteressado);
		buscaInteressado.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.inactiveCaptionText);
		btnBuscar.setForeground(SystemColor.controlHighlight);
		btnBuscar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/magnifier.png")));
		btnBuscar.setBounds(414, 40, 100, 27);
		btnBuscar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		contentPane.add(btnBuscar);
		
		lblPapelDesempenhado = new JButton("Insira o papel desempenhado no projeto: ");
		lblPapelDesempenhado.setFocusable(false);
		lblPapelDesempenhado.setFocusTraversalKeysEnabled(false);
		lblPapelDesempenhado.setFocusPainted(false);
		lblPapelDesempenhado.setForeground(SystemColor.control);
		lblPapelDesempenhado.setBackground(SystemColor.activeCaptionText);
		lblPapelDesempenhado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPapelDesempenhado.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblPapelDesempenhado.setBounds(5, 250, 515, 25);
		contentPane.add(lblPapelDesempenhado);
		
		recebePapelDesempenhado = new JTextField();
		recebePapelDesempenhado.setBounds(10, 280, 504, 27);
		contentPane.add(recebePapelDesempenhado);
		recebePapelDesempenhado.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(230, 230, 230));
		btnSalvar.setBackground(SystemColor.inactiveCaptionText);
		btnSalvar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/disk.png")));
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnSalvar.setBounds(283, 330, 110, 27);
		contentPane.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(SystemColor.controlHighlight);
		btnCancelar.setBackground(SystemColor.inactiveCaptionText);
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnCancelar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
			}
		});
		btnCancelar.setBounds(405, 330, 110, 27);
		contentPane.add(btnCancelar);
		
		lblCadastrarInteressadoNo = new JButton("Pesquisar interessado");
		lblCadastrarInteressadoNo.setFocusable(false);
		lblCadastrarInteressadoNo.setFocusTraversalKeysEnabled(false);
		lblCadastrarInteressadoNo.setFocusPainted(false);
		lblCadastrarInteressadoNo.setForeground(SystemColor.control);
		lblCadastrarInteressadoNo.setBackground(SystemColor.activeCaptionText);
		lblCadastrarInteressadoNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarInteressadoNo.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblCadastrarInteressadoNo.setBounds(5, 10, 515, 25);
		contentPane.add(lblCadastrarInteressadoNo);
		
		JButton lblResultadoDaBusca = new JButton("Resultado da busca");
		lblResultadoDaBusca.setForeground(SystemColor.control);
		lblResultadoDaBusca.setBackground(SystemColor.activeCaptionText);
		lblResultadoDaBusca.setFocusable(false);
		lblResultadoDaBusca.setFocusTraversalKeysEnabled(false);
		lblResultadoDaBusca.setFocusPainted(false);
		lblResultadoDaBusca.setHorizontalAlignment(SwingConstants.LEFT);
		lblResultadoDaBusca.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblResultadoDaBusca.setBounds(5, 90, 515, 25);
		contentPane.add(lblResultadoDaBusca);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 35, 515, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(5, 116, 515, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(5, 276, 515, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
