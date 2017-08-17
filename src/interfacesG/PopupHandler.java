package interfacesG;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class PopupHandler implements ActionListener,
PopupMenuListener {
	JTree tree;
	JPopupMenu popup;
	JMenuItem item;
	JMenuItem item2; 
	boolean overRoot = false;
	Point loc;

	public PopupHandler(JTree tree) {
		this.tree = tree;
		popup = new JPopupMenu();
		popup.setInvoker(tree);
		JMenu menu = new JMenu("Novo");
		popup.add(menu);
		menu.add(item2= getMenuItem("Novo Projeto"));
		menu.add(item = getMenuItem("Novo Requisito"));
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
		if(ac.equals("NOVO PROJETO"))
			exibeProjeto(path);
		if(ac.equals("NOVO REQUISITO"))
			exibeRequisito(path);
	}

	private void exibeProjeto(TreePath path) {

		CadastrarProjeto novoProjeto=new CadastrarProjeto();
		novoProjeto.setVisible(true);
		novoProjeto.setLocationRelativeTo(null);
	}

	private void exibeRequisito(TreePath path) {
		CadastrarRequisito novoRequisito=new CadastrarRequisito();
		novoRequisito.setVisible(true);
		novoRequisito.setLocationRelativeTo(null);
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
	}

	public void popupMenuCanceled(PopupMenuEvent e) {}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
}