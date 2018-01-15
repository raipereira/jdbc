package br.com.raimundo;

import java.sql.Connection;
import java.util.List;

import br.com.raimundo.dao.ProdutoDAO;
import br.com.raimundo.model.Produto;
import br.com.raimundo.programa.ConnectionPool;

public class TestaInsercaoDoProduto {
	
	public static void main(String[] args) throws Exception {
		
		Produto produto = new Produto("Mesa", "Mesa de 4 pes");
		
		try(Connection connection = new ConnectionPool().getConection()){
			ProdutoDAO dao = new ProdutoDAO(connection);
			dao.salva(produto);
			List<Produto> produtos = dao.lista();
			for(Produto p : produtos) {
				System.out.println(p);
			}
			
			
		}
		
	}

}
