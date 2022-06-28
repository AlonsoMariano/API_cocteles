package com.app.proyectot4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.proyectot4.databinding.ActivityListaLicoresBinding;

import java.util.ArrayList;

public class listaLicores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListaLicoresBinding bin= ActivityListaLicoresBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        bin.categoryRecycler.setLayoutManager(new LinearLayoutManager(this));

        LAdapter adapter = new LAdapter(LAdapter.DIIF_CALLBACK);
        /*adapter.setOnItemClickListener(categoria -> {
        });*/
        bin.categoryRecycler.setAdapter(adapter);

        viewModel.getEqList().observe(this,tList -> {
            adapter.submitList(tList);
            if(tList.isEmpty()){
                bin.txtAlerta.setVisibility(View.VISIBLE);
            }else{
                bin.txtAlerta.setVisibility(View.GONE);
            }
        });
        viewModel.getCategoria();
    }
}