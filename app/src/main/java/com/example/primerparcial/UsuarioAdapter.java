package com.example.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {

    private List<UsuarioModel> usuarios;

    public UsuarioAdapter(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        UsuarioViewHolder holder = new UsuarioViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        UsuarioModel usuario = usuarios.get(position);
        holder.tvNombre.setText(usuario.getNombre());
        holder.tvTipo.setText(usuario.getTipoUsuario().toString());
        holder.tvContrasenia.setText(usuario.getContrasenia());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
