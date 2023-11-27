package projeto_farmacia.repository;

import projeto_farmacia.model.Produto;

public interface Repository {

	// Implementação CRUD
	public void cadastrar(Produto produto);
	public void listarTodos();
	public void consultarPorId(int id);
	public void atualizar(Produto produto);
	public void deletar(int id);
	
}
