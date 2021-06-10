package br.projetodelivery.entidade;

public class Cliente extends Pessoa {
	String login;
	String senha;
    int codigo;
    
    
    
    
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente() {}

	public Cliente(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [login=" + login + ", senha=" + senha + ", codigo=" + codigo + "]";
	}

}
