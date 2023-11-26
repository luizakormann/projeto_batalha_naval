package projeto_farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_farmacia.model.Medicamento;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		Medicamento m1 = new Medicamento(1, "Dipirona", 1, 14.90f, 2);
		// teste medicamento
		m1.visualizar();

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
			case 5 -> {
				leia.close();
				System.exit(5);
			}
			case 1 -> {
				System.out.println("Crie um novo produto.");
				break;
			}
			case 2 -> {
				System.out.println("Aqui está a lista de produtos: ");
				break;
			}
			case 3 -> {
				System.out.println("Consulte aqui um produto: ");
				break;
			}
			case 4 -> {
				System.out.println("Atualize um produto");
				break;
			}
			default -> {
				System.out.println("\nOpção Inválida!");
				break;
			}
			}
		}
	}
}
