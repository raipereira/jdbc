package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {
	
	public static void main(String[] args) throws SQLException {
		ConnectionPool database = new ConnectionPool();
		Connection connection = database.getConection();
		Statement stmt = connection.createStatement();
		stmt.executeQuery("delete from Produto where id>3");
		int count = stmt.getUpdateCount();
		System.out.println("Linhas removidos " + count);
		
		stmt.close();
		connection.close();
	}

}
