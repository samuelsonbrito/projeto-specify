package interfacesG;

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
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTable;

public class MeusProjetos extends JFrame {

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
					MeusProjetos frame = new MeusProjetos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//frame.setExtendedState(MAXIMIZED_BOTH);
					
					

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
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 718, 32);
		contentPane.add(toolBar);
		
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