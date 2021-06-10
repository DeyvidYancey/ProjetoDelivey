package br.projetodelivery.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.projetodelivery.entidade.Pedido;
import br.projetodelivery.entidade.Venda;

public class VendaCadastra {
	
	
	public static ArrayList<Venda> listaVendas = new ArrayList<Venda>();

	public VendaCadastra() {}
	
	private int menu() {

		System.out.println("==============================================");
		System.out.println(" MENU DE VENDAS ");
		System.out.println(" 1 - Listagem das vendas");
		System.out.println(" 0 - Sair");
		System.out.println("");
		Scanner input = new Scanner(System.in);

		return input.nextInt();
	}
	
	public void menuVendas() {
		Scanner input = new Scanner(System.in);

		int opcaoMenu = menu();

		while (opcaoMenu != 0) {
			switch (opcaoMenu) {
			case 1:
				listagemVendas();
				break;
			    case 2:
			    	Scanner sc = new Scanner(System.in);
					System.out.println("==============================================");
					System.out.println("Digite o codigo do produto que deseja deletar:");
					opcaoMenu=sc.nextInt();
					deletarVenda(opcaoMenu);
				break;
				
			default:
				System.out.println("Opção inválida, tente novamente e com mais atenção");
				break;
			}
			opcaoMenu = menu();
		}

	}
	
	public void cadastraVenda(String cardapio, String cliente, double valor ) {

	
		
		Venda venda = new Venda(cardapio, cliente, valor);
		listaVendas.add(venda);
					
	}
	
	public static void listagemVendas() {
		if (listaVendas.isEmpty())
			System.out.println("Não há vendas cadastradas");
		else
			for (Venda vendas : listaVendas) {
				System.out.println("==============================================");
				System.out.println("Cliente: " + vendas.getCliente());
				System.out.println("Produto: " + vendas.getCardapio());
				System.out.println("Preço: " + vendas.getValor());
				System.out.println("");
			}
	}
public void deletarVenda(int codigo) {
		
		
		for (Venda venda : listaVendas) {
			
			if (venda.getCodigo()==codigo) {
				listaVendas.remove(venda);
			}
		}
}
public void alterarVenda(Venda venda) {
	
    for (Venda venda1 : listaVendas) {
			
			if (venda1.getValor()==venda.getValor()) {
				
				listaVendas.remove(venda);
				listaVendas.add(venda);
			}
		}
}
}