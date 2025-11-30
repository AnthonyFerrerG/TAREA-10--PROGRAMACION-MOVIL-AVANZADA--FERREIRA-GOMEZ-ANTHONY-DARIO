package com.example.fragmentcommunication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar Fragmento 1 al iniciar
        if (savedInstanceState == null) {
            loadFragment(new Fragment1());
        }
    }

    // Método para cargar fragmentos
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }

    // Este método recibe los datos desde Fragment1
    @Override
    public void onSendData(String text) {
        // Crear Fragment2 y enviar los datos
        Fragment2 fragment2 = Fragment2.newInstance(text);
        loadFragment(fragment2);
    }
}
