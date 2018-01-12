package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	
	public static void main(String[] args) throws SQLException {
		
		String nome = "Notebook";
		String descricao = "Notebook 'i5";
		
		Connection connection = Database.getConection();
		String sql = "insert into Produto(nome, descricao) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		
		boolean result = stmt.execute();
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
