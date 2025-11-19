# 🍔 C\_M\_LANCHES: Sistema de Pedidos e Vendas

## ✨ Visão Geral do Projeto

Este projeto é um sistema de pedidos e gerenciamento de vendas simples desenvolvido em Java para simular o funcionamento de uma lanchonete. Ele foi construído utilizando amplamente **Padrões de Projeto (Design Patterns)**, o que garante modularidade, flexibilidade e fácil manutenção.

-----

## 👥 Criadores

| Função | Nome |
| :--- | :--- |
| Desenvolvedor Principal | **CARLOS HENRIQUE** |
| Desenvolvedor Principal | **MIGUEL PEREIRA** |

-----

## 🚀 Como Executar o Projeto

1.  **Requisitos:** Certifique-se de ter o **JDK (Java Development Kit)** instalado (versão 8 ou superior).
2.  **Compilação:** Navegue até o diretório raiz do projeto no seu terminal e compile os arquivos:
    ```bash
    javac C_M_Lanches/*.java C_M_Lanches/Bebidas/*.java C_M_Lanches/lanches/*.java C_M_Lanches/lanches/Extras/*.java Main.java
    ```
3.  **Execução:** Execute o programa a partir da classe principal (`Main`):
    ```bash
    java Main
    ```
    O sistema iniciará o menu interativo no terminal.

-----

## 🛠️ Padrões de Projeto Utilizados

A arquitetura do `C_M_Lanches` é baseada nos seguintes padrões:

### 1\. Composite (Composto) 🌳

  * **Onde ocorre:** Classes `ItemCardapio_Interface` e `Categoria_Cardapio_Composite`.
  * **Função:** Permite que o sistema trate objetos individuais (como um `Suco_Laranja`) e coleções de objetos (como a `Categoria_Bebidas`) de forma uniforme. A função `getDescricaoFormatada()` da Categoria **delega** a chamada para todos os seus filhos, montando o cardápio completo.

### 2\. Decorator (Decorador) 🎁

  * **Onde ocorre:** Classes `Pastel_Abstrato` e as classes `Extras` (ex: `Pastel_Catupiri`).
  * **Função:** Permite adicionar funcionalidades (extras) a um objeto dinamicamente sem alterar seu código base. O custo de um pastel é calculado de forma **recursiva** no método `cost()`, somando o custo base mais o custo de cada *decorator* (extra) que o envolve.

### 3\. Singleton (Instância Única) 🏰

  * **Onde ocorre:** Classes `Debug_Singleton` e `Gerenciador_Vendas_Singleton`.
  * **Função:** Garante que haja apenas **uma única instância** global para recursos críticos.
      * **`Debug_Singleton`:** Centraliza todos os logs do sistema.
      * **`Gerenciador_Vendas_Singleton`:** Controla o acesso ao arquivo `historico_vendas.txt` para salvar ou ler pedidos, garantindo que não haja conflitos de escrita.

### 4\. Factory Method (Fábrica) 🏭

  * **Onde ocorre:** Classes `Suco_Factory` e `Pastel_Factory`.
  * **Função:** Isola a lógica de criação de objetos do código cliente (`Main`). O `Main` pede um item (`Factory.criarSuco(1)`) sem precisar saber o nome da classe concreta que está sendo instanciada (`Suco_Laranja`).

-----

## 📁 Estrutura de Pastas (Pacotes)

O código é organizado nos seguintes pacotes Java:

  * `C_M_Lanches/`: Contém as interfaces, singletons e a classe `Categoria_Cardapio_Composite`.
  * `C_M_Lanches/Bebidas/`: Contém as classes `Suco_Abstrato`, sabores de suco (ex: `Suco_Laranja`) e a `Suco_Factory`.
  * `C_M_Lanches/lanches/`: Contém a base dos lanches (pastéis) e a `Pastel_Factory`.
  * `C_M_Lanches/lanches/Extras/`: Contém as classes que implementam o Padrão Decorator (ex: `Pastel_Catupiri`, `Pastel_Cheddar`).
  * `Main.java`: A classe principal que inicializa o sistema, monta o cardápio e gerencia a interface do usuário.
