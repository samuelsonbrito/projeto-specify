package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.bean.Interessado;
import model.dao.InteressadoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastrarInteressado extends JFrame {

	private JPanel contentPane;
	private JTextField recebeNome;
	private JTextField recebeSobrenome;
	private JTextField recebeEndereco;
	private JTextField recebeTelefone;
	private JTextField recebeRG;
	private JTextField recebeCPF;
	private JTextField recebeEmail;

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
					CadastrarInteressado frame = new CadastrarInteressado();
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
	public CadastrarInteressado() {
		setTitle("Cadastrar Interessado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/*************botão de cancelar ********************/
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(SystemColor.controlHighlight);
		btnCancelar.setBackground(SystemColor.activeCaptionText);
		btnCancelar.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/cancel.png")));
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnCancelar.setBounds(342, 424, 117, 25);
		contentPane.add(btnCancelar);
		
		/*************botão de ajuda *************&*******/
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TelaAjudaRequisito ajuda = new TelaAjudaRequisito();
				//ajuda.setLocationRelativeTo(null);
				//ajuda.setVisible(true);
			}
		});
		btnAjuda.setForeground(SystemColor.controlHighlight);
		btnAjuda.setBackground(SystemColor.activeCaptionText);
		btnAjuda.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/help.png")));
		btnAjuda.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnAjuda.setBounds(70, 424, 117, 25);
		contentPane.add(btnAjuda);
		
		/*************botão salvar interessado*************/
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interessado i= new Interessado();
				InteressadoDAO dao = new InteressadoDAO();
				i.setNome(recebeNome.getText());
				i.setSobrenome(recebeSobrenome.getText());
				i.setEndereco(recebeEndereco.getText());
				i.setEmail(recebeEmail.getText());
				i.setCpf(recebeCPF.getText());
				i.setRg(recebeRG.getText());
				i.setTelefone(recebeTelefone.getText());
				dao.create(i);
				
				 
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo interessado?", "Cadastrar novo interessado", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION){
					//limpa campos para cadastrar novo requisito
					recebeNome.setText("");
					recebeSobrenome.setText("");
					recebeEndereco.setText("");
					recebeEmail.setText("");
					recebeCPF.setText("");
					recebeRG.setText("");
					recebeTelefone.setText("");
				
				}
				if (resposta ==JOptionPane.NO_OPTION)
					dispose();
			}
		});
		btnSalvar.setForeground(SystemColor.controlHighlight);
		btnSalvar.setBackground(SystemColor.activeCaptionText);
		btnSalvar.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/disk.png")));
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnSalvar.setBounds(206, 424, 117, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblNome.setBounds(71, 60, 60, 15);
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		lblSobrenome.setBounds(250, 60, 100, 15);
		lblSobrenome.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblSobrenome);
		
		JLabel lblEndereco = new JLabel("Endereço: ");
		lblEndereco.setBounds(71, 100, 100, 15);
		lblEndereco.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblEndereco);
		
		JLabel lblRg = new JLabel("RG: ");
		lblRg.setBounds(71, 180, 60, 15);
		lblRg.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(71, 216, 60, 15);
		lblCpf.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(71, 140, 90, 15);
		lblTelefone.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblEmail.setBounds(71, 260, 60, 15);
		contentPane.add(lblEmail);
		
		recebeNome = new JTextField();
		recebeNome.setBounds(120, 56, 122, 27);
		contentPane.add(recebeNome);
		recebeNome.setColumns(10);
		
		recebeSobrenome = new JTextField();
		recebeSobrenome.setBounds(330, 56, 122, 27);
		contentPane.add(recebeSobrenome);
		recebeSobrenome.setColumns(10);
		
		recebeEndereco = new JTextField();
		recebeEndereco.setBounds(140, 95, 313, 27);
		contentPane.add(recebeEndereco);
		recebeEndereco.setColumns(10);
		
		recebeTelefone = new JTextField();
		recebeTelefone.setBounds(141, 135, 122, 27);
		contentPane.add(recebeTelefone);
		recebeTelefone.setColumns(10);
		
		recebeRG = new JTextField();
		recebeRG.setBounds(100, 176, 122, 27);
		contentPane.add(recebeRG);
		recebeRG.setColumns(10);
		
		recebeCPF = new JTextField();
		recebeCPF.setBounds(100, 210, 122, 27);
		contentPane.add(recebeCPF);
		recebeCPF.setColumns(10);
		
		recebeEmail = new JTextField();
		recebeEmail.setBounds(120, 258, 122, 27);
		contentPane.add(recebeEmail);
		recebeEmail.setColumns(10);
		
		
	}
}
