package com.app.proyectot4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.app.proyectot4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bin= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());

        bin.btnVisualizarLista.setOnClickListener(view -> {
            Intent intent= new Intent(this,listaLicores.class);
            startActivity(intent);
        });
    }
}