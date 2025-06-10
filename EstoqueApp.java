// EstoqueApp.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Importações das suas classes de modelo
import java.util.List; // Necessário para a classe EstoqueApp interagir com List<Produto>

public class EstoqueApp extends JFrame {
    private Estoque estoque; // Instância da classe Estoque

    // Componentes da GUI
    private JTextField txtCodigo, txtNome, txtPreco, txtQuantidade, txtCampoEspecifico;
    private JComboBox<String> cmbTipoProduto;
    private JTextArea areaResultados;
    private JButton btnAdicionar, btnRemover, btnBuscar, btnListar, btnAtualizar;
    private JLabel lblCampoEspecifico; // Label que muda de acordo com o tipo de produto

    public EstoqueApp() {
        super("Sistema de Gerenciamento de Estoque");
        estoque = new Estoque();

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelEntrada = new JPanel(new GridLayout(7, 2, 5, 5));
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelResultados = new JPanel(new BorderLayout());

        txtCodigo = new JTextField(10);
        txtNome = new JTextField(20);
        txtPreco = new JTextField(10);
        txtQuantidade = new JTextField(10);
        txtCampoEspecifico = new JTextField(20);
        lblCampoEspecifico = new JLabel("Data Validade/Material:");
        cmbTipoProduto = new JComboBox<>(new String[]{"Produto Perecível", "Produto Durável"});

        cmbTipoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbTipoProduto.getSelectedItem().equals("Produto Perecível")) {
                    lblCampoEspecifico.setText("Data de Validade (DD/MM/AAAA):");
                } else {
                    lblCampoEspecifico.setText("Material:");
                }
            }
        });

        panelEntrada.add(new JLabel("Tipo de Produto:"));
        panelEntrada.add(cmbTipoProduto);
        panelEntrada.add(new JLabel("Código:"));
        panelEntrada.add(txtCodigo);
        panelEntrada.add(new JLabel("Nome:"));
        panelEntrada.add(txtNome);
        panelEntrada.add(new JLabel("Preço:"));
        panelEntrada.add(txtPreco);
        panelEntrada.add(new JLabel("Quantidade:"));
        panelEntrada.add(txtQuantidade);
        panelEntrada.add(lblCampoEspecifico);
        panelEntrada.add(txtCampoEspecifico);

        btnAdicionar = new JButton("Adicionar Produto");
        btnRemover = new JButton("Remover Produto");
        btnBuscar = new JButton("Buscar Produto");
        btnListar = new JButton("Listar Todos");
        btnAtualizar = new JButton("Atualizar Quantidade");

        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnRemover);
        panelBotoes.add(btnBuscar);
        panelBotoes.add(btnListar);
        panelBotoes.add(btnAtualizar);

        areaResultados = new JTextArea(10, 50);
        areaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados do Estoque"));
        panelResultados.add(scrollPane, BorderLayout.CENTER);

// EstoqueApp.java
// ... (código anterior igual até a criação dos painéis e componentes) ...

    // Adiciona os painéis à janela principal
    // Ajustamos o layout da janela principal para que tenha espaçamento
    setLayout(new BorderLayout(10, 10));

    // Painel de Entrada no TOPO (NORTH)
    add(panelEntrada, BorderLayout.NORTH);

    // Painel de Botões na parte INFERIOR (SOUTH)
    // Isso é uma mudança, pois antes estava no CENTER
    add(panelBotoes, BorderLayout.SOUTH);

    // Painel de Resultados no CENTRO (CENTER)
    // Este painel agora ocupa a maior parte do espaço disponível
    add(panelResultados, BorderLayout.CENTER);

    // ... (resto do código igual) ...

        btnAdicionar.addActionListener(e -> adicionarProduto());
        btnRemover.addActionListener(e -> removerProduto());
        btnBuscar.addActionListener(e -> buscarProduto());
        btnListar.addActionListener(e -> listarProdutos());
        btnAtualizar.addActionListener(e -> atualizarQuantidade());

        Estoque.exibirNomeEstoque(); // Chamada ao método estático
    }

    private void adicionarProduto() {
        try {
            String tipo = (String) cmbTipoProduto.getSelectedItem();
            String codigo = txtCodigo.getText();
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            String campoEspecifico = txtCampoEspecifico.getText();

            Produto novoProduto = null;
            if (tipo.equals("Produto Perecível")) {
                novoProduto = new ProdutoPerecivel(codigo, nome, preco, quantidade, campoEspecifico);
            } else if (tipo.equals("Produto Durável")) {
                novoProduto = new ProdutoDuravel(codigo, nome, preco, quantidade, campoEspecifico);
            }

            if (novoProduto != null) {
                estoque.adicionarProduto(novoProduto);
                areaResultados.append("Produto " + nome + " adicionado/atualizado com sucesso!\n");
                limparCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para Preço e Quantidade.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerProduto() {
        String codigo = JOptionPane.showInputDialog(this, "Digite o código do produto a remover:");
        if (codigo != null && !codigo.trim().isEmpty()) {
            if (estoque.removerProduto(codigo)) {
                areaResultados.append("Produto com código " + codigo + " removido.\n");
            } else {
                areaResultados.append("Produto com código " + codigo + " não encontrado.\n");
            }
        }
    }

    private void buscarProduto() {
        String codigo = JOptionPane.showInputDialog(this, "Digite o código do produto a buscar:");
        if (codigo != null && !codigo.trim().isEmpty()) {
            Produto p = estoque.buscarProduto(codigo);
            if (p != null) {
                areaResultados.append("Produto encontrado:\n" + p.detalhes() + "\n");
            } else {
                areaResultados.append("Produto com código " + codigo + " não encontrado.\n");
            }
        }
    }

    private void listarProdutos() {
        areaResultados.setText("");
        List<Produto> produtosNoEstoque = estoque.getProdutos();
        if (produtosNoEstoque.isEmpty()) {
            areaResultados.append("Estoque vazio.\n");
            return;
        }
        areaResultados.append("--- Produtos no Estoque ---\n");
        for (Produto p : produtosNoEstoque) {
            areaResultados.append(p.detalhes() + "\n");
        }
        areaResultados.append("---------------------------\n");
    }

    private void atualizarQuantidade() {
        try {
            String codigo = JOptionPane.showInputDialog(this, "Digite o código do produto para atualizar a quantidade:");
            if (codigo != null && !codigo.trim().isEmpty()) {
                String novaQuantidadeStr = JOptionPane.showInputDialog(this, "Digite a nova quantidade:");
                if (novaQuantidadeStr != null && !novaQuantidadeStr.trim().isEmpty()) {
                    int novaQuantidade = Integer.parseInt(novaQuantidadeStr);
                    if (estoque.atualizarQuantidade(codigo, novaQuantidade)) {
                        areaResultados.append("Quantidade do produto " + codigo + " atualizada para " + novaQuantidade + ".\n");
                    } else {
                        areaResultados.append("Não foi possível atualizar a quantidade do produto " + codigo + ".\n");
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido para a quantidade.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        txtCampoEspecifico.setText("");
        cmbTipoProduto.setSelectedIndex(0);
    }
}