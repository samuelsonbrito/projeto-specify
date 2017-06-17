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
		panel.setBounds(12, 28, 776, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCadastrarNovoProjeto = new JButton("Cadastrar novo projeto");
		btnCadastrarNovoProjeto.setBounds(200, 138, 400, 40);
		panel.add(btnCadastrarNovoProjeto);
		btnCadastrarNovoProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//colocar acao do botao cadastrar novo projeto aqui 				
			}
		});
		btnCadastrarNovoProjeto.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		
		JButton btnVerMeusProjetos = new JButton("Ver meus projetos");
		btnVerMeusProjetos.setBounds(200, 195, 400, 40);
		panel.add(btnVerMeusProjetos);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setBounds(200, 252, 400, 40);
		panel.add(btnSobre);
		btnSobre.setToolTipText("Sobre o (nome do software aqui)");
		
		JLabel lblNomeDoSoftware = new JLabel("Nome do software aqui");
		lblNomeDoSoftware.setBounds(200, 70, 400, 19);
		panel.add(lblNomeDoSoftware);
		lblNomeDoSoftware.setFont(new Font("Monospaced", lblNomeDoSoftware.getFont().getStyle(), lblNomeDoSoftware.getFont().getSize() + 4));
		lblNomeDoSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSistemaParaApoiar = new JLabel("Sistema para apoiar a Especificação de Requisitos de Software");
		lblSistemaParaApoiar.setBounds(180, 100, 470, 15);
		panel.add(lblSistemaParaApoiar);
		btnVerMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar ação do botao ver meus projetos aqui 
			}
		});
	}
}
