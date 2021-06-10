package br.projetodelivery.entidade;

public class Pedido {
	private int codigo;
	private int numeroPedido;
	private Cliente cliente;
	private Produto cardapio;
	private double valorPedido;
    private String cliente1;
    private String cardapio1;
    
	public Pedido() {}

	

	public String getCliente1() {
		return cliente1;
	}



	public void setCliente1(String cliente1) {
		this.cliente1 = cliente1;
	}



	public String getCardapio1() {
		return cardapio1;
	}



	public void setCardapio1(String cardapio1) {
		this.cardapio1 = cardapio1;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public Pedido(int codigo, int numeroPedido, Cliente cliente, Produto cardapio, double valorPedido) {
		super();
		this.codigo = codigo;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.cardapio = cardapio;
		this.valorPedido = valorPedido;
	}



	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getCardapio() {
		return cardapio;
	}

	public void setCardapio(Produto cardapio) {
		this.cardapio = cardapio;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}

}
