package software;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastrarRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtListaDosProjetos;
	private JTextField recebeID;
	private JTextField recebeSujeito;
	private JTextField recebeAcaoRestri;
	private JTextField recebeValorRazao;
	private JTextField recebeGrauPrio;
	private JTextField recebeGrauDifi;
	private JTextField recebeEstimativa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarRequisito frame = new CadastrarRequisito();
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
	public CadastrarRequisito() {
		setTitle("Cadastrar requisito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastreSeuNovo = new JLabel("Cadastre seu novo requisito");
		lblCadastreSeuNovo.setFont(new Font("TakaoPGothic", Font.BOLD, 19));
		lblCadastreSeuNovo.setBounds(150, 40, 500, 15);
		contentPane.add(lblCadastreSeuNovo);
		
		JLabel lblProjetoAoQual = new JLabel("Selecione o projeto ao qual o requisito pertence:");
		lblProjetoAoQual.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblProjetoAoQual.setBounds(61, 84, 400, 15);
		contentPane.add(lblProjetoAoQual);
		
		txtListaDosProjetos = new JTextField();
		txtListaDosProjetos.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDosProjetos.setText("uma lista dos projetos ja cadastrados deve aparecer aqui ");
		txtListaDosProjetos.setBounds(65, 103, 400, 19);
		contentPane.add(txtListaDosProjetos);
		txtListaDosProjetos.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(185, 151, 70, 15);
		contentPane.add(lblId);
		
		recebeID = new JTextField();
		recebeID.setBounds(215, 149, 200, 19);
		contentPane.add(recebeID);
		recebeID.setColumns(10);
		
		JLabel lblSujeito = new JLabel("Sujeito: ");
		lblSujeito.setFont(new Font("TakaoPGothic", Font.BOLD, 12));	
		lblSujeito.setBounds(154, 182, 70, 15);
		contentPane.add(lblSujeito);
		
		recebeSujeito = new JTextField();
		recebeSujeito.setBounds(215, 179, 200, 19);
		contentPane.add(recebeSujeito);
		recebeSujeito.setColumns(10);
		
		JLabel lblAoEouRestrio = new JLabel("Ação e/ou restrição:");
		lblAoEouRestrio.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblAoEouRestrio.setBounds(68, 212, 300, 15);
		contentPane.add(lblAoEouRestrio);
		
		recebeAcaoRestri = new JTextField();
		recebeAcaoRestri.setBounds(215, 210, 200, 19);
		contentPane.add(recebeAcaoRestri);
		recebeAcaoRestri.setColumns(10);
		
		JLabel lblValorOuRazo = new JLabel("Valor ou razão: ");
		lblValorOuRazo.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblValorOuRazo.setBounds(104, 239, 300, 15);
		contentPane.add(lblValorOuRazo);
		
		recebeValorRazao = new JTextField();
		recebeValorRazao.setBounds(215, 239, 200, 19);
		contentPane.add(recebeValorRazao);
		recebeValorRazao.setColumns(10);
		
		JLabel lblGrauDePrioridade = new JLabel("Grau de prioridade:");
		lblGrauDePrioridade.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblGrauDePrioridade.setBounds(76, 297, 300, 15);
		contentPane.add(lblGrauDePrioridade);
		
		recebeGrauPrio = new JTextField();
		recebeGrauPrio.setBounds(215, 295, 200, 19);
		contentPane.add(recebeGrauPrio);
		recebeGrauPrio.setColumns(10);
		
		JLabel lblGrauDeDificuldade = new JLabel("Grau de dificuldade: ");
		lblGrauDeDificuldade.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblGrauDeDificuldade.setBounds(70, 266, 300, 15);
		contentPane.add(lblGrauDeDificuldade);
		
		JLabel lblEstimativa = new JLabel("Estimativa: ");
		lblEstimativa.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblEstimativa.setBounds(130, 324, 200, 15);
		contentPane.add(lblEstimativa);
		
		recebeGrauDifi = new JTextField();
		recebeGrauDifi.setBounds(215, 264, 200, 19);
		contentPane.add(recebeGrauDifi);
		recebeGrauDifi.setColumns(10);
		
		recebeEstimativa = new JTextField();
		recebeEstimativa.setBounds(215, 324, 200, 19);
		contentPane.add(recebeEstimativa);
		recebeEstimativa.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/disk.png")));
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//flata colocar as paradas aqui 
				JOptionPane.showMessageDialog(null, "Requisito salvo com sucesso!");
				dispose();
			}
		});
		btnSalvar.setBounds(225, 377, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/cancel.png")));
		btnCancelar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(355, 377, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/help.png")));
		btnAjuda.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnAjuda.setBounds(95, 377, 117, 25);
		contentPane.add(btnAjuda);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
