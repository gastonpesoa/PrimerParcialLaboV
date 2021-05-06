package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
    private UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.add(new UsuarioModel("Juan", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Miguel", "Miguel", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Ana", "Ana", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Pablo", "Pablo", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Susana", "Susana", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Dario", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Mario", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Jazmin", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Pedro", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Santiago", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Maria", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Paula", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Daniela", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Sofia", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("Yamil", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Andres", "juan", TipoUsuario.ADMINISTRADOR));
        usuarios.add(new UsuarioModel("German", "juan", TipoUsuario.USUARIO));
        usuarios.add(new UsuarioModel("Rocio", "juan", TipoUsuario.ADMINISTRADOR));

        this.adapter = new UsuarioAdapter(usuarios);
        RecyclerView recyclerView = super.findViewById(R.id.rvUsuarios);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}