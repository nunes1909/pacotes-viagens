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
    - A classe do Adapter extends de BaseAdapter.
    - Implementado os métodos obrigatórios do adapter.  
    - Os parâmetros da classe do adapter recebem os parâmetros que o construtor exige.
    - Método "getCount()" -> Define o tamanho da lista.
    - Método "getItem()" -> Retorna os itens pela posição.
    - Método "getView()" -> Implementa o Layout dos itens, e também add as informações dos itens no Layout.
4. **Configuração do DAO.**
    - Classe responsável por armazenar os dados de cada item da lista.
``` 
public class PacoteDAO {

    public List<Pacote> lista() {
        List<Pacote> pacotes = new ArrayList<>(Arrays.asList(
                new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99)),
                new Pacote("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal(421.50)),
                new Pacote("Recife", "recife_pe", 4, new BigDecimal(754.20)),
                new Pacote("Rio de Janeiro", "rio_de_janeiro_rj", 6, new BigDecimal(532.55)),
                new Pacote("Salvador", "salvador_ba", 5, new BigDecimal(899.99)),
                new Pacote("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal(289.90))));
        return pacotes;
    }

}
```
5. **Configuração do processo de "bind" das informações no layout.**
    - O LayoutInflater e o inflate são responsáveis por implementar o layout criado:
        - ``` View viewCriada = LayoutInflater.from(copiaContext).inflate(R.layout.item_pacote, viewGroup, false);```
    - O copiaPacotes é o atributo da classe adapter que recebe a lista. Ele busca a poscição através do método get:
        - ``` Pacote pacoteBind = copiaPacotes.get(posicao); ```
    
