package br.com.fuctura.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String URL = "jdbc:oracle:thin:@localhost:1522/xe";
	private static String usuario = "fuctura";
	private static String senha = "123";
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(URL, usuario, senha);
		}
		return connection;
	}
	

}
