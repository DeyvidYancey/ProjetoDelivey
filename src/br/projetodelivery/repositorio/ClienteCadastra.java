package br.projetodelivery.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.projetodelivery.entidade.Cliente;
import br.projetodelivery.entidade.Produto;
import br.projetodelivery.entidade.Venda;

public class ClienteCadastra {

	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteCadastra() {

	}

	private int menu() {
		System.out.println("==============================================");
		System.out.println(" MENU DE CLIENTES ");
		System.out.println("");
		System.out.println(" 1 - Cadastrar clientes");
		System.out.println(" 2 - Listagem dos clientes");
		System.out.println(" 3 - Deletar Clientes");
		System.out.println(" 4 - Alterar Clientes");
		System.out.println(" 0 - Sair");

		Scanner input = new Scanner(System.in);

		return input.nextInt();
	}

	public void menuCliente() {
		Scanner input = new Scanner(System.in);

		int opcaoMenu = menu();

		while (opcaoMenu != 0) {
			switch (opcaoMenu) {
			case 1:
				System.out.println("Cadastro de clientes");
				System.out.println("");
				cadastraClientes();
				break;
			case 2:
				System.out.print("Clientes cadastrados: ");
				System.out.println("");
				System.out.print("");
				listaDosClientes();
				break;
			case 3:
				Scanner sc = new Scanner(System.in);
				System.out.println("==============================================");
				System.out.println("Digite o codigo do cliente que deseja deletar:");
				opcaoMenu = sc.nextInt();
				deletarCliente(opcaoMenu);
				break;
			case 4:
				System.out.println("Digite o codigo do cliente que deseja alterar:");
				Scanner sc1 = new Scanner(System.in);
				opcaoMenu = sc1.nextInt();
				deletarCliente(opcaoMenu);
				cadastraClientes();
				break;
			default:
				System.out.println("Opção inválida, tente novamente e com mais atenção");
				break;
			}
			opcaoMenu = menu();
		}

	}

	public static void cadastraClientes() {
		try {
			Cliente c = new Cliente();

			Scanner texto = new Scanner(System.in);
			System.out.println("==============================================");
			System.out.print("Digite seu código: ");
			c.setCodigo(texto.nextInt());
			texto.nextLine();
			System.out.print("Digite seu nome: ");
			c.setNome(texto.nextLine());

			System.out.println("");
			System.out.print("Digite seu login: ");
			c.setLogin(texto.nextLine());

			System.out.print("Digite uma senha: ");
			c.setSenha(texto.nextLine());

			System.out.print("Digite seu endereço para entrega: ");
			c.setEndereco(texto.nextLine());

			listaClientes.add(c);

			System.out.println("");
			System.out.println("Cadastro do cliente realizado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar clientes, por favor cadastre informações válidas.");
		}

	}

	public static void listaDosClientes() {
		try {
			if (listaClientes.isEmpty()) {
				System.out.println("==============================================");
				System.out.println("Não há clientes cadastrados");
			} else
				System.out.println("");
			for (Cliente cliente : listaClientes) {
				System.out.println("==============================================");
				System.out.println("Código: " + cliente.getCodigo());
				System.out.println("Cliente: " + cliente.getNome());
				System.out.println("Login: " + cliente.getLogin());
				System.out.println("Endereco: " + cliente.getEndereco());
				System.out.println("");

			}
		} catch (Exception e) {
			System.out.println("==============================================");
			System.out.println("Erro ao listar Clientes");
		}

	}

	public Cliente localizarCliente(String login) {
		try {
			Scanner input = new Scanner(System.in);

			for (Cliente cliente : listaClientes) {
				if (cliente != null && cliente.getLogin().equalsIgnoreCase(login)) {

					System.out.print("Digite a senha: ");
					String comparaSenha = input.next();

					if (comparaSenha.equals(cliente.getSenha())) {

						return cliente;
					} else {
						
						System.out.println("Senha incorreta!");
					}

				} else
			
					System.out.println("Login inválido, por favor escreva um login válido");
			}

		} catch (Exception e) {
			System.out.println("Erro ao localizar clientes");
		}
		return null;
	}

	public void deletarCliente(int codigo) {
		try {
			for (Cliente cliente : listaClientes) {

				if (cliente.getCodigo() == codigo) {
					listaClientes.remove(cliente);
					
				}else {
					System.out.println("Código de cliente não encontrado");
				}
			}
		} catch (Exception e) {
			System.out.println("");
			System.out.println("==============================================");
		}

	}

	public void alterarCliente(Cliente cliente) {
		try {
			for (Cliente cliente1 : listaClientes) {

				if (cliente1.getNome() == cliente.getNome()) {

					listaClientes.remove(cliente);
					listaClientes.add(cliente);
				}
			}
		} catch (Exception e) {
			System.out.println("==========================================");
		}

	}
	
	}
