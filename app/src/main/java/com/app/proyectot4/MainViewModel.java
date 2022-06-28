package com.app.proyectot4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.proyectot4.api.CategoriaJSONResponse;
import com.app.proyectot4.api.Drink;
import com.app.proyectot4.api.EqApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<Categoria>> tList = new MutableLiveData<>();

    public LiveData<List<Categoria>> getEqList(){
        return tList;
    }

    public void getCategoria(){
        EqApiClient.EqService service = EqApiClient.getInstance().getService();
        service.getCategorias().enqueue(new Callback<CategoriaJSONResponse>() {
            @Override
            public void onResponse(Call<CategoriaJSONResponse> call, Response<CategoriaJSONResponse> response) {
                List<Categoria> categoriaList = getCategoriaWithMoshi(response.body());
                tList.setValue(categoriaList);
            }

            private List<Categoria> getCategoriaWithMoshi(CategoriaJSONResponse body) {
                ArrayList<Categoria> eqList = new ArrayList<>();
                List<Drink> drinks = body.getDrinks();
                for(Drink drink: drinks){
                    String id = drink.getIdDrink();
                    String nombre = drink.getStrDrink();
                    String imagen = drink.getStrDrinkThumb();
                    Categoria categoria = new Categoria(id,nombre,imagen);
                    eqList.add(categoria);
                }
                return eqList;
            }

            @Override
            public void onFailure(Call<CategoriaJSONResponse> call, Throwable t) {

            }
        });
    }

}
