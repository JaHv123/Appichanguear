package com.example.appichanguearfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appichanguearfinal.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ExampleBottomSheetDailog extends BottomSheetDialogFragment {

    TextView campNombre, campPrecio, campDireccion, campDistancia, campHorario, campTelefono;
    Button btnReserva;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_resource_layout,container,false);

       campNombre = view.findViewById(R.id.txtNombreCampo);
        campPrecio = view.findViewById(R.id.txtPrecioCampo);
        campDireccion = view.findViewById(R.id.txtDireccionCampo);
        campDistancia = view.findViewById(R.id.txtDistanciaCampo);
        campHorario = view.findViewById(R.id.txtHorarioCampo);
        campTelefono = view.findViewById(R.id.txtTelefonoCampo);
        btnReserva = view.findViewById(R.id.btnReserva);

        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ReservaActivity.class));
            }
        });

        onStop();

        getCampoDetail();
        return view;
    }

    public void getCampoDetail(){
        CampoDetail campingUrrelo = new CampoDetail();
        campNombre.setText(campingUrrelo.Nombre = "Camping de Urrelo");
        campPrecio.setText(campingUrrelo.Precio = "S/30.00 (Día) / S/60.00 (Noche)");
        campDireccion.setText(campingUrrelo.Direccion = "Jr. Guillermo Urrelo");
        campDistancia.setText(campingUrrelo.Distancia = "2 Km");
        campHorario.setText(campingUrrelo.Horario = "06:00 AM / 23:00 PM");
        campTelefono.setText(campingUrrelo.telefono = "960780543");
    }



}