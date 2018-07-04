package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomePanel extends JPanel{
	private LoginPanel loginPanel;
	private CadastroPanel cadastroPanel;
	
	public HomePanel() {
		setSize(800,600);
		this.loginPanel = new LoginPanel();
		this.cadastroPanel = new CadastroPanel();
		add(loginPanel,BorderLayout.NORTH);
		add(cadastroPanel,BorderLayout.SOUTH);
	}
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public CadastroPanel getCadastroPanel() {
		return cadastroPanel;
	}

	public void setCadastroPanel(CadastroPanel cadastroPanel) {
		this.cadastroPanel = cadastroPanel;
	}
}
