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
        - ``` public class ListaPacotesAdapter extends BaseAdapter {} ```
    - Os parâmetros da classe do adapter recebem os parâmetros que o construtor exige.
        - ``` public ListaPacotesAdapter(List< Pacote> pacotes, Context context){ ```
        - ``` this.copiaContext = context; ```
        - ``` this.copiaPacotes = pacotes; ```
    - Implementado os métodos obrigatórios do adapter.  
    - Método "getCount()" -> Define o tamanho da lista.
        - ``` return copiaPacotes.size(); ```
    - Método "getItem()" -> Retorna os itens pela posição.
        - ``` return copiaPacotes.get(posicao); ```
    - Método "getView()" -> Implementa o Layout dos itens, e também add as informações dos itens no Layout.
        - _Explicado mais abaixo._
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
    - O copiaPacotes é o atributo da classe adapter que recebe a lista. Ele busca a poscição de cada pacote através do método get:
        - ``` Pacote pacoteBind = copiaPacotes.get(posicao); ```
    - Utilizando a "viewCriada" do LayoutInflater, é possível buscar pelo ID cada campo do layout criado. Neste exemplo, o campo local:
        - ``` TextView local = viewCriada.findViewById(R.id.item_pacote_local);```
    - E utilizando o objeto dessa "busca" do campo, é possível setar o texto:
        - ``` local.setText(pacoteBind.getLocal()); ```
    - O processo acima é feito igual para os atributos: "dias" e "preco".
    - Para a imagem é feito um processo diferente, pois é necessário converter a imagem (drawable) para String:
```
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = copiaContext.getResources();
        int idDoDrawable = resources.getIdentifier(pacoteBind.getImagem(), "drawable", copiaContext.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);
```
        
   
    
