package br.com.digitalhouse.dh_petsapp2.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitalhouse.dh_petsapp2.R;
import br.com.digitalhouse.dh_petsapp2.interfaces.Comunicador;
import br.com.digitalhouse.dh_petsapp2.model.Animal;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String ANIMAL_KEY = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container2, new PrimeiroFragment());
    }

    @Override
    public void recebeMensagem(Animal animal) {
        setBundleToFragment(animal, ANIMAL_KEY);
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();

    }

    public void setBundleToFragment(Animal so, String CHAVE){
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, so);

        Fragment segundoFragment = new SegundoFragment();
        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container1, segundoFragment);

    }
}
