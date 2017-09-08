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
import java.util.Calendar;
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

import model.bean.Interessado;
import model.bean.InteressadoProjeto;
import model.bean.Projeto;
import model.bean.Requisito;
import model.dao.InteressadoDAO;
import model.dao.InteressadoProjetoDAO;
import model.dao.ProjetoDAO;
import model.dao.RequisitoDAO;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Canvas;

import javax.swing.AbstractButton;
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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class MeusProjetos extends JFrame {
	private JTree tree;
	private JLabel selectedLabel;
	private JScrollPane scrollPane, scrollPane2; 	
	boolean overRoot = false;
	private JTable table_1, table_2;
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	; 
	private JPanel contentPane2;

	private JPanel panelProjetos, panelInteressados, panelRequisitos;
	private int node; 
	private DefaultTableModel modelo;
	DefaultMutableTreeNode node5;
	private JComboBox comboBox;
	Point loc;
	private JTextField recebeCodigo;
	private JTextField recebeNome;
	private JTextField recebeDataI;
	private JTextField recebeDataT;
	private JTextField recebeDataC;
	private JTextField recebeRecursoF;
	private JTextField recebeDataUM;
	private JTextArea recebeDescricao;
	JLabel lblNewLabel_2;
	private JButton btnSalvar;
	private JButton btnEditarProjeto;
	private JButton btnExcluirProjeto;
	TreePath path;
	JFrame frame2; 

	TableRequisitos tableModel = new TableRequisitos(); 
	TableExibeInteressadosP iptable = new TableExibeInteressadosP();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//aparencia da interface: Nimbus
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.put("JTabbedPane.selected", Color.DARK_GRAY);

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

		JMenuItem mntmLogout = new JMenuItem("");
		mntmLogout.setBackground(SystemColor.inactiveCaptionText);
		mntmLogout.setToolTipText("Logout");
		mntmLogout.setFocusable(true);
		mntmLogout.setFocusTraversalPolicyProvider(true);
		mntmLogout.setFocusPainted(true);
		mntmLogout.setFocusCycleRoot(true);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mntmLogout.setHorizontalAlignment(SwingConstants.CENTER);
		mntmLogout.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/exit.png")));
		mntmLogout.setBounds(807, 10, 54, 30);
		stBarra.add(mntmLogout);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/help.png")));
		mntmAjuda.setForeground(SystemColor.window);
		mntmAjuda.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 14));
		mntmAjuda.setBounds(750, 3, 72, 40);
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
		btnNewButton.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/application_add.png")));
		btnNewButton.setToolTipText("Novo projeto");

		JButton btnCadInteressado = new JButton("");
		btnCadInteressado.setToolTipText("Novo interessado");
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




		//////// PAINEL ESQUERDO

		JPanel panel = new JPanel();			
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBounds(10, 80, 294, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton LabelProjetos = new JButton("Projetos");
		LabelProjetos.setHorizontalAlignment(SwingConstants.LEFT);
		LabelProjetos.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));

		LabelProjetos.setForeground(SystemColor.controlHighlight);
		LabelProjetos.setBackground(SystemColor.inactiveCaptionText);
		LabelProjetos.setVerifyInputWhenFocusTarget(false);
		LabelProjetos.setFocusTraversalKeysEnabled(false);
		LabelProjetos.setFocusPainted(false);
		LabelProjetos.setBorderPainted(false);
		LabelProjetos.setAutoscrolls(true);
		LabelProjetos.setFocusable(false);
		LabelProjetos.setBounds(2, 1, 290, 25);
		panel.add(LabelProjetos);

		///////////////////////	JTREE
		constroiArvoreBancoDados(panel); //invoca a construção da tree no JPanel 

		////////////////////// FIM JTREE

		////////////PAINEL DIREITO

		RequisitoDAO dao = new RequisitoDAO();
		ProjetoDAO pdao = new ProjetoDAO();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		tabbedPane.setBounds(310, 77, 568, 553);
		contentPane.add(tabbedPane);


		tabbedPane.addTab("Projetos ", new ImageIcon(MeusProjetos.class.getResource("/images/application_xp.png")), panelProjetos(), null);
		tabbedPane.addTab("Requisitos ", new ImageIcon(MeusProjetos.class.getResource("/images/application_view_list.png")), panelRequisitos(), null);
		tabbedPane.addTab("Interessados ", new ImageIcon(MeusProjetos.class.getResource("/images/group.png")), panelInteressados(), null);



	}

	public static int recebeReqID(int codigo){
		return codigo;
	}

	public void abrirPanel(int i){
		tabbedPane.setSelectedIndex(i);
	}

	public JPanel panelInteressados(){
		panelInteressados = new JPanel();
		panelInteressados.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelInteressados.setLayout(null);
		criaJTableInteressado();

		JButton btnLixeira = new JButton("");
		btnLixeira.setBounds(495, 2, 50, 27);
		btnLixeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InteressadoProjetoDAO ipdao = new InteressadoProjetoDAO();
				//ação p deletar linha 
				if(table_2.getSelectedRow() != -1){

					int i=table_2.getSelectedRow();
					Object valorSelecionado = iptable.getValueAt(i, 0);

					if(valorSelecionado.equals(true)){
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover este interessado? ", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (resposta == JOptionPane.YES_OPTION){
							int code = Integer.parseInt(iptable.getValueAt(i, 1).toString());
							for(InteressadoProjeto pp: ipdao.buscaInteressados()){
								if(pp.getCodInteressado()==code){
									pp.setPapelDesempenhado(iptable.getValueAt(i, 4).toString());
									pp.setCodInteressado(code);
									ipdao.updateDel(pp);													
									break;
								}

							}
						}
					}
				}
			}
		});

		btnLixeira.setToolTipText("Deletar Interessado");
		btnLixeira.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/lixeira.png")));
		panelInteressados.add(btnLixeira);


		return panelInteressados;

	}

	public JPanel panelProjetos(){
		panelProjetos = new JPanel();
		panelProjetos.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelProjetos.setLayout(null);

		btnEditarProjeto = new JButton("");
		btnEditarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recebeDescricao.setEditable(true);
				recebeDescricao.setOpaque(false);
				recebeNome.setEditable(true);
				recebeNome.setOpaque(false);
				recebeDataT.setEditable(true);
				recebeDataT.setOpaque(false);
				recebeRecursoF.setEditable(true);
				recebeRecursoF.setOpaque(false);
				btnSalvar.setEnabled(true);


			}
		});
		btnEditarProjeto.setToolTipText("Editar projeto");
		btnEditarProjeto.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/application_edit.png")));
		btnEditarProjeto.setBounds(492, 15, 40, 27);
		btnEditarProjeto.setEnabled(false);
		panelProjetos.add(btnEditarProjeto);

		JLabel lblInfoProjeto = new JLabel("Informações sobre o projeto");
		lblInfoProjeto.setBounds(44, 20, 200, 15);
		lblInfoProjeto.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 13));
		panelProjetos.add(lblInfoProjeto);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(137, 105, 44, 15);
		lblNome.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblNome);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(131, 60, 60, 15);
		lblCodigo.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblCodigo);

		JLabel lblDataDeInicio = new JLabel("Data de inicio: ");
		lblDataDeInicio.setBounds(95, 150, 100, 15);
		lblDataDeInicio.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblDataDeInicio);

		JLabel lblDataAproxDe = new JLabel("Data aprox. de término: ");
		lblDataAproxDe.setBounds(40, 195, 200, 15);
		lblDataAproxDe.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblDataAproxDe);

		JLabel lblDescrio = new JLabel("Descrição: ");
		lblDescrio.setBounds(117, 333, 100, 15);
		lblDescrio.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblDescrio);

		JLabel lblRe = new JLabel("Recursos financeiros: ");
		lblRe.setBounds(57, 420, 200, 15);
		lblRe.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblRe);

		JLabel lblNewLabel_1 = new JLabel("Data/hora criação: ");
		lblNewLabel_1.setBounds(71, 238, 160, 15);
		lblNewLabel_1.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblNewLabel_1);

		btnExcluirProjeto = new JButton("");
		btnExcluirProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjetoDAO dao = new ProjetoDAO();
				RequisitoDAO rdao=new RequisitoDAO(); 
				MeusProjetos mp = new MeusProjetos();
				InteressadoProjetoDAO ipdao = new InteressadoProjetoDAO();

				int resposta = JOptionPane.showConfirmDialog(null, "Ao deletar um projeto todos os requisitos e interessados associados a ele serão removidos. \nDeseja realmente remover o projeto "+recebeNome.getText()+"?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION){
					//deletar primeiro os requisitos ligados ao projeto
					for(Requisito r: rdao.readID()){
						if(Integer.parseInt(recebeCodigo.getText())==(r.getProjcodigo())){							
							rdao.delete(r.getId());
							break;
						}	
					}
					//deletar os interessados
					for(InteressadoProjeto ip:ipdao.buscaInteressados()){
						if(Integer.parseInt(recebeCodigo.getText())==(ip.getCodProj())){							
							ipdao.delete(ip.getCodProj());
							break;
						}
					}

					//deletar o projeto
					dao.delete(Integer.parseInt(recebeCodigo.getText()));
					mp.rodaArvore(tree);
					recebeCodigo.setText("");
					recebeNome.setText("");
					recebeDataI.setText("");
					recebeDataT.setText("");
					recebeDataUM.setText("");
					recebeDataC.setText("");
					recebeRecursoF.setText("");
					recebeDescricao.setText("");	
				}
			}
		});
		btnExcluirProjeto.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/lixeira.png")));
		btnExcluirProjeto.setToolTipText("Excluir projeto");
		btnExcluirProjeto.setEnabled(false);
		btnExcluirProjeto.setBounds(445, 15, 40, 27);
		panelProjetos.add(btnExcluirProjeto);

		JLabel lblDatahoraltimaModificao = new JLabel("Última modificação: ");
		lblDatahoraltimaModificao.setBounds(61, 285, 200, 15);
		lblDatahoraltimaModificao.setFont(new Font("Noto Sans CJK KR Medium", Font.PLAIN, 12));
		panelProjetos.add(lblDatahoraltimaModificao);

		recebeCodigo = new JTextField();
		recebeCodigo.setOpaque(true);
		recebeCodigo.setEditable(false);
		recebeCodigo.setBounds(203, 54, 122, 27);
		panelProjetos.add(recebeCodigo);
		recebeCodigo.setColumns(10);

		recebeDescricao = new JTextArea();
		recebeDescricao.setEditable(false);
		recebeDescricao.setOpaque(true);
		recebeDescricao.setWrapStyleWord(true);
		recebeDescricao.setLineWrap(true);
		JScrollPane scrollPane3 = new JScrollPane(recebeDescricao);
		scrollPane3.setBounds(203, 330, 300, 60);
		scrollPane3.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane3.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER); // nunca mostra a barra de rolagem horizontal
		panelProjetos.add(scrollPane3);

		recebeNome = new JTextField();
		recebeNome.setEditable(false);
		recebeNome.setOpaque(true);
		recebeNome.setBounds(203, 100, 300, 27);
		panelProjetos.add(recebeNome);
		recebeNome.setColumns(10);

		recebeDataI = new JTextField();
		recebeDataI.setEditable(false);
		recebeDataI.setOpaque(true);
		recebeDataI.setBounds(203, 147, 150, 27);
		panelProjetos.add(recebeDataI);
		recebeDataI.setColumns(10);

		recebeDataT = new JTextField();
		recebeDataT.setEditable(false);
		recebeDataT.setOpaque(true);
		recebeDataT.setBounds(203, 190, 150, 27);
		panelProjetos.add(recebeDataT);
		recebeDataT.setColumns(10);

		recebeDataC = new JTextField();
		recebeDataC.setEditable(false);
		recebeDataC.setOpaque(true);
		recebeDataC.setBounds(203, 234, 300, 27);
		panelProjetos.add(recebeDataC);
		recebeDataC.setColumns(10);

		recebeRecursoF = new JTextField();
		recebeRecursoF.setEditable(false);
		recebeRecursoF.setOpaque(true);
		recebeRecursoF.setBounds(203, 414, 150, 27);
		panelProjetos.add(recebeRecursoF);
		recebeRecursoF.setColumns(10);

		recebeDataUM = new JTextField();
		recebeDataUM.setEditable(false);
		recebeDataUM.setOpaque(true);
		recebeDataUM.setText("");
		recebeDataUM.setBounds(203, 279, 300, 27);
		panelProjetos.add(recebeDataUM);
		recebeDataUM.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjetoDAO dao = new ProjetoDAO();
				Projeto pj=new Projeto();
				String recebeD=recebeDataI.getText();

				pj.setDataAproxTermino(recebeDataT.getText());
				int comp = recebeD.compareTo(pj.getDataAproxTermino());
				if(comp > 0){
					JOptionPane.showMessageDialog(null, "Data inválida!");	
				}
				else {
					pj.setCodigo(Integer.parseInt(recebeCodigo.getText()));
					pj.setNome(recebeNome.getText());
					pj.setDescricao(recebeDescricao.getText());
					pj.setHoraCriacao(recebeDataC.getText());
					String texto = recebeRecursoF.getText();
					texto = texto.replace(".", "");
					texto = texto.replace(",", ".");
					pj.setRecursosFinanceiros(Double.parseDouble(texto));	


					dao.update(pj);
				}

				recebeDescricao.setEditable(false);
				recebeDescricao.setOpaque(true);
				recebeNome.setEditable(false);
				recebeNome.setOpaque(true);
				recebeDataT.setEditable(false);
				recebeDataT.setOpaque(true);
				recebeRecursoF.setEditable(false);
				recebeRecursoF.setOpaque(true);
				btnSalvar.setEnabled(false);


				for(Projeto p: dao.read()){
					if(recebeNome.getText().equals(p.getNome())){
						String code = Integer.toString(p.getCodigo()); 
						recebeCodigo.setText(code);
						recebeNome.setText(p.getNome());
						recebeDataI.setText(p.getDataInicio());
						recebeDataT.setText(p.getDataAproxTermino());
						recebeDataUM.setText(p.getUltimaAtualizacao());
						recebeDataC.setText(p.getHoraCriacao());
						recebeRecursoF.setText(String.valueOf(p.getRecursosFinanceiros()));
						recebeDescricao.setText(p.getDescricao());						
					}
				}

				atualizaArvore(tree);


			}
		});
		btnSalvar.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/disk.png")));
		btnSalvar.setBounds(422, 478, 100, 27);
		panelProjetos.add(btnSalvar);

		return panelProjetos; 
	}

	public JFrame ShowDRCE(JFrame frame2){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDocReqCartaoEstoria frame2 = new ShowDocReqCartaoEstoria();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 403);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);

		JButton btnCartoEstria = new JButton("Cartão de estória");
		btnCartoEstria.setForeground(SystemColor.control);
		btnCartoEstria.setBackground(SystemColor.activeCaptionText);
		btnCartoEstria.setFont(new Font("TakaoPGothic", Font.PLAIN, 13));
		btnCartoEstria.setBounds(12, 5, 449, 25);
		contentPane2.add(btnCartoEstria);

		JButton btnDocReq = new JButton("Doc. de Requisito");
		btnDocReq.setForeground(SystemColor.control);
		btnDocReq.setBackground(SystemColor.activeCaptionText);
		btnDocReq.setFont(new Font("TakaoPGothic", Font.PLAIN, 13));
		btnDocReq.setBounds(12, 180, 449, 25);
		contentPane2.add(btnDocReq);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 30, 449, 148);
		contentPane2.add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(7, 25, 435, 4);
		panel.add(separator);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(7, 80, 435, 4);
		panel.add(separator2);

		JSeparator separator3 = new JSeparator();
		separator3.setBounds(7, 100, 435, 4);
		panel.add(separator3);

		JSeparator separator4 = new JSeparator();
		separator4.setBounds(7, 120, 435, 4);
		panel.add(separator4);

		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblId.setBounds(319, 5, 60, 15);
		panel.add(lblId);

		JLabel lblComoUm = new JLabel("Como um "+"tipoUsuario "+"eu quero "+"objetivo"+" afim de que "+"razao");
		lblComoUm.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblComoUm.setBounds(17, 10, 430, 54);
		panel.add(lblComoUm);

		JLabel lblGr = new JLabel("Prioridade: ");
		lblGr.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblGr.setBounds(17, 85, 200, 15);
		panel.add(lblGr);

		JLabel lblGrauDificuldade = new JLabel("Dificuldade: ");
		lblGrauDificuldade.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblGrauDificuldade.setBounds(17, 104, 200, 15);
		panel.add(lblGrauDificuldade);

		JLabel lblEstimativa = new JLabel("Estimativa: ");
		lblEstimativa.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblEstimativa.setBounds(17, 124, 120, 15);
		panel.add(lblEstimativa);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(12, 205, 449, 133);
		contentPane2.add(panel2);
		panel2.setLayout(null);

		JLabel lblIdreq = new JLabel("ID: ");
		lblIdreq.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblIdreq.setBounds(319, 5, 60, 15);
		panel2.add(lblIdreq);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(7, 25, 435, 4);
		panel2.add(separator1);

		JSeparator separator22 = new JSeparator();
		separator22.setBounds(7, 80, 435, 4);
		panel2.add(separator22);

		JSeparator separator33 = new JSeparator();
		separator33.setBounds(7, 100, 435, 4);
		panel2.add(separator33);

		JSeparator separator44 = new JSeparator();
		separator44.setBounds(7, 120, 435, 4);
		panel2.add(separator44);

		JLabel lblGrReq = new JLabel("Prioridade: ");
		lblGrReq.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblGrReq.setBounds(17, 85, 200, 15);
		panel2.add(lblGrReq);

		JLabel lblGrauDificuldadeReq = new JLabel("Dificuldade: ");
		lblGrauDificuldadeReq.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		lblGrauDificuldadeReq.setBounds(17, 104, 200, 15);
		panel2.add(lblGrauDificuldadeReq);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnOk.setForeground(SystemColor.control);
		btnOk.setBackground(SystemColor.activeCaptionText);
		btnOk.setIcon(new ImageIcon(ShowDocReqCartaoEstoria.class.getResource("/images/accept.png")));
		btnOk.setBounds(361, 365, 100, 27);
		contentPane2.add(btnOk);

		JButton btnBaixar = new JButton("Baixar");
		btnBaixar.setForeground(SystemColor.control);
		btnBaixar.setBackground(SystemColor.activeCaptionText);
		btnBaixar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnBaixar.setIcon(new ImageIcon(ShowDocReqCartaoEstoria.class.getResource("/images/page_white_acrobat.png")));
		btnBaixar.setBounds(249, 365, 100, 27);
		contentPane2.add(btnBaixar);
		return frame2;
	}

	public JPanel panelRequisitos(){
		panelRequisitos = new JPanel();
		panelRequisitos.setBorder(new LineBorder(SystemColor.inactiveCaption));
		criaJTable();

		JButton btnEditar = new JButton("");
		btnEditar.setBounds(384, 2, 50, 27);
		btnEditar.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/application_edit.png")));
		panelRequisitos.add(btnEditar);

		JButton btnImprimir = new JButton("");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(table_1.getSelectedRow() != -1){

					int i=table_1.getSelectedRow();
					Object valorSelecionado = tableModel.getValueAt(i, 1);
					String valor=valorSelecionado.toString();
					int codigo = Integer.parseInt(valor);
					recebeReqID(codigo);
					//frame2.setVisible(true);
				}

				JCheckBox chckbxNewCheckBox = new JCheckBox("Cartão estória");
				chckbxNewCheckBox.setBounds(171, 85, 129, 23);
				JCheckBox chckbxDocDeRequisitos = new JCheckBox("Doc. de Requisitos");
				chckbxDocDeRequisitos.setBounds(171, 110, 200, 17);

				JCheckBox checkbox = new JCheckBox("Cartão estória");
				JCheckBox checkbox2 = new JCheckBox("Doc. de requisios");
				String message = "Selecione os formatos para visualizar e/ou imprimir: ";
				Object[] params = {message, checkbox, checkbox2};
				JOptionPane.showConfirmDialog(null, params, "Visualizar/Imprimir", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if(checkbox.isSelected() && checkbox2==null){
					ShowCartaoEstoria ce = new ShowCartaoEstoria();
					ce.setVisible(true);
					ce.setLocationRelativeTo(null);
				}
				if(checkbox2.isSelected() && checkbox==null){
					ShowDocReq dr = new ShowDocReq();
					dr.setVisible(true);
					dr.setLocationRelativeTo(null);
				}
				if(checkbox.isSelected() && checkbox2.isSelected()){
					ShowDocReqCartaoEstoria drce = new ShowDocReqCartaoEstoria();
					//drce.setVisible(true);
					//drce.setLocationRelativeTo(null);
					ShowDRCE(frame2);
				}



			}
		});



		btnImprimir.setBounds(440, 2, 50, 27);
		btnImprimir.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/printer.png")));
		panelRequisitos.add(btnImprimir);

		JButton btnLixeira = new JButton("");
		btnLixeira.setBounds(495, 2, 50, 27);
		btnLixeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RequisitoDAO rrrdao = new RequisitoDAO();
				Requisito r= new Requisito(); 
				//ação p deletar linha 

				if(table_1.getSelectedRow() != -1){

					int i=table_1.getSelectedRow();
					System.out.println(tableModel.getValueAt(i, 0));
					Object valorSelecionado = tableModel.getValueAt(i, 0);

					if(valorSelecionado.equals(true)){
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover este requisito? ", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (resposta == JOptionPane.YES_OPTION){
							String codigo=(String)tableModel.getValueAt(i, 2);
							System.out.println(codigo);
							rrrdao.deleteReqTabela(codigo);							
						}

					}

				}


			}
		});

		btnLixeira.setToolTipText("Deletar requisito");
		btnLixeira.setIcon(new ImageIcon(MeusProjetos.class.getResource("/images/lixeira.png")));
		panelRequisitos.add(btnLixeira);

		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(10, 5, 400, 20);
		panelRequisitos.add(lblNewLabel_2);


		return panelRequisitos;
	}

	public void criaJTableInteressado(){
		table_2 = new JTable();
		table_2.setBounds(3, 24, 540, 0);
		table_2.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));		
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_2.getTableHeader().setResizingAllowed(true);
		table_2.getTableHeader().setReorderingAllowed(false);
		table_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("Menu[Disabled].textForeground")));
		JTableHeader header =  table_2.getTableHeader();
		DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);	   		
		table_2.setModel(iptable);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(25);	
		table_2.getColumnModel().getColumn(1).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(164);	
		table_2.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(140);


		panelInteressados.setLayout(null);
		panelInteressados.add(table_2);
		scrollPane2 = new JScrollPane(table_2);
		scrollPane2.setBounds(4, 29, 545, 490);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		panelInteressados.add(scrollPane2);

	}
	public void criaJTable(){
		table_1 = new JTable();
		table_1.setBounds(3, 24, 540, 0);
		table_1.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));		
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getTableHeader().setResizingAllowed(true);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("Menu[Disabled].textForeground")));
		JTableHeader header =  table_1.getTableHeader();
		DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);	   		
		table_1.setModel(tableModel);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(80);	
		table_1.getColumnModel().getColumn(1).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(399);		
		panelRequisitos.setLayout(null);
		panelRequisitos.add(table_1);
		scrollPane2 = new JScrollPane(table_1);
		scrollPane2.setBounds(4, 29, 545, 490);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		panelRequisitos.add(scrollPane2);
	}

	public void readJTableInteressado(int node){
		InteressadoProjetoDAO ipdao = new InteressadoProjetoDAO();
		InteressadoDAO idao = new InteressadoDAO();
		for(InteressadoProjeto ip : ipdao.buscaInteressados()){
			//System.out.println("entrou no for "+ip.getCodProj() +" "+ node);
			if(ip.getCodProj()==node){
				//System.out.println("entrou no if "+ip.getCodProj() +" "+ node);
				ip.isSelected();
				ip.getCodInteressado();
				for(Interessado it: idao.readNomeSobreN()){
					//System.out.println("entrou no for de busca pelo nome"+it.getCodigo() + " "+ ip.getCodInteressado());
					if(ip.getCodInteressado()==it.getCodigo()){
						//System.out.println(it.getNome());
						ip.setNome(it.getNome());
						break;
					}
				}
				ip.getDataEntrada();
				iptable.addRow(ip);
				break;
			}

		}

	}


	public void readJTableRequisito(int node) {
		RequisitoDAO rrdao = new RequisitoDAO();	
		for (Requisito r : rrdao.readALL()) {
			if(r.getProjcodigo()==node){
				r.isSelected();
				r.getCodigo();
				r.getId();
				tableModel.addRow(r);	
			}

		}
	}


	public JTree getTree() {
		return tree;
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
							node_1.add(node_2);			
							node_3 = new DefaultMutableTreeNode("Interessados");
							node_1.add(node_3);			
							add(node_1);  //adiciona nó pai na arvore							
						} //fim for
					}
				}
				));	
	}

	public JTree constroiArvoreBancoDados(JPanel panel){
		tree = new JTree();
		tree.setRootVisible(false);
		tree.setToggleClickCount(1);
		tree.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));
		tree.setVisibleRowCount(0);
		rodaArvore(tree);

		PopupHandler handler = new PopupHandler(tree);
		tree.add(handler.getPopup());
		tree.setBounds(5, 30, 330, 515);
		panel.add(tree);

		scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(5, 25, 285, 522);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // nunca mostra a barra de rolagem horizontal
		panel.add(scrollPane);

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loc = e.getPoint();
				//path  = tree.getPathForLocation(loc.x, loc.y);

				node5 = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				Object nodeInf2= node5.getUserObject();
				Object nodeInfo = node5.getParent();

				String parente=node5.getParent().toString();
				String noClicked=nodeInf2.toString();
				MeusProjetos mp = new MeusProjetos();
				ProjetoDAO dao = new ProjetoDAO();


				if (e.getClickCount() == 2 && ((nodeInfo!=null) && ((nodeInf2 !="Interessados") && (nodeInf2!="Requisitos") && (nodeInf2!=null)))) {
					abrirPanel(0);
					btnExcluirProjeto.setEnabled(true);
					btnEditarProjeto.setEnabled(true);
					for(Projeto p: dao.read()){
						if(noClicked.equals(p.getNome())){
							String code = Integer.toString(p.getCodigo()); 
							recebeCodigo.setText(code);
							recebeNome.setText(p.getNome());
							recebeDataI.setText(p.getDataInicio());
							recebeDataT.setText(p.getDataAproxTermino());
							recebeDataUM.setText(p.getUltimaAtualizacao());
							recebeDataC.setText(p.getHoraCriacao().toString());
							recebeRecursoF.setText(String.valueOf(p.getRecursosFinanceiros()));
							recebeDescricao.setText(p.getDescricao());						
						}

					}

				}
				if (e.getClickCount() == 2 && ((nodeInfo!=null) && ((nodeInf2 !="Interessados") && (nodeInf2=="Requisitos") && (nodeInf2!=null)))) {
					abrirPanel(1);

					for(Projeto p: dao.readName()){
						if(parente.equals((p.getNome()))){
							lblNewLabel_2.setText(p.getNome());
							tableModel.limpar();
							readJTableRequisito(p.getCodigo());

						}
					}

				}
				if (e.getClickCount() == 2 && ((nodeInfo!=null) && ((nodeInf2 =="Interessados") && (nodeInf2!="Requisitos") && (nodeInf2!=null)))) {
					abrirPanel(2);
					for(Projeto p: dao.readName()){
						if(parente.equals(p.getNome())){
							iptable.limpar();
							readJTableInteressado(p.getCodigo());
						}
					}
				}

			}
		});

		return tree;

	}
}