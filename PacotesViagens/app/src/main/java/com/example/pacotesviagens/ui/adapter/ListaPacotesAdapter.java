package com.example.pacotesviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pacotesviagens.R;
import com.example.pacotesviagens.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> copiaPacotes;
    private Context copiaContext;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.copiaContext = context;
        this.copiaPacotes = pacotes;
    }

    // define o tamanho da lista
    @Override
    public int getCount() {
        return copiaPacotes.size();
    }

    // devolve um item de pacotes
    @Override
    public Pacote getItem(int posicao) {
        return copiaPacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // metodo que implementa o layout dos itens
    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(copiaContext).inflate(R.layout.item_pacote, viewGroup, false);

        Pacote pacoteBind = copiaPacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacoteBind.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = copiaContext.getResources();
        int idDoDrawable = resources.getIdentifier(pacoteBind.getImagem(), "drawable", copiaContext.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        dias.setText(pacoteBind.getDias() + " dias");

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        preco.setText(pacoteBind.getPreco().toString());

        return viewCriada;
    }
}

