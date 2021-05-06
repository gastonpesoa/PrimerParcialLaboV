package com.example.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {

    private UsuarioOnItemClick listener;
    private List<UsuarioModel> usuarios;

    public UsuarioAdapter(List<UsuarioModel> usuarios, UsuarioOnItemClick listener) {
        this.usuarios = usuarios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        UsuarioViewHolder holder = new UsuarioViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        UsuarioModel usuario = usuarios.get(position);
        holder.tvNombre.setText(usuario.getNombre());
        holder.tvTipo.setText(usuario.getTipoUsuario().toString());
        holder.tvContrasenia.setText(usuario.getContrasenia());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
