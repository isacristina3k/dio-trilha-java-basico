package Loja;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
	private Map<Long, Produto> estoqueProdutosMap;

	public EstoqueProdutos() {
		this.estoqueProdutosMap = new HashMap<>();
	}
	
	public void adicionarProduto (long cod, String nome, double preco, int quantidade) {
		estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
	}
	
	public void exibirProdutos() {
		System.out.println(estoqueProdutosMap);
	}
	
	public double calculaValorTotal() {
		
		double valorTotalEstoque = 0;
		if(!estoqueProdutosMap.isEmpty()) {
			for (Produto p :estoqueProdutosMap.values()) {
				valorTotalEstoque += p.getQuantidade() * p.getPreco();
			}
		}
		return valorTotalEstoque;
	}
	
	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p: estoqueProdutosMap.values()) {
				if(p.getPreco() > maiorPreco) {
					produtoMaisCaro = p;
				}
			}
		}
		return produtoMaisCaro;
	}
	
	public static void main(String[] args) {
		EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
		estoqueProdutos.adicionarProduto(1, "celular", 1099.45, 24);
		estoqueProdutos.adicionarProduto(1, "celular", 5004.45, 21);
		estoqueProdutos.adicionarProduto(2, "notebook", 1826.78, 31);
		estoqueProdutos.adicionarProduto(3, "fone samsung", 588.47, 91);
		estoqueProdutos.exibirProdutos();
		
		//System.out.println(estoqueProdutos.calculaValorTotal()); 
		
		System.out.println(estoqueProdutos.obterProdutoMaisCaro()); 
	}
}
