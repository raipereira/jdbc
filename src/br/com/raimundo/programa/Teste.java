package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
	
	public static void main(String... args) throws SQLException {
		
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		
		Statement stmt = c.createStatement();
		boolean resultado = stmt.execute("select * from Produto");
		if(resultado) {
			ResultSet result = stmt.getResultSet();
			while(result.next()) {
				int id = result.getInt("id");
				String nome = result.getString("nome");
				String descricao = result.getString("descricao");
				System.out.println(id + "\n" + nome + "\n" + descricao);
			}
			
			result.close();
			stmt.close();
			c.close();
		
	}
	}

}
