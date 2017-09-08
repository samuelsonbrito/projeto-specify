package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;

import model.bean.Interessado;
import model.bean.InteressadoProjeto;
import model.bean.Projeto;
import model.bean.Requisito;
import model.dao.InteressadoDAO;
import model.dao.InteressadoProjetoDAO;
import model.dao.ProjetoDAO;
import model.dao.RequisitoDAO;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastrarInteressadoSistema extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane2;
	private JTextField buscaInteressado;
	private JButton btnBuscar;
	private JButton lblPapelDesempenhado;
	private JTextField recebePapelDesempenhado;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton lblCadastrarInteressadoNo;
	private JPanel panel_2;
	private static JTree tree; 

	TableInteressadoProjeto tableIP = new TableInteressadoProjeto(); 
	

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
					CadastrarInteressadoSistema frame = new CadastrarInteressadoSistema(tree);
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
	public CadastrarInteressadoSistema(JTree tree) {
		this.tree=tree; 
		setTitle("Cadastrar interessado no projeto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		criaJTable();

		buscaInteressado = new JTextField();
		buscaInteressado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				buscaInteressado.setText("");

			}
		});

		buscaInteressado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscaInteressado.setText("");

			}
		});

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableIP.limpar();
				readJTable();
			}
		});
		btnBuscar.setBackground(SystemColor.inactiveCaptionText);
		btnBuscar.setForeground(SystemColor.controlHighlight);
		btnBuscar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/magnifier.png")));
		btnBuscar.setBounds(419, 40, 93, 27);
		btnBuscar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		contentPane.add(btnBuscar);

		buscaInteressado.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		buscaInteressado.setForeground(SystemColor.controlShadow);
		buscaInteressado.setText("Insira o nome do interessado que deseja cadastrar");
		buscaInteressado.setBounds(12, 40, 410, 27);
		contentPane.add(buscaInteressado);
		buscaInteressado.setColumns(10);

		lblPapelDesempenhado = new JButton("Insira o papel desempenhado no projeto ");
		lblPapelDesempenhado.setFocusable(false);
		lblPapelDesempenhado.setFocusTraversalKeysEnabled(false);
		lblPapelDesempenhado.setFocusPainted(false);
		lblPapelDesempenhado.setForeground(SystemColor.control);
		lblPapelDesempenhado.setBackground(SystemColor.activeCaptionText);
		lblPapelDesempenhado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPapelDesempenhado.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblPapelDesempenhado.setBounds(5, 213, 515, 25);
		contentPane.add(lblPapelDesempenhado);

		recebePapelDesempenhado = new JTextField();
		recebePapelDesempenhado.setForeground(SystemColor.inactiveCaption);
		recebePapelDesempenhado.setText("(exemplo: programador)");
		recebePapelDesempenhado.setBounds(10, 242, 504, 27);
		contentPane.add(recebePapelDesempenhado);
		recebePapelDesempenhado.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InteressadoProjeto ip = new InteressadoProjeto();
				InteressadoProjetoDAO ipDAO = new InteressadoProjetoDAO();
				ProjetoDAO pdao = new ProjetoDAO();


				if(table.getSelectedRow() != -1){


					Object nodeSelected = tree.getLastSelectedPathComponent().toString();
					int i=table.getSelectedRow();
					int j =(int) table.getValueAt(i, 1);
					for(Projeto p: pdao.readName()){
						if(nodeSelected.equals(p.getNome())){
							//p.getCodigo();
							ip.setCodInteressado(j);
							ip.setCodProj(p.getCodigo());
							ip.setPapelDesempenhado(recebePapelDesempenhado.getText());
							ipDAO.create(ip);

							int rp = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo interessado para este mesmo projeto?", "Cadastrar novo interessado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if(rp==JOptionPane.YES_OPTION){
								recebePapelDesempenhado.setText("");
								buscaInteressado.setText("");
							}
							else{
								dispose();
							}

							break;
						}


						if(nodeSelected.equals("Interessados")){
							//System.out.println("ta comparando certo");
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
							Object nodeParent = node.getParent().toString();
							if(nodeParent.equals(p.getNome())){
								System.out.println(nodeParent);
								ip.setCodInteressado(j);
								ip.setCodProj(p.getCodigo());
								ip.setPapelDesempenhado(recebePapelDesempenhado.getText());
								ipDAO.create(ip);

								int rp = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo interessado para este mesmo projeto?", "Cadastrar novo interessado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

								if(rp==JOptionPane.YES_OPTION){
									recebePapelDesempenhado.setText("");
									buscaInteressado.setText("");
								}
								else{
									dispose();
								}

								break;
							}

						}

					}





				}


			}
		});
		btnSalvar.setForeground(new Color(230, 230, 230));
		btnSalvar.setBackground(SystemColor.inactiveCaptionText);
		btnSalvar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/disk.png")));
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnSalvar.setBounds(283, 290, 110, 27);
		contentPane.add(btnSalvar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(SystemColor.controlHighlight);
		btnCancelar.setBackground(SystemColor.inactiveCaptionText);
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnCancelar.setIcon(new ImageIcon(CadastrarInteressadoSistema.class.getResource("/images/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
			}
		});
		btnCancelar.setBounds(405, 290, 110, 27);
		contentPane.add(btnCancelar);

		lblCadastrarInteressadoNo = new JButton("Pesquisar interessado");
		lblCadastrarInteressadoNo.setFocusable(false);
		lblCadastrarInteressadoNo.setFocusTraversalKeysEnabled(false);
		lblCadastrarInteressadoNo.setFocusPainted(false);
		lblCadastrarInteressadoNo.setForeground(SystemColor.control);
		lblCadastrarInteressadoNo.setBackground(SystemColor.activeCaptionText);
		lblCadastrarInteressadoNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarInteressadoNo.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblCadastrarInteressadoNo.setBounds(5, 10, 515, 25);
		contentPane.add(lblCadastrarInteressadoNo);

		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 35, 515, 170);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setEnabled(false);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(5, 238, 515, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}

	public void criaJTable(){
		table = new JTable();
		table.setModel(tableIP);
		table.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 12));		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setResizingAllowed(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("Menu[Disabled].textForeground")));
		JTableHeader header =  table.getTableHeader();
		DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);	   		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);	
		table.getColumnModel().getColumn(1).setPreferredWidth(60);		

		table.getColumnModel().getColumn(2).setPreferredWidth(354);		

		table.setBounds(52, 88, 424, 268);

		scrollPane2 = new JScrollPane(table);
		scrollPane2.setBounds(13, 80, 500, 110);
		scrollPane2.setVerticalScrollBarPolicy(scrollPane2.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane2.setHorizontalScrollBarPolicy(scrollPane2.HORIZONTAL_SCROLLBAR_AS_NEEDED); // só mostra a barra horizontal se necessário
		contentPane.add(scrollPane2);
	}
	public void readJTable() {
		InteressadoDAO iDAO = new InteressadoDAO(); 	
		for (Interessado i : iDAO.readForDesc(buscaInteressado.getText())) {

			i.isSelected();
			i.getCodigo();
			i.getNome();
			tableIP.addRow(i);	
		}


	}

}
