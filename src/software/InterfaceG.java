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

public class InterfaceG extends JFrame {

	private JPanel contentPane;
	private Projeto projeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceG frame = new InterfaceG();
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
	public InterfaceG() {
		setTitle("Nome do software aqui");
		projeto=new Projeto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 800, 500);  //tamanho da janela 
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setBackground(UIManager.getColor("DesktopIcon.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 28, 776, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMeusProjetos = new JButton("Meus projetos");
		btnMeusProjetos.setToolTipText("Incluir, alterar, excluir e ver meus projetos");
		btnMeusProjetos.setBounds(180, 134, 400, 40);
		panel.add(btnMeusProjetos);
		btnMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//colocar acao do botao cadastrar novo projeto aqui 				
			}
		});
		btnMeusProjetos.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		
		JButton btnSobreP = new JButton("Sobre");
		btnSobreP.setToolTipText("Sobre o (nome do programa aqui)");
		btnSobreP.setBounds(180, 191, 400, 40);
		panel.add(btnSobreP);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(180, 248, 400, 40);
		panel.add(btnSair);
		btnSair.setToolTipText("");
		
		JLabel lblNomeDoSoftware = new JLabel("Nome do software aqui");
		lblNomeDoSoftware.setBounds(180, 66, 400, 19);
		panel.add(lblNomeDoSoftware);
		lblNomeDoSoftware.setFont(new Font("Monospaced", lblNomeDoSoftware.getFont().getStyle(), lblNomeDoSoftware.getFont().getSize() + 4));
		lblNomeDoSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSistemaParaApoiar = new JLabel("Sistema para apoiar a Especificação de Requisitos de Software");
		lblSistemaParaApoiar.setBounds(160, 96, 470, 15);
		panel.add(lblSistemaParaApoiar);
		
		JLabel facomLogo = new JLabel("");
		facomLogo.setIcon(new ImageIcon(InterfaceG.class.getResource("/images/facomlogo.png"))); //tentar direcionar para site depois
		facomLogo.setBounds(320, 321, 50, 51);
		panel.add(facomLogo);
		
		JLabel ufmsLogo = new JLabel("");
		ufmsLogo.setIcon(new ImageIcon(InterfaceG.class.getResource("/images/newlogo.png"))); //tentar direcionar para site depois 
		ufmsLogo.setBounds(400, 321, 50, 51);
		panel.add(ufmsLogo);
		btnSobreP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar ação do botao ver meus projetos aqui 
			}
		});
	}
}
