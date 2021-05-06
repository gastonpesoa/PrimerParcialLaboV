package com.example.primerparcial;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombre;
    TextView tvTipo;
    TextView tvContrasenia;
    ImageButton btnEdit;

    public UsuarioViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvTipo = itemView.findViewById(R.id.tvTipo);
        tvContrasenia = itemView.findViewById(R.id.tvContrasenia);
        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
