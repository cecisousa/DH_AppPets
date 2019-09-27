package br.com.digitalhouse.dh_petsapp2.views;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.dh_petsapp2.R;
import br.com.digitalhouse.dh_petsapp2.interfaces.Comunicador;
import br.com.digitalhouse.dh_petsapp2.model.Animal;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    private Button btnCao;
    private Button btnGato;
    private Comunicador comunicador;

    public PrimeiroFragment() {
        // Required empty public constructor
    }

    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        initViews(view);

        btnCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal cachorro = new Animal(R.drawable.scoobydoo, "Scoob");
                comunicador.recebeMensagem(cachorro);
            }
        });

        btnGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal gato = new Animal(R.drawable.gato, "Salem");
                comunicador.recebeMensagem(gato);
            }
        });

        return view;

    }


        public void initViews(View view){
            btnCao = view.findViewById(R.id.buttonCao);
            btnGato = view.findViewById(R.id.buttonGato);
        }

}
