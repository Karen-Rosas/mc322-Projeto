// ProdutoPerecivel.java
public class ProdutoPerecivel extends Produto {
    private String dataValidade;

    public ProdutoPerecivel(String codigo, String nome, double preco, int quantidade, String dataValidade) {
        super(codigo, nome, preco, quantidade); // Chama o construtor da superclasse Produto
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() { return dataValidade; }

    @Override
    public String detalhes() {
        return "Perecível - Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco) + ", Qtd: " + quantidade + ", Validade: " + dataValidade;
    }
}