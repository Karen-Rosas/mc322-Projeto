// Produto.java
public abstract class Produto {
    protected String codigo;
    protected String nome;
    protected double preco;
    protected int quantidade;

    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    // Setter para quantidade (permite atualização)
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método abstrato que será implementado pelas subclasses
    public abstract String detalhes();
}