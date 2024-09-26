package com.ulp.myapprecuperatorio1.ui.Cargar;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.myapprecuperatorio1.Model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class CargarFragmentViewModel extends AndroidViewModel {


    public static List<Inmueble> listaInmuebles = new ArrayList<>();

    public CargarFragmentViewModel(Application application) {
        super(application);
    }


    public void agregarInmueble(Inmueble inmueble) {
        if (!inmueblesExistente(inmueble.getCodigo())) {
            listaInmuebles.add(inmueble);
        } else {

        }
    }


    private boolean inmueblesExistente(String codigo) {
        for (Inmueble inmueble : listaInmuebles) {
            if (inmueble.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}

