package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
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
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;

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
		setBounds(100, 100, 1200, 650);

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
		toolBar.setBounds(0, 0, 1200, 30);
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
		
		JTabbedPane tabsShowInfo = new JTabbedPane(JTabbedPane.TOP);
		
		tabsShowInfo.setOpaque(true);
		tabsShowInfo.setAutoscrolls(true);
		tabsShowInfo.setForeground(SystemColor.window);
		tabsShowInfo.setBackground(new Color(51, 51, 51));
		tabsShowInfo.setBounds(369, 37, 798, 550);
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
		
		JTree tree = new JTree();
		tree.setBounds(2, 28, 335, 519);
		panel.add(tree);
		
		
		
		
		
	}
}