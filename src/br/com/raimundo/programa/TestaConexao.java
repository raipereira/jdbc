package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		ConnectionPool database = new ConnectionPool();
		Connection connection  = database.getConection();
		System.out.println("Testando conexão");
		connection.close();
	}

}
