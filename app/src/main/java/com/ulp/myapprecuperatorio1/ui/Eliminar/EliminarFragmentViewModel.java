package com.ulp.myapprecuperatorio1.ui.Eliminar;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.ulp.myapprecuperatorio1.Model.Inmueble;
import com.ulp.myapprecuperatorio1.ui.Cargar.CargarFragmentViewModel;
public class EliminarFragmentViewModel extends AndroidViewModel {

    public EliminarFragmentViewModel(Application application) {
        super(application);
    }

    public boolean eliminarInmueble(String codigo) {
        return CargarFragmentViewModel.listaInmuebles.removeIf(inmueble -> inmueble.getCodigo().equals(codigo));
    }

    public Inmueble buscarInmueble(String codigo) {
        for (Inmueble inmueble : CargarFragmentViewModel.listaInmuebles) {
            if (inmueble.getCodigo().equals(codigo)) {
                return inmueble;
            }
        }
        return null; // No encontrado
    }
}