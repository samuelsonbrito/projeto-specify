package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;

public class TelaAjudaProjeto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try 
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjudaProjeto frame = new TelaAjudaProjeto();
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
	public TelaAjudaProjeto() {
		setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAjudaProjeto.class.getResource("/images/help.png")));
		setTitle("Ajuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComoPreencherOs = new JLabel("Como preencher os campos? ");
		lblComoPreencherOs.setBounds(110, 10, 250, 22);
		contentPane.add(lblComoPreencherOs);
		lblComoPreencherOs.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 15));
		lblComoPreencherOs.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/help.png")));



		JTextArea txtrDeveSerPreenchido = new JTextArea();
		txtrDeveSerPreenchido.setFocusTraversalKeysEnabled(false);
		txtrDeveSerPreenchido.setFocusable(false);
		txtrDeveSerPreenchido.setWrapStyleWord(true);
		txtrDeveSerPreenchido.setLineWrap(true);
		txtrDeveSerPreenchido.setBounds(40, 70, 360, 42);
		contentPane.add(txtrDeveSerPreenchido);
		txtrDeveSerPreenchido.setEditable(false);
		txtrDeveSerPreenchido.setText("Deve ser preenchido com o nome do projeto desejado, não excedendo o número 1000 de caracteres.");

		JTextArea txtDataInicio = new JTextArea();
		txtDataInicio.setFocusable(false);
		txtDataInicio.setFocusTraversalKeysEnabled(false);
		txtDataInicio.setWrapStyleWord(true);
		txtDataInicio.setLineWrap(true);
		txtDataInicio.setBounds(40, 140, 360, 60);
		contentPane.add(txtDataInicio);
		txtDataInicio.setEditable(false);
		txtDataInicio.setText(
				"Deve ser preenchida com a data de início do projeto, no formato numérico "
						+ "obedecendo o formato AAAA/MM/DD (ano, mês e dia, respectivamente)");

		JTextArea txtDataTerm = new JTextArea();
		txtDataTerm.setFocusable(false);
		txtDataTerm.setFocusTraversalKeysEnabled(false);
		txtDataTerm.setWrapStyleWord(true);
		txtDataTerm.setLineWrap(true);
		txtDataTerm.setBounds(40, 230, 360, 70);
		contentPane.add( txtDataTerm);
		txtDataTerm.setEditable(false);
		txtDataTerm.setText(
				"Deve ser preenchida com a data aproximada do término do projeto, "
						+ "no formato numérico obedecendo o formato AAAA/MM/DD (ano, mês e dia, respectivamente)" );


		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFocusable(false);
		txtDescricao.setFocusTraversalKeysEnabled(false);
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setLineWrap(true);
		txtDescricao.setBounds(40, 330, 360, 70);
		contentPane.add(txtDescricao);
		txtDescricao.setEditable(false);
		txtDescricao.setText( 
				"Deve ser preenchido com uma descrição generalizada do projeto, como por exemplo,"
						+ " principal objetivo do mesmo, não ultrapassando o número máximo de 5000 caracteres." );

		JTextArea txtRecF = new JTextArea();
		txtRecF.setFocusable(false);
		txtRecF.setFocusTraversalKeysEnabled(false);
		txtRecF.setWrapStyleWord(true);
		txtRecF.setLineWrap(true);
		txtRecF.setBounds(40, 430, 360, 87);
		contentPane.add(txtRecF);
		txtRecF.setEditable(false);
		txtRecF.setText("Deve ser preenchido com o recurso financeiro estimado para o andamento do projeto, "
				+"a moeda utilizada é o real, não é necessário acrescentar vírgulas, tendo em vista que o campo às acrescenta automaticamente. ");




		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/accept.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnNewButton.setForeground(SystemColor.controlHighlight);
		btnNewButton.setBackground(SystemColor.inactiveCaptionText);
		btnNewButton.setBounds(310, 530, 80, 25);
		contentPane.add(btnNewButton);

		JLabel lblNomeDoProjeto = new JLabel("Nome do projeto: ");
		contentPane.add(lblNomeDoProjeto);
		lblNomeDoProjeto.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblNomeDoProjeto.setBounds(25, 50, 131, 21);
		lblNomeDoProjeto.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblDataInicio = new JLabel("Data de início:  ");
		contentPane.add(lblDataInicio );
		lblDataInicio.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDataInicio.setBounds(25, 120, 131, 21);
		lblDataInicio.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblDataTerm = new JLabel("Data aprox. para término:  ");
		contentPane.add(lblDataInicio );
		lblDataInicio.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDataInicio.setBounds(25, 120, 131, 21);
		lblDataInicio.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblDataTer = new JLabel("Data aprox. para término:  ");
		contentPane.add(lblDataTer);
		lblDataTer.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDataTer.setBounds(25, 210, 200, 21);
		lblDataTer.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblDescri = new JLabel("Descrição do projeto: ");
		contentPane.add( lblDescri);
		lblDescri.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDescri.setBounds(25, 310, 200, 21);
		lblDescri.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblrecf= new JLabel("Recurso financeiro estimado:  ");
		contentPane.add(lblrecf);
		lblrecf.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblrecf.setBounds(25, 410, 250, 21);
		lblrecf.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));




	}
}
