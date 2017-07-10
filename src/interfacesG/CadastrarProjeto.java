package interfacesG;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import model.bean.Projeto;
import model.dao.ProjetoDAO;
import model.dao.MonetarioDocument;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;

public class CadastrarProjeto extends JFrame {

	private JPanel contentPane;
	private Projeto cprojeto; 
	private JTextField recebeNomeProjeto;
	private JFormattedTextField recebeDataInicio_1_1;
	//private JFormattedTextField recebeDataTermino;
	private JFormattedTextField recebeDataTermino_1;
	private JLabel lblDescrioDoProjeto;
	private JTextArea recebeDescricao;
	private JLabel lblRecursosFinanceiros;
	
	private JFormattedTextField recebeRecursoFinanceiro_1;

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
					CadastrarProjeto frame = new CadastrarProjeto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
	
	/*
	public void readJTable() {   
	   ProjetoDAO projeto = new ProjetoDAO();
	    for (Projeto p : projeto.read()) {
	        modelo.addRow(new Object[]{
	            p.getNome(),
	        });
	    }
	}*/


	/**
	 * Create the frame.
	 */
	public CadastrarProjeto() {
		cprojeto=new Projeto();
		setTitle("Cadastrar Projeto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraONome = new JLabel("Nome do projeto:");
		lblInsiraONome.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblInsiraONome.setBounds(110, 109, 130, 25);
		contentPane.add(lblInsiraONome);
		
		recebeNomeProjeto = new JTextField();
		recebeNomeProjeto.setBounds(240, 111, 230, 25);
		contentPane.add(recebeNomeProjeto);
		recebeNomeProjeto.setColumns(10);
		
		/*********datas inicio e fim******************/
		JLabel lblInsiraAData = new JLabel("Data de inicio: ");
		lblInsiraAData.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblInsiraAData.setBounds(130, 150, 100, 20);
		contentPane.add(lblInsiraAData);
		
		recebeDataInicio_1_1 = new JFormattedTextField();

		try {
			javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####/##/##");
			data.setPlaceholderCharacter('_');
			recebeDataInicio_1_1 = new javax.swing.JFormattedTextField(data);
			recebeDataInicio_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			recebeDataInicio_1_1.setToolTipText("AAAA/MM/DD");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir data!");
		}
		
		recebeDataInicio_1_1.setBounds(240, 150, 80, 25);
		contentPane.add(recebeDataInicio_1_1);
		recebeDataInicio_1_1.setColumns(10);
		
		
		JLabel lblDataAproximadaPara = new JLabel("Data aprox. para término:");
		lblDataAproximadaPara.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDataAproximadaPara.setBounds(62, 196, 250, 20);
		contentPane.add(lblDataAproximadaPara);
		
		recebeDataTermino_1 = new JFormattedTextField();
		try {
			javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####/##/##");
			data.setPlaceholderCharacter('_');
			recebeDataTermino_1 = new javax.swing.JFormattedTextField(data);
			recebeDataTermino_1.setHorizontalAlignment(SwingConstants.LEFT);
			recebeDataTermino_1.setToolTipText("AAAA/MM/DD");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir data!");
		}
		
		recebeDataTermino_1.setBounds(240, 196, 80, 25);
		contentPane.add(recebeDataTermino_1);
		recebeDataTermino_1.setColumns(10);
		/********************************************/
		
		lblDescrioDoProjeto = new JLabel("Descrição do projeto:");
		lblDescrioDoProjeto.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblDescrioDoProjeto.setBounds(87, 233, 200, 15);
		contentPane.add(lblDescrioDoProjeto);
		
		
		
		recebeDescricao = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(recebeDescricao);
		scrollPane.setBounds(240, 231, 230, 60);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER); // nunca mostra a barra de rolagem horizontal
		
		contentPane.add(scrollPane);

		
		recebeDescricao.setMargin(new Insets(4, 3, 4, 3));
		recebeDescricao.setTabSize(10);
		recebeDescricao.setWrapStyleWord(true);
		recebeDescricao.setLineWrap(true);
		recebeDescricao.setBounds(271, 284, 200, 60);
		                           //contentPane.add(recebeDescricao);
		recebeDescricao.setColumns(10);
		
		
	/******************************************************* 
	 * 					recurso financeiro 
	 *******************************************************/
		
		lblRecursosFinanceiros = new JLabel("Recurso financeiro estimado:");
		lblRecursosFinanceiros.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblRecursosFinanceiros.setBounds(50, 306, 250, 25);
		contentPane.add(lblRecursosFinanceiros);
		
		recebeRecursoFinanceiro_1 = new JFormattedTextField();
		try {
			recebeRecursoFinanceiro_1.setDocument(new MonetarioDocument());
			recebeRecursoFinanceiro_1.setText("0");		
		}
		catch (Exception e) {  
		      e.printStackTrace();  
		  } 
		
		recebeRecursoFinanceiro_1.setBounds(240, 309, 230, 25);
		contentPane.add(recebeRecursoFinanceiro_1);
		recebeRecursoFinanceiro_1.setColumns(10);
		
	/*************************************************/
		
		
	/********************ACAO SALVAR******************/	
		
		JButton btnSalvar = new JButton("Salvar ");
		btnSalvar.setForeground(SystemColor.controlHighlight);
		btnSalvar.setBackground(SystemColor.inactiveCaptionText);
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));

		btnSalvar.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/disk.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ação salvar projeto
				
				ProjetoDAO dao = new ProjetoDAO();
				//cprojeto.setCodigo(Integer.parseInt(recebeNumero.getText()));
				cprojeto.setNome(recebeNomeProjeto.getText());
				cprojeto.setDataInicio(recebeDataInicio_1_1.getText());
				cprojeto.setDataAproxTermino(recebeDataTermino_1.getText());
				cprojeto.setDescricao(recebeDescricao.getText());
				String texto = recebeRecursoFinanceiro_1.getText();
				texto = texto.replace(".", "");
				texto = texto.replace(",", ".");
				cprojeto.setRecursosFinanceiros(Double.parseDouble(texto));		
				dao.create(cprojeto);
				
				
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo projeto?");
				if (resposta == JOptionPane.YES_OPTION){
					//precisa fazer limpar campos para poder cadastrar novo req
					recebeNomeProjeto.setText("");
					recebeDataInicio_1_1.setText("");
					recebeDataTermino_1.setText("");
					recebeDescricao.setText("");
					recebeRecursoFinanceiro_1.setText("");
				
				}
				if (resposta ==JOptionPane.NO_OPTION)
					dispose();
					//dispose();
			}
		});
		btnSalvar.setBounds(208, 405, 117, 25);
		contentPane.add(btnSalvar);
		
		/**************** FIM BOTAO SALVAR***********************/
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(SystemColor.controlHighlight);
		btnCancelar.setBackground(SystemColor.inactiveCaptionText);
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));

		btnCancelar.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(338, 405, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setForeground(SystemColor.controlHighlight);
		btnAjuda.setBackground(SystemColor.inactiveCaptionText);
		btnAjuda.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnAjuda.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/help.png")));
		btnAjuda.setBounds(78, 405, 117, 25);
		contentPane.add(btnAjuda);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Cadastre seu novo projeto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 14));
		panel.setBounds(35, 60, 475, 310);
		contentPane.add(panel);
	}
	public JFormattedTextField getRecebeRecursoFinanceiro_1() {
		return recebeRecursoFinanceiro_1;
	}
}
