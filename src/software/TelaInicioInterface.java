package software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

public class TelaInicioInterface extends JFrame {

	private JPanel contentPane;
	//private Projeto projeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicioInterface frame = new TelaInicioInterface();
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
	public TelaInicioInterface() {
		setResizable(false);
		setFocusTraversalPolicyProvider(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Nome do software aqui");
		//projeto=new Projeto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 600, 500);  //tamanho da janela 
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 23, 576, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMeusProjetos = new JButton("Meus projetos");
		btnMeusProjetos.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnMeusProjetos.setToolTipText("Incluir, alterar, excluir e ver meus projetos");
		btnMeusProjetos.setBounds(86, 140, 400, 40);
		panel.add(btnMeusProjetos);
		btnMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//colocar acao do botao cadastrar novo projeto aqui 				
			}
		});
		btnMeusProjetos.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		
		JButton btnSobreP = new JButton("Sobre");
		btnSobreP.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnSobreP.setToolTipText("Sobre o (nome do programa aqui)");
		btnSobreP.setBounds(86, 197, 400, 40);
		panel.add(btnSobreP);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar ação para fechar o programa aqui 
			}
		});
		btnSair.setBounds(86, 254, 400, 40);
		panel.add(btnSair);
		btnSair.setToolTipText("");
		
		JLabel lblNomeDoSoftware = new JLabel("Nome do Software Aqui");
		lblNomeDoSoftware.setForeground(SystemColor.windowText);
		lblNomeDoSoftware.setBounds(86, 72, 400, 19);
		panel.add(lblNomeDoSoftware);
		lblNomeDoSoftware.setFont(new Font("TakaoPGothic", Font.BOLD, 19));
		lblNomeDoSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSistemaParaApoiar = new JLabel("Sistema para apoiar a Especificação de Requisitos de Software");
		lblSistemaParaApoiar.setFont(new Font("Garuda", Font.BOLD | Font.ITALIC, 15));
		lblSistemaParaApoiar.setForeground(SystemColor.menuText);
		lblSistemaParaApoiar.setBackground(UIManager.getColor("Button.background"));
		lblSistemaParaApoiar.setBounds(70, 105, 470, 15);
		panel.add(lblSistemaParaApoiar);
		
		JLabel facomLogo = new JLabel("");
		facomLogo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/facomlogo.png"))); //tentar direcionar para site depois
		facomLogo.setBounds(226, 327, 50, 51);
		panel.add(facomLogo);
		
		JLabel ufmsLogo = new JLabel("");
		ufmsLogo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/newlogo.png"))); //tentar direcionar para site depois 
		ufmsLogo.setBounds(306, 327, 50, 51);
		panel.add(ufmsLogo);
		
		JLabel bgFundo2 = new JLabel("");
		bgFundo2.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/diamond-bg.png")));
		bgFundo2.setBounds(0, 0, 606, 472);
		panel.add(bgFundo2);
		
		JLabel bgFundo = new JLabel("");
		bgFundo.setBounds(0, 0, 606, 523);
		contentPane.add(bgFundo);
		bgFundo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/diamond-bg.png")));
		btnSobreP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar ação do botao ver meus projetos aqui 
			}
		});
	}
}
