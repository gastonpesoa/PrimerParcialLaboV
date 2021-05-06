package com.example.primerparcial;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private UsuarioOnItemClick listener;
    TextView tvNombre;
    TextView tvTipo;
    TextView tvContrasenia;
    ImageButton btnEdit;
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public UsuarioViewHolder(@NonNull View itemView, UsuarioOnItemClick listener) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvTipo = itemView.findViewById(R.id.tvTipo);
        tvContrasenia = itemView.findViewById(R.id.tvContrasenia);
        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(position);
    }
}
