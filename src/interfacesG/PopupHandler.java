package interfacesG;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.bean.Projeto;
import model.bean.Requisito;
import model.dao.ProjetoDAO;
import model.dao.RequisitoDAO;

public class PopupHandler implements ActionListener,
PopupMenuListener {
	DefaultMutableTreeNode node;
	JTree tree;
	JPopupMenu popup;
	JMenuItem item;
	JMenuItem item2; 
	JMenuItem item3; 
	//JMenuItem item4; 
	JMenuItem item5, item6, item7; 
	JMenu menu, menu2, menu3; 
	boolean overRoot = false;
	boolean menuPopUpDel = false; 
	boolean interessado = false;
	boolean requisito = false; 
	Point loc;
	static JTabbedPane tabbedPane;

	public PopupHandler(JTree tree) {

		this.tree = tree;
		popup = new JPopupMenu();
		popup.setInvoker(tree);
		menu = new JMenu("Novo");
		menu2 = new JMenu("Deletar");
		//menu3 = new JMenu("Ver");
		popup.add(menu);
		popup.add(menu2);
		//popup.add(menu3);
		menu.add(item2= getMenuItem("Novo projeto"));
		menu.add(item7=getMenuItem("Novo interessado"));
		menu.add(item = getMenuItem("Novo requisito"));

		menu2.add(item3= getMenuItem("Projeto"));
		//menu2.add(item4= getMenuItem("Requisito"));
		//menu3.add(item5= getMenuItem("Informações do projeto"));
		//menu3.add(item6=getMenuItem("Todos os requisitos"));
		tree.addMouseListener(ma);
		popup.addPopupMenuListener(this);
	}

	private JMenuItem getMenuItem(String s) {
		JMenuItem menuItem = new JMenuItem(s);
		menuItem.setActionCommand(s.toUpperCase());
		menuItem.addActionListener(this);
		return menuItem;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		TreePath path  = tree.getPathForLocation(loc.x, loc.y);
		//System.out.println("path = " + path);
		//System.out.printf("loc = [%d, %d]%n", loc.x, loc.y);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				tree.getLastSelectedPathComponent();
		Object nodeInfo = node.getUserObject();
		String recebenode=(String) nodeInfo;
		//JOptionPane.showMessageDialog(null, recebenode);
		if(ac.equals("NOVO PROJETO"))
			exibeProjeto(path);
		if(ac.equals("NOVO REQUISITO"))
			exibeRequisito(path);
		if(ac.equals("PROJETO"))
			deletarProjeto(recebenode);
		if(ac.equals("NOVO INTERESSADO")){
			exibeCadInteressado(path);
		}
	}

	public void exibeCadInteressado(TreePath path){
		CadastrarInteressadoSistema IS = new CadastrarInteressadoSistema(tree);
		IS.setLocationRelativeTo(null);
		IS.setVisible(true);

	}

	private void deletarProjeto(String recebenode){
		//TreePath path = ((JTree) nodeInfo).getPathForLocation ( getX (), getY () );
		ProjetoDAO dao = new ProjetoDAO();
		RequisitoDAO rdao=new RequisitoDAO();
		MeusProjetos mp = new MeusProjetos();
		for(Projeto p: dao.readName()){

			if(recebenode.equals(p.getNome())){
				int resposta = JOptionPane.showConfirmDialog(null, "Ao deletar um projeto todos os requisitos e interessados associados a ele serão removidos. \nDeseja realmente deletar o projeto "+p.getNome()+"?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION){
					//deletar primeiro os requisitos ligados ao projeto
					for(Requisito r: rdao.readID()){
						if(p.getCodigo()==r.getProjcodigo()){							
							rdao.delete(r.getId());
						}	
					}
					//deletar os interessados


					//deletar o projeto
					dao.delete(p.getCodigo());
					mp.rodaArvore(tree);

				}



			}	
		}

	}
	private void exibeProjeto(TreePath path) {

		CadastrarProjeto novoProjeto=new CadastrarProjeto(tree);
		novoProjeto.setVisible(true);
		novoProjeto.setLocationRelativeTo(null);
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();

	}

	private void exibeRequisito(TreePath path) {

		CadastrarRequisito novoRequisito=new CadastrarRequisito();
		novoRequisito.setVisible(true);
		novoRequisito.setLocationRelativeTo(null);
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();

	}

	private MouseListener ma = new MouseAdapter() {
		private void checkForPopup(MouseEvent e) {
			if(e.isPopupTrigger()) {
				loc = e.getPoint();
				TreePath path  = tree.getPathForLocation(loc.x, loc.y);
				//System.out.printf("path = %s%n", path);
				if(path == null) {
					e.consume();
					return;
				}

				TreeNode root = (TreeNode)tree.getModel().getRoot();;
				overRoot = path.getLastPathComponent() == root;

				teste(); 

				popup.show(tree, loc.x, loc.y);

			}
		}

		public void teste (){
			/// testar 
			TreePath path  = tree.getPathForLocation(loc.x, loc.y);
			TreeNode root = (TreeNode)tree.getModel().getRoot();;

			node = (DefaultMutableTreeNode) path.getLastPathComponent();
			Object nodeInf2= node.getUserObject();
			Object nodeInfo = node.getParent();
			//String parent = tree.getSelectionPath().getParentPath().getLastPathComponent().toString();
			//System.out.println(nodeInfo+" "+node + " "+ nodeInf2);

			if((node!=root) && (nodeInfo!=null) && ((nodeInf2 != "Requisitos") && (nodeInf2 !="Interessados"))){
				menuPopUpDel=true;
			}else{
				menuPopUpDel=false; 
			}
			
			if ((node!=root) && (nodeInfo!=null) && (nodeInf2!="Requisitos")){
				interessado=true;
			}
			else{
				interessado=false; 
			}
			
			if ((node!=root) && (nodeInfo!=null) && (nodeInf2!="Interessados")){
				requisito=true;
			}
			else{
				requisito=false; 
			}
			popup.show(tree, loc.x, loc.y);


		}

		public void mousePressed(MouseEvent e)  { checkForPopup(e); }
		public void mouseReleased(MouseEvent e) { checkForPopup(e); }
		public void mouseClicked(MouseEvent e)  { checkForPopup(e); }
	};



	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		item.setVisible(requisito); //novo requisito nao pode ser visivel na raiz 
		item2.setVisible(overRoot); //novo projeto só pode ser visível na raiz 
		item3.setVisible(!overRoot); //projeto   ============> arrumar 
		//item5.setVisible(!overRoot);   
		//item6.setVisible(!overRoot);
		item7.setVisible(interessado);

		menu2.setVisible(menuPopUpDel); // não pode ser visivel na raiz e nem em requisitos      =======> arrumar 
		//menu3.setVisible(!overRoot); // não pode ser visivel na raiz 		========> arrumar 
	}

	public void popupMenuCanceled(PopupMenuEvent e) {}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
}