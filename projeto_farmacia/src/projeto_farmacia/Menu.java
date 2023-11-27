package projeto_farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_farmacia.controller.Controller;
import projeto_farmacia.model.Cosmetico;
import projeto_farmacia.model.Medicamento;
import projeto_farmacia.model.Produto;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		Controller produto = new Controller();

		int opcao, tipo, generico, id;
		String nome, frag;
		float preco;

		while (true) {
			System.out.println("Bem vindo a FarmaFloat! Escolha a opção desejada: ");
			System.out.println("1. Crie um produto novo");
			System.out.println("2. Liste todos os produtos");
			System.out.println("3. Consulte um produto pelo ID");
			System.out.println("4. Atualizar um produto");
			System.out.println("5. Deletar um produto");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 5;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Cadastre um novo produto.");
				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R"); // Tks Matheus!!!
				nome = leia.nextLine();

				System.out.println("Digite o tipo do produto 1-MEDICAMENTO ou 2-COSMÉTICO: ");
				tipo = leia.nextInt();

				System.out.println("Digite o preço de venda do produto: ");
				preco = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("O medicamento é genérico? Digite 1 PARA SIM e 2 PARA NÃO.");
					generico = leia.nextInt();
					leia.skip("\\R");
					produto.cadastrar(new Medicamento(produto.gerarNumero(), nome, tipo, preco, generico));
					break;
				}
				case 2 -> {
					System.out.println("Especifique o tipo de fragrância do produto: ");
					leia.skip("\\R");
					frag = leia.nextLine();
					produto.cadastrar(new Cosmetico(produto.gerarNumero(), nome, tipo, preco, frag));
					break;
				}
				}

				keyPress();
				break;
			}
			case 2 -> {
				System.out.println("Aqui está a lista de produtos disponíveis atualmente: ");
				produto.listarTodos();
				keyPress();
				break;
			}
			case 3 -> {
				System.out.println("Consulte aqui um produto: ");
				System.out.println("Digite o ID do produto procurado: ");
				id = leia.nextInt();
				produto.consultarPorId(id);

				keyPress();
				break;
			}
			case 4 -> {
				System.out.println("Atualize um produto");
				System.out.println("Digite o ID do produto que será atualizado: ");
				id = leia.nextInt();

				Optional<Produto> produtos = produto.buscarNaCollection(id);

				if (produtos.isPresent()) {
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();

					System.out.println("Digite o tipo do produto 1-MEDICAMENTO ou 2-COSMÉTICO: ");
					tipo = leia.nextInt();

					System.out.println("Digite o preço de venda do produto: ");
					preco = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("O medicamento é genérico? Digite 1 PARA SIM e 2 PARA NÃO.");
						generico = leia.nextInt();
						leia.skip("\\R");
						produto.cadastrar(new Medicamento(produto.gerarNumero(), nome, tipo, preco, generico));
						break;
					}
					case 2 -> {
						System.out.println("Especifique o tipo de fragrância do produto: ");
						leia.skip("\\R");
						frag = leia.nextLine();
						produto.cadastrar(new Cosmetico(produto.gerarNumero(), nome, tipo, preco, frag));
						break;
					}
					}
				} else
					System.out.println("Produto não encontrado.");

				keyPress();
				break;
			}
			case 5 -> {
				System.out.println("Deletar um produto.");
				System.out.println("Digite o ID do produto que será deletado: ");
				id = leia.nextInt();
				produto.deletar(id);
				System.out.println("Produto deletado!");
			}
			default -> {
				System.out.println("\nOpção Inválida!");
				keyPress();
				break;
			}
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\n\n **** Pressione a tecla Enter para continuar ****");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Tecla inválida. Pressione a tecla Enter para continuar.");
		}
	}
}
