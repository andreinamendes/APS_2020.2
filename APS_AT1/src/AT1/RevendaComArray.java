package AT1;

public class RevendaComArray {
	private Produto[] produtos;
	private int indice;
	
	public RevendaComArray(int qtd) {
		this.produtos = new Produto[qtd];
	}
	
	public boolean inserirProduto(Produto produto) {
		for(indice = 0; indice < this.produtos.length; indice++) {
			if(this.produtos[indice] == null) {
				this.produtos[indice] = produto;
				return true;
			}
		}
		return false;
	}
	
	public boolean comprar(int cod, int qtd) {
		for(int indice = 0; indice < this.produtos.length; indice++) {
			if(this.produtos[indice].getCodigo() == cod) {
				this.produtos[indice].compra(qtd);
				return true;
			}
		}
		System.out.println("Compra cancelada, produto não se encontra em estoque.");
		return false;
	}
	
	public boolean vender(int cod, int qtd) {
		for(int indice = 0; indice < this.produtos.length; indice++) {
			if(this.produtos[indice].getCodigo() == cod) {
				if(this.produtos[indice].getQuantidade() >= qtd) {
					this.produtos[indice].compra(qtd);
					return true;
				}
				System.out.println("Venda cancelada, estoque insuficiente.");
				return false;
			}
		}
		System.out.println("Venda cancelada, produto não se encontra em estoque.");
		return false;
	}
	
	public void consultaPrecoVenda(int cod) {
		for(int indice = 0; indice < this.produtos.length; indice++) {
			if(this.produtos[indice].getCodigo() == cod) {
				System.out.println("Valor do produto " + this.produtos[indice].getDescricao() + " é: " + this.produtos[indice].getValor());
				return;
			}
		}
		System.out.println("Produto não se encontra em estoque.");
	}
	
	public void listaPrecos() {
		for(int indice = 0; indice < this.produtos.length; indice++) {
			System.out.println("---------Produto " + (indice + 1) + "----------");
			System.out.println("Descrição: " + this.produtos[indice].getDescricao());
			System.out.println("Código: " + this.produtos[indice].getCodigo());
			System.out.println("Valor: " + this.produtos[indice].getValor());
			System.out.println("----------------------------");
		}
	}
	
	public Produto getProduto(int cod) {
		for(indice = 0; indice < this.produtos.length; indice++) {
			if(this.produtos[indice].getCodigo() == cod)
				return this.produtos[indice];
		}
		System.out.println("Produto inexistente.");
		return null;
	}
}
