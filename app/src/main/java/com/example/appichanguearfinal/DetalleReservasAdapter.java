package com.example.appichanguearfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetalleReservasAdapter extends RecyclerView.Adapter<DetalleReservasAdapter.DetalleViewHolder> {

    private ArrayList<DetalleReserva> detalleReservas ;

    public class DetalleViewHolder extends RecyclerView.ViewHolder{

        public ImageView ImgDetalleReserva;
        public TextView mTextVIew1;
        public TextView mTextVIew2;

        public DetalleViewHolder(View view){
            super(view);

            ImgDetalleReserva = view.findViewById(R.id.imgDetalleReserva);
            mTextVIew1 = itemView.findViewById(R.id.txtDetalleReservaName);
            mTextVIew2 = itemView.findViewById(R.id.txtDetalleDescripcionRes);
        }
    }

    public DetalleReservasAdapter (ArrayList<DetalleReserva> mItemReserva){
        detalleReservas = mItemReserva;
    }

    @NonNull
    @Override
    public DetalleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_reserva_item,parent,false);
        DetalleViewHolder evh = new DetalleViewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleViewHolder holder, int position) {
        DetalleReserva currentTime = detalleReservas.get(position);

        holder.ImgDetalleReserva.setImageResource(currentTime.getmImageResource());
        holder.mTextVIew1.setText(currentTime.getmText1());
        holder.mTextVIew2.setText(currentTime.getMtext2());
    }

    @Override
    public int getItemCount() {
        return detalleReservas.size();
    }

}
