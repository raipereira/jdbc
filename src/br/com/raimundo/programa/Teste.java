package br.com.raimundo.programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {
	
	public static void main(String... args) throws SQLException {
		
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		
		System.out.println("conecão aberta");
		
		c.close();
		
	}

}
