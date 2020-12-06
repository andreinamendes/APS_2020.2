package AT1;

public class Produto {
	private int codigo;
	private String descricao;
	private double valor;
	private double custo;
	private double margem_de_lucro;
	private int qtd_estoque;
	
	public Produto(int cod, String desc) {
		this.codigo = cod;
		this.descricao = desc;
	}
	
	public Produto(int cod, String desc, double valor, double custo, double margem) {
		this.codigo = cod;
		this.descricao = desc;
		this.valor = valor;
		this.custo = custo;
		this.margem_de_lucro = margem;
	}
	
	public Produto(int cod, String desc, double valor, double custo, double margem, int qtd) {
		this.codigo = cod;
		this.descricao = desc;
		this.valor = valor;
		this.custo = custo;
		this.margem_de_lucro = margem;
		this.qtd_estoque = qtd;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String desc) {
		this.descricao = desc;
	}
	
	public double getValor(){
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getCusto() {
		return this.custo;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public double getMargemDeLucro() {
		return this.margem_de_lucro;
	}
	
	public void setMargemDeLucro(double margem) {
		this.margem_de_lucro = margem;
	}
	
	public int getQuantidade() {
		return this.qtd_estoque;
	}
	
	public void setQuantidade(int qtd) {
		this.qtd_estoque = qtd;
	}
	
	public void compra(int qtd) {
		this.qtd_estoque = qtd_estoque + qtd;
	}
	
	public void venda(int qtd) {
		this.qtd_estoque = this.qtd_estoque - qtd;
	}
	
	public double calculaPrecoVenda() {
		return (this.valor + this.custo + this.margem_de_lucro) * (this.valor + this.custo);
	}
}
