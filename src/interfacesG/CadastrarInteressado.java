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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;

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
		setBounds(100, 100, 492, 415);
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
		btnCancelar.setBounds(356, 367, 110, 25);
		contentPane.add(btnCancelar);
		
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
		btnSalvar.setBounds(231, 367, 110, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblNome.setBounds(57, 77, 60, 15);
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		lblSobrenome.setBounds(236, 77, 100, 15);
		lblSobrenome.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblSobrenome);
		
		JLabel lblEndereco = new JLabel("Endereço: ");
		lblEndereco.setBounds(36, 117, 120, 15);
		lblEndereco.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblEndereco);
		
		JLabel lblRg = new JLabel("RG: ");
		lblRg.setBounds(75, 203, 60, 15);
		lblRg.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(70, 240, 60, 15);
		lblCpf.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(41, 160, 90, 15);
		lblTelefone.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblEmail.setBounds(57, 277, 60, 15);
		contentPane.add(lblEmail);
		
		recebeNome = new JTextField();
		recebeNome.setBounds(106, 72, 122, 27);
		contentPane.add(recebeNome);
		recebeNome.setColumns(10);
		
		recebeSobrenome = new JTextField();
		recebeSobrenome.setBounds(316, 72, 122, 27);
		contentPane.add(recebeSobrenome);
		recebeSobrenome.setColumns(10);
		
		recebeEndereco = new JTextField();
		recebeEndereco.setBounds(106, 112, 332, 27);
		contentPane.add(recebeEndereco);
		recebeEndereco.setColumns(10);
		
		recebeTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter telefone= new javax.swing.text.MaskFormatter("(##)#####-####");
			telefone.setPlaceholderCharacter('_');
			recebeTelefone = new javax.swing.JFormattedTextField(telefone);
			recebeTelefone.setHorizontalAlignment(SwingConstants.LEFT);
			recebeTelefone.setToolTipText("Exemplo: (67)99222-2222");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir CPF!");
		}
		recebeTelefone.setBounds(106, 155, 150, 27);
		contentPane.add(recebeTelefone);
		recebeTelefone.setColumns(10);
		
		recebeRG = new JTextField();
		recebeRG.setBounds(106, 197, 150, 27);
		contentPane.add(recebeRG);
		recebeRG.setColumns(10);
		
		recebeCPF = new JTextField();

		try {
			javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
			cpf.setPlaceholderCharacter('_');
			recebeCPF = new javax.swing.JFormattedTextField(cpf);
			recebeCPF.setHorizontalAlignment(SwingConstants.LEFT);
			recebeCPF.setToolTipText("AAAA/MM/DD");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir CPF!");
		}
		
		recebeCPF.setBounds(106, 237, 150, 27);
		contentPane.add(recebeCPF);
		recebeCPF.setColumns(10);
		
		recebeEmail = new JTextField();
		recebeEmail.setBounds(106, 273, 332, 27);
		contentPane.add(recebeEmail);
		recebeEmail.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(21, 35, 448, 315);
		contentPane.add(panel);
		
		JButton lblCadastroDeInsteressados_1 = new JButton(" Cadastrar novo interessado no sistema");
		lblCadastroDeInsteressados_1.setFocusable(false);
		lblCadastroDeInsteressados_1.setFocusTraversalKeysEnabled(false);
		lblCadastroDeInsteressados_1.setFocusPainted(false);
		lblCadastroDeInsteressados_1.setForeground(SystemColor.control);
		lblCadastroDeInsteressados_1.setBackground(SystemColor.activeCaptionText);
		lblCadastroDeInsteressados_1.setIcon(new ImageIcon(CadastrarInteressado.class.getResource("/images/group_add.png")));
		lblCadastroDeInsteressados_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeInsteressados_1.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 14));
		lblCadastroDeInsteressados_1.setBounds(21, 6, 448, 30);
		contentPane.add(lblCadastroDeInsteressados_1);
		
		
	}
}
