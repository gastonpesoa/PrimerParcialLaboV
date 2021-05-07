package com.example.primerparcial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioOnItemClick {

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

        this.adapter = new UsuarioAdapter(usuarios, this);
        RecyclerView recyclerView = super.findViewById(R.id.rvUsuarios);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onItemClick(int position) {
        UsuarioModel usuario = usuarios.get(position);
        Log.d("main", usuario.toString());
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("usuario", usuario);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 101){
            if (resultCode == Activity.RESULT_OK){
                UsuarioModel usuarioUpdated = (UsuarioModel) data.getSerializableExtra("usuarioModificado");
                int position = data.getExtras().getInt("positionModificado");

                Log.d("main", " modificado: ".concat(usuarioUpdated.toString()));
                Log.d("main", " pos: ".concat(Integer.valueOf(position).toString()));

                UsuarioModel usuario = this.usuarios.get(position);

                usuario.setNombre(usuarioUpdated.getNombre());
                usuario.setContrasenia(usuarioUpdated.getContrasenia());
                usuario.setTipoUsuario(usuarioUpdated.getTipoUsuario().toString());
                Log.d("main", "modificado  updated: ".concat(usuario.toString()));

                this.adapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}