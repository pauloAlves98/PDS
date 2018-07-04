package controller;

import java.awt.event.ActionEvent;

import view.AbstractPanelManipular;
import view.TelasManipulacao;

public class AbstractPanelManipularController {
	AbstractPanelManipular telaManipularMaterial;
	AbstractPanelManipular telaManipularTopico;

	public AbstractPanelManipularController(AbstractPanelManipular telaManipularMaterial,AbstractPanelManipular telaManipularTopico) {
		this.telaManipularTopico = telaManipularTopico;
		
		// manipulando mudancas de telas contindas em funcionalidades de manipulacao de dados(meterial,topicos)
		
		// tratando eventos para tela manipularMaterial
		telaManipularTopico.getFuncionalidadesPanel().getEditarButton().addActionListener
		((ActionEvent e) -> telaManipularTopico.mudarManipularPanel(TelasManipulacao.EDITAR));
		
		telaManipularTopico.getFuncionalidadesPanel().getAdicionarButton().addActionListener
		((ActionEvent e) -> telaManipularTopico.mudarManipularPanel(TelasManipulacao.ADICIONAR));
		
		telaManipularTopico.getFuncionalidadesPanel().getRemoverButton().addActionListener((ActionEvent e)-> System.out.println("exluir precionado"));
		
		// tratando eventos para tela manipularMaterial
		telaManipularMaterial.getFuncionalidadesPanel().getEditarButton().addActionListener
		((ActionEvent e) -> telaManipularMaterial.mudarManipularPanel(TelasManipulacao.EDITAR));
		
		telaManipularMaterial.getFuncionalidadesPanel().getAdicionarButton().addActionListener
		((ActionEvent e) -> telaManipularMaterial.mudarManipularPanel(TelasManipulacao.ADICIONAR));
		
		telaManipularMaterial.getFuncionalidadesPanel().getRemoverButton().addActionListener((ActionEvent e)-> System.out.println("exluir precionado"));
	}
	
	
	
}
