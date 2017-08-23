package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaAjudaRequisito extends JFrame {

	private JPanel contentPane;

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
					TelaAjudaRequisito frame = new TelaAjudaRequisito();
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
	public TelaAjudaRequisito() {
		setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAjudaProjeto.class.getResource("/images/help.png")));
		setTitle("Ajuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComoPreencherOs = new JLabel("Como preencher os campos? ");
		lblComoPreencherOs.setBounds(150, 15, 250, 22);
		contentPane.add(lblComoPreencherOs);
		lblComoPreencherOs.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 15));
		lblComoPreencherOs.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/help.png")));



		JTextArea txtrDeveSerPreenchido = new JTextArea();
		txtrDeveSerPreenchido.setFocusTraversalKeysEnabled(false);
		txtrDeveSerPreenchido.setFocusable(false);
		txtrDeveSerPreenchido.setWrapStyleWord(true);
		txtrDeveSerPreenchido.setLineWrap(true);
		txtrDeveSerPreenchido.setBounds(40, 70, 465, 30);
		contentPane.add(txtrDeveSerPreenchido);
		txtrDeveSerPreenchido.setEditable(false);
		txtrDeveSerPreenchido.setText("Deve-se selecionar o nome do projeto ao qual o requisito esta ligado. ");

		JTextArea txtDataInicio = new JTextArea();
		txtDataInicio.setFocusable(false);
		txtDataInicio.setFocusTraversalKeysEnabled(false);
		txtDataInicio.setWrapStyleWord(true);
		txtDataInicio.setLineWrap(true);
		txtDataInicio.setBounds(40, 122, 465, 45);
		contentPane.add(txtDataInicio);
		txtDataInicio.setEditable(false);
		txtDataInicio.setText( "Deve-se selecionar o tipo do requisito, "
				+ "podendo ser requisito funcional, requisito não funcional, requisito de usuário e requisito de negócio.");

		JTextArea txtDataTerm = new JTextArea();
		txtDataTerm.setFocusable(false);
		txtDataTerm.setFocusTraversalKeysEnabled(false);
		txtDataTerm.setWrapStyleWord(true);
		txtDataTerm.setLineWrap(true);
		txtDataTerm.setBounds(40, 190, 465, 43);
		contentPane.add( txtDataTerm);
		txtDataTerm.setEditable(false);
		txtDataTerm.setText(
				"Deve ser preenchido com um identifcador, o qual será único para o requisito que está sendo cadastrado. " );


		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFocusable(false);
		txtDescricao.setFocusTraversalKeysEnabled(false);
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setLineWrap(true);
		txtDescricao.setBounds(40, 255, 465, 60);
		contentPane.add(txtDescricao);
		txtDescricao.setEditable(false);
		txtDescricao.setText( 
				"Deve ser preenchido com o ator, papel ou classe do usuário ao qual o requisito se refere. Exemplo: “estudante”, “sistema”, “gerente”, “passageiro”" );

		JTextArea txtRecF = new JTextArea();
		txtRecF.setFocusable(false);
		txtRecF.setFocusTraversalKeysEnabled(false);
		txtRecF.setWrapStyleWord(true);
		txtRecF.setLineWrap(true);
		txtRecF.setBounds(40, 337, 465, 45);
		contentPane.add(txtRecF);
		txtRecF.setEditable(false);
		txtRecF.setText(
				"Deve ser preenchido com a ação e/ou restrição a qual o requisito está relacionado. Exemplo: “acessar percentual de presenças online”"				);
		

		 JTextArea txtValorR = new JTextArea();
		 txtValorR.setFocusable(false);
		 txtValorR.setFocusTraversalKeysEnabled(false);
		 txtValorR.setWrapStyleWord(true);
		 txtValorR.setLineWrap(true);
		 txtValorR.setBounds(40, 400, 465, 58);
		 contentPane.add(  txtValorR);
		 txtValorR.setEditable(false);
		 txtValorR.setText(
				 "Deve ser preenchido com o valor que o requisito irá agregar ao projeto ou com "
				 + "a razão ao qual o requisito está relacionado. Exemplo: “saber se já reprovei em uma disciplina”, “embarcar”.");
		 
		 JTextArea txtGrauD = new JTextArea();
		 txtGrauD.setFocusable(false);
		 txtGrauD.setFocusTraversalKeysEnabled(false);
		 txtGrauD.setWrapStyleWord(true);
		 txtGrauD.setLineWrap(true);
		 txtGrauD.setBounds(40, 481, 465, 56);
		 contentPane.add(txtGrauD);
		 txtGrauD.setEditable(false);
		 txtGrauD.setText(
				 "Deve ser preenchido selecionando o grau de dificuldade ou prioridade de implementação do requisito que está sendo cadastrado, selecionando baixa, média ou alta.");
		
		 
		 JTextArea txtEst = new JTextArea();
		 txtEst.setFocusable(false);
		 txtEst.setFocusTraversalKeysEnabled(false);
		 txtEst.setWrapStyleWord(true);
		 txtEst.setLineWrap(true);
		 txtEst.setBounds(40, 560, 465, 55);
		 contentPane.add(txtEst);
		 txtEst.setEditable(false);
		 txtEst.setText(
				 "Deve ser preenchido opcionalmente com a estimativa inicial em horas da equipe sobre quanto tempo é necessário para implementar este requisito.");
		
		 
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
		btnNewButton.setBounds(420, 625, 80, 25);
		contentPane.add(btnNewButton);

		JLabel lblNomeDoProjeto = new JLabel("Projeto: ");
		contentPane.add(lblNomeDoProjeto);
		lblNomeDoProjeto.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblNomeDoProjeto.setBounds(25, 50, 131, 21);
		lblNomeDoProjeto.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblTipoRequisito = new JLabel("Tipo de requisito:");
		contentPane.add(lblTipoRequisito );
		lblTipoRequisito.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblTipoRequisito.setBounds(25, 100, 131, 21);
		lblTipoRequisito.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblIdentificador = new JLabel("Identificador: ");
		contentPane.add(lblIdentificador);
		lblIdentificador.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblIdentificador.setBounds(25, 168, 200, 21);
		lblIdentificador.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblSujeito = new JLabel("Sujeito: ");
		contentPane.add( lblSujeito);
		lblSujeito.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblSujeito.setBounds(25, 235, 200, 21);
		lblSujeito.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblarestri= new JLabel("Ação e/ou Restrição: ");
		contentPane.add(lblarestri);
		lblarestri.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblarestri.setBounds(25, 316, 250, 21);
		lblarestri.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));

		JLabel lblValorR= new JLabel("Valor ou Razão: ");
		contentPane.add(lblValorR);
		lblValorR.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblValorR.setBounds(25, 380, 250, 21);
		lblValorR.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));
		
		JLabel lblGrauDP= new JLabel("Grau de dificuldade e grau de prioridade: ");
		contentPane.add(lblGrauDP);
		lblGrauDP.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblGrauDP.setBounds(25, 460, 400, 21);
		lblGrauDP.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));
		
		JLabel lblEstimativa= new JLabel("Estimativa: ");
		contentPane.add(lblEstimativa);
		lblEstimativa.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblEstimativa.setBounds(25, 540, 250, 21);
		lblEstimativa.setIcon(new ImageIcon(TelaAjudaProjeto.class.getResource("/images/attach.png")));



	}
}


