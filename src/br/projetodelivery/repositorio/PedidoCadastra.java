package br.projetodelivery.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.projetodelivery.entidade.Produto;
import br.projetodelivery.entidade.Cliente;
import br.projetodelivery.entidade.Pedido;
import br.projetodelivery.entidade.Venda;

public class PedidoCadastra {

	public ClienteCadastra cliente;
	public ProdutoCadastra cardapio;
	public Produto valor;

	public ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

	public PedidoCadastra(ClienteCadastra cliente, ProdutoCadastra cardapio, Produto valor) {
		super();
		this.cliente = cliente;
		this.cardapio = cardapio;
		this.valor = valor;
	}

	public PedidoCadastra() {
	}

	private int menu() {
		System.out.println("==============================================");
		System.out.println(" MENU DE PEDIDO ");
		System.out.println("");
		System.out.println(" 1 - Fazer um pedido");
		System.out.println(" 2 - Listagem dos pedidos");
		System.out.println(" 0 - Sair");
		System.out.println("");
		Scanner input = new Scanner(System.in);

		return input.nextInt();
	}

	public void menuPedido() {
		Scanner input = new Scanner(System.in);

		int opcaoMenu = menu();

		while (opcaoMenu != 0) {
			switch (opcaoMenu) {
			case 1:
				System.out.println("Fazer pedido");
				System.out.println("");
				realizarPedido();
				break;
			case 2:
				listaDosPedidos();
				break;
			//case 3:
				//Scanner sc = new Scanner(System.in);
				//System.out.println("Digite o numero do pedido que deseja deletar:");
				//opcaoMenu = sc.nextInt();
				//deletarPedido(opcaoMenu);
				//break;
			default:
				System.out.println("Opção inválida, tente novamente e com mais atenção");
				break;
			}
			opcaoMenu = menu();
		}

	}

	public void realizarPedido() {
		try {
			VendaCadastra venda = new VendaCadastra();
			Pedido pedido = new Pedido();
			ClienteCadastra cliente = new ClienteCadastra();
			ProdutoCadastra cardapio = new ProdutoCadastra();
			Scanner input = new Scanner(System.in);
			Pedido pe = new Pedido();
			System.out.println("==============================================");
			System.out.print("Senhor cliente, informe seu login: ");
			pedido.setCliente(cliente.localizarCliente(input.next()));
			
	


if (pedido.getCliente() != null) {

				cardapio.listaDosCardapios();

				if (!cardapio.listaCardapio.isEmpty()) {
                   
					int codigoPedido;
                    Scanner cs = new Scanner (System.in);
                    System.out.println("==============================================");
					
                  // System.out.println("Digite um código para marcar seu Pedido");
                    //pedido.setCodigo(cs.nextInt());
                    
					System.out.print("Infome o código do produto: ");
 
					pedido.setCardapio(cardapio.localizarCardapio(Integer.parseInt(input.next())));
					pedido.setValorPedido(pedido.getCardapio().getPreco());
					
                  
                    
					listaPedido.add(pedido);
					venda.cadastraVenda(pedido.getCardapio().getnomeCardapio(), pedido.getCliente().getNome(),
							pedido.getValorPedido());
					System.out.println("==============================================");
					System.out.println("Pedido realizado com sucesso.");

					System.out.println("Cliente: " + pedido.getCliente().getNome());
					System.out.println("Cardápio: " + pedido.getCardapio().getnomeCardapio());
					System.out.println("Valor: " + pedido.getValorPedido());
					System.out.println("Endereço de entrega: " + pedido.getCliente().getEndereco());
                  
				
					System.out.println("");

				}
			}
		} catch (Exception e) {
			System.out.println("pedido Inválido, por favor informe um pedido válido");
		}

	}

	public void listaDosPedidos() {
		if (listaPedido.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		} else
			System.out.println("");
		for (Pedido pedido : listaPedido) {
          //  System.out.println("Codigo de marcação:"+ pedido.getCodigo());
			System.out.println("Nome do cliente: " + pedido.getCliente().getNome());
			System.out.println("Cardápio: " + pedido.getCardapio().getnomeCardapio());
			System.out.println("Valor do pedido: " + pedido.getValorPedido());
			System.out.println("");
		
		}
		
	}

	public void deletarPedido(int codigoPedido) {

		for (Pedido pedido : listaPedido) {

			if (pedido.getCodigo() == codigoPedido) {
				
				
				pedido.setCliente1("");
				
				
				pedido.setCodigo(0);
				pedido.setValorPedido(0);
				
			}
		}

	}


	public void alterarPedido(Pedido pedido) {

		for (Pedido pedido1 : listaPedido) {

			if (pedido1.getNumeroPedido() == pedido.getNumeroPedido()) {

				listaPedido.remove(pedido);
				listaPedido.add(pedido);
			}
		}
	}
}
