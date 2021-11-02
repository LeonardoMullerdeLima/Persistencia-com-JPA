package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos") // nome na tabela != nome aqui
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();

//	@Enumerated(EnumType.STRING) // cadastro default é itn. Isso faz cm que use o nome da categoria (string)
	@ManyToOne
	private Categoria categoria;

	public Produto() {
	}
	
	public Produto(String nome, String descricao, BigDecimal preço, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preço;
		this.categoria = categoria;
	}
	
	public BigDecimal getPreco() {
		return this.preco;
	}
	
	@Override
	public String toString() {
		return this.id + " | " + this.nome + " | " + this.descricao + " | " + this.preco + " | " + this.dataCadastro;
	}
}
