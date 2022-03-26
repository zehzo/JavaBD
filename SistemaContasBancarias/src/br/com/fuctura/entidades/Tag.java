package br.com.fuctura.entidades;

public class Tag {
	private long codigo;
	private String descricao;

	public Tag(long codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Tag [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	

}
