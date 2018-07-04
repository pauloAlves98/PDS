package view;

public enum TelasManipulacao {
	EDITAR("EDITAR"),ADICIONAR("ADICIONAR"),
	ADICIONAR_MATERIA("adicionarMateriaPanel"),EDITAR_MATERIA("editarMateriaPanel"),
	VISUALIZAR_MATERIA("visualizarMateriaPanel");
	
	String value;
	private TelasManipulacao(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
