package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrar();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
//		Produto p = produtoDAO.buscarPorId(1l);
//		System.out.println(p);
		
//		List<Produto> todos = produtoDAO.buscarTodos();
//		todos.forEach(p2 -> System.out.println(p2));
		
//		List<Produto> porNome = produtoDAO.buscarPorNome("Xiaomi redmi");
//		porNome.forEach(p3 -> System.out.println(p3));
		
//		List<Produto> porCategoria = produtoDAO.buscarPorCategoria("celulares");
//		porCategoria.forEach(p4 -> System.out.println(p4));
		
		BigDecimal preco = produtoDAO.buscarPrecoDoProdutoPorNome("Xiaomi redmi");
		System.out.println(preco);
	}

	private static void cadastrar() {
		Categoria celulares = new Categoria("celulares");
		Produto celular = new Produto("Xiaomi redmi", "muito legal", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}
}
