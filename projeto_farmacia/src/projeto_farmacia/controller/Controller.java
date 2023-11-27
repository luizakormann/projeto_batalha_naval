package projeto_farmacia.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_farmacia.model.Produto;
import projeto_farmacia.repository.Repository;

public class Controller implements Repository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	int id = 0;

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso!");

	}

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}

	}

	@Override
	public void consultarPorId(int id) {

		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			produto.get().visualizar();
		} else
			System.out.println("Produto não encontrado!");
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscarProduto = buscarNaCollection(produto.getId());
		if (buscarProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscarProduto.get()), produto);
			System.out.println("O produto com ID " + produto.getId() + "foi atualizado com sucesso!");
		} else
			System.out.println("O produto com ID " + produto.getId() + "não foi encontrado.");
	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		if (produto.isPresent()) {
			listaProdutos.remove(produto.get());
			System.out.println("O produto " + produto.get().getNome() + " foi deletado com sucesso.");
		} else
			System.out.println("O produto " + produto.get().getNome() + " não foi encontrado.");

	}
// Métodos auxiliares

	public int gerarNumero() {
		return ++id;
	}
	
	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return Optional.of(produto);
			}
		}
		return Optional.empty();
	}

}
