package com.example.appichanguearfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.ReservasVIewHolder>{

    private ArrayList<ItemReserva> itemReservas;

    public static class ReservasVIewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextVIew1;
        public TextView mTextVIew2;
        public TextView mTextView3;
        public Button btnConfirReserva;

        public ReservasVIewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imgReserva);
            mTextVIew1 = itemView.findViewById(R.id.txtReservaName);
            mTextVIew2 = itemView.findViewById(R.id.txtDescripcionReserva);
            mTextView3 = itemView.findViewById(R.id.txtEstadp);
            btnConfirReserva = itemView.findViewById(R.id.btnConfirmarReserva);
        }
    }

    public ReservasAdapter(ArrayList<ItemReserva> mItemReserva){
        itemReservas = mItemReserva;
    }

    @NonNull
    @Override
    public ReservasVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reseerva_item,parent,false);
        ReservasVIewHolder evh = new ReservasVIewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ReservasVIewHolder holder, int position) {
        ItemReserva currentTime = itemReservas.get(position);

        holder.mImageView.setImageResource(currentTime.getmImageResource());
        holder.mTextVIew1.setText(currentTime.getmText1());
        holder.mTextVIew2.setText(currentTime.getMtext2());
        holder.mTextView3.setText(currentTime.getmText3());

        holder.btnConfirReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(holder.btnConfirReserva.getContext());
                builder.setTitle("CONFIRMACIÓN DE RESERVA").setMessage("¿Deseas confirmar tu resera?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(holder.mTextView3.getText().equals("Disponible")){
                            holder.mTextView3.setText("Reservado");
                        }else{
                            holder.mTextView3.setText("Disponible");
                        }
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemReservas.size();
    }


}
