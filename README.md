# Sistema de Gerenciamento de Estoque Básico

## Visão Geral do Projeto

Este é um Sistema de Gerenciamento de Estoque Básico desenvolvido em Java, utilizando Programação Orientada a Objetos (POO) e uma interface gráfica (GUI) com Swing. O objetivo principal é fornecer uma ferramenta simples para adicionar, remover, buscar, atualizar a quantidade e listar produtos em um estoque.

O projeto foi desenvolvido como parte da disciplina de **MC322 - Programação Orientada a Objetos** na UNICAMP.

### Funcionalidades Principais

As funcionalidades atuais do sistema incluem:

* **Cadastro de Produtos:** Adicionar novos produtos ao estoque, escolhendo entre produtos perecíveis e duráveis.
* **Atualização de Quantidade:** Modificar a quantidade de produtos existentes no estoque.
* **Remoção de Produtos:** Remover produtos do estoque pelo seu código.
* **Busca de Produtos:** Localizar produtos específicos pelo seu código.
* **Listagem de Produtos:** Exibir todos os produtos atualmente no estoque.
* [cite_start]**Interface Gráfica (GUI):** Todas as interações são realizadas através de uma interface de usuário intuitiva. 


### Funcionalidades Complexas
Visão Geral do Sistema

1. Produto (Classe Abstrata)
Esta é a classe base para todos os tipos de produtos no nosso estoque. Ela é abstrata porque um "Produto" genérico não faz sentido por si só; sempre será um tipo mais específico de produto (perecível ou durável).
Propósito: Definir os atributos e comportamentos comuns a qualquer produto, independentemente de ser perecível ou durável. Isso evita duplicação de código.


Conceitos POO Abordados:


Classes Abstratas: Não pode ser instanciada diretamente.
Herança: Serve como superclasse para ProdutoPerecivel e ProdutoDuravel.
Encapsulamento: Atributos são protected (acessíveis por subclasses, mas não diretamente de fora do pacote).
Métodos Abstratos: Define um método detalhes() que deve ser implementado por todas as subclasses, demonstrando polimorfismo.
Atributos (protected):


String codigo: Um identificador único para o produto (ex: "EAN123", "CEL001").
String nome: O nome do produto (ex: "Arroz Tipo 1", "Smartphone X").
double preco: O preço unitário do produto.
int quantidade: A quantidade do produto em estoque.
Métodos (public):


Produto(String codigo, String nome, double preco, int quantidade) (Construtor):
Propósito: Inicializar um objeto Produto com seus valores básicos.
Explicação: Chamado pelas subclasses (super(...)) para configurar a parte comum do produto.
getCodigo(), getNome(), getPreco(), getQuantidade() (Getters):
Propósito: Permitir o acesso seguro (leitura) aos atributos privados/protegidos da classe.
setQuantidade(int quantidade) (Setter):
Propósito: Permitir a modificação segura da quantidade do produto em estoque.
abstract String detalhes():
Propósito: Um método abstrato que obriga as subclasses a fornecerem sua própria implementação de como exibir os detalhes completos do produto, incluindo seus atributos específicos.
Explicação: Essencial para o conceito de polimorfismo de método.

2. ProdutoPerecivel (Classe Concreta)
Representa um produto que tem uma data de validade, como alimentos ou medicamentos.
Propósito: Estender a funcionalidade de Produto adicionando um atributo específico para produtos perecíveis.


Conceitos POO Abordados:


Herança: Herda de Produto.
Encapsulamento: Adiciona seu próprio atributo private.
Polimorfismo (de Método): Sobrescreve o método detalhes() da superclasse para incluir a data de validade.
Atributos (private):


String dataValidade: A data até a qual o produto pode ser consumido/utilizado (ex: "31/12/2025").
Métodos (public):


ProdutoPerecivel(String codigo, String nome, double preco, int quantidade, String dataValidade) (Construtor):
Propósito: Inicializar um ProdutoPerecivel.
Explicação: Chama o construtor da superclasse Produto usando super(...) e depois inicializa dataValidade.
getDataValidade() (Getter):
Propósito: Acessar a data de validade do produto.
@Override String detalhes():
Propósito: Fornecer uma representação textual completa do produto perecível, incluindo sua data de validade.
Explicação: O @Override indica que este método está sobrescrevendo um método da superclasse (Produto), demonstrando o polimorfismo de método.

3. ProdutoDuravel (Classe Concreta)
Representa um produto que não tem data de validade e é feito de um material específico.
Propósito: Estender a funcionalidade de Produto adicionando um atributo específico para produtos duráveis.


Conceitos POO Abordados:


Herança: Herda de Produto.
Encapsulamento: Adiciona seu próprio atributo private.
Polimorfismo (de Método): Sobrescreve o método detalhes() da superclasse para incluir o material.
Atributos (private):


String material: O material principal do qual o produto é feito (ex: "Plástico", "Metal", "Madeira").
Métodos (public):


ProdutoDuravel(String codigo, String nome, double preco, int quantidade, String material) (Construtor):
Propósito: Inicializar um ProdutoDuravel.
Explicação: Chama o construtor da superclasse Produto usando super(...) e depois inicializa material.
getMaterial() (Getter):
Propósito: Acessar o material do produto.
@Override String detalhes():
Propósito: Fornecer uma representação textual completa do produto durável, incluindo seu material.
Explicação: Também demonstra o polimorfismo de método ao sobrescrever detalhes().

4. Estoque (Classe de Gerenciamento)
Esta é a classe central que gerencia a coleção de todos os produtos no estoque.
Propósito: Encapsular a lógica de adicionar, remover, buscar, atualizar e listar produtos.


Conceitos POO Abordados:


Encapsulamento: O atributo produtos (a lista de produtos) é privado e só pode ser manipulado através dos métodos da classe Estoque.
Relacionamento (Associação): A classe Estoque tem uma associação com a classe Produto. Um Estoque "contém" (has-a) muitos Produtos. Especificamente, usamos um ArrayList<Produto>.
Arrays/Collections: Utiliza java.util.ArrayList para armazenar os produtos, que é uma coleção dinâmica baseada em arrays.
Variáveis e Métodos Estáticos:
private static String NOME_ESTOQUE: Uma variável de classe (estática) que pertence à própria classe Estoque, não a instâncias específicas. Representa um nome comum para todos os estoques (embora em uma aplicação maior, poderia ser um ID único).
public static void exibirNomeEstoque(): Um método de classe (estático) que pode ser chamado diretamente na classe (Estoque.exibirNomeEstoque()) sem precisar criar um objeto Estoque.
Sobrecarga de Métodos: O método adicionarProduto possui duas versões, demonstrando sobrecarga.
Atributos (private):


List<Produto> produtos: Uma lista que armazena objetos do tipo Produto. Graças ao polimorfismo de tipo, esta lista pode conter tanto ProdutoPerecivel quanto ProdutoDuravel.
private static String NOME_ESTOQUE: Nome fixo para o estoque.
Métodos (public):


Estoque() (Construtor):
Propósito: Inicializar a lista produtos como um novo ArrayList.
public static void exibirNomeEstoque():
Propósito: Exibir o nome estático do estoque.
adicionarProduto(Produto produto) (Sobrecarga 1):
Propósito: Adicionar um novo produto ou atualizar a quantidade de um produto existente.
Explicação: Se um produto com o mesmo código já existe, ele incrementa a quantidade. Caso contrário, adiciona o novo produto à lista.
adicionarProduto(String codigo, String nome, double preco, int quantidade) (Sobrecarga 2 - Exemplo):
Propósito: Uma sobrecarga que permite adicionar um produto pelos seus dados brutos. Nota: Para o GUI, a primeira sobrecarga é mais usada, pois a GUI já constrói o objeto Produto completo.
removerProduto(String codigo):
Propósito: Remover um produto do estoque pelo seu código.
Explicação: Itera sobre a lista, encontra o produto e o remove. Retorna true se removido, false caso contrário.
buscarProduto(String codigo):
Propósito: Encontrar um produto pelo seu código.
Explicação: Retorna o objeto Produto se encontrado, ou null se não.
atualizarQuantidade(String codigo, int novaQuantidade):
Propósito: Modificar a quantidade de um produto existente.
Explicação: Busca o produto e, se encontrado, atualiza sua quantidade, garantindo que não seja negativa.
getProdutos():
Propósito: Retornar a lista de produtos (útil para a GUI listar todos).
listarTodosProdutos():
Propósito: Imprimir os detalhes de todos os produtos no console.
Explicação: Utiliza o polimorfismo de tipo e de método ao iterar sobre a List<Produto>. Para cada Produto p, ele chama p.detalhes(). Dependendo se p é um ProdutoPerecivel ou ProdutoDuravel, o método detalhes() correspondente à subclasse correta será invocado.

5. EstoqueApp (Classe de Interface Gráfica - GUI)
Esta é a classe responsável por criar e gerenciar a interface com o usuário.
Propósito: Fornecer uma interface visual para que o usuário interaja com o sistema de estoque, sem a necessidade de comandos de linha.


Conceitos POO Abordados:


Herança: Estende javax.swing.JFrame (a janela principal da aplicação).
Relacionamento (Associação): Possui uma instância da classe Estoque (private Estoque estoque;) para interagir com a lógica de negócio. A GUI é um "cliente" da lógica do estoque.
Entrada e Saída de Dados: Através de JTextField (entrada), JTextArea (saída de texto/resultados) e JOptionPane (caixas de diálogo).
Tratamento de Exceções: Contém blocos try-catch para lidar com entradas inválidas do usuário (como NumberFormatException ao tentar converter texto para número). Este será o local para expandir as exceções personalizadas.
Delegados de Eventos (Listeners): Usa ActionListener para responder aos cliques dos botões.
Polimorfismo (implícito): Ao criar novos produtos, a GUI constrói objetos ProdutoPerecivel ou ProdutoDuravel e os passa para o Estoque como Produtos, aproveitando o polimorfismo.
Componentes da GUI (private):


JTextFields: Para codigo, nome, preco, quantidade, campoEspecifico (data de validade ou material).
JComboBox<String>: Para selecionar o tipo de produto (Perecível/Durável).
JTextArea: Para exibir resultados e mensagens.
JButtons: Para as ações (Adicionar, Remover, Buscar, Listar, Atualizar).
JLabel: Rótulos para os campos, incluindo um lblCampoEspecifico que muda dinamicamente.
JPanels: Para organizar os componentes visualmente.
Métodos (public e private):


EstoqueApp() (Construtor):
Propósito: Configurar a janela principal, inicializar todos os componentes da GUI, organizar o layout e anexar os "ouvintes" (listeners) aos botões.
Explicação: Define título, tamanho, operação de fechamento, centraliza a janela. Cria os painéis e adiciona os componentes a eles, e depois adiciona os painéis à janela principal usando BorderLayout. Conecta cada botão a um método de ação.
adicionarProduto(), removerProduto(), buscarProduto(), listarProdutos(), atualizarQuantidade():
Propósito: São os métodos que contêm a lógica a ser executada quando o usuário clica nos botões correspondentes.
Explicação: Eles pegam os dados dos campos de texto, validam a entrada (com try-catch), chamam os métodos apropriados da instância de Estoque, e exibem o resultado ou mensagens de erro na JTextArea ou em um JOptionPane.
limparCampos():
Propósito: Limpar todos os campos de entrada após uma operação bem-sucedida.

6. Main (Classe Principal da Aplicação)
Esta é a classe que contém o método main, o ponto de entrada da aplicação Java.
Propósito: Iniciar o programa, garantindo que a interface gráfica seja criada e exibida de forma segura na thread de eventos do Swing.


Conceitos POO Abordados:


Ponto de Entrada: Contém o public static void main(String[] args).
Métodos (public static):


main(String[] args):
Propósito: É o primeiro método a ser executado quando o programa inicia.
Explicação: Usa SwingUtilities.invokeLater() para garantir que a criação e manipulação da GUI ocorra na Event Dispatch Thread (EDT) do Swing. Isso é uma boa prática para evitar problemas de concorrência e garantir que a interface do usuário seja responsiva. Ele cria uma instância de EstoqueApp e a torna visível.

Interações entre as Classes:
Main -> EstoqueApp: Main cria e exibe a janela EstoqueApp.
EstoqueApp -> Estoque: EstoqueApp (a GUI) é o "cliente" que interage com a lógica de negócio. Ela chama os métodos de Estoque (ex: adicionarProduto, removerProduto) para realizar as operações.
Estoque -> Produto (ProdutoPerecivel, ProdutoDuravel): A classe Estoque armazena e manipula objetos do tipo Produto. Quando Estoque.adicionarProduto() é chamado, ele recebe um Produto (que pode ser ProdutoPerecivel ou ProdutoDuravel via polimorfismo). Quando Estoque.listarTodosProdutos() é chamado, ele itera sobre sua List<Produto> e chama p.detalhes() para cada produto, ativando o polimorfismo de método.



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

