package br.com.fuctura.entidades;

public class Senha {
	private long codigo;//id
	private String valor;


	public Senha(String valor) {
		super();
		this.valor = valor;
	}

	public Senha() {
		super();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
