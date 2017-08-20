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
	JTree tree;
	JPopupMenu popup;
	JMenuItem item;
	JMenuItem item2; 
	JMenuItem item3; 
	JMenuItem item4; 
	JMenu menu, menu2; 
	boolean overRoot = false;
	Point loc;

	public PopupHandler(JTree tree) {
		this.tree = tree;
		popup = new JPopupMenu();
		popup.setInvoker(tree);
		menu = new JMenu("Novo");
		menu2 = new JMenu("Deletar");
		popup.add(menu);
		popup.add(menu2);
		menu.add(item2= getMenuItem("Novo Projeto"));
		menu.add(item = getMenuItem("Novo Requisito"));
		menu2.add(item3= getMenuItem("Projeto"));
		menu2.add(item4= getMenuItem("Requisito"));
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
		if(ac.equals("REQUISITO"));
			deletarRequisito(recebenode);
	}
	
	private void deletarRequisito(String recebenode){
		RequisitoDAO dao = new RequisitoDAO();
		for(Requisito r: dao.readID()){

			if(recebenode.equals(r.getId())){
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o requisito "+recebenode+"?");
				if (resposta == JOptionPane.YES_OPTION){
				//JOptionPane.showMessageDialog(null, "Teste .equals:  "+recebenode+"="+p.getNome()+" "+ p.getCodigo());	
				dao.delete(r.getId());
				}
			}	else {
				//JOptionPane.showMessageDialog(null, "Para deletar selecione um projeto valido.");
				
			}
		}
		
	}

	private void deletarProjeto(String recebenode){
		//TreePath path = ((JTree) nodeInfo).getPathForLocation ( getX (), getY () );
		ProjetoDAO dao = new ProjetoDAO();
		for(Projeto p: dao.readName()){

			if(recebenode.equals(p.getNome())){
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o projeto "+recebenode+"?");
				if (resposta == JOptionPane.YES_OPTION){
				//JOptionPane.showMessageDialog(null, "Teste .equals:  "+recebenode+"="+p.getNome()+" "+ p.getCodigo());	
				dao.delete(p.getCodigo());
				}
			}	else {
				//JOptionPane.showMessageDialog(null, "Para deletar selecione um projeto valido.");
				
			}
		}
		
	}
	private void exibeProjeto(TreePath path) {

		CadastrarProjeto novoProjeto=new CadastrarProjeto();
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
				popup.show(tree, loc.x, loc.y);
			}
		}

		public void mousePressed(MouseEvent e)  { checkForPopup(e); }
		public void mouseReleased(MouseEvent e) { checkForPopup(e); }
		public void mouseClicked(MouseEvent e)  { checkForPopup(e); }
	};

	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		item.setVisible(!overRoot);
		item2.setVisible(overRoot);
		item3.setVisible(!overRoot);
		item4.setVisible(!overRoot);
		menu2.setVisible(!overRoot);
	}

	public void popupMenuCanceled(PopupMenuEvent e) {}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
}