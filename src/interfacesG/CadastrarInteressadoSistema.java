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

public class CadastrarInteressadoSistema extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane2;
	private JTextField textField;
	private JButton btnBuscar;
	private JLabel lblPapelDesempenhado;
	private JTextField textField_1;
	private JButton btnSalvar;
	private JButton btnCancelar;

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
		setBounds(100, 100, 534, 380);
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
		scrollPane2.setBounds(10, 50, 500, 150);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane2.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane2.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		contentPane.add(scrollPane2);
		
		textField = new JTextField();
		textField.setBounds(10, 15, 410, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(428, 15, 80, 27);
		contentPane.add(btnBuscar);
		
		lblPapelDesempenhado = new JLabel("Papel desempenhado: ");
		lblPapelDesempenhado.setBounds(28, 239, 200, 15);
		contentPane.add(lblPapelDesempenhado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 235, 328, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(278, 300, 100, 27);
		contentPane.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
			}
		});
		btnCancelar.setBounds(400, 300, 100, 27);
		contentPane.add(btnCancelar);
	}
}
