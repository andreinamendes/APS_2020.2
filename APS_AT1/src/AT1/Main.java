package AT1;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static void menu() {
		System.out.println("---------------MENU---------------");
		System.out.println("	1 - Criar produto");
		System.out.println("	2 - Comprar");
		System.out.println("	3 - Vender");
		System.out.println("	4 - Consultar preço");
		System.out.println("	5 - Listar preços");
		System.out.println("	6 - Editar produto");
		System.out.println("----------------------------------");
		System.out.print("Digite a opção desejada: ");
	}
	
	public static void editarProduto() {
		System.out.println("--------Editar Produto--------");
		System.out.println("	1 - Consultar valor");
		System.out.println("	2 - Consultar custo");
		System.out.println("	3 - Consultar margem de lucro");
		System.out.println("	4 - Alterar valor");
		System.out.println("	5 - Alterar custo");
		System.out.println("	6 - Alterar margem de lucro");
		System.out.println("------------------------------");
		System.out.print("Digite a opção desejada: ");
	}
	
	public static void main(String[] args) {
		RevendaComArray revenda = new RevendaComArray(1);
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int cod = 0, qtd = 0;
			menu();
			switch(scan.nextInt()) {
				case 1:
					System.out.print("Digite o codigo: ");
					cod = scan.nextInt();
					System.out.print("Digite a descrição: ");
					scan.nextLine();
					String desc = scan.nextLine();
					System.out.print("Digite o valor: ");
					double valor = scan.nextDouble();
					System.out.print("Digite o custo: ");
					double custo = scan.nextDouble();
					System.out.print("Digite a margem de lucro: ");
					double margem = scan.nextDouble();
					System.out.print("Digite a quantidade para o estoque: ");
					qtd = scan.nextInt();
					Produto produto = new Produto(cod, desc, valor, custo, margem, qtd);
					if(revenda.inserirProduto(produto))
						System.out.println("Produto criado com sucesso!");
					break;
				case 2:
					System.out.print("Digite o código: ");
					cod = scan.nextInt();
					System.out.print("Digite a quantidade: ");
					qtd = scan.nextInt();
					if(revenda.comprar(cod, qtd))
						System.out.println("Compra realizada com sucesso!");
					break;
				case 3:
					System.out.print("Digite o código: ");
					cod = scan.nextInt();
					System.out.print("Digite a quantidade: ");
					qtd = scan.nextInt();
					if(revenda.vender(cod, qtd))
						System.out.println("Venda realizada com sucesso!");
					break;
				case 4:
					System.out.print("Digite o código: ");
					cod = scan.nextInt();
					revenda.consultaPrecoVenda(cod);
					break;
				case 5:
					revenda.listaPrecos();
					break;
				case 6: 
					System.out.println("Digite o código do produto: ");
					cod = scan.nextInt();
					Produto prod = revenda.getProduto(cod);
					if(prod == null) {
						System.out.println("Produto inválido.");
						break;
					}
					editarProduto();
					switch(scan.nextInt()) {
						case 1:
							System.out.println("Valor: " + prod.getValor());
							break;
						case 2:
							System.out.println("Custo: " + prod.getCusto());
							break;
						case 3:
							System.out.println("Margem de lucro: " + prod.getMargemDeLucro());
							break;
						case 4:
							System.out.println("Digite o novo valor: ");
							prod.setValor(scan.nextInt());
							System.out.println("Novo valor cadastrado com sucesso!");
						case 5:
							System.out.println("Digite o novo custo: ");
							prod.setCusto(scan.nextDouble());
							System.out.println("Novo custo cadastrado com sucesso!");
						case 6:
							System.out.println("Digite a nova margem de lucro: ");
							prod.setMargemDeLucro(scan.nextDouble());
							System.out.println("Nova margem de lucro cadastrada com sucesso!");
					}
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		}
	}
}
