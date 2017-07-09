package interfacesG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JToolBar;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JDesktopPane;

public class TelaInicioInterface extends JFrame {

	private JPanel contentPane;
	//private Projeto projeto;

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
					TelaInicioInterface frame = new TelaInicioInterface();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
	 
		
		/*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicioInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicioInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicioInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicioInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>*/
	}

	/**
	 * Create the frame.
	 */
	
	public TelaInicioInterface() {
		
		setResizable(false);
		setFocusTraversalPolicyProvider(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Nome do software aqui");
		//projeto=new Projeto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 600, 500);  //tamanho da janela 
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 23, 576, 465);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnMeusProjetos = new JButton("Meus projetos");
		btnMeusProjetos.setForeground(SystemColor.control);
		btnMeusProjetos.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnMeusProjetos.setToolTipText("Incluir, alterar, excluir e ver meus projetos");
		btnMeusProjetos.setBounds(116, 159, 340, 40);
		panel.add(btnMeusProjetos);
		btnMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//colocar acao do botao meus projetos aqui 
			
				MeusProjetos myProjects = new MeusProjetos();
				myProjects.setVisible(true);
				myProjects.setTitle("Meus Projetos");
				myProjects.setLocationRelativeTo(null);
				//myProjects.setExtendedState(MAXIMIZED_BOTH);
				dispose();
				
			}
		});
		btnMeusProjetos.setBackground(SystemColor.inactiveCaptionText);
		
		JButton btnSobreP = new JButton("Sobre");
		btnSobreP.setForeground(SystemColor.control);
		btnSobreP.setBackground(SystemColor.inactiveCaptionText);
		btnSobreP.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnSobreP.setToolTipText("Sobre o (nome do programa aqui)");
		btnSobreP.setBounds(116, 216, 340, 40);
		panel.add(btnSobreP);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(SystemColor.control);
		btnSair.setBackground(SystemColor.inactiveCaptionText);
		btnSair.setFont(new Font("TakaoPGothic", Font.BOLD, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(116, 273, 340, 40);
		panel.add(btnSair);
		btnSair.setToolTipText("");
		
		JLabel lblNomeDoSoftware = new JLabel("Nome do Software Aqui");
		lblNomeDoSoftware.setForeground(SystemColor.windowText);
		lblNomeDoSoftware.setBounds(86, 72, 400, 19);
		panel.add(lblNomeDoSoftware);
		lblNomeDoSoftware.setFont(new Font("TakaoPGothic", Font.BOLD, 19));
		lblNomeDoSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSistemaParaApoiar = new JLabel("Sistema para apoiar a Especificação de Requisitos de Software");
		lblSistemaParaApoiar.setFont(new Font("Garuda", Font.BOLD | Font.ITALIC, 15));
		lblSistemaParaApoiar.setForeground(SystemColor.menuText);
		lblSistemaParaApoiar.setBackground(UIManager.getColor("Button.background"));
		lblSistemaParaApoiar.setBounds(70, 105, 470, 15);
		panel.add(lblSistemaParaApoiar);
		
		JLabel facomLogo = new JLabel("");
		facomLogo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/facomlogo.png"))); //tentar direcionar para site depois
		facomLogo.setBounds(222, 390, 50, 51);
		panel.add(facomLogo);
		
		JLabel ufmsLogo = new JLabel("");
		ufmsLogo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/newlogo.png"))); //tentar direcionar para site depois 
		ufmsLogo.setBounds(302, 390, 50, 51);
		panel.add(ufmsLogo);
		
		JLabel bgFundo2 = new JLabel("");
		bgFundo2.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/diamond-bg.png")));
		bgFundo2.setBounds(0, 0, 576, 465);
		panel.add(bgFundo2);
		
		
		JLabel bgFundo = new JLabel("");
		bgFundo.setBounds(0, 0, 606, 523);
		contentPane.add(bgFundo);
		bgFundo.setIcon(new ImageIcon(TelaInicioInterface.class.getResource("/images/diamond-bg.png")));
		btnSobreP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colocar ação do botão sobre 
			}
		});
	}
}
