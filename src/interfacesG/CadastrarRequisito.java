package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Projeto;
import model.bean.Requisito;
import model.bean.Requisito.GrauD;
import model.bean.Requisito.GrauP;
import model.bean.Requisito.TipoReq;
import model.dao.ProjetoDAO;
import model.dao.RequisitoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

import java.util.Date;


public class CadastrarRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtListaDosProjetos;
	private JTextField recebeID;
	private JTextField recebeSujeito;
	private JTextArea recebeAcaoRestri;
	private JTextField recebeValorRazao;
	private JTextField recebeEstimativa;
	private Requisito nreq; 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private boolean selectPrioridade; 
	private boolean selectDificuldade; 
	private JLabel lblNewLabel;

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
					CadastrarRequisito frame = new CadastrarRequisito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
	
	 public AbstractAction acaoBotao() {
	        AbstractAction acao = new AbstractAction() {
	            public void actionPerformed(ActionEvent event) {
	                //limpa os campos
	                for (int i=0; i < getContentPane().getComponentCount(); i++) {
	                    //varre todos os componentes
	                    Component c = getContentPane().getComponent(i);
	                    if (c instanceof JTextField) {
	                        //apaga os valores
	                        JTextField field = (JTextField) c;
	                        field.setText("");
	                        //System.out.println("apagando campo " + i);
	                    }
	                }
	            }
	        };
	        
	        return acao;
	    }
	/**
	 * Create the frame.
	 */
	public CadastrarRequisito() {
		nreq = new Requisito();
		
		setTitle("Cadastrar requisito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*JLabel lblProjetoAoQual = new JLabel("Selecione o projeto ao qual o requisito pertence:");
		lblProjetoAoQual.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		lblProjetoAoQual.setBounds(61, 84, 400, 15);
		contentPane.add(lblProjetoAoQual);

		txtListaDosProjetos = new JTextField();
		txtListaDosProjetos.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDosProjetos.setText("uma lista dos projetos ja cadastrados deve aparecer aqui ");
		txtListaDosProjetos.setBounds(65, 103, 400, 19);
		contentPane.add(txtListaDosProjetos);
		txtListaDosProjetos.setColumns(10);*/

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblId.setBounds(155, 130, 80, 15);
		contentPane.add(lblId);

		recebeID = new JTextField();
		recebeID.setBounds(186, 130, 250, 25);
		contentPane.add(recebeID);
		recebeID.setColumns(10);

		recebeSujeito = new JTextField();
		recebeSujeito.setBounds(186, 165, 250, 25);
		contentPane.add(recebeSujeito);
		recebeSujeito.setColumns(10);

		//------acao restricao --------//
		JLabel lblAoEouRestrio = new JLabel("Ação e/ou restrição:");
		lblAoEouRestrio.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
		lblAoEouRestrio.setBounds(50, 209, 300, 15);
		contentPane.add(lblAoEouRestrio);

		recebeAcaoRestri = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(recebeAcaoRestri);
		scrollPane.setBounds(186, 200, 250, 40);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical se necessário
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER); // nunca mostra a barra de rolagem horizontal
		
		contentPane.add(scrollPane);

		
		recebeAcaoRestri.setMargin(new Insets(4, 3, 4, 3));
		recebeAcaoRestri.setTabSize(0);
		recebeAcaoRestri.setWrapStyleWord(true);
		recebeAcaoRestri.setLineWrap(true);
		recebeAcaoRestri.setBounds(180, 210, 200, 25);
		recebeAcaoRestri.setColumns(10);
		
		//------------------------------//
		

		JLabel lblValorOuRazo = new JLabel("Valor ou razão: ");
		lblValorOuRazo.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblValorOuRazo.setBounds(80, 250, 300, 15);
		contentPane.add(lblValorOuRazo);

		recebeValorRazao = new JTextField();
		recebeValorRazao.setBounds(186, 249, 250, 25);
		contentPane.add(recebeValorRazao);
		recebeValorRazao.setColumns(10);

		JLabel lblGrauDePrioridade = new JLabel("Grau de prioridade:");
		lblGrauDePrioridade.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblGrauDePrioridade.setBounds(54, 308, 300, 15);
		contentPane.add(lblGrauDePrioridade);

		JLabel lblGrauDeDificuldade = new JLabel("Grau de dificuldade: ");
		lblGrauDeDificuldade.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblGrauDeDificuldade.setBounds(49, 280, 300, 15);
		contentPane.add(lblGrauDeDificuldade);

		JLabel lblEstimativa = new JLabel("Estimativa: ");
		lblEstimativa.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		lblEstimativa.setBounds(103, 337, 200, 15);
		contentPane.add(lblEstimativa);

		recebeEstimativa = new JTextField();
		recebeEstimativa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				recebeEstimativa.setText("");
			}		
		});
		
		recebeEstimativa.setToolTipText("em horas, exemplo: 1, para uma hora, 2, para duas horas. ");
		
		
		/*try {
		
			javax.swing.text.MaskFormatter hora= new javax.swing.text.MaskFormatter("##:##:##");
			hora.setPlaceholderCharacter('0');
			recebeEstimativa = new javax.swing.JFormattedTextField(hora);
			recebeEstimativa.setHorizontalAlignment(SwingConstants.LEFT);
			recebeEstimativa.setToolTipText("HH:MM:SS");
		}
		catch (Exception e) {     
			JOptionPane.showMessageDialog(null,"Erro ao inserir data!");
		}*/	
		
		recebeEstimativa.setBounds(186, 334, 250, 25);
		contentPane.add(recebeEstimativa);
		recebeEstimativa.setColumns(10);

		/********* grau dificuldade ****************/
		JRadioButton gdBaixa = new JRadioButton("Baixa");
		gdBaixa.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup.add(gdBaixa);
		gdBaixa.setBounds(195, 277, 70, 23);
		contentPane.add(gdBaixa);

		JRadioButton gdMdia = new JRadioButton("Média");
		gdMdia.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup.add(gdMdia);
		gdMdia.setBounds(278, 277, 80, 23);
		contentPane.add(gdMdia);

		JRadioButton gdAlta = new JRadioButton("Alta");
		gdAlta.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup.add(gdAlta);
		gdAlta.setBounds(370, 277, 110, 23);
		contentPane.add(gdAlta);

		/******** grau prioridade ****************/
		JRadioButton gpBaixa = new JRadioButton("Baixa");
		gpBaixa.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup_1.add(gpBaixa);
		gpBaixa.setBounds(195, 304, 70, 23);
		contentPane.add(gpBaixa);

		JRadioButton gpMedia = new JRadioButton("Média");
		gpMedia.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup_1.add(gpMedia);
		gpMedia.setBounds(278, 304, 80, 23);
		contentPane.add(gpMedia);

		JRadioButton gpAlta = new JRadioButton("Alta");
		gpAlta.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		buttonGroup_1.add(gpAlta);
		gpAlta.setBounds(370, 304, 110, 23);
		contentPane.add(gpAlta);
		
		
		
		JComboBox comboBox = new JComboBox();	
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.setBackground(new Color(28,28,28));
			}
			
		});
			
		comboBox.setForeground(SystemColor.controlHighlight);
		comboBox.setBackground(SystemColor.inactiveCaptionText);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		comboBox.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		comboBox.setBounds(187, 93, 250, 25);
		//String selecione="Selecione";
		String rf="Requisito funcional";
		String rnf="Requisito não funcional"; 
		String ru="Requisito de usuário";
		String rn="Requisito de negócio"; 
		//comboBox.addItem(selecione);
		comboBox.addItem(rf);
		comboBox.addItem(rnf);
		comboBox.addItem(ru);
		comboBox.addItem(rn);
		
		contentPane.add(comboBox);
		
		
		JComboBox comboBox2 = new JComboBox();	
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.setBackground(new Color(28,28,28));
			}
			
		});	
		comboBox2.setForeground(SystemColor.controlHighlight);
		comboBox2.setBackground(SystemColor.inactiveCaptionText);
		comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		comboBox2.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
		comboBox2.setBounds(187, 55, 250, 25);
		//String selecione="Selecione";
		ProjetoDAO pdao = new ProjetoDAO();
		for(Projeto p: pdao.readName()){
			String nomep=p.getNome();
			comboBox2.addItem(nomep);
		}
		contentPane.add(comboBox2);

		/*************ação ao salvar requisito*************/
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(SystemColor.controlHighlight);
		btnSalvar.setBackground(SystemColor.activeCaptionText);
		btnSalvar.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/disk.png")));
		btnSalvar.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequisitoDAO dao = new RequisitoDAO();
				ProjetoDAO pdao = new ProjetoDAO();
				
				for(Projeto p: pdao.readName() ){
					if(comboBox2.getSelectedItem().equals(p.getNome())){
						nreq.setProjcodigo(p.getCodigo());
					}
				}
				
				
				
				if(comboBox.getSelectedItem()==rf){
					nreq.setTipoReq(TipoReq.FUNCIONAL);			
				}
				if(comboBox.getSelectedItem()==rnf){
					nreq.setTipoReq(TipoReq.NAOFUNCIONAL);
				}
				
				if(comboBox.getSelectedItem()==ru){
					nreq.setTipoReq(TipoReq.USUARIO);
				}
				if(comboBox.getSelectedItem()==rn){
					nreq.setTipoReq(TipoReq.NEGOCIO);	
				}
				
				nreq.setId(recebeID.getText());
				nreq.setSujeito(recebeSujeito.getText());
				nreq.setAcaoRestricao(recebeAcaoRestri.getText());
				nreq.setValorRazao(recebeValorRazao.getText());

				//setando grau de dificuldade
				if (gdBaixa.isSelected()){
					nreq.setGrauDificuldade(GrauD.BAIXA);
				}
				if (gdMdia.isSelected()){
					nreq.setGrauDificuldade(GrauD.MEDIA);
				}
				if (gdAlta.isSelected()){
					nreq.setGrauDificuldade(GrauD.ALTA);
				}

				//setando grau de prioridade
				if(gpBaixa.isSelected()){
					nreq.setGrauPrioridade(GrauP.BAIXA);	
				}
				if(gpMedia.isSelected()){
					nreq.setGrauPrioridade(GrauP.MEDIA);
				}
				if(gpAlta.isSelected()){
					nreq.setGrauPrioridade(GrauP.ALTA);					
				}

				nreq.setEstimativa(Integer.parseInt(recebeEstimativa.getText()));

				dao.create(nreq);
				
				 
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo requisito para este mesmo projeto?");
				if (resposta == JOptionPane.YES_OPTION){
					//limpa campos para cadastrar novo requisito
					recebeID.setText("");
					recebeSujeito.setText("");
					recebeAcaoRestri.setText("");
					recebeValorRazao.setText("");
					recebeEstimativa.setText("");
				
				}
				if (resposta ==JOptionPane.NO_OPTION)
					dispose();
					//dispose();
			}
		});
		btnSalvar.setBounds(216, 420, 117, 25);
		contentPane.add(btnSalvar);
		
		// ------------------------- end salvar requisito 

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
		btnCancelar.setBounds(352, 420, 117, 25);
		contentPane.add(btnCancelar);

		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setForeground(SystemColor.controlHighlight);
		btnAjuda.setBackground(SystemColor.activeCaptionText);
		btnAjuda.setIcon(new ImageIcon(CadastrarRequisito.class.getResource("/images/help.png")));
		btnAjuda.setFont(new Font("TakaoPGothic", Font.BOLD, 12));
		btnAjuda.setBounds(80, 420, 117, 25);
		contentPane.add(btnAjuda);
				
				JLabel labelProjeto = new JLabel("Projeto: ");
				labelProjeto.setBounds(124, 55, 52, 21);
				contentPane.add(labelProjeto);
				labelProjeto.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));
				
				JLabel lblSujeito = new JLabel("Sujeito: ");
				lblSujeito.setFont(new Font("Noto Sans CJK SC Medium", Font.PLAIN, 13));	
				lblSujeito.setBounds(124, 165, 70, 15);
				contentPane.add(lblSujeito);
				
				lblNewLabel = new JLabel("Tipo de requisito: ");
				lblNewLabel.setFont(new Font("Noto Sans CJK TC Medium", Font.PLAIN, 13));
				lblNewLabel.setBounds(65, 90, 150, 25);
				contentPane.add(lblNewLabel);
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Cadastre seu novo requisito", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel.setBounds(35, 30, 480, 360);
				contentPane.add(panel);
				
			
				
				

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
