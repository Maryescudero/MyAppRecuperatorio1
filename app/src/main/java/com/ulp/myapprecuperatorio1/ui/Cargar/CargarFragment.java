package com.ulp.myapprecuperatorio1.ui.Cargar;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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



public class CargarFragment extends Fragment {

    private EditText etCodigo, etDescripcion, etCantAmbientes, etDireccion, etPrecio;
    private Button btAgregar;
    private CargarFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cargar, container, false);


        etCodigo = view.findViewById(R.id.etCodigo);
        etDescripcion = view.findViewById(R.id.etDescripcion);
        etCantAmbientes = view.findViewById(R.id.etCantAmbientes);
        etDireccion = view.findViewById(R.id.etDireccion);
        etPrecio = view.findViewById(R.id.etPrecio);
        btAgregar = view.findViewById(R.id.btAgregar);


        viewModel = new ViewModelProvider(this).get(CargarFragmentViewModel.class);


        btAgregar.setOnClickListener(v -> {
            String codigo = etCodigo.getText().toString();
            String descripcion = etDescripcion.getText().toString();
            int cantAmbientes = Integer.parseInt(etCantAmbientes.getText().toString());
            String direccion = etDireccion.getText().toString();
            double precio = Double.parseDouble(etPrecio.getText().toString());


            if (!codigo.isEmpty() && !descripcion.isEmpty() && !direccion.isEmpty()) {
                Inmueble inmueble = new Inmueble(codigo, descripcion, cantAmbientes, direccion, precio);
                viewModel.agregarInmueble(inmueble);
                Toast.makeText(getActivity(), "Inmueble agregado", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(getActivity(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void limpiarCampos() {
        etCodigo.setText("");
        etDescripcion.setText("");
        etCantAmbientes.setText("");
        etDireccion.setText("");
        etPrecio.setText("");
    }
}