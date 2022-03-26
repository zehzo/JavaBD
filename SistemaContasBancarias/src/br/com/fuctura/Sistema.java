package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidades.Senha;
import br.com.fuctura.entidades.Usuario;
import br.com.fuctura.repositorio.UsuarioRepositorio;
import br.com.fuctura.util.Conexao;

public class Sistema {
	
	
	public static void inserirUsuarioComum(Connection con, int codigo, String nome, int idade, String email, String senha) throws SQLException {
		String sql = "insert into usuario(codigo, nome, idade, email, senha) "
				+  "values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, codigo);
		pstmt.setString(2, nome);
		pstmt.setInt(3, idade);
		pstmt.setString(4, email);
		pstmt.setString(5, senha);
		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Usuário inserido com sucesso!");
		
	}
	
	public static void deletarUsuario(Connection con, int codigo) throws SQLException {
		String sql = "delete usuario where codigo = '?'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, codigo);
		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Usuário deletado com sucesso!");
	
	}
	
	public static void trocarSenha(Connection con, int codigo, String senha) throws SQLException {
		String sql = "UPDATE usuario SET senha = ? WHERE codigo = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, senha);
		pstmt.setInt(2, codigo);
		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Senha alterada com sucesso");
	}

	
	public static void main(String[] args) {
		
		try {
			Connection con = Conexao.getConnection();
			
			UsuarioRepositorio usuRepo = new UsuarioRepositorio();
			System.out.println("Conexão efetuada com sucesso!\n");
			
			
			System.out.println(usuRepo.obterUsuario(2));
			System.out.println("\n----------------\n");
			System.out.println(usuRepo.listarTodos());
			

//			inserirUsuarioComum(con, 8, "Luiz Fragoso", 37, "seuluiz@gmail.com", "mamule");
//			usuRepo.inserir(usu);
//			deletarUsuario(con, 2);
//			trocarSenha(con, 3, "12342");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
