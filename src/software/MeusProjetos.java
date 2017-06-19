package software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MeusProjetos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeusProjetos frame = new MeusProjetos();
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
	public MeusProjetos() {
		setTitle("Meus projetos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 464);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/folder.png")));
		menuBar.add(mnArquivo);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNovoProjeto = new JButton("Novo projeto");
		btnNovoProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ação botao novo projeto 
				
				CadastrarProjeto novoprojeto= new CadastrarProjeto();
				novoprojeto.setVisible(true);
				novoprojeto.setLocationRelativeTo(null);
			}
		});
		btnNovoProjeto.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/layout_add.png")));
		toolBar.add(btnNovoProjeto);
		
		JButton btnNovoRequisito = new JButton("Novo requisito");
		btnNovoRequisito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarRequisito novoRequisito=new CadastrarRequisito();
				novoRequisito.setVisible(true);
				novoRequisito.setLocationRelativeTo(null);
			}
		});
		btnNovoRequisito.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/page_add.png")));
		toolBar.add(btnNovoRequisito);
	}
}