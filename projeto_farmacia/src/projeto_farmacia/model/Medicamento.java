package projeto_farmacia.model;

public class Medicamento extends Produto {

	private int generico;

	public Medicamento(int id, String nome, int tipo, float preco, int generico) {
		super(id, nome, tipo, preco);
		this.generico = generico;

	}

	public int getGenerico() {
		return generico;
	}

	public void setGenerico(int generico) {
		this.generico = generico;
	}

	@Override
	public void visualizar() {
		super.visualizar();

		String gen = "";
		switch (this.generico) {
		case 1 -> {
			gen = "Sim";
			break;
		}
		case 2 -> {
			gen = "Não";
			break;
		}
		}
		System.out.println("Medicamento precisa de receita: " + gen);
	}

}
