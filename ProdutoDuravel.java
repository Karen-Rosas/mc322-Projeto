// ProdutoDuravel.java
public class ProdutoDuravel extends Produto {
    private String material;

    public ProdutoDuravel(String codigo, String nome, double preco, int quantidade, String material) {
        super(codigo, nome, preco, quantidade); // Chama o construtor da superclasse Produto
        this.material = material;
    }

    public String getMaterial() { return material; }

    @Override
    public String detalhes() {
        return "Durável - Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco) + ", Qtd: " + quantidade + ", Material: " + material;
    }
}