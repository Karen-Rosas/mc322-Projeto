# Sistema de Gerenciamento de Estoque Básico

## Visão Geral do Projeto

Este é um Sistema de Gerenciamento de Estoque Básico desenvolvido em Java, utilizando Programação Orientada a Objetos (POO) e uma interface gráfica (GUI) com Swing. O objetivo principal é fornecer uma ferramenta simples para adicionar, remover, buscar, atualizar a quantidade e listar produtos em um estoque.

O projeto foi desenvolvido como parte da disciplina de **MC322 - Programação Orientada a Objetos** na UNICAMP.

## Funcionalidades Principais

As funcionalidades atuais do sistema incluem:

* **Cadastro de Produtos:** Adicionar novos produtos ao estoque, escolhendo entre produtos perecíveis e duráveis.
* **Atualização de Quantidade:** Modificar a quantidade de produtos existentes no estoque.
* **Remoção de Produtos:** Remover produtos do estoque pelo seu código.
* **Busca de Produtos:** Localizar produtos específicos pelo seu código.
* **Listagem de Produtos:** Exibir todos os produtos atualmente no estoque.
* [cite_start]**Interface Gráfica (GUI):** Todas as interações são realizadas através de uma interface de usuário intuitiva. 

## Tópicos de POO Abordados

Este projeto demonstra a aplicação dos seguintes conceitos de Programação Orientada a Objetos em Java, conforme requisitos da disciplina:

* **Classes, Variáveis e Métodos:** O sistema é estruturado em classes como `Produto`, `ProdutoPerecivel`, `ProdutoDuravel`, `Estoque` e `EstoqueApp`, cada uma com seus atributos e métodos. [cite_start]Inclui sobrecarga de métodos (ex: `adicionarProduto` na classe `Estoque`). 
* [cite_start]**Visibilidade:** Aplicação correta de modificadores de visibilidade (`public`, `private`, `protected`). 
* [cite_start]**Herança:** Implementação de uma estrutura de herança com `Produto` (classe abstrata) sendo herdada por `ProdutoPerecivel` e `ProdutoDuravel`. 
* [cite_start]**Variáveis e Métodos Estáticos:** A classe `Estoque` inclui uma variável estática (`NOME_ESTOQUE`) e um método estático (`exibirNomeEstoque()`). 
* [cite_start]**Arrays:** Utilização de `java.util.List` (implementada com `ArrayList`) na classe `Estoque` para armazenar a coleção de produtos. 
* [cite_start]**Enumerações:** (Ainda não implementado, mas planejado para categorias de produto/status de validade). 
* [cite_start]**Entrada e Saída de Dados:** Realizada através da interface gráfica (campos de texto, áreas de texto, caixas de diálogo) e interações com o usuário. 
* [cite_start]**Relacionamentos (Associação):** A classe `Estoque` possui um relacionamento de associação com `Produto`, indicando que um estoque "contém" múltiplos produtos. 
* [cite_start]**Classes Abstratas:** A classe `Produto` é abstrata, definindo um contrato comum para seus subtipos. 
* [cite_start]**Polimorfismo:** Exemplos de polimorfismo de tipo (manipulando `ProdutoPerecivel` e `ProdutoDuravel` como `Produto` na lista do `Estoque`) e polimorfismo de método (através da sobrescrita do método `detalhes()`). 
* [cite_start]**Interface Gráfica (GUI):** O sistema é controlado por uma interface gráfica desenvolvida com Swing. 
* **Tratamento de Exceções:** Inclui tratamento básico de exceções (ex: `NumberFormatException` para entradas inválidas na GUI). [cite_start](Ainda será expandido com exceções personalizadas). 
* [cite_start]**Arquivos (Leitura e Gravação):** (Ainda não implementado, mas planejado para persistência dos dados do estoque). 

## Estrutura do Projeto (Classes)

O projeto é organizado nas seguintes classes principais:

* `Main.java`: Ponto de entrada da aplicação, responsável por iniciar a interface gráfica.
* `EstoqueApp.java`: A classe da interface gráfica (GUI), estendendo `JFrame`, onde o usuário interage com o sistema.
* `Produto.java`: Classe abstrata base para todos os produtos.
* `ProdutoPerecivel.java`: Estende `Produto`, adicionando `dataValidade`.
* `ProdutoDuravel.java`: Estende `Produto`, adicionando `material`.
* `Estoque.java`: Gerencia a coleção de produtos, com métodos para adicionar, remover, buscar, listar e atualizar.

## Como Compilar e Executar

Para compilar e executar este projeto, você precisará ter o **Java Development Kit (JDK)** instalado (versão 11 ou superior, como OpenJDK 17 ou 21).

**Passos:**

1.  **Clone o Repositório:**
    ```bash
    git clone <link_do_seu_repositorio>
    cd <nome_da_pasta_do_projeto> # ex: cd Sistema-Estoque-Java
    ```
    (Se você não estiver usando Git, apenas navegue até a pasta onde salvou os arquivos `.java`).

2.  **Compile os Arquivos Java:**
    Abra um terminal (ou prompt de comando) na pasta raiz do projeto e execute:
    ```bash
    javac *.java
    ```
    Isso compilará todas as classes `.java` e criará os arquivos `.class` correspondentes.

3.  **Execute a Aplicação:**
    Após a compilação bem-sucedida, execute a aplicação principal:
    ```bash
    java Main
    ```
    A janela do Sistema de Gerenciamento de Estoque deverá aparecer na sua tela.

## Contribuições

Sinta-se à vontade para explorar o código. Sugestões e melhorias são bem-vindas!

## Autores

* Karen Rosas Ketelhute Sampaio - RA:174537
* Caio Lima Albuquerque - RA:288808
* Giovana Jacome Marchetti - RA:177700
* Allan Rocha - RA: xxxxxxx

