package com.ulp.myapprecuperatorio1.ui.Eliminar;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import com.ulp.myapprecuperatorio1.Model.Inmueble;
import com.ulp.myapprecuperatorio1.R;




public class EliminarFragment extends Fragment {

    private EliminarFragmentViewModel viewModel;
    private EditText etCod;
    private Button btBuscar, btEliminar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);
        etCod = view.findViewById(R.id.etCod);
        btBuscar = view.findViewById(R.id.btBuscar);
        btEliminar = view.findViewById(R.id.btEliminar);

        viewModel = new ViewModelProvider(this).get(EliminarFragmentViewModel.class);

        btBuscar.setOnClickListener(v -> buscarInmueble());
        btEliminar.setOnClickListener(v -> eliminarInmueble());

        return view;
    }

    private void buscarInmueble() {
        String codigo = etCod.getText().toString();
        Inmueble inmueble = viewModel.buscarInmueble(codigo);
        if (inmueble != null) {
            // Mostrar datos del inmueble en un formulario
            // (Asegúrate de implementar esto, tal vez mostrando en TextViews)
            btEliminar.setEnabled(true); // Habilitar botón eliminar
        } else {
            Toast.makeText(getContext(), "Inmueble no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarInmueble() {
        String codigo = etCod.getText().toString();
        if (viewModel.eliminarInmueble(codigo)) {
            Toast.makeText(getContext(), "Inmueble borrado", Toast.LENGTH_SHORT).show();
            etCod.setText(""); // Limpiar campo
            btEliminar.setEnabled(false); // Deshabilitar botón eliminar
        } else {
            Toast.makeText(getContext(), "Inmueble no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}











