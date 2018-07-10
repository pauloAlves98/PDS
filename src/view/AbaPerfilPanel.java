package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import app.App;
import model.Personalizar;


@SuppressWarnings("serial")
public class AbaPerfilPanel extends JPanel{
	private PerfilPanel perfilPanel;
	private EditarPerfilPanel editarPerfilPanel;
	private CardLayout cardLayout;//tirar daqui e colocar na aba Objetivo
	private EditarMaterialPanel editarMaterialPanel;//temporario
	public AbaPerfilPanel() {
		 perfilPanel = new PerfilPanel();
		 editarPerfilPanel = new EditarPerfilPanel();
		 cardLayout = new CardLayout();
		 editarMaterialPanel = new EditarMaterialPanel();
		 setLayout(cardLayout);
		 App.lookWindows();
		 add(perfilPanel);
		 add(editarPerfilPanel);
		 App.lookPadrao();
		 perfilPanel.setSize(800,550);
		 perfilPanel.setBackground(Personalizar.roxoClaro);
		 editarPerfilPanel.setSize(800,550);
		
		 cardLayout.addLayoutComponent(perfilPanel,"perfilPanel");
		 cardLayout.addLayoutComponent(editarPerfilPanel,"editarPerfilPanel");
		
		 
		 cardLayout.show(this,"perfilPanel");
		 setBackground(Personalizar.roxoClaro);
	}
	
	
	public EditarMaterialPanel getEditarMaterialPanel() {
		return editarMaterialPanel;
	}


	public void setEditarMaterialPanel(EditarMaterialPanel editarMaterialPanel) {
		this.editarMaterialPanel = editarMaterialPanel;
	}


	public void setEditarPerfilPanel(EditarPerfilPanel editarPerfilPanel) {
		this.editarPerfilPanel = editarPerfilPanel;
	}

	public PerfilPanel getPerfilPanel() {
		return perfilPanel;
	}

	public EditarPerfilPanel getEditarPerfilPanel() {
		return editarPerfilPanel;
	}
	/**
	 * 
	 * @param nomePanel nome de panel para ser trocado perfilPanel vai pro perfil inicial, e editarPerfilPanel vai pra tela de configurações
	 */
	public void mudarPanel(String nomePanel) {
		cardLayout.show(this,nomePanel);
	}
	
	@SuppressWarnings("serial")
	public class PerfilPanel extends JPanel{
		
		private JLabel nomeLabel,fotoPerfilLabel;
		private JProgressBar objetivoProgress;
		private Font nomeLabelFont ;
		private JButton editarPerfilButton,excluirPerfilButton,visualizarMaterialButton,
		cadastrarMaterialButton,editarMaterialButton;//quando criar a aba objetivo esta butão ficara lá
		
		
		public PerfilPanel() {
			
			nomeLabel = new JLabel("NOME COMPLETO");
			fotoPerfilLabel = new JLabel();
			editarPerfilButton = new JButton("EDITAR PERFIL");
			excluirPerfilButton = new JButton("EXCLUIR PERFIL");
			objetivoProgress = new JProgressBar();
			nomeLabelFont   = new Font("serif",Font.BOLD,30);
			cadastrarMaterialButton = new JButton("INSERIR MATERIAL");
			editarMaterialButton = new JButton("EDITAR MATERIAL");
			visualizarMaterialButton = new JButton("VER MATERIAL");
			nomeLabel.setFont(nomeLabelFont);
			
			setLayout(null);
			
			add(editarPerfilButton);
			add(excluirPerfilButton);
			//add(cadastrarMaterialButton);
		    //add(editarMaterialButton);
		   // add(visualizarMaterialButton);
			add(nomeLabel);
			add(objetivoProgress);
			add(fotoPerfilLabel);
			// perfumaria
			JSeparator js = new JSeparator(JSeparator.VERTICAL);
			js.setBackground(Color.black);
			add(js);
			js.setBounds(250,10,10,530);
			
			fotoPerfilLabel.setBorder(new LineBorder(Color.red));
			fotoPerfilLabel.setBounds(50,50,150,150);
			nomeLabel.setBounds(282,75,400,34);
			objetivoProgress.setBounds(50,210,150,20);
			editarPerfilButton.setBounds(55,245,140,20);//15
			excluirPerfilButton.setBounds(55,270,140,20);//5 a distancia entre botoes
			cadastrarMaterialButton.setBounds(55,295,140,20);
			editarMaterialButton.setBounds(55,320,140,20);
			visualizarMaterialButton.setBounds(55,345,140,20);
		}
		
		public JButton getCadastrarMaterialButton() {
			return cadastrarMaterialButton;
		}

		public void setCadastrarMaterialButton(JButton cadastrarMaterialButton) {
			this.cadastrarMaterialButton = cadastrarMaterialButton;
		}

		public JButton getEditarMaterialButton() {
			return editarMaterialButton;
		}

		public void setEditarMaterialButton(JButton editarMaterialButton) {
			this.editarMaterialButton = editarMaterialButton;
		}

		public void setEditarPerfilButton(JButton editarPerfilButton) {
			this.editarPerfilButton = editarPerfilButton;
		}

		public JButton getExcluirPerfilButton() {
			return excluirPerfilButton;
		}

		public void setExcluirPerfilButton(JButton excluirPerfilButton) {
			this.excluirPerfilButton = excluirPerfilButton;
		}

		public JLabel getNomeLabel() {
			return nomeLabel;
		}
	
	
		public JLabel getFotoPerfilLabel() {
			return fotoPerfilLabel;
		}
	
	
		public JProgressBar getObjetivoProgress() {
			return objetivoProgress;
		}
	
	
		public Font getNomeLabelFont() {
			return nomeLabelFont;
		}
	
	
		public void setNomeLabelFont(Font nomeLabelFont) {
			this.nomeLabelFont = nomeLabelFont;
		}
	
		public JButton getEditarPerfilButton() {
			return editarPerfilButton;
		}
	
	
	}
	
	public class EditarPerfilPanel extends JPanel{
		private OpcoesPanel opcoesPanel;
		private JPanel formularioEdicaoPanel ; // Panel para entrada de dados de edição de respectivas configurações selecionadas em um dos botões
		private FormularioConfigPerfilPanel formularioConfigPerfilPanel;
		private FormularioConfigContaPanel formularioConfigContaPanel;
		private CardLayout cardLayout;
		
		public EditarPerfilPanel() {
			setLayout(null);
			opcoesPanel = new OpcoesPanel();
			formularioEdicaoPanel = new JPanel();
			cardLayout = new CardLayout();
			formularioConfigContaPanel = new FormularioConfigContaPanel();
			formularioConfigPerfilPanel = new FormularioConfigPerfilPanel();
	
			formularioEdicaoPanel.setLayout(cardLayout);	
			//setBackground(Personalizar.roxoEscuro);
			
			formularioEdicaoPanel.add(formularioConfigPerfilPanel);
			formularioEdicaoPanel.add(formularioConfigContaPanel);
			
			cardLayout.addLayoutComponent(formularioConfigPerfilPanel,"formularioConfigPerfilPanel");
			cardLayout.addLayoutComponent(formularioConfigContaPanel,"formularioConfigContaPanel");
			add(opcoesPanel);
			add(formularioEdicaoPanel);
			
			opcoesPanel.setBounds(0,0,250,550);
			formularioEdicaoPanel.setBounds(260,0,540,550);
			
		}
		
		/**
		 * 
		 * @param nomePanel String formularioConfigPerfilPanel muda a o panel formulario para o correspondente 
		 * como também o formularioConfigContaPanel que mostra na tela o formulario para edidição de dados 
		 * da conta 
		 */
		public void mudarPanel(String nomePanel) {
			cardLayout.show(formularioEdicaoPanel,nomePanel);
		}
		
		
		public OpcoesPanel getOpcoesPanel() {
			return opcoesPanel;
		}
		public FormularioConfigPerfilPanel getFormularioConfigPerfilPanel() {
			return formularioConfigPerfilPanel;
		}
		public FormularioConfigContaPanel getFormularioConfigContaPanel() {
			return formularioConfigContaPanel;
		}

		/**
		 * Panel com botões e descrição(opções de configuração), a classe tem como função mudar o panel de formulario atravez de um cardLayout
		 * @author
		 *
		 */
		public class OpcoesPanel extends JPanel{
			
			private JLabel configuracoesLabel;
			private JButton perfilButton,contaButton;
			private JPanel internoPanel;
			
			public OpcoesPanel() {
				setLayout(null);
				setBackground(Personalizar.roxoClaro);
				// instanciando componentes
				configuracoesLabel = new JLabel("Configurações");
				configuracoesLabel.setFont(Personalizar.agency19);
				configuracoesLabel.setForeground(Color.white);
				perfilButton = new JButton("Perfil");
				contaButton = new JButton("Conta");
				internoPanel = new JPanel(null);	
				internoPanel.setBackground(Personalizar.roxoMedio);
				
				//adicionando botões e descrição a grid
				
				internoPanel.add(configuracoesLabel);
				internoPanel.add(perfilButton);
				internoPanel.add(contaButton);
				internoPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
				
				configuracoesLabel.setBounds(10,15,150,20);
				perfilButton.setBounds(10,40,150,20);
				contaButton.setBounds(10,66,150,20);
				
				add(internoPanel);
				
				internoPanel.setBounds(40,75,170,350);
				
				
			}
	
			public JButton getContaButton() {
				return contaButton;
			}

			public JButton getPerfilButton() {
				return perfilButton;
			}
	
		}
		public class FormularioConfigPerfilPanel extends FormularioCadastro{
			private JLabel editarLabel;
			private JButton voltarButton,confirmarButton;
			
			public FormularioConfigPerfilPanel() {
				
				setLayout(null);
				setBackground(Personalizar.roxoClaro);
				editarLabel = new JLabel("Editar dados de Perfil");
				voltarButton = new JButton("Voltar");
				confirmarButton = new JButton("Confirmar");
				
				
				add(editarLabel);
				editarLabel.setFont(Personalizar.agency30);
				
				add(nomeLabel);
				add(sobrenomeLabel);
				add(sexoLabel);
				add(cpf);
				
				add(nomeField);
				add(sobrenomeField);
				add(cpfField);
				add(sexoBox);
				
				add(voltarButton);
				add(confirmarButton);
				
				editarLabel.setBounds(40,90,250,24);
				
				nomeLabel.setBounds(110,156,50,13);
				sobrenomeLabel.setBounds(82,192,100,13);
				sexoLabel.setBounds(113,226,50,13);
				cpf.setBounds(117,260,50,13);
				
				nomeField.setBounds(160,150,180,25);
				sobrenomeField.setBounds(160,186,180,25);
				sexoBox.setBounds(160,220,180,25);
				cpfField.setBounds(160,255,180,25);
				
				voltarButton.setBounds(290,500,100,25);
				confirmarButton.setBounds(400,500,100,25);
			}
	
			public JButton getVoltarButton() {
				return voltarButton;
			}
	
			public JButton getConfirmarButton() {
				return confirmarButton;
			}
			
			
		}
		
		public class FormularioConfigContaPanel extends JPanel{
			private JTextField loginField;
			private JLabel mudarLoginLabel,loginLabel,mudarSenhaLabel,senhaAtualLabel,confirmarSenhaLabel,novaSenhaLabel;
			private JPasswordField senhaAtualField,novaSenhaField,confirmarSenhaField;
			private JButton voltarButton,confirmarLoginButton,confirmarSenhaButton;
			
			public FormularioConfigContaPanel() {
				super(null);
				setBackground(Personalizar.roxoClaro);
				mudarLoginLabel = new JLabel("Mudar Login");
				mudarSenhaLabel = new JLabel("Mudar Senha");
				
				mudarLoginLabel.setFont(Personalizar.agency30);
				mudarSenhaLabel.setFont(Personalizar.agency30);
				
				loginLabel = new JLabel("Novo Login");
				loginField = new JTextField();
				confirmarLoginButton = new JButton("Confirmar");
				
				senhaAtualLabel = new JLabel("Senha Atual");
				novaSenhaLabel = new JLabel("Nova Senha");
				confirmarSenhaLabel = new JLabel("Confirmar Senha");
				senhaAtualField = new JPasswordField();
				novaSenhaField = new JPasswordField();
				confirmarSenhaField = new JPasswordField();
				confirmarSenhaButton = new JButton("Confirmar");
			
				voltarButton = new JButton("Voltar");
				
				// campos para edilçao de login
				add(mudarLoginLabel);
				add(loginLabel);
				add(loginField);
				add(confirmarLoginButton);
				
				// campos para edição de senha
				add(mudarSenhaLabel);
				add(senhaAtualLabel);
				add(senhaAtualField);
				add(novaSenhaLabel);
				add(novaSenhaField);
				add(confirmarSenhaLabel);
				add(confirmarSenhaField);
				add(confirmarSenhaButton);
				
				add(voltarButton);
				
				mudarLoginLabel.setBounds(40,70,200,50);
				loginLabel.setBounds(75,162,100,13);
				loginField.setBounds(150,156,180,25);
				confirmarLoginButton.setBounds(230,190,100,25);
				
				mudarSenhaLabel.setBounds(40,230,200,50);
				senhaAtualLabel.setBounds(73,293,100,13);
				novaSenhaLabel.setBounds(75,326,100,13);
				confirmarSenhaLabel.setBounds(47,362,100,13);
				senhaAtualField.setBounds(150,285,180,25);
				novaSenhaField.setBounds(150,321,180,25);
				confirmarSenhaField.setBounds(150,357,180,25);
				confirmarSenhaButton.setBounds(230,390,100,25);
	
				voltarButton.setBounds(400,500,100,25);
			}
	
			public JButton getVoltarButton() {
				return voltarButton;
			}

			public JTextField getLoginField() {
				return loginField;
			}

			public JPasswordField getSenhaAtualField() {
				return senhaAtualField;
			}

			public JPasswordField getNovaSenhaField() {
				return novaSenhaField;
			}

			public JPasswordField getConfirmarSenhaField() {
				return confirmarSenhaField;
			}

			public JButton getConfirmarLoginButton() {
				return confirmarLoginButton;
			}

			public JButton getConfirmarSenhaButton() {
				return confirmarSenhaButton;
			}
			
			
		}
		
	}
	
}
