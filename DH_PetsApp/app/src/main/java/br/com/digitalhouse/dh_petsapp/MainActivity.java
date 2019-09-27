package br.com.digitalhouse.dh_petsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnCao;
    private Button btnGato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCao = findViewById(R.id.button1);
        btnGato = findViewById(R.id.button2);

        btnCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recarregaFragment(new PrimeiroFragment());
            }
        });

        btnGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recarregaFragment(new SegundoFragment());
            }
        });

    }

    public void recarregaFragment (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}
