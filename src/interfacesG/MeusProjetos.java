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
import javax.swing.JComboBox;
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
import java.awt.Cursor;
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

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MeusProjetos extends JFrame {
	private JPanel contentPane, panelDireito;
	private JTree tree;
	private JLabel selectedLabel;
	private JScrollPane scrollPane, scrollPane2; 
	Point loc;
	boolean overRoot = false;
	private JTable table;
	private JTable table_1;
	private int node; 
	private DefaultTableModel modelo;
	private JComboBox comboBox;




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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MeusProjetos.class.getResource("/images/logoAzul.png")));
		setTitle("Specify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel toolBar = new JPanel();
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toolBar.setBackground(new Color(51,51,51));
		toolBar.setBounds(10, 49, 869, 28);
		contentPane.add(toolBar);

		JPanel stBarra = new JPanel();
		stBarra.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		stBarra.setBackground(new Color(51,51,51));
		stBarra.setBounds(10, 2, 869, 45);
		contentPane.add(stBarra);
		stBarra.setLayout(null);

		JPanel panelRodape = new JPanel();
		panelRodape.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRodape.setBounds(10, 634, 869, 28);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);

		JLabel lblNewLabel = new JLabel("Versão 1.0.0");
		lblNewLabel.setBounds(780, 5, 71, 18);
		lblNewLabel.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		panelRodape.add(lblNewLabel);

		JMenuItem mntmMeusProjetos = new JMenuItem("");
		mntmMeusProjetos.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/logo.png")));
		mntmMeusProjetos.setForeground(SystemColor.control);
		mntmMeusProjetos.setBackground(java.awt.Color.white);
		mntmMeusProjetos.setHorizontalAlignment(SwingConstants.CENTER);
		mntmMeusProjetos.setSelected(true);
		mntmMeusProjetos.setBounds(5, 2, 80, 40);
		stBarra.add(mntmMeusProjetos);

		JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
		mntmNewMenuItem.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 14));
		mntmNewMenuItem.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/information.png")));
		mntmNewMenuItem.setForeground(SystemColor.control);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem.setBounds(670, 2, 80, 40);
		stBarra.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setBackground(SystemColor.inactiveCaptionText);
		mntmNewMenuItem_1.setToolTipText("Logout");
		mntmNewMenuItem_1.setFocusable(true);
		mntmNewMenuItem_1.setFocusTraversalPolicyProvider(true);
		mntmNewMenuItem_1.setFocusPainted(true);
		mntmNewMenuItem_1.setFocusCycleRoot(true);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/exit.png")));
		mntmNewMenuItem_1.setBounds(810, 10, 50, 30);
		stBarra.add(mntmNewMenuItem_1);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/help.png")));
		mntmAjuda.setForeground(SystemColor.window);
		mntmAjuda.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 14));
		mntmAjuda.setBounds(750, 3, 70, 40);
		stBarra.add(mntmAjuda);

		JLabel lblSistemaParaApoiar = new JLabel("Sistema para apoiar a especificação de Requisitos de Software");
		lblSistemaParaApoiar.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblSistemaParaApoiar.setForeground(SystemColor.window);
		lblSistemaParaApoiar.setBackground(SystemColor.window);
		lblSistemaParaApoiar.setBounds(90, 15, 500, 15);
		stBarra.add(lblSistemaParaApoiar);
		toolBar.setLayout(null);

		//botãozinho de novo projeto
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 1, 40, 26);
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastrarProjeto novoprojeto= new CadastrarProjeto(tree);
				novoprojeto.setVisible(true);
				novoprojeto.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/layout_add.png")));
		btnNewButton.setToolTipText("Novo projeto");

		//botãozinho de refresh
		JButton btnRefresh = new JButton("");
		btnRefresh.setBounds(100, 1, 40, 26);
		toolBar.add(btnRefresh);
		btnRefresh.setToolTipText("Atualizar");
		btnRefresh.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/arrow_refresh.png")));
		
		JButton btnCadInteressado = new JButton("");
		btnCadInteressado.setToolTipText("Cadastrar Interessado");
		btnCadInteressado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarInteressado cI = new CadastrarInteressado();
				cI.setVisible(true);
				cI.setLocationRelativeTo(null);
			}
		});
		btnCadInteressado.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/group_add.png")));
		btnCadInteressado.setBounds(55, 1, 40, 26);
		toolBar.add(btnCadInteressado);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rodaArvore(tree);
				readJTable(node);
				//atualizaComboBox(comboBox);
			}
		});


		//////// LADO ESQUERDO DO PROGRAMA

		JPanel panel = new JPanel();			
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBounds(10, 80, 313, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton LabelProjetos = new JButton("Projetos");
		LabelProjetos.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));

		LabelProjetos.setForeground(SystemColor.controlHighlight);
		LabelProjetos.setBackground(SystemColor.inactiveCaptionText);
		LabelProjetos.setVerifyInputWhenFocusTarget(false);
		LabelProjetos.setFocusTraversalKeysEnabled(false);
		LabelProjetos.setFocusPainted(false);
		LabelProjetos.setBorderPainted(false);
		LabelProjetos.setAutoscrolls(true);
		LabelProjetos.setFocusable(false);
		LabelProjetos.setBounds(0, 0, 313, 28);
		panel.add(LabelProjetos);

		///////////////////////	JTREE
		constroiArvoreBancoDados(panel); //invoca a construção da tree no JPanel 

		/////////////////////// FIM JTREE

		////////////PAINEL DIREITO

		RequisitoDAO dao = new RequisitoDAO();
		ProjetoDAO pdao = new ProjetoDAO();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setBounds(327, 77, 552, 553);
		contentPane.add(tabbedPane);
		
		JPanel panelProjetos = new JPanel();
		tabbedPane.addTab("Projetos", null, panelProjetos, null);

		panelDireito = new JPanel();
		tabbedPane.addTab("Requisitos", null, panelDireito, null);
		panelDireito.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelDireito.setLayout(null);
		criaJTable();

		/******************botões panelDireito***********/
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/application_edit.png")));
		btnEditar.setBounds(384, 2, 50, 27);
		panelDireito.add(btnEditar);

		JButton btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/printer_empty.png")));
		btnImprimir.setBounds(440, 2, 50, 27);
		panelDireito.add(btnImprimir);

		JButton btnLixeira = new JButton("");
		btnLixeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RequisitoDAO dao = new RequisitoDAO();
				//ação p deletar linha 
			}
		});
		
		btnLixeira.setToolTipText("Deletar requisito");
		btnLixeira.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/lixeira.png")));
		btnLixeira.setBounds(495, 2, 50, 27);
		panelDireito.add(btnLixeira);
		/******************botões panelDireito***********/


		comboBox = new JComboBox();
		comboBox.addItem("Selecione o projeto");
		comboBox.setForeground(SystemColor.controlHighlight);
		comboBox.setBackground(SystemColor.inactiveCaptionText);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		comboBox.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		comboBox.setBounds(5, 3, 375, 25);
		rodaComboBox(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				for (Projeto p: pdao.readName()){
					if(comboBox.getSelectedItem().equals(p.getNome())){
						readJTable(p.getCodigo());
					}
				}
			}
		});
		panelDireito.add(comboBox);
		
		JPanel panelInteressados = new JPanel();
		tabbedPane.addTab("Interessados", null, panelInteressados, null);



		////////////FIM PAINEL DIREITO 
	}

	public JTree getTree() {
		return tree;
	}


	public void rodaComboBox(JComboBox comboBox){
		RequisitoDAO dao = new RequisitoDAO();
		ProjetoDAO pdao = new ProjetoDAO();

		//comboBox.repaint();
		for (Projeto p: pdao.readName()){
			String nomep=p.getNome();
			comboBox.addItem(nomep);

		}
	}

	/*public void atualizaComboBox(JComboBox comboBox){
		RequisitoDAO dao = new RequisitoDAO();
		ProjetoDAO pdao = new ProjetoDAO();

		comboBox.removeAllItems();
		for (Projeto p: pdao.readName()){
			String nomep=p.getNome();
			comboBox.addItem(nomep);

		}
	}*/

	public void criaJTable(){
		table_1 = new JTable();
		table_1.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		table_1.setColumnSelectionAllowed(false);
		table_1.setCellSelectionEnabled(true);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setShowVerticalLines(true);
		table_1.setShowHorizontalLines(true);
		table_1.getTableHeader().setResizingAllowed(true);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("Menu[Disabled].textForeground")));
		table_1.setBounds(6, 32, 788, 513);
		JTableHeader header =  table_1.getTableHeader();
		DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);

		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"-","C\u00F3digo", "Identificador"
				}
				));

		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);	
		table_1.getColumnModel().getColumn(1).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(405);
		modelo = (DefaultTableModel) table_1.getModel();
		modelo.setNumRows(0);

		//readJTable(node);

		panelDireito.add(table_1);

		scrollPane2 = new JScrollPane(table_1);
		scrollPane2.setBounds(4, 29, 545, 490);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		panelDireito.add(scrollPane2);

	}



	public void readJTable(int node) {

		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		modelo.setNumRows(0);
		RequisitoDAO pdao = new RequisitoDAO();
		for (Requisito r : pdao.readALL()) {
			if(r.getProjcodigo()==node){
				//JOptionPane.showMessageDialog(null, "Teste: "+ r.getProjcodigo() + " = "+ node);
				modelo.addRow(new Object[]{
						"",
						r.getCodigo(),
						r.getId(),
				});
			}
		}
	}

	public void atualizaArvore(JTree tree){
		ProjetoDAO pdao = new ProjetoDAO();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() 
			{                                                                                                                                      
				rodaArvore(tree);			
			}
		});

	}


	public void rodaArvore(JTree tree){
		ProjetoDAO pdao = new ProjetoDAO();
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
							node_2.add(new DefaultMutableTreeNode(""));
							node_1.add(node_2);			
							node_3 = new DefaultMutableTreeNode("Interessados");
							node_3.add(new DefaultMutableTreeNode(""));
							node_1.add(node_3);			
							add(node_1);  //adiciona nó pai na arvore							
						} //fim for
					}
				}
				));	

	}


	public JTree constroiArvoreBancoDados(JPanel panel){
		tree = new JTree();
		tree.setShowsRootHandles(false);
		tree.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		tree.setVisibleRowCount(0);
		rodaArvore(tree);

		PopupHandler handler = new PopupHandler(tree);
		tree.add(handler.getPopup());
		tree.setBounds(5, 30, 330, 515);
		panel.add(tree);

		scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(5, 30, 305, 518);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // nunca mostra a barra de rolagem horizontal
		panel.add(scrollPane);

		return tree;

	}
}