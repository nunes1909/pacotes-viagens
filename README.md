## Dados do repositório:
Curso: Layouts Android parte 1 - Criando telas com Constraint Layouts.<br>
Nome do App: Pacotes de Viagens.<br>
Recursos: ConstraintLayout + ListView.<br>

## Este aplicativo aborda:
1. **Criação do Layout inicial e do Layout dos itens da ListView.**
    - Boas práticas de ConstraintLayout.
2. **Configuração da model.**
    - O objeto/classe "Pacote", que possui os parâmetros seguido dos getters and setters.
3. **Configuração do Adapter da ListView.**
    - Implementado os métodos obrigatórios do adapter.  
    - Método "getCount()" -> Define o tamanho da lista.
        - ``` return copiaPacotes.size(); ```
    - Método "getItem()" -> Retorna os itens pela posição.
        - ``` return copiaPacotes.get(posicao); ```
    - Método "getView()" -> Implementa o Layout dos itens, e também add as informações dos itens no Layout.
        - _Explicado mais abaixo._
4. **Configuração do DAO.**
    - Classe responsável por armazenar os dados de cada item da lista.
5. **Configuração do processo de "bind" das informações no layout.**
6. **Refatoração em todo o código da aplicação.**
7. **Implementação de Classes Utilitárias.**
    - A classe adapter estava com muitas responsabilidades além da configuração do adapter.
    - As responsabilidades a mais foram transferias para as classes DiasUtil, MoedaUtil e ResourceUtil.
    - Todas as classes foram movidas para o package util.
   
    
