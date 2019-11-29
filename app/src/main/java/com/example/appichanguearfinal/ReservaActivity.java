package com.example.appichanguearfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appichanguearfinal.ui.dashboard.DashboardFragment;

import java.util.ArrayList;

public class ReservaActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        ArrayList<ItemReserva> itemReservas= new ArrayList<>();
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","06:00 - 07:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","07:00 - 08:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","08:00 - 09:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","10:00 - 11:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","11:00 - 12:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","12:00 - 13:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","13:00 - 14:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","14:00 - 18:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","15:00 - 16:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","16:00 - 17:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","17:00 - 18:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","18:00 - 19:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","19:00 - 20:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","20:00 - 21:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","21:00 - 22:00","Disponible"));
        itemReservas.add(new ItemReserva(R.drawable.ic_date, "Camping de Urrelo","22:00 - 23:00","Disponible"));

        mRecyclerView = findViewById(R.id.recyclerVIew);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ReservasAdapter(itemReservas);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
