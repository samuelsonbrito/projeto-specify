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
	private JLabel lblCadastreSeuNovo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public CadastrarProjeto() {
		cprojeto=new Projeto();
		setTitle("Cadastrar Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraONome = new JLabel("Insira o nome do projeto:");
		lblInsiraONome.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblInsiraONome.setBounds(92, 137, 200, 15);
		contentPane.add(lblInsiraONome);
		
		recebeNomeProjeto = new JTextField();
		recebeNomeProjeto.setBounds(271, 135, 200, 20);
		contentPane.add(recebeNomeProjeto);
		recebeNomeProjeto.setColumns(10);
		
		/*********datas inicio e fim******************/
		JLabel lblInsiraAData = new JLabel("Data de inicio: ");
		lblInsiraAData.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblInsiraAData.setBounds(159, 179, 200, 15);
		contentPane.add(lblInsiraAData);
		
		recebeDataInicio_1_1 = new JFormattedTextField();

		try {
			javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####/##/##");
			data.setPlaceholderCharacter('_');
			recebeDataInicio_1_1 = new javax.swing.JFormattedTextField(data);
			recebeDataInicio_1_1.setToolTipText("AAAA/MM/DD");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir data!");
		}
		
		recebeDataInicio_1_1.setBounds(271, 179, 200, 20);
		contentPane.add(recebeDataInicio_1_1);
		recebeDataInicio_1_1.setColumns(10);
		
		
		JLabel lblDataAproximadaPara = new JLabel("Data aproximada para término:");
		lblDataAproximadaPara.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblDataAproximadaPara.setBounds(55, 222, 250, 15);
		contentPane.add(lblDataAproximadaPara);
		
		recebeDataTermino_1 = new JFormattedTextField();
		try {
			javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####/##/##");
			data.setPlaceholderCharacter('_');
			recebeDataTermino_1 = new javax.swing.JFormattedTextField(data);
			recebeDataTermino_1.setToolTipText("AAAA/MM/DD");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir data!");
		}
		
		recebeDataTermino_1.setBounds(271, 220, 200, 20);
		contentPane.add(recebeDataTermino_1);
		recebeDataTermino_1.setColumns(10);
		/********************************************/
		
		lblDescrioDoProjeto = new JLabel("Descrição do projeto:");
		lblDescrioDoProjeto.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblDescrioDoProjeto.setBounds(115, 257, 200, 15);
		contentPane.add(lblDescrioDoProjeto);
		
		
		
		recebeDescricao = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(recebeDescricao);
		scrollPane.setBounds(271, 255, 200, 60);
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
		lblRecursosFinanceiros.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblRecursosFinanceiros.setBounds(64, 332, 250, 15);
		contentPane.add(lblRecursosFinanceiros);
		
		recebeRecursoFinanceiro_1 = new JFormattedTextField();
		try {
			recebeRecursoFinanceiro_1.setDocument(new MonetarioDocument());
			recebeRecursoFinanceiro_1.setText("0");		
		}
		catch (Exception e) {  
		      e.printStackTrace();  
		  } 
		
		recebeRecursoFinanceiro_1.setBounds(271, 333, 200, 20);
		contentPane.add(recebeRecursoFinanceiro_1);
		recebeRecursoFinanceiro_1.setColumns(10);
		
	/*************************************************/
		
		
		JButton btnSalvar = new JButton("Salvar ");
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
				
				/*int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo projeto?");
				if (resposta == JOptionPane.YES_OPTION)
					JOptionPane.showMessageDialog(null, "");;
					//precisa fazer limpar campos para poder cadastrar novo req
				if (resposta ==JOptionPane.NO_OPTION)
					dispose();*/
				
				dispose();
			}
		});
		btnSalvar.setBounds(124, 417, 140, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));

		btnCancelar.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(282, 417, 140, 25);
		contentPane.add(btnCancelar);
		
		lblCadastreSeuNovo = new JLabel("Cadastre seu novo projeto");
		lblCadastreSeuNovo.setFont(new Font("TakaoPGothic", Font.BOLD, 19));
		lblCadastreSeuNovo.setBounds(150, 30, 500, 30);
		contentPane.add(lblCadastreSeuNovo);
	}
	public JFormattedTextField getRecebeRecursoFinanceiro_1() {
		return recebeRecursoFinanceiro_1;
	}
}
