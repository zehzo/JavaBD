package br.com.fuctura.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidades.Senha;
import br.com.fuctura.entidades.Usuario;
import br.com.fuctura.util.Conexao;

public class UsuarioRepositorio {
	public void inserir(Usuario usu) throws SQLException {
		Connection con = Conexao.getConnection();
		String sql = "insert into usuario(codigo, nome, idade, email, senha) "
				+  "values (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, usu.getCodigo());
		pstmt.setString(2, usu.getNome());
		pstmt.setInt(3, usu.getIdade());
		pstmt.setString(4, usu.getEmail());
		pstmt.setString(5, usu.getSenha().getValor());
		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Usuário inserido com sucesso!");
		
	}
	
	public List<Usuario> listarTodos() throws SQLException {
		
		Connection con = Conexao.getConnection();
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		ResultSet rs = stmt.getResultSet();
		
		//next retorna o booleano true se tiver proxima posicao, e anda o cursor para a proxima linha
		while (rs.next()) {
			String nome = rs.getString("nome");
			long codigo = rs.getLong("codigo");
			String email = rs.getString("email");
			int idade = rs.getInt("idade");
			String valorSenha = rs.getString("senha");
			Senha senha = new Senha();
			senha.setValor(valorSenha);
			
			Usuario usu = new Usuario(codigo, nome, email, idade, senha);
			lista.add(usu);
		}
		return lista;
	}
	
	public static void imprimirUsuarios(List<Usuario> listaUsuarios) {
		for (Usuario usuario: listaUsuarios) {
			System.out.println(usuario);
		}
	}

	public Usuario obterUsuario(long id) throws SQLException {
		Connection con = Conexao.getConnection();
		String sql = "select * from usuario where codigo=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, id);
		pstmt.executeUpdate();
		
		ResultSet rs = pstmt.getResultSet();

		if (rs.next()){
			String nome = rs.getString("nome");
			long codigo = rs.getLong("codigo");
			String email = rs.getString("email");
			int idade = rs.getInt("idade");
			String valorSenha = rs.getString("senha");
			
			Usuario usu = new Usuario(codigo, nome, email, idade, new Senha(valorSenha));
			pstmt.close();
			return usu;	
		}
		pstmt.close();
		return null;
	}
			
}