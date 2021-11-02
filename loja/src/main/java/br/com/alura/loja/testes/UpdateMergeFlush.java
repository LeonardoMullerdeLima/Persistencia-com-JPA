package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class UpdateMergeFlush {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("celulares");
		// instanciamos a entidade. Nesse momento ele se encontra no estado "TRANSIENT"

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.persist(celulares);
		// entidade entra em estado "MANAGED". A db está "de olho" para eventuais
		// mudanças

		celulares.setNome("Você conhece o Mario?");

		em.flush();
		// ao usarmos flush ou commit sincronizamos a entidade com a db

		em.clear();
		// limpa a 'em'. Suas entidades entram em estado "DETACHED"

		celulares = em.merge(celulares);
		// merge recebe uma entidade em estado "DETACHED" e devolve uma referencia para
		// uma nova entidade em estado "MANAGED"

		celulares.setNome("Que Mário?");
		em.flush();
		
		em.remove(celulares); // "REMOVED"
		em.flush();

		em.close();
	}

	/*
	 * em.getTransaction().begin(); 
	 * Produto produto = em.find(Produto.class, 1l);
	 * produto.setDescricao(“Teste 1”); 
	 * em.flush();
	 * produto.setDescricao(“Teste 2”);
	 * em.merge(produto); 
	 * produto.setDescricao(“Teste 3”);
	 * em.getTransaction().commit(); 
	 * em.close();
	 * 
	 * No código anterior o merge acabou sendo indiferente, 
	 * pois a entidade já estava no estado Managed
	 */
}
