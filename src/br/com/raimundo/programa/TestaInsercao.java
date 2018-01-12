package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = Database.getConection();
		Statement stmt = connection.createStatement();	
		boolean result = stmt.execute("insert into Produto(nome, descricao) values('Notebook', 'i5')",
				Statement.RETURN_GENERATED_KEYS);
		System.out.println(result);
		
		ResultSet resultSet = stmt.getGeneratedKeys();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " gerado");
		}
		stmt.close();
		resultSet.close();
		connection.close();
	}

}
