// Estoque.java
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private static String NOME_ESTOQUE = "Estoque Principal"; // Variável estática

    public Estoque() {
        // Usamos ArrayList para flexibilidade no tamanho, que é baseado em array internamente
        this.produtos = new ArrayList<>();
    }

    // Método estático
    public static void exibirNomeEstoque() {
        System.out.println("Nome do Estoque: " + NOME_ESTOQUE);
    }

    // Sobrecarga de método: Adicionar produto com verificação de existência
    public void adicionarProduto(Produto produto) {
        Produto existente = buscarProduto(produto.getCodigo());
        if (existente != null) {
            // Se o produto já existe, atualiza a quantidade
            existente.setQuantidade(existente.getQuantidade() + produto.getQuantidade());
            System.out.println("Produto existente, quantidade atualizada para " + existente.getQuantidade() + ".");
        } else {
            // Se o produto não existe, adiciona-o à lista
            this.produtos.add(produto);
            System.out.println("Produto " + produto.getNome() + " adicionado ao estoque.");
        }
    }

    // Outra sobrecarga de método (exemplo simples de sobrecarga)
    // Este método poderia ser usado para adicionar um produto que já sabemos a quantidade a adicionar,
    // sem precisar de um objeto Produto completo, mas para o nosso GUI, a primeira sobrecarga é mais útil.
    public void adicionarProduto(String codigo, String nome, double preco, int quantidade) {
        // Exemplo: cria um Produto genérico e chama a outra sobrecarga
        // Isso é apenas um exemplo de sobrecarga, a lógica real dependeria do tipo de produto
        Produto p = new ProdutoDuravel(codigo, nome, preco, quantidade, "N/A"); // Exemplo simples
        adicionarProduto(p);
    }


    public boolean removerProduto(String codigo) {
        Produto produtoParaRemover = null;
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                produtoParaRemover = p;
                break;
            }
        }
        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            System.out.println("Produto " + codigo + " removido.");
            return true;
        }
        System.out.println("Produto com código " + codigo + " não encontrado.");
        return false;
    }

    public Produto buscarProduto(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar o produto
    }

    public boolean atualizarQuantidade(String codigo, int novaQuantidade) {
        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            if (novaQuantidade >= 0) { // Não permitir quantidade negativa
                produto.setQuantidade(novaQuantidade);
                System.out.println("Quantidade do produto " + codigo + " atualizada para " + novaQuantidade + ".");
                return true;
            } else {
                System.out.println("Erro: A quantidade não pode ser negativa.");
            }
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
        return false;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void listarTodosProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("--- Produtos no Estoque ---");
        for (Produto p : produtos) {
            System.out.println(p.detalhes()); // Polimorfismo em ação!
        }
        System.out.println("---------------------------");
    }
}