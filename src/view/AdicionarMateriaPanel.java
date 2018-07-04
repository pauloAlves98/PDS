package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import model.Personalizar;

import javax.swing.tree.DefaultMutableTreeNode;
//acoplar essa tela ao card do paneSubObjetivo , tratar seus eventos, criar outras telas
public class AdicionarMateriaPanel extends ManipularMateria {
	private JTree arvoreDeMaterias;
	private JTextArea areaDeMaterias;
	/**
	 * Create the panel.
	 */
	public AdicionarMateriaPanel()  {
		super();
		areaDeMaterias = new JTextArea();
		areaDeMaterias.setLineWrap(true);
		areaDeMaterias.setEditable(false);
		setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(554, 162, 154, 192);
		add(scrollPane_1);
		setBackground(Personalizar.violeta);
		arvoreDeMaterias = new JTree();
		arvoreDeMaterias.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Paulo");
						node_1.add(new DefaultMutableTreeNode(""));
					add(node_1);
				}
			}
		));
		scrollPane_1.setViewportView(areaDeMaterias);
		JLabel lblMateriasDoObjetivo = new JLabel("Mat\u00E9rias do Objetivo");
		lblMateriasDoObjetivo.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblMateriasDoObjetivo.setBounds(554, 120, 154, 29);
		add(lblMateriasDoObjetivo);
	}
	
	public JTextArea getAreaDeMaterias() {
		return areaDeMaterias;
	}

	public void setAreaDeMaterias(JTextArea areaDeMaterias) {
		this.areaDeMaterias = areaDeMaterias;
	}

	public JTree getArvoreDeMaterias() {
		return arvoreDeMaterias;
	}
	public void setArvoreDeMaterias(JTree arvoreDeMaterias) {
		this.arvoreDeMaterias = arvoreDeMaterias;
	}
	
}
