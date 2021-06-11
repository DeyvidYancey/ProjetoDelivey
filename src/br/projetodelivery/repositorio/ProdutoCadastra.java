package br.projetodelivery.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.projetodelivery.entidade.Produto;

public class ProdutoCadastra {

	public ProdutoCadastra() {
	}

	Produto ca = new Produto();
	public static ArrayList<Produto> listaCardapio = new ArrayList<Produto>();

	private int menu() {

		System.out.println("==============================================");
		System.out.println(" MENU DE PRODUTO ");
		System.out.println("");
		System.out.println(" 1 - Cadastrar Produtos");
		System.out.println(" 2 - Listagem dos Produtos");
		System.out.println(" 3 - Deletar Produtos");
		System.out.println(" 4 - Alterar Produtos");
		System.out.println(" 0 - Sair");

		Scanner input = new Scanner(System.in);

		return input.nextInt();
	}

	public void menuCardapio() {
		Scanner input = new Scanner(System.in);

		int opcaoMenu = menu();

		while (opcaoMenu != 0) {
			switch (opcaoMenu) {
			case 1:
				System.out.println("Cadastro de produtos");
				System.out.println("");
				cadastraCardapio();
				break;
			case 2:
				listaDosCardapios();
				break;
			case 3:
				Scanner sc = new Scanner(System.in);
				System.out.println("==============================================");
				System.out.println("Digite o codigo do produto que deseja deletar:");
				opcaoMenu = sc.nextInt();
				deletarCardapio(opcaoMenu);

				break;
			case 4:

				System.out.println("Digite o codigo do produto que deseja alterar:");
				Scanner sc1 = new Scanner(System.in);
				opcaoMenu = sc1.nextInt();
				deletarCardapio(opcaoMenu);
				cadastraCardapio();
				break;
			default:
				System.out.println("Op��o inv�lida, tente novamente e com mais aten��o");
				break;
			}
			opcaoMenu = menu();
		}

	}

	

	int x;

	public void cadastraCardapio() {

		try {
			Produto c = new Produto();
			Scanner texto = new Scanner(System.in);

			System.out.println("==============================================");
			System.out.print("Digite o c�digo do produto: ");
			c.setCodigo(Integer.parseInt(texto.next()));
			texto.nextLine();
			System.out.print("Digite o nome do produto: ");
			c.setnomeCardapio(texto.nextLine());

			System.out.print("Digite o pre�o: ");
			c.setPreco(Double.parseDouble(texto.next()));

			listaCardapio.add(c);

			System.out.println("");
			System.out.println("Produto cadastrado com sucesso.");

		} catch (Exception e) {
			System.out.println("Erro ao salvar produto, por favor inserir um produto v�lido.");

		}
	}

	public Produto localizarCardapio(int codigo) {

		for (Produto cardapio : listaCardapio) {
			if (cardapio != null && cardapio.getCodigo() == (codigo)) {
				return cardapio;
			}
		}
		System.out.println("Produto n�o encontrado");
		return null;
	}

	public void listaDosCardapios() {
		try {
			if (listaCardapio.isEmpty())
				System.out.println("N�o h� produtos cadastrados");
			else
				for (Produto cardapio : listaCardapio) {
					System.out.println("==============================================");
					System.out.println("C�digo: " + cardapio.getCodigo());
					System.out.println("Card�pio: " + cardapio.getnomeCardapio());
					System.out.println("Pre�o: " + cardapio.getPreco());
					System.out.println("");
				}
		} catch (Exception e) {
			System.out.println("Erro ao Listar produtos");
		}
	}

	public void deletarCardapio(int codigo) {
		try {
			for (Produto cardapio : listaCardapio) {

				if (cardapio.getCodigo() == codigo) {
					listaCardapio.remove(cardapio);
			
				}else {
					System.out.println("C�digo de produto n�o encontrado");
				}
			}

		} catch (Exception e) {
			System.out.println("");
			System.out.println("==============================================");
		}
	}

	public void alterarCardapio(Produto cardapio) {
		try {
			for (Produto cardapio1 : listaCardapio) {

				if (cardapio1.getCodigo() == cardapio.getCodigo()) {

					listaCardapio.remove(cardapio);
					listaCardapio.add(cardapio);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao alterar produto");
		}
	}


	public boolean verificarCodigo() {
		Produto d = new Produto();
		if (ca.getCodigo() == x) {
			System.out.println("Esse c�digo ja esta sendo utilizado");
			return true;
		} else {
			return false;
		}
	}
}
