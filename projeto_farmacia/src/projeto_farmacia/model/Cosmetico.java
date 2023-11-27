package projeto_farmacia.model;

public class Cosmetico extends Produto {

	private String frag;

	public Cosmetico(int id, String nome, int tipo, float preco, String frag) {
		super(id, nome, tipo, preco);
		this.frag = frag;
	}

	public String getFrag() {
		return frag;
	}

	public void setFrag(String frag) {
		this.frag = frag;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Fragância: " + this.frag);
	}
}
