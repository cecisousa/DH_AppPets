package br.com.digitalhouse.dh_petsapp2.views;


import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.dh_petsapp2.R;
import br.com.digitalhouse.dh_petsapp2.model.Animal;

import static br.com.digitalhouse.dh_petsapp2.views.MainActivity.ANIMAL_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private ImageView imagem;
    private TextView texto;


    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initView (view);

        if (!getArguments().isEmpty()){

            Animal carro = getArguments().getParcelable(ANIMAL_KEY);

            if (carro != null){
                Drawable drawable = getResources().getDrawable(carro.getImagem());

                imagem.setImageDrawable(drawable);
                texto.setText(carro.getNome());
            }
        }

        return view;


    }

    public void initView(View view){
        imagem = view.findViewById(R.id.imagemCao);
        texto = view.findViewById(R.id.textoCao);
    }

}
