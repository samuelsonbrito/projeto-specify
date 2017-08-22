package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import model.bean.Projeto;
import model.bean.Requisito;
import model.dao.ProjetoDAO;
import model.dao.RequisitoDAO;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import java.awt.Point;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.DebugGraphics;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MeusProjetos extends JFrame {

	private JPanel contentPane;
	private JTree tree;
	private JLabel selectedLabel;
	private JScrollPane scrollPane; 
	Point loc;
	boolean overRoot = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//aparencia da interface: Nimbus
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		//da run no frame
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
		setBounds(100, 100, 1170, 630);

	/** 
	 * 
	 * Início codigo dos componentes da interface
	 * 
	 **/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(204, 204, 204));
		menuBar.setBackground(new Color(51, 51, 51));
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
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 1170, 30);
		contentPane.add(toolBar);
		
		//botãozinho de novo projeto
		JButton btnNewButton = new JButton("");
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastrarProjeto novoprojeto= new CadastrarProjeto();
				novoprojeto.setVisible(true);
				novoprojeto.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/layout_add.png")));
		btnNewButton.setToolTipText("Novo projeto");
		
		
		
		JTabbedPane tabsShowInfo = new JTabbedPane(JTabbedPane.TOP);

		tabsShowInfo.setOpaque(true);
		tabsShowInfo.setAutoscrolls(true);
		tabsShowInfo.setForeground(SystemColor.window);
		tabsShowInfo.setBackground(new Color(51, 51, 51));
		tabsShowInfo.setBounds(360, 37, 798, 550);
		contentPane.add(tabsShowInfo);

		JPanel panelShowInfo = new JPanel();
		panelShowInfo.setBackground(SystemColor.controlLtHighlight);
		FlowLayout fl_panelShowInfo = (FlowLayout) panelShowInfo.getLayout();
		tabsShowInfo.addTab("New tab", null, panelShowInfo, null);
		panelShowInfo.setBorder(new LineBorder(SystemColor.textInactiveText));

		JPanel panel_1 = new JPanel();
		tabsShowInfo.addTab("New tab", null, panel_1, null);


		JPanel panel = new JPanel();
		
		

		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBounds(10, 36, 339, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton LabelProjetos = new JButton("Projetos");
		
		LabelProjetos.setForeground(SystemColor.controlHighlight);
		LabelProjetos.setBackground(SystemColor.inactiveCaptionText);
		LabelProjetos.setVerifyInputWhenFocusTarget(false);
		LabelProjetos.setFocusTraversalKeysEnabled(false);
		LabelProjetos.setFocusPainted(false);
		LabelProjetos.setBorderPainted(false);
		LabelProjetos.setAutoscrolls(true);
		LabelProjetos.setFocusable(false);
		LabelProjetos.setBounds(0, 0, 339, 28);
		panel.add(LabelProjetos);

		
		constroiArvoreBancoDados(panel); //invoca a construção da tree no JPanel 
		
		//botãozinho de refresh
		JButton btnRefresh = new JButton("");
		toolBar.add(btnRefresh);
		btnRefresh.setToolTipText("Atualizar");
		btnRefresh.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/arrow_refresh.png")));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rodaArvore(tree);	
			}
		});
	}
	
	public void rodaArvore(JTree tree){
		ProjetoDAO pdao = new ProjetoDAO();
		RequisitoDAO rdao = new RequisitoDAO();
		tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Projetos") { //raiz
					{					       			
						DefaultMutableTreeNode node_1;
						DefaultMutableTreeNode node_2;
						DefaultMutableTreeNode node_3;
						 
						//le do banco de dados projetos e requisitos 
						for(Projeto p: pdao.readName()){
							node_1 = new DefaultMutableTreeNode(p.getNome()); //cria novo nó pai
							node_2 = new DefaultMutableTreeNode("Requisitos"); //filho do pai

							for(Requisito r: rdao.readID()){
								//JOptionPane.showMessageDialog(null, "Teste: "+ r.getProjcodigo() + " = "+ p.getCodigo());
								if(r.getProjcodigo()==p.getCodigo()){
									node_2.add(new DefaultMutableTreeNode(r.getId())); //filho do filho
									node_1.add(node_2);
								}
								else {
									node_1.add(node_2);
								}
							} //fim for	menor					
							node_3 = new DefaultMutableTreeNode("Interessados");
							node_3.add(new DefaultMutableTreeNode("opções de interessados"));
							node_1.add(node_3);			
							add(node_1);  //adiciona nó pai na arvore							
						} //fim for
					}
				}
				));	
	}
	
	public void constroiArvoreBancoDados(JPanel panel){
		
			tree = new JTree();
		 
			tree.setVisibleRowCount(0);
			rodaArvore(tree);
		
			PopupHandler handler = new PopupHandler(tree);
	        tree.add(handler.getPopup());
	    	tree.setBounds(5, 30, 330, 515);
	        panel.add(tree);
	        
	        scrollPane = new JScrollPane(tree);
			scrollPane.setBounds(5, 30, 330, 518);
			scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
			scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER); // nunca mostra a barra de rolagem horizontal
			panel.add(scrollPane);
			
			
	        
	}
	

}