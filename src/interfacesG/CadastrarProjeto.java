package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Projeto;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastrarProjeto extends JFrame {

	private JPanel contentPane;
	private Projeto cprojeto; 
	private JTextField recebeNomeProjeto;
	private JTextField recebeDataInicio;
	private JTextField recebeDataTermino;
	private JLabel lblDescrioDoProjeto;
	private JTextField recebeDescricao;
	private JLabel lblRecursosFinanceiros;
	private JTextField recebeRecursoFinanceiro;
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
		lblInsiraONome.setBounds(92, 105, 200, 15);
		contentPane.add(lblInsiraONome);
		
		recebeNomeProjeto = new JTextField();
		recebeNomeProjeto.setBounds(271, 103, 200, 20);
		contentPane.add(recebeNomeProjeto);
		recebeNomeProjeto.setColumns(10);
		
		JLabel lblInsiraAData = new JLabel("Data de inicio: ");
		lblInsiraAData.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblInsiraAData.setBounds(159, 147, 200, 15);
		contentPane.add(lblInsiraAData);
		
		recebeDataInicio = new JTextField();
		recebeDataInicio.setBounds(271, 147, 200, 20);
		contentPane.add(recebeDataInicio);
		recebeDataInicio.setColumns(10);
		
		JLabel lblDataAproximadaPara = new JLabel("Data aproximada para término:");
		lblDataAproximadaPara.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblDataAproximadaPara.setBounds(55, 190, 250, 15);
		contentPane.add(lblDataAproximadaPara);
		
		recebeDataTermino = new JTextField();
		recebeDataTermino.setBounds(271, 188, 200, 20);
		contentPane.add(recebeDataTermino);
		recebeDataTermino.setColumns(10);
		
		lblDescrioDoProjeto = new JLabel("Descrição do projeto:");
		lblDescrioDoProjeto.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblDescrioDoProjeto.setBounds(115, 225, 200, 15);
		contentPane.add(lblDescrioDoProjeto);
		
		recebeDescricao = new JTextField();
		recebeDescricao.setBounds(271, 225, 200, 60);
		contentPane.add(recebeDescricao);
		recebeDescricao.setColumns(10);
		
		lblRecursosFinanceiros = new JLabel("Recurso financeiro estimado:");
		lblRecursosFinanceiros.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblRecursosFinanceiros.setBounds(64, 300, 250, 15);
		contentPane.add(lblRecursosFinanceiros);
		
		recebeRecursoFinanceiro = new JTextField();
		recebeRecursoFinanceiro.setBounds(271, 301, 200, 20);
		contentPane.add(recebeRecursoFinanceiro);
		recebeRecursoFinanceiro.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar ");
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));

		btnSalvar.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/disk.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ação salvar projeto
				cprojeto.setNome(recebeNomeProjeto.getText());
				cprojeto.setDataAproxTermino(recebeDataInicio.getText());
				cprojeto.setDataAproxTermino(recebeDataTermino.getText());
				cprojeto.setDescricao(recebeDescricao.getText());
				cprojeto.setRecursosFinanceiros(recebeRecursoFinanceiro.getText());
				JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
				dispose();
			}
		});
		btnSalvar.setBounds(124, 385, 140, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));

		btnCancelar.setIcon(new ImageIcon(CadastrarProjeto.class.getResource("/images/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(282, 385, 140, 25);
		contentPane.add(btnCancelar);
		
		lblCadastreSeuNovo = new JLabel("Cadastre seu novo projeto");
		lblCadastreSeuNovo.setFont(new Font("TakaoPGothic", Font.BOLD, 19));
		lblCadastreSeuNovo.setBounds(150, 30, 500, 30);
		contentPane.add(lblCadastreSeuNovo);
	}
}
