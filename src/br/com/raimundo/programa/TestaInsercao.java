package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionPool database = new ConnectionPool();
		
		try(Connection connection = database.getConection()){
			connection.setAutoCommit(false);
			String sql = "insert into Produto(nome, descricao) values(?,?)";
			
			try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				adiciona("TV LG", "45 polegado", stmt);
				adiciona("Blueray", "Full HDMI", stmt);
				connection.commit();
			}catch (Exception e){
				System.out.println(e);
				connection.rollback();
				System.out.println("Rollback feito");
			}
		
		}
	}

	private static ResultSet adiciona(String nome, String descricao, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		
		if(nome.equals("Blueray")) {
			
			throw new IllegalArgumentException("ocorreu um problema");
		}
		
		boolean result = stmt.execute();
		System.out.println(result);
		
		ResultSet resultSet = stmt.getGeneratedKeys();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " gerado");
		}
		
		return resultSet;
	}

}
