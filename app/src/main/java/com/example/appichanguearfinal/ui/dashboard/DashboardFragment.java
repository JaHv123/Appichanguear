package com.example.appichanguearfinal.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appichanguearfinal.DetalleReserva;
import com.example.appichanguearfinal.DetalleReservasAdapter;
import com.example.appichanguearfinal.ItemReserva;
import com.example.appichanguearfinal.R;
import com.example.appichanguearfinal.ReservasAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ArrayList<DetalleReserva> reservaUsuarios= new ArrayList<>();
        reservaUsuarios.add(new DetalleReserva(R.drawable.ic_date, "Camping de Urrelo","06:00 - 07:00"));

        mRecyclerView = root.findViewById(R.id.rcvResgistroReservas);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new DetalleReservasAdapter(reservaUsuarios);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return root;
    }





}