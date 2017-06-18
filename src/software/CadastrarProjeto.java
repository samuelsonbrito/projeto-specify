package software;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CadastrarProjeto extends JFrame {

	private JPanel contentPane;
	private Projeto cprojeto; 
	private JTextField recebeNomeProjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProjeto frame = new CadastrarProjeto();
					frame.setVisible(true);
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
		setTitle("CadastrarProjeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraONome = new JLabel("Insira o nome do projeto:");
		lblInsiraONome.setBounds(54, 55, 200, 15);
		contentPane.add(lblInsiraONome);
		
		recebeNomeProjeto = new JTextField();
		recebeNomeProjeto.setBounds(254, 77, 114, 19);
		contentPane.add(recebeNomeProjeto);
		recebeNomeProjeto.setColumns(10);
	}
}
