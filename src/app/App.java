package app;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.AbaObjetivosPanelController;
import controller.ControllerAbaPerfilPanel;
import controller.ControllerCadastro;
import controller.ControllerLoginPanel;
import model.BaseDados;
import view.TelaPrincipal;

public class App {

	public static void main(String[] args) {
		
		BaseDados baseDados = BaseDados.getInstance();
		
		new ControllerLoginPanel(TelaPrincipal.getInstance().getHomePanel().getLoginPanel(), baseDados);
		new ControllerCadastro(TelaPrincipal.getInstance().getHomePanel().getCadastroPanel(),baseDados);
		new ControllerAbaPerfilPanel(TelaPrincipal.getInstance().getFuncionalidadesPanel().getAbaPerfilPanel());
		//o array objetivos info vai ficar em objetivos panel
		AbaObjetivosPanelController objetivosPanelController = new AbaObjetivosPanelController(TelaPrincipal.getInstance().getFuncionalidadesPanel().getAbaObjetivosPanel());
	}
	public static void lookPadrao(){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}

	}
	public static void lookWindows(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}
	}
	public static void lookNoire(){
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}
	}
	public static void lookNimbus(){
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					    if ("Nimbus".equals(info.getName())) {
					        UIManager.setLookAndFeel(info.getClassName());
					        break;
					    }
					}
					} catch (Exception e) {
					   // If Nimbus is not available, you can set the GUI to another look and feel.
					}
	}
}
